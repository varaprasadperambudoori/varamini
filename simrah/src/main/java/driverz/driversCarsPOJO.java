package driverz;

import java.util.List;


public class driversCarsPOJO {
    private String name;

    private int age;
    private List cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List getCars() {
        return cars;
    }

    public void setCars(List cars) {
        this.cars = cars;
    }

}