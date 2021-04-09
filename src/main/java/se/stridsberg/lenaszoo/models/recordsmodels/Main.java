package se.stridsberg.lenaszoo.models.recordsmodels;

public class Main {

    public static void main(String[] args) {

        String name = "Leo";
        String type = "Lejon";

        Animal animal1 = new Animal(name, type);
        Animal animal2 = new Animal(name, type);
        Animal animal3 = new Animal("Gun", "Giraff");
        AnimalRecord animalRecord1 = new AnimalRecord(name, type);
        AnimalRecord animalRecord2 = new AnimalRecord(name, type);
        AnimalRecord animalRecord3 = new AnimalRecord(type);

        System.out.println("Animal1: " + animal1);
        System.out.println("AnimalRecord1: " + animalRecord1);

        System.out.println("Animal1: " + animal1.getName());
        System.out.println("AnimalRecord1: " + animalRecord1.name());

        System.out.println("Equals: " + animal1.equals(animal3));
        System.out.println("Equals: " + animalRecord1.equals(animalRecord2));

        System.out.println("Hashcode: " + animal1.hashCode());
        System.out.println("Hashcode: " + animal3.hashCode());
        System.out.println("Hashcode: " + animalRecord1.hashCode());
        System.out.println("Hashcode: " + animalRecord2.hashCode());

        System.out.println(animalRecord3);

    }
}
