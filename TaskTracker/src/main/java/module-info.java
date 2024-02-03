module com.tt.tasktracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens com.tt.tasktracker.entities to org.hibernate.orm.core, javafx.base;
    opens com.tt.tasktracker to javafx.fxml;
    exports com.tt.tasktracker;
    exports com.tt.tasktracker.controller;
    opens com.tt.tasktracker.controller to javafx.fxml;
    exports com.tt.tasktracker.util;
    opens com.tt.tasktracker.util to javafx.fxml;
}