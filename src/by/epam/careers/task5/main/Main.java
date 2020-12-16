package by.epam.careers.task5.main;

import by.epam.careers.task5.entity.Present;
import by.epam.careers.task5.logic.PresentManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**Подарки. Реализовать приложение, позволяющее создавать подарки(объект, представляющий
 * собой подарок). Состовляющими целого подарка являются сладости и упаковка.*/
public class Main {
    private static Logger logger;

    static {
        try(FileInputStream ins = new FileInputStream("D:/logger/log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            logger = Logger.getLogger(Main.class.getName());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Present present1 = PresentManager.getInstance().createPresent("wooden", "chocolate", "beverage");
            System.out.println(present1);
            Present present2 = PresentManager.getInstance().createPresent("wooen", "chocolate", "beverage");
        } catch (IOException e) {
            logger.log(Level.WARNING, "Неверный ввод", e);
        }
    }
}
