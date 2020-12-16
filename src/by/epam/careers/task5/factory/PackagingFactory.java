package by.epam.careers.task5.factory;

import by.epam.careers.task5.entity.packaging.*;

public class PackagingFactory {

    public Packaging createPacking(String type) {
        for (PackagingType packagingType : PackagingType.values()) {
            if (packagingType.toString().equalsIgnoreCase(type)) {
                return new Packaging(packagingType);
            }
        }
        return null;
    }
}
