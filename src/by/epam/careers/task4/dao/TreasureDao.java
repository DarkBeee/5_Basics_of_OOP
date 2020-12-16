package by.epam.careers.task4.dao;

import by.epam.careers.task4.entity.Treasure;

import java.io.IOException;
import java.util.List;

public interface TreasureDao {

    public List<Treasure> readAllTreasures() throws IOException;

    public void writeAllTreasures(List<Treasure> treasures) throws IOException;

    public Treasure readOneTreasure(int lineNumber) throws IOException;

    public void writeOneTreasure(Treasure treasure) throws IOException;

    public List<Treasure> findTreasureByName(String name) throws IOException;

    public void overwriteTreasures(List<Treasure> treasures) throws IOException;
}
