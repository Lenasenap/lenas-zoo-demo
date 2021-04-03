package se.stridsberg.lenaszoo.repository;


import org.springframework.data.repository.CrudRepository;
import se.stridsberg.lenaszoo.models.dto.EmployeeDTO;


public interface EmployeeRepository extends CrudRepository<EmployeeDTO, Integer> {
}
