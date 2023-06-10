package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.domain.*;
import fr.esgi.todolist.domain.errors.FileWriterException;

public class JavaIoFileWriter implements FileWriter {
    @Override
    public void write(String filename, String todoList) {
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(filename);
            fileWriter.write(todoList);
            fileWriter.close();
        } catch (Exception e) {
            throw new FileWriterException("Error while writing file (filename = " + filename + ")");
        }
    }
}
