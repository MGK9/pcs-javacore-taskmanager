package ru.netology.javacore;

import com.google.gson.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            while (true) {
                try (Socket socket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    String taskInput = in.readLine();
                    JsonElement element = JsonParser.parseString(taskInput);
                    JsonObject object = element.getAsJsonObject();

                    String type = object.get("type").getAsString();
                    String task = object.get("task").getAsString();

                    switch (type) {
                        case "ADD":
                            todos.addTask(task);
                            break;
                        case ("REMOVE"):
                            todos.removeTask(task);
                            break;
                    }
                    out.println(todos.getAllTasks());
                }
            }

        } catch (IOException e) {
            System.out.println("I can't start the server");
            e.printStackTrace();
        }
    }
}