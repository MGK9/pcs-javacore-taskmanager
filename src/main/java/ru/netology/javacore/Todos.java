package ru.netology.javacore;

import java.util.*;

public class Todos {

    private List<String> tasksList = new ArrayList<>();

    public void addTask(String task) {
        tasksList.add(task);
    }

    public void removeTask(String task) {
        tasksList.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(tasksList);
        StringBuilder sb = new StringBuilder();
        for (String task : tasksList) {
            sb.append(task).append(" ");
        }
        return sb.toString();
    }

    public List<String> getTasksList() {
        return tasksList;
    }
}