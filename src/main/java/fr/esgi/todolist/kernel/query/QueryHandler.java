package fr.esgi.todolist.kernel.query;

import fr.esgi.todolist.kernel.UserActionHandler;

public interface QueryHandler<Q extends Query, R> extends UserActionHandler<Q, R> {
    R handle(Q query);
}
