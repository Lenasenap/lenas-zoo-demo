package se.stridsberg.lenaszoo.dao;

import org.springframework.stereotype.Repository;
import se.stridsberg.lenaszoo.models.dto.VisitorDTO;
import se.stridsberg.lenaszoo.repository.VisitorRepository;

import java.util.Optional;

@Repository
public class VisitorDAO {

    private final VisitorRepository visitorRepository;

    public VisitorDAO(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public Iterable<VisitorDTO> getAllVisitors() {
        return visitorRepository.findAll();
    }

    public VisitorDTO addVisitor(VisitorDTO visitorDTO) {
        return visitorRepository.save(visitorDTO);
    }

    public Optional<VisitorDTO> getVisitorById(Integer id) {
        return visitorRepository.findById(id);
    }

    public void deleteVisitor(Integer id) {
        visitorRepository.deleteById(id);
    }
}
