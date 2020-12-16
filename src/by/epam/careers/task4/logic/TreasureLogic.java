package by.epam.careers.task4.logic;

import by.epam.careers.task4.dao.FileTreasureDao;
import by.epam.careers.task4.entity.DragonCave;
import by.epam.careers.task4.entity.Treasure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TreasureLogic {
    private static TreasureLogic instance;

    private TreasureLogic() {
    }

    public static TreasureLogic getInstance() {
        if (instance == null) {
            instance = new TreasureLogic();
        }
        return instance;
    }

    public DragonCave loadTreasuresFromFile() throws IOException {
        List<Treasure> treasures = FileTreasureDao.getInstance().readAllTreasures();
        return new DragonCave(treasures);
    }

    public void saveTreasuresOnFile(DragonCave cave) throws IOException {
        FileTreasureDao.getInstance().writeAllTreasures(cave.getTreasures());
    }

    public List<Treasure> getTreasureByName(String name) throws IOException {
        return FileTreasureDao.getInstance().findTreasureByName(name);
    }

    public Treasure getOneTreasureFromFile(int poz) throws IOException {
        return FileTreasureDao.getInstance().readOneTreasure(poz);
    }

    public void overwriteTreasuresOnFile(DragonCave cave) throws IOException {
        FileTreasureDao.getInstance().overwriteTreasures(cave.getTreasures());
    }

    public void writeOneTreasureOnFile(Treasure treasure) throws IOException {
        FileTreasureDao.getInstance().writeOneTreasure(treasure);
    }

    public Treasure getMostExpensiveTreasure(List<Treasure> treasures) {
        List<Treasure> sorted = TreasureLogic.getInstance().sortByPrice(treasures);
        return sorted.get(sorted.size() - 1);
    }

    public List<Treasure> getTreasuresForGivenSum(List<Treasure> treasures, double givenAmount) {
        List<Treasure> found = new ArrayList<Treasure>();
        double sum = 0;
        for (Treasure treasure : treasures) {
            if (sum < givenAmount) {
                sum += treasure.getPrice();
                found.add(treasure);
            }
        }
        return found;
    }

    public List<Treasure> sortByPrice(List<Treasure> treasures) {
        List<Treasure> sorted = new ArrayList<Treasure>(treasures);
        sorted.sort(Comparator.comparing(Treasure::getPrice));
        return sorted;
    }

    public List<Treasure> sortByName(List<Treasure> treasures) {
        List<Treasure> sorted = new ArrayList<Treasure>(treasures);
        sorted.sort(Comparator.comparing(Treasure::getName));
        return sorted;
    }
}
