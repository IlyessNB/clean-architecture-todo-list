package fr.esgi.todolist.domain;

public enum TaskState {
    TODO("TODO"),
    PENDING("PENDING"),
    PROGRESS("PROGRESS"),
    DONE("DONE"),
    CANCELLED("CANCELLED"),
    CLOSED("CLOSED");

    private final String taskState;

    TaskState() {
        this.taskState = this.name().toUpperCase();
    }

    TaskState(String state) {
        this.taskState = state;
    }

    public String getTaskState() {
        return taskState;
    }
}
