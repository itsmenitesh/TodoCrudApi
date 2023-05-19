package com.TodoApplication.DemoApplication.models;

public class Todo {
    private String id;
    private String todoNames;
    private boolean totStatus;
    public Todo(String id, String todoNames, boolean totStatus) {
        this.id = id;
        this.todoNames = todoNames;
        this.totStatus = totStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTodoNames() {
        return todoNames;
    }

    public void setTodoNames(String todoNames) {
        this.todoNames = todoNames;
    }

    public boolean isTotStatus() {
        return totStatus;
    }

    public void setTotStatus(boolean totStatus) {
        this.totStatus = totStatus;
    }


}
