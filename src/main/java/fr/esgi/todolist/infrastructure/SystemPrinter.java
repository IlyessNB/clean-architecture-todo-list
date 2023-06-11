package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.domain.Printer;

public class SystemPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
