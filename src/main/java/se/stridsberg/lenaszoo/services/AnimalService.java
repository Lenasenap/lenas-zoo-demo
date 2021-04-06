package se.stridsberg.lenaszoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.stridsberg.lenaszoo.dao.AnimalDAO;
import se.stridsberg.lenaszoo.models.Animal;
import se.stridsberg.lenaszoo.models.dto.AnimalDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private final AnimalDAO animalDAO;

    @Autowired
    public AnimalService(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public List<Animal> getAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        for (AnimalDTO animalDTO : animalDAO.getAllAnimals()) {
            Animal animal = mapToAnimal(animalDTO);
            animals.add(animal);
        }
        return animals;
    }

    public Animal updateAnimal(Animal animal, Integer id) {
        Animal animalToUpdate = getAnimalById(id);

        if (animalToUpdate != null) {
            animalToUpdate.setName(animal.getName());
            animalToUpdate.setType(animal.getType());
        } else {
            animalToUpdate.setId(id);
        }
        AnimalDTO updatedAnimal = animalDAO.addAnimal(mapFromAnimal(animalToUpdate));
        return mapToAnimal(updatedAnimal);
    }

    public Animal addAnimal(Animal animal) {
        AnimalDTO newAnimalDTO = animalDAO.addAnimal(mapFromAnimal(animal));
        return mapToAnimal(newAnimalDTO);
    }

    public Animal getAnimalById(Integer id) {
        if (animalDAO.findAnimalByID(id).isPresent()) {
            return mapToAnimal(animalDAO.findAnimalByID(id).get());
        }
        return null;
    }

    public void deleteAnimal(Integer id) {
        animalDAO.deleteAnimal(id);
    }

    public void deleteAllAnimals() {
        animalDAO.deleteAllAnimals();
    }

    public AnimalDTO mapFromAnimal(Animal animal) {
        return new AnimalDTO(animal.getId(), animal.getType(), animal.getName());
    }

    public Animal mapToAnimal(AnimalDTO animalDTO) {
        return new Animal(animalDTO.getId(), animalDTO.getType(), animalDTO.getName());
    }

}
