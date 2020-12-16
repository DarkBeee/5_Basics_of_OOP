package by.epam.careers.task5.logic;

import by.epam.careers.task5.entity.Present;
import by.epam.careers.task5.entity.packaging.Packaging;
import by.epam.careers.task5.entity.sweets.Sweetness;
import by.epam.careers.task5.factory.PackagingFactory;
import by.epam.careers.task5.factory.SweetnessFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PresentManager {
    private static PresentManager instance;

    private PresentManager() {
    }

    public static PresentManager getInstance() {
        if (instance == null) {
            instance = new PresentManager();
        }
        return instance;
    }

    private static PackagingFactory packagingFactory = new PackagingFactory();
    private static SweetnessFactory sweetnessFactory = new SweetnessFactory();

    public Present createPresent(String packaging, String ... sweets) throws IOException {
        Packaging pack = createPackaging(packaging);
        List<Sweetness> sweetnesses = createSweets(sweets);
        if (pack == null || sweetnesses == null) {
            throw new IOException();
        }
        return new Present(sweetnesses, pack);
    }

    private Packaging createPackaging(String packaging) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(packaging);
        if (matcher.find()) {
            return packagingFactory.createPacking(packaging);
        }
        return null;
    }

    private List<Sweetness> createSweets(String ... sweets) {
        List<Sweetness> sweetnesses = new ArrayList<>();
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        for (String sweetness : sweets) {
            Matcher matcher = pattern.matcher(sweetness);
            if (matcher.find()) {
                Sweetness s = sweetnessFactory.createSweetness(sweetness);
                if (s != null) {
                    sweetnesses.add(s);
                }
            }
            else {
                return null;
            }
        }
        return sweetnesses;
    }
}
