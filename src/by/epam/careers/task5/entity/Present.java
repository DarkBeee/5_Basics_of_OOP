package by.epam.careers.task5.entity;

import by.epam.careers.task5.entity.packaging.Packaging;
import by.epam.careers.task5.entity.sweets.Sweetness;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Present implements Serializable {
    private static final long serialVersionUID = 492361283122551807L;

    private List<Sweetness> sweets;
    private Packaging packaging;

    {
        sweets = new ArrayList<>();
    }

    public Present() {
    }

    public Present(Packaging packaging) {
        this.packaging = packaging;
    }

    public Present(List<Sweetness> sweets, Packaging packaging) {
        this.sweets = sweets;
        this.packaging = packaging;
    }

    public List<Sweetness> getSweets() {
        return sweets;
    }

    public void setSweets(List<Sweetness> sweets) {
        this.sweets = sweets;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Present present = (Present) o;
        return sweets.equals(present.sweets) && packaging.equals(present.packaging);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sweets, packaging);
    }

    @Override
    public String toString() {
        return "Gift content \nsweets:" + sweets +
                "\npackaging: " + packaging;
    }
}
