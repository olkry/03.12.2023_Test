package AnimalsClasses;

import java.io.Serializable;

public class Animal implements Serializable  {
    private int id;
    private String name;
    private String type;
    private String birthDate;

    public static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Animal(int id, String name, String type, String birthDate){
        this.id = id;
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
    }

    public void displayInfo(){
        System.out.println("ID: " + id);
        System.out.println("Имя: " + name);
        System.out.println("Тип: " + type);
        System.out.println("Дата рождения: " + birthDate);
    }

    public void displayCommands() {
        System.out.println("Это животное не знает команд.");
    }

}
