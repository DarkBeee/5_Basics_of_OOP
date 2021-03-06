package by.epam.careers.task1.entity;

import java.util.Objects;

public abstract class File {
    private String fileName;

    public File() {
    }

    public File(String fileName) {
        this.fileName = fileName;
    }

    public abstract void removeFile(File file);

    public abstract void changeName(String name);

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(fileName, file.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName);
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}
