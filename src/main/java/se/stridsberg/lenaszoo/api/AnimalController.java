package se.stridsberg.lenaszoo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.stridsberg.lenaszoo.models.Animal;
import se.stridsberg.lenaszoo.services.AnimalService;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping("/animalsdata")
    public List<Animal> getAnimals() {
        return animalService.getAnimals();
    }
}
