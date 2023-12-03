package AnimalsClasses.SubClasses;

import AnimalsClasses.PackAnimal;

import java.util.List;

public class Horse extends PackAnimal {
    public Horse(int id, String name, String type, String birthDate, List<String> commands) {
        super(id, name, type, birthDate, commands);
    }
}
