package by.epam.careers.task4.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DragonCave implements Serializable {
    private static final long serialVersionUID = 51084931142168L;

    private List<Treasure> treasures;

    {
        treasures = new ArrayList<Treasure>();
    }

    public DragonCave() {
    }

    public DragonCave(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    public Treasure getOneTreasure(int i) {
        return treasures.get(i);
    }

    public void setOneTreasure(Treasure treasure, int i) {
        treasures.add(i, treasure);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DragonCave that = (DragonCave) o;
        return Objects.equals(treasures, that.treasures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treasures);
    }

    @Override
    public String toString() {
        return "DragonCave{" +
                "treasures=" + treasures +
                '}';
    }
}
