package se.stridsberg.lenaszoo.services;

import org.springframework.stereotype.Service;
import se.stridsberg.lenaszoo.models.Animal;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    public List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Lejon", "Leo"));
        animals.add(new Animal("Orm", "Väs"));
        return animals;
    }

}
