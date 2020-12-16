package by.epam.careers.task4.main;

import by.epam.careers.task4.entity.DragonCave;
import by.epam.careers.task4.entity.Treasure;
import by.epam.careers.task4.logic.TreasureLogic;
import by.epam.careers.task4.view.TreasureView;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100
 * сокровищах в пещере дракона. Реализовать возможность просмотра сокровищ, выбора
 * самого дорогого по стоимости сокровища и выбора сокровищ на заданную сумму.*/
public class Main {
    private static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("D:/logger/log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Main.class.getName());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        TreasureLogic logic = TreasureLogic.getInstance();
        TreasureView view = TreasureView.getInstance();
        DragonCave cave = new DragonCave();
        try {
            cave = logic.loadTreasuresFromFile();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "IOException", e);
        }
        view.print("Сокровища пещеры", cave.getTreasures());

        Treasure mostExpensive = logic.getMostExpensiveTreasure(cave.getTreasures());
        view.print("Самое дорогое сокровище", mostExpensive);

        List<Treasure> find = logic.getTreasuresForGivenSum(cave.getTreasures(), 120.0);
        view.print("Сокровища на заданную сумму", find);
    }
}
