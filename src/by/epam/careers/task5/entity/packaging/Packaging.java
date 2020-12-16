package by.epam.careers.task5.entity.packaging;

import java.io.Serializable;
import java.util.Objects;

public class Packaging implements Serializable {
    private static final long serialVersionUID = 572572951277731678L;

    private PackagingType type;

    public Packaging() {
    }

    public Packaging(PackagingType type) {
        this.type = type;
    }

    public PackagingType getType() {
        return type;
    }

    public void setType(PackagingType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packaging packaging = (Packaging) o;
        return type == packaging.type;
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
