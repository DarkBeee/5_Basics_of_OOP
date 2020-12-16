package by.epam.careers.task1.view;

import by.epam.careers.task1.entity.File;

import java.util.List;

public class FileView {
    private static FileView instance;

    private FileView() {
    }

    public static FileView getInstance() {
        if (instance == null) {
            instance = new FileView();
        }
        return instance;
    }

    public void printFile(File file) {
        System.out.println(file);
    }

    public void printFile(String message, File file) {
        System.out.println(message);
        System.out.println(file);
    }

    public void printDirectory(List<File> files) {
        for (File file : files) {
            System.out.println(file.getFileName());
        }
    }

    public void printDirectory(String message, List<File> files) {
        System.out.println(message);
        for (File file : files) {
            System.out.println(file.getFileName());
        }
    }
}
