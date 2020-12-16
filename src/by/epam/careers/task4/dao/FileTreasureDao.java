package by.epam.careers.task4.dao;

import by.epam.careers.task4.entity.Treasure;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTreasureDao implements TreasureDao {
    private static FileTreasureDao instance;

    private static String fileLocation = "C:/Users/Владислав/IdeaProjects/" +
            "IntroductionToJava/Module05/src/by/epam/task4/resources/treasures.csv";

    private FileTreasureDao() {
    }

    public static FileTreasureDao getInstance() {
        if (instance == null) {
            instance = new FileTreasureDao();
        }
        return instance;
    }

    @Override
    public void writeAllTreasures(List<Treasure> treasures) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true));
        for (Treasure treasure : treasures) {
            writer.write(treasure.getName() + ";" + treasure.getPrice()
                    + ";" + treasure.getDescription() + '\n');
        }
        writer.close();
    }

    @Override
    public Treasure readOneTreasure(int lineNumber) throws IOException {
        Treasure treasure = null;
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        String line = reader.readLine();
        int i = 1;
        while (i < lineNumber) {
            line = reader.readLine();
            i++;
        }
        String[] reading = line.split(";");
        treasure = new Treasure(reading[0], Double.parseDouble(reading[1].trim()), reading[2]);
        reader.close();
        return treasure;
    }

    @Override
    public void writeOneTreasure(Treasure treasure) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true));
        writer.write(treasure.getName() + ";" +
                treasure.getPrice() + ";" + treasure.getDescription() + '\n');
        writer.close();
    }

    @Override
    public List<Treasure> findTreasureByName(String name) throws IOException {
        List<Treasure> treasures = new ArrayList<Treasure>();
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        String line = reader.readLine();
        while (line != null) {
            String[] reading = line.split(";");
            if (reading[0].trim().equalsIgnoreCase(name.trim())) {
                treasures.add(new Treasure(reading[0],
                        Double.parseDouble(reading[1].trim()), reading[2]));
            }
            line = reader.readLine();
        }
        reader.close();
        return treasures;
    }

    @Override
    public void overwriteTreasures(List<Treasure> treasures) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation));
        for (Treasure treasure : treasures) {
            writer.write(treasure.getName() + ";" + treasure.getPrice()
                    + ";" + treasure.getDescription() + '\n');
        }
        writer.close();
    }

    @Override
    public List<Treasure> readAllTreasures() throws IOException {
        List<Treasure> treasures = new ArrayList<Treasure>();
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        String line = reader.readLine();
        while (line != null) {
            String[] treasure = line.split(";");
            treasures.add(new Treasure(treasure[0],
                    Double.parseDouble(treasure[1].trim()), treasure[2]));
            line = reader.readLine();
        }
        reader.close();
        return treasures;
    }
}
