package org.example;

import jakarta.persistence.*;

@Entity
public class Laptop {
    @Id
    private int id;
    private String brand;
    private int ram;

    @ManyToOne
    @JoinColumn(name = "aid")
    private Alien aline;


    public Laptop(int id, String brand, int ram) {
        this.id = id;
        this.brand = brand;
        this.ram = ram;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public Alien getAline() {
        return aline;
    }

    public void setAline(Alien aline) {
        this.aline = aline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", ram=" + ram +
                '}';
    }
}
