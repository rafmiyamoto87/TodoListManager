package org.todolistapp.todolist;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class TodoListApp extends Application {

    private ObservableList<String> tasks;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        tasks = FXCollections.observableArrayList();

        // UI Components
        ListView<String> taskListView = new ListView<>(tasks);
        TextField taskInput = new TextField();
        taskInput.setPromptText("Enter new task");

        // Buttons styled with BootstrapFX classes
        Button addButton = new Button("Add Task");
        addButton.getStyleClass().addAll("btn", "btn-primary"); // Bootstrap-like primary button style

        Button removeButton = new Button("Remove Task");
        removeButton.getStyleClass().addAll("btn", "btn-danger"); // Bootstrap-like danger button style

        // Layout
        HBox inputBox = new HBox(10, taskInput, addButton, removeButton);
        VBox layout = new VBox(10, taskListView, inputBox);

        // Scene and Stage
        Scene scene = new Scene(layout, 400, 300);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet()); // Add BootstrapFX stylesheet

        primaryStage.setScene(scene);
        primaryStage.setTitle("To-Do List Manager with BootstrapFX");
        primaryStage.show();

        // Event Handlers
        addButton.setOnAction(e -> {
            String newTask = taskInput.getText();
            if (!newTask.isEmpty()) {
                tasks.add(newTask);
                taskInput.clear();
            }
        });

        removeButton.setOnAction(e -> {
            String selectedTask = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                tasks.remove(selectedTask);
            }
        });
    }
}
