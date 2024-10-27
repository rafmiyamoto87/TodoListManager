module org.todolistapp.todolist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.todolistapp.todolist to javafx.fxml;
    exports org.todolistapp.todolist;
}