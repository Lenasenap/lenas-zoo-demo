package se.stridsberg.lenaszoo.models.dto;

import javax.persistence.*;

@Entity
@Table(name = "animals")
public class AnimalDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;
    private String name;

    public AnimalDTO(Integer id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public AnimalDTO() {
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
