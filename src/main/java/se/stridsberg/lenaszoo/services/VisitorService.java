package se.stridsberg.lenaszoo.services;

import org.springframework.stereotype.Service;
import se.stridsberg.lenaszoo.dao.VisitorDAO;
import se.stridsberg.lenaszoo.models.Visitor;
import se.stridsberg.lenaszoo.models.dto.VisitorDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VisitorService {

    private final VisitorDAO visitorDAO;

    public VisitorService(VisitorDAO visitorDAO) {
        this.visitorDAO = visitorDAO;
    }

    public List<Visitor> getAllVisitors() {
        List<Visitor> visitors = new ArrayList<>();
        for (VisitorDTO visitorDTO : visitorDAO.getAllVisitors()) {
            Visitor visitor = mapToVisitor(visitorDTO);
            visitors.add(visitor);
        }
        return visitors;
    }

    public Visitor addVisitor(Visitor newVisitor) {
        if(zooIsFull()) {
            return null;
        }
        VisitorDTO newVisitorDTO = visitorDAO.addVisitor(mapFromVisitor(newVisitor));
        return mapToVisitor(newVisitorDTO);
    }

    public Visitor getVisitorById(Integer id) {
        Optional<VisitorDTO> maybeVisitorDTO = visitorDAO.getVisitorById(id);
        if (maybeVisitorDTO.isPresent()) {
            VisitorDTO visitorDTO = maybeVisitorDTO.get();
            return mapToVisitor(visitorDTO);
        }
        return null;
    }

    public void deleteVisitor(Integer id) {
        visitorDAO.deleteVisitor(id);
    }

    private boolean zooIsFull() {
        return getAllVisitors().size() >= 8;
    }

    private Visitor mapToVisitor(VisitorDTO visitorDTO) {
        return new Visitor(visitorDTO.getId(), visitorDTO.getName(), visitorDTO.getAge());
    }

    private VisitorDTO mapFromVisitor(Visitor visitor) {
        return new VisitorDTO(visitor.getId(), visitor.getName(), visitor.getAge());
    }


}
