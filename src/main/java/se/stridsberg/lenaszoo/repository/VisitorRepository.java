package se.stridsberg.lenaszoo.repository;

import org.springframework.data.repository.CrudRepository;
import se.stridsberg.lenaszoo.models.dto.VisitorDTO;

public interface VisitorRepository extends CrudRepository<VisitorDTO, Integer> {
}
