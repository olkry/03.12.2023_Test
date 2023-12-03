package AnimalsClasses;

import java.util.List;

public class Pet extends Animal {
    private List<String> commands;


    public Pet(int id, String name, String type, String birthDate, List<String> commands) {
        super(id, name, type, birthDate);
        this.commands = commands;
    }
}
