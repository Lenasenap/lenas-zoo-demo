package se.stridsberg.lenaszoo.models.recordsmodels;

import java.util.Objects;

public record AnimalRecord(String name, String type) {

    public AnimalRecord {
        Objects.requireNonNull(name);
        Objects.requireNonNull(type);
    }

    public AnimalRecord(String type) {
        this("John Doe", type);
    }
}
