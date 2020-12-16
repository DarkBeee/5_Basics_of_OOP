package by.epam.careers.task5.entity.sweets;

import java.io.Serializable;
import java.util.Objects;

public class Sweetness implements Serializable {
    private static final long serialVersionUID = 262595029940270684L;

    private SweetnessType type;

    public Sweetness() {
    }

    public Sweetness(SweetnessType type) {
        this.type = type;
    }

    public SweetnessType getType() {
        return type;
    }

    public void setType(SweetnessType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweetness sweetness = (Sweetness) o;
        return type == sweetness.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
