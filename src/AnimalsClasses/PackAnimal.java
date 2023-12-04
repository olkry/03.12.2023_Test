package AnimalsClasses;

import java.io.Serializable;
import java.util.List;

public class PackAnimal extends Animal implements Serializable {
    private List<String> commands;

    public static final long serialVersionUID = 1L;

    public List<String> getCommands() {
        return commands;
    }

    public PackAnimal(int id, String name, String type, String birthDate, List<String> commands) {
        super(id, name, type, birthDate);
        this.commands = commands;
    }

    @Override
    public void displayCommands() {
        if (commands.isEmpty()) {
            System.out.println("У этого домашнего животного нет известных команд.");
        } else {
            System.out.println("Список команд, которые знает " + getName() + ":");
            for (String command : commands) {
                System.out.println("- " + command);
            }
        }
    }
}
