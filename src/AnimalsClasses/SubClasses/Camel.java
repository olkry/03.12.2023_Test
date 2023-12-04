package AnimalsClasses.SubClasses;

import AnimalsClasses.PackAnimal;

import java.io.Serializable;
import java.util.List;

public class Camel extends PackAnimal implements Serializable {
    public static final long serialVersionUID = 1L;
    public Camel(int id, String name, String type, String birthDate, List<String> commands) {
        super(id, name, type, birthDate, commands);
    }

    @Override
    public void displayCommands() {
        if (getCommands().isEmpty()) {
            System.out.println(getName() + " не знает команд.");
        } else {
            System.out.println(getName() + " знает следующие команды:");
            for (String command : getCommands()) {
                System.out.println("- " + command);
            }
        }
    }
}
