package Operators;

import AnimalsClasses.Animal;

import java.util.HashMap;
import java.util.Map;

public class AnimalRegistry {
    private Map<Integer, Animal> animalRegistry;

    public AnimalRegistry() {
        this.animalRegistry = new HashMap<>();
    }

    public void addAnimal(Animal animal){
        animalRegistry.put(animal.getId(), animal);
    }


}
