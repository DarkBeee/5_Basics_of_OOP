package by.epam.careers.task4.view;

import by.epam.careers.task4.entity.Treasure;

import java.util.List;

public class TreasureView {
    private static TreasureView instance;

    private TreasureView() {
    }

    public static TreasureView getInstance() {
        if (instance == null) {
            instance = new TreasureView();
        }
        return instance;
    }

    public void print(List<Treasure> treasures) {
        for (Treasure treasure : treasures) {
            System.out.println(treasure);
        }
    }

    public void print(String message, List<Treasure> treasures) {
        System.out.println(message);
        for (Treasure treasure : treasures) {
            System.out.println(treasure);
        }
    }

    public void print(String message, Treasure treasure) {
        System.out.println(message);
        System.out.println(treasure);
    }
}
