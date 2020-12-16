package by.epam.careers.task1.main;

import by.epam.careers.task1.entity.TextFile;
import by.epam.careers.task1.entity.Directory;
import by.epam.careers.task1.entity.File;
import by.epam.careers.task1.view.FileView;

/**Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.*/
public class Main {
    public static void main(String[] args) {
        FileView view = FileView.getInstance();

        Directory directory = new Directory("Новая папка");

        TextFile textFile = new TextFile("Новый файл", "Создать объект " +
                "класса Текстовый файл, используя классы Файл, Директория.");
        directory.addFile(textFile);

        textFile.changeName("Задание 1");
        textFile.supplementFile("Методы: создать, переименовать, вывести на " +
                "консоль содержимое, дополнить, удалить.");
        view.printFile("Содержимое файла", textFile);

        File example = TextFile.createTextFile("Новый файл", "Какое-то содержимое");
        directory.addFile(example);

        textFile.removeFile(textFile);
        view.printDirectory("Файлы в папке", directory.getFiles());
        directory.removeFileFromDirectory(example);
    }
}
