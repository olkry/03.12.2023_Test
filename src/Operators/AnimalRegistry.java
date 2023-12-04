package Operators;

import AnimalsClasses.Animal;
import AnimalsClasses.PackAnimal;
import AnimalsClasses.Pet;
import AnimalsClasses.SubClasses.*;

import java.io.*;
import java.util.*;

public class AnimalRegistry {
    private List<Animal> animalList;
    private static final String ALL_ANIMAL_LIST = "AllAnimal.dat";
    private int totalAnimalCount;

    public AnimalRegistry() {
        this.animalList = new ArrayList<>();
        this.totalAnimalCount = 6; // Число установил 6, т.к. на момент создания счётчика уже добавил 6 животных
    }

    private int generateID() {
        return animalList.size() + 1;
    }

    public void addAnimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введте тип животного (кошка, собака, хомяк, лошадь, верблюд, осёл): ");
        String type = scanner.nextLine();

        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();

        System.out.println("Введите дату рождения животного(гггг-мм-дд): ");
        String brithDate = scanner.nextLine();

        System.out.println("Введите команды животного через запятую: ");
        String commandInp = scanner.nextLine();
        List<String> commands = new ArrayList<>();
        if (!commandInp.isEmpty()) {
            String[] commandArray = commandInp.split(",");
            for (String command : commandArray) {
                commands.add(command.trim());
            }
        }


        Animal newAnimal;

        switch (type.toLowerCase()) {
            case "кошка":
                newAnimal = new Cat(generateID(), name, type, brithDate, commands);
                break;

            case "собака":
                newAnimal = new Dog(generateID(), name, type, brithDate, commands);
                break;

            case "хомяк":
                newAnimal = new Hamster(generateID(), name, type, brithDate, commands);
                break;

            case "лошадь":
                newAnimal = new Horse(generateID(), name, type, brithDate, commands);
                break;

            case "верблюд":
                newAnimal = new Camel(generateID(), name, type, brithDate, commands);
                break;

            case "осёл":
                newAnimal = new Donkey(generateID(), name, type, brithDate, commands);
                break;

            default:
                System.out.println("Неизвестный тип животного! Доступные типы указаны в скобках.");
                return;
        }

        animalList.add(newAnimal);
        totalAnimalCount++;
        System.out.println("Животное успешно добавленно в реестр");


    }

    public void displayRegistry() {
        System.out.println("Реестр домашних животных:");
        for (Animal animal : animalList) {
            animal.displayInfo();
            System.out.println("-----------------------------");
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ALL_ANIMAL_LIST))) {
            oos.writeObject(animalList);
            System.out.println("Данные успешно сохранены.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных в файл: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ALL_ANIMAL_LIST))) {
            List<Animal> loadedList = (List<Animal>) ois.readObject();
            animalList.clear();
            animalList.addAll(loadedList);
            System.out.println("Данные успешно загружены из файла.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки из файла: " + e.getMessage());
        }
    }

    public boolean containsAnimal(int animalId) {
        for (Animal animal : animalList) {
            if (animal.getId() == animalId) {
                return true;
            }
        }
        return false;
    }

    public Animal getAnimalById(int animalId) {
        for (Animal animal : animalList) {
            if (animal.getId() == animalId) {
                return animal;
            }
        }
        return null;
    }

    public void displayCommandsForAnimal() {
        System.out.println("Введите ID животного для отображения доступных команд: ");
        Scanner scanner = new Scanner(System.in);
        int animalID = scanner.nextInt();
        scanner.nextLine();

        if (containsAnimal(animalID)) {
            getAnimalById(animalID).displayCommands();
        } else {
            System.out.println("Животное с ID " + animalID + " не найдено в реестре.");
        }

    }

    public void trainAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID животного, которое вы хотите обучить:");
        int animalId = scanner.nextInt();
        scanner.nextLine();

        if (containsAnimal(animalId)) {
            Animal animal = getAnimalById(animalId);

            System.out.println("Введите новую команду для обучения:");
            String newCommand = scanner.nextLine();


            if (animal instanceof Pet) {
                Pet pet = (Pet) animal;
                pet.addCommand(newCommand);
                System.out.println(animal.getName() + " домашний питомец успешно обучено новой команде: " + newCommand);
            } else if (animal instanceof PackAnimal) {
                PackAnimal pet = (PackAnimal) animal;
                pet.addCommand(newCommand);
                System.out.println(animal.getName() + " животное успешно обучено новой команде: " + newCommand);
            } else {
                System.out.println("Это животное нельзя обучить командам.");
            }

        } else {
            System.out.println("Животное с ID " + animalId + " не найдено в реестре.");
        }
    }

    public void displayAnimalsByBirthDate() {
        if (animalList.isEmpty()) {
            System.out.println("Реестр животных пуст.");
            return;
        }
        System.out.println("-----------------------------------");
        System.out.println("Список животных по дате рождения:");

        Collections.sort(animalList, Comparator.comparing(Animal::getBirthDate));
        for (Animal animal : animalList) {
            System.out.println("Дата рождения: " + animal.getBirthDate() + ", Имя: " + animal.getName() +
                    ", Тип: " + animal.getType() + ", ID: " + animal.getId());
        }
        System.out.println("-----------------------------------");
    }

    public void displayTotalAnimalCount() {
        System.out.println("Общее количество созданных животных: " + totalAnimalCount);
    }
}
