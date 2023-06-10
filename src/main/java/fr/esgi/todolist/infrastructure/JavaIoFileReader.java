package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.domain.FileReader;
import fr.esgi.todolist.domain.errors.FileReaderException;

import java.nio.file.Files;
import java.nio.file.Path;

public class JavaIoFileReader implements FileReader {
    @Override
    public String read(String filename) {
        try {
            Path filePath = Path.of(filename);
            return Files.readString(filePath);
        } catch (Exception e) {
            throw new FileReaderException("Error while reading file (filename = " + filename + ")");
        }
    }
}
