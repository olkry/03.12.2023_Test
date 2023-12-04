package Terminal;

import Operators.AnimalRegistry;

import java.util.Scanner;

public class terminal {

    public void startTerminal() {
        AnimalRegistry animalRegistry = new AnimalRegistry();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Загрузить из файла");
            System.out.println("2. Просмотреть реестр");
            System.out.println("3. Добавить новое животное");
            System.out.println("4. Отобразить список команд для животного");
            System.out.println("5. Обучить животное новой команде");
            System.out.println("8. Сохранить в файл");
            System.out.println("9. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    animalRegistry.loadFromFile();
                    break;

                case 3:
                    animalRegistry.addAnimal();
                    break;

                case 2:
                    animalRegistry.displayRegistry();
                    break;

                case 4:
                    animalRegistry.displayCommandsForAnimal();
                    break;

                case 5:
                    animalRegistry.trainAnimal();
                    break;

                case 8:
                    animalRegistry.saveToFile();
                    break;

                case 9:
                    System.out.println("Завершение работы программы");
                    System.exit(0);

                default:
                    System.out.println("Неверный выбор. Попробуйте ещё раз.");
            }
        }
    }
}
