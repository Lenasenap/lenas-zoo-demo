package se.stridsberg.lenaszoo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.stridsberg.lenaszoo.models.Animal;
import se.stridsberg.lenaszoo.services.AnimalService;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping()
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable("id") Integer id) {
        return animalService.getAnimalById(id);
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable("id") Integer id) {
        animalService.deleteAnimal(id);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@RequestBody Animal newAnimal,
                               @PathVariable("id") Integer id) {

        return animalService.updateAnimal(newAnimal, id);
    }
}
