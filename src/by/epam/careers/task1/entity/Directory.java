package by.epam.careers.task1.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory {
    private String directoryName;
    private List<Directory> directory;
    private List<File> files;
    {
       files = new ArrayList<File>();
       directory = new ArrayList<Directory>();
    }

    public Directory() {
    }

    public Directory(String directoryName) {
        this.directoryName = directoryName;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void removeFileFromDirectory(File f) {
        files.removeIf(file -> file.getFileName().equalsIgnoreCase(f.getFileName()));
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public List<Directory> getDirectory() {
        return directory;
    }

    public void setDirectory(List<Directory> directory) {
        this.directory = directory;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory1 = (Directory) o;
        return Objects.equals(directoryName, directory1.directoryName) &&
                Objects.equals(directory, directory1.directory) &&
                Objects.equals(files, directory1.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directoryName, directory, files);
    }

    @Override
    public String toString() {
        return "Directory{" +
                "directoryName='" + directoryName + '\'' +
                ", directory=" + directory +
                ", files=" + files +
                '}';
    }
}
