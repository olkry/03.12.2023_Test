package AnimalsClasses.SubClasses;

import AnimalsClasses.Pet;

import java.util.List;

class Dog extends Pet {
    public Dog(int id, String name, String type, String birthDate, List<String> commands) {
        super(id, name, type, birthDate, commands);
    }
}
