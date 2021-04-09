package se.stridsberg.lenaszoo.models.dto;

import javax.persistence.*;

@Entity
@Table(name = "visitors")
public class VisitorDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private int age;

    public VisitorDTO(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public VisitorDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
