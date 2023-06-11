package fr.esgi.todolist.kernel.command;

import fr.esgi.todolist.kernel.UserActionHandler;

public interface CommandHandler<C extends Command, R> extends UserActionHandler<C, R> {
    R handle(C command);
}

