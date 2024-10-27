package org.todolistapp.todolist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TodoListAppController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}