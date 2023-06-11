package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.domain.*;
import fr.esgi.todolist.domain.errors.FileWriterException;

public class JavaIoFileWriter implements FileWriter {
    @Override
    public void write(String filename, String content) {
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(filename);
            fileWriter.write(content);
            fileWriter.close();
        } catch (Exception e) {
            throw new FileWriterException("Error while writing file (filename = " + filename + ")");
        }
    }
}
