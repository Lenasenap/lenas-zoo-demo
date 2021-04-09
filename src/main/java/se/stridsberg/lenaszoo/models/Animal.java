package se.stridsberg.lenaszoo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Animal {

    private Integer id;
    private String type;
    private String name;

    // TODO Undersök @JsonProperty - bara för att skriva till java eller också tvärtom?
    // Behöver vi ens den här annotationen?
    public Animal(Integer id,
                  String type,
                  String name) {
        this.id = id;
        this.type = type;
        this.name = name;
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

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
