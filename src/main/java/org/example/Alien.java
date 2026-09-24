package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Alien {
    @Id
    private int id;
    private String name;
    private int age;
    @OneToMany(mappedBy = "aline")
    private List<Laptop> laptops;

    public Alien(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", laptops=" + laptops +
                '}';
    }
}
