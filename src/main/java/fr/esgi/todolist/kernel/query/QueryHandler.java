package fr.esgi.todolist.kernel.query;

public interface QueryHandler<Q extends Query, R> {
    R handle(Q query);
}
