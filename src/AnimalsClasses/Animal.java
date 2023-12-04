package AnimalsClasses;

import java.io.Serializable;

public class Animal implements Serializable {
    private int id;
    private String name;
    private String type;
    private String birthDate;

    public static final long serialVersionUID = 1L;

    /**
     * @return Метод возвращает ID животного.
     */
    public int getId() {
        return id;
    }

    /**
     * @return Метод возвращает имя животного.
     */
    public String getName() {
        return name;
    }

    public Animal(int id, String name, String type, String birthDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
    }

    /**
     * Метод построчно выводит основную информацию по животному.
     */
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Имя: " + name);
        System.out.println("Тип: " + type);
        System.out.println("Дата рождения: " + birthDate);
    }

    /**
     * Метод выводит доступные для животного команды.
     */
    public void displayCommands() {
        System.out.println("Это животное не знает команд.");
    }

    /**
     * @return Метод возвращает дату рождения животного.
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @return Метод возвращает тип животного.
     */
    public String getType() {
        return type;
    }
}
