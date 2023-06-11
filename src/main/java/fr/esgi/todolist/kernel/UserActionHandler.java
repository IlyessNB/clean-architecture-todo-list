package fr.esgi.todolist.kernel;

import fr.esgi.todolist.domain.UserAction;

public interface UserActionHandler<U extends UserAction, R> {
    R handle(U userAction);
}

