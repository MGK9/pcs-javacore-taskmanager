package ru.netology.javacore;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

public class TodosTests {

    @BeforeAll
    public static void start() {
        System.out.println("Tests started");
    }

    @AfterAll
    public static void finish() {
        System.out.print("Tests finished");
    }

    @Test
    public void addTaskTest() {
        String task1 = "task1";

        Todos todos = new Todos();
        todos.addTask(task1);
        List<String> result = todos.getTasksList();
        List<String> expected = Arrays.asList(task1);
        Assertions.assertEquals(expected, result);
        System.out.println("Test add todos");
    }

    @Test
    public void removeTaskTest(){
        String task1 = "task1";
        String task2 = "task2";

        Todos todos = new Todos();
        todos.addTask(task1);
        todos.addTask(task2);
        todos.removeTask(task2);
        List<String> result = todos.getTasksList();
        List<String> expected = Arrays.asList(task1);
        Assertions.assertEquals(expected, result);
        System.out.println("Test check one todos");
    }

    @Test
    public void addTwoTaskTest() {
        String task1 = "task1";
        String task2 = "task2";

        Todos todos = new Todos();
        todos.addTask(task1);
        todos.addTask(task2);
        List<String> result = todos.getTasksList();
        List<String> expected = Arrays.asList(task1, task2);
        Assertions.assertEquals(expected, result);
        System.out.println("Test add two todos");
    }
}