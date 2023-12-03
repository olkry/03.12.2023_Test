package AnimalsClasses.SubClasses;

import AnimalsClasses.Pet;

import java.util.List;

class Cat extends Pet {
    public Cat(int id, String name, String type, String birthDate, List<String> commands) {
        super(id, name, type, birthDate, commands);
    }
}
