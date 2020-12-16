package by.epam.careers.task5.factory;

import by.epam.careers.task5.entity.sweets.*;

public class SweetnessFactory {

    public Sweetness createSweetness(String type) {
        for (SweetnessType sweetnessType : SweetnessType.values()) {
            if (sweetnessType.toString().equalsIgnoreCase(type)) {
                return new Sweetness(sweetnessType);
            }
        }
        return null;
    }
}
