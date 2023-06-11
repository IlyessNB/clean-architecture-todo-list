package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.domain.*;
import fr.esgi.todolist.domain.errors.FileWriterException;

import java.io.File;

public class JavaIoFileWriter implements FileWriter {
    @Override
    public void write(String filename, String content) {
        try {
            File file = new File(filename);
            file.getParentFile().mkdirs();
            file.createNewFile();

            java.io.FileWriter fileWriter = new java.io.FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (Exception e) {
            throw new FileWriterException("Error while writing file (filename = " + filename + ")");
        }
    }

    @Override
    public void append(String filename, String todoList) {
        try {
            File file = new File(filename);
            file.getParentFile().mkdirs();
            file.createNewFile();

            java.io.FileWriter fileWriter = new java.io.FileWriter(file, true);
            fileWriter.write(todoList);
            fileWriter.close();
        } catch (Exception e) {
            throw new FileWriterException("Error while appending file (filename = " + filename + ")");
        }
    }
}
