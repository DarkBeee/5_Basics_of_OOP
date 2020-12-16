package by.epam.careers.task4.entity;

import java.io.Serializable;
import java.util.Objects;

public class Treasure implements Serializable {
    private static final long serialVersionUID = 42496228595486L;

    private String name;
    private double price;
    private String description;

    {
        description = "";
    }

    public Treasure() {
    }

    public Treasure(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Treasure(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treasure treasure = (Treasure) o;
        return Double.compare(treasure.price, price) == 0 &&
                Objects.equals(name, treasure.name) &&
                Objects.equals(description, treasure.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description);
    }

    @Override
    public String toString() {
        return name + ", цена " + price +
                ", описание: " + description;
    }
}
