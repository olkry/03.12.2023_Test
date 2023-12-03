package AnimalsClasses;

public class Animal {
    private int id;
    private String name;
    private String type;
    private String birthDate;

    public int getId() {
        return id;
    }

    public Animal(int id, String name, String type, String birthDate){
        this.id = id;
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
    }


}
