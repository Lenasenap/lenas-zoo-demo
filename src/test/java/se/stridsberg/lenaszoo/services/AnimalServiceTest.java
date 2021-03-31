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

    @Mock
    public AnimalDAO animalDAO;
    public AnimalService animalService;
    public List<AnimalDTO> allAnimals;

    @BeforeAll
    public static void initAll() {
        // Jag behöver instansiera min mockade klass om jag inte har hämtat in jupiter-dependencyt
        //animalDAO = Mockito.mock(AnimalDAO.class);
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
    void getAllAnimals_ShouldGetAllAnimals() {
        List<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(new Animal(1, "Lejon", "Leo"));
        expectedAnimals.add(new Animal(2, "Giraff", "Gulle"));
        expectedAnimals.add(new Animal(3, "Elefant", "Elof"));

        Mockito.when(animalDAO.getAllAnimals()).thenReturn(allAnimals);
        List<Animal> actualAnimals = animalService.getAllAnimals();

        Assertions.assertThat(actualAnimals.size()).isEqualTo(expectedAnimals.size());
    }

    @Test
    void updateAnimal() {

    }

    @Test
    void addAnimal_ShouldAddAnimal() {
        AnimalDTO animalDTO = new AnimalDTO(1, "Lejon", "Leo");
        Animal newAnimal = new Animal(null, "Lejon", "Leo");

        Mockito.when(animalDAO.addAnimal(ArgumentMatchers.any(AnimalDTO.class))).thenReturn(animalDTO);

        Animal createdAnimal = animalService.addAnimal(newAnimal);

        Assertions.assertThat(newAnimal.getName()).isSameAs(createdAnimal.getName());
    }

    @Test
    void getAnimalById_ShouldFindAnimalById() {
        AnimalDTO animalDTO = new AnimalDTO(1, "Lejon", "Leo");
        Animal expectedAnimal = new Animal(1, "Lejon", "Leo");

        Mockito.when(animalDAO.findAnimalByID(1)).thenReturn(Optional.of(animalDTO));
        Animal actualAnimal = animalService.getAnimalById(1);

        Assertions.assertThat(actualAnimal.getId()).isEqualTo(expectedAnimal.getId());
        Assertions.assertThat(actualAnimal.getName()).isEqualTo(expectedAnimal.getName());
    }

    @Test
    void deleteAnimal() {
        animalService.deleteAnimal(1);
        Mockito.verify(animalDAO, Mockito.times(1)).deleteAnimal(1);
    }
}