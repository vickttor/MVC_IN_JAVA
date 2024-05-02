package padraomvc.model.bean;

import padraomvc.enums.Gender;

import java.io.Serializable;

public class Pet implements Serializable {

    private int id;
    private String name;
    private Gender gender;
    private int age;

    public Pet(int id) {
        this.id = id;
    }
    
    public Pet(String name) {
        this.name = name;
    }

    public Pet(int id, String name, Gender gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Pet(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + '}';
    }
}
