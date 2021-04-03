package se.stridsberg.lenaszoo.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.stridsberg.lenaszoo.dao.AnimalDAO;
import se.stridsberg.lenaszoo.models.Animal;
import se.stridsberg.lenaszoo.models.dto.AnimalDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    public static AnimalDAO animalDAO;
    public AnimalService animalService;
    public List<AnimalDTO> allAnimals;

    @BeforeAll
    public static void initAll() {
        animalDAO = Mockito.mock(AnimalDAO.class);
    }

    @BeforeEach
    public void init() {
        animalService = new AnimalService(animalDAO);
        allAnimals = new ArrayList<>();
        allAnimals.add(new AnimalDTO(1, "Lejon", "Leo"));
        allAnimals.add(new AnimalDTO(2, "Giraff", "Gulle"));
        allAnimals.add(new AnimalDTO(3, "Elefant", "Elof"));
    }

    @Test
    void getAllAnimals_ShouldReturnAllAnimals() {
        List<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(new Animal(1, "Lejon", "Leo"));
        expectedAnimals.add(new Animal(2, "Giraff", "Gulle"));
        expectedAnimals.add(new Animal(3, "Elefant", "Elof"));

        Mockito.when(animalDAO.getAllAnimals()).thenReturn(allAnimals);
        List<Animal> actualAnimals = animalService.getAllAnimals();

        Assertions.assertThat(actualAnimals.size()).isEqualTo(expectedAnimals.size());
    }

    @Test
    void addAnimal_ShouldAddAnimalAndReturnCorrectName() {
        AnimalDTO animalDTOFromDatabase = new AnimalDTO(1, "Lejon", "Leo");
        Animal newAnimal = new Animal(null, "Lejon", "Leo");

        Mockito.when(animalDAO.addAnimal(ArgumentMatchers.any(AnimalDTO.class))).thenReturn(animalDTOFromDatabase);
        Animal createdAnimal = animalService.addAnimal(newAnimal);

        Assertions.assertThat(newAnimal.getName()).isEqualTo(createdAnimal.getName());
    }

    @Test
    void getAnimalById_ShouldFindAnimalById() {
        AnimalDTO animalDTOFromDatabase = new AnimalDTO(1, "Lejon", "Leo");
        Animal expectedAnimal = new Animal(1, "Lejon", "Leo");

        Mockito.when(animalDAO.findAnimalByID(1)).thenReturn(Optional.of(animalDTOFromDatabase));
        Animal actualAnimal = animalService.getAnimalById(1);

        Assertions.assertThat(actualAnimal.getId()).isEqualTo(expectedAnimal.getId());
    }

    @Test
    void getAnimalById_ShouldFindAnimalWithCorrectName() {
        AnimalDTO animalDTOFromDatabase = new AnimalDTO(1, "Lejon", "Leo");
        Animal expectedAnimal = new Animal(1, "Lejon", "Leo");

        Mockito.when(animalDAO.findAnimalByID(1)).thenReturn(Optional.of(animalDTOFromDatabase));
        Animal actualAnimal = animalService.getAnimalById(1);

        Assertions.assertThat(actualAnimal.getName()).isEqualTo(expectedAnimal.getName());
    }

    @Test
    void deleteAnimal_ShouldInvokeDeleteAnimal() {
        animalService.deleteAnimal(1);
        Mockito.verify(animalDAO,Mockito.times(1)).deleteAnimal(1);
    }

    @Test
    void deleteAnimal_ShouldNotInvokeAddAnimal() {
        animalService.deleteAnimal(1);
        Mockito.verify(animalDAO, Mockito.times(0)).addAnimal(new AnimalDTO(null, null, null));
    }

    @Test
    void updateAnimal() {
        Animal newAnimal = new Animal(1, "Anka", "Kalle");
        AnimalDTO animalDTOFromDatabaseFirstIteration = new AnimalDTO(1, "Anka", "Arne");
        AnimalDTO animalDTOFromDatabaseSecondIteration = new AnimalDTO(1, "Anka", "Kalle");

        Mockito.when(animalDAO.findAnimalByID(1)).thenReturn(Optional.of(animalDTOFromDatabaseFirstIteration));
        Mockito.when(animalDAO.addAnimal(ArgumentMatchers.any(AnimalDTO.class))).thenReturn(animalDTOFromDatabaseSecondIteration);
        Animal actualAnimal = animalService.updateAnimal(newAnimal, 1);

        Assertions.assertThat(actualAnimal.getName()).isEqualTo(newAnimal.getName());
    void deleteAnimal() {
        animalService.deleteAnimal(1);
        Mockito.verify(animalDAO, Mockito.times(1)).deleteAnimal(1);
    }
}