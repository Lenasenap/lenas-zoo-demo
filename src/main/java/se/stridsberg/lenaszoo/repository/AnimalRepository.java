package se.stridsberg.lenaszoo.repository;

import org.springframework.data.repository.CrudRepository;
import se.stridsberg.lenaszoo.models.dto.AnimalDTO;

public interface AnimalRepository extends CrudRepository<AnimalDTO, Integer> {
}
