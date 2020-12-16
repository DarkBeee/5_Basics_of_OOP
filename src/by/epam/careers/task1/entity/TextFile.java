package by.epam.careers.task1.entity;

import java.util.Objects;

public class TextFile extends File {
    private String content;

    public TextFile() {
    }

    public TextFile(String fileName) {
        super(fileName);
    }

    public TextFile(String fileName, String content) {
        super(fileName);
        this.content = content;
    }

    @Override
    public void removeFile(File file) {
        file = null;
    }

    @Override
    public void changeName(String name) {
        this.setFileName(name);
    }

    public void supplementFile(String str) {
        content += str;
    }
    public static TextFile createTextFile(String name, String content) {
        File file = new TextFile(name, content);
        return (TextFile) file;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TextFile textFile = (TextFile) o;
        return Objects.equals(content, textFile.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content);
    }

    @Override
    public String toString() {
        return this.getFileName() + ".txt\n" + content;
    }
}
