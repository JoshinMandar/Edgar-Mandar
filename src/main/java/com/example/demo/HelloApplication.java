package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.demo.ApplicationProperties.*;

public class HelloApplication extends Application {

    ArrayList<Course> courses = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        createSampleData();

        BorderPane root = new BorderPane();
        Circle profile = new Circle(30);
        profile.setFill(Color.WHITE);
        profile.setStroke(PROFILE_COLOR);
        profile.setStrokeWidth(2);

        Text dashboard = new Text("MY DASHBOARD");
        dashboard.setFont(TITLE_FONT);
        dashboard.setFill(TEXT_COLOR);

        VBox top = new VBox(SPACING);
        top.getChildren().addAll(profile, dashboard);
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(PADDING, PADDING, SPACING, PADDING));
        root.setTop(top);


        VBox classList = new VBox(PADDING);
        classList.setPadding(new Insets(SPACING, PADDING, PADDING, PADDING));
        classList.setAlignment(Pos.TOP_CENTER);
        for (Course course : courses) {
            classList.getChildren().add(createClassCard(course));
        }
        root.setCenter(classList);

        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        stage.setTitle("MyAssignment");
        stage.setScene(scene);
        stage.show();
    }


    private VBox createClassCard(Course course) {

        Text className = new Text(course.getClassCode() + " - " + course.getClassName());
        className.setFont(CLASS_FONT);
        className.setFill(TEXT_COLOR);

        Button editButton = new Button("Edit");
        Button toggleButton = new Button("▼");

        HBox header = new HBox(SPACING);
        header.getChildren().addAll(className, editButton, toggleButton);
        header.setAlignment(Pos.CENTER);


        VBox assignmentList = new VBox(5);
        assignmentList.setPadding(new Insets(5, 0, 0, 0));
        assignmentList.setAlignment(Pos.CENTER);
        for (Assignment assignment : course.getAssignments()) {
            Text info = new Text(assignment.getInformation());
            info.setFont(BODY_FONT);
            if (assignment.isCompleted()) {
                info.setFill(COMPLETED_COLOR);
            } else {
                info.setFill(TEXT_COLOR);
            }
            assignmentList.getChildren().add(info);
        }

        VBox card = new VBox(5);
        card.getChildren().addAll(header, assignmentList);
        card.setAlignment(Pos.CENTER);


        toggleButton.setOnAction(e -> {
            if (card.getChildren().contains(assignmentList)) {
                card.getChildren().remove(assignmentList);
                toggleButton.setText("▶");
            } else {
                card.getChildren().add(assignmentList);
                toggleButton.setText("▼");
            }
        });


        TextField tfClassName = new TextField(course.getClassName());
        Button saveButton = new Button("Save");

        editButton.setOnAction(e -> {
            tfClassName.setText(course.getClassName());
            header.getChildren().clear();
            header.getChildren().addAll(tfClassName, saveButton);
        });

        saveButton.setOnAction(e -> {
            String newName = tfClassName.getText().trim();
            if (!newName.isEmpty()) {
                course.setClassName(newName);
            }
            className.setText(course.getClassCode() + " - " + course.getClassName());
            header.getChildren().clear();
            header.getChildren().addAll(className, editButton, toggleButton);
        });

        return card;
    }
    private void createSampleData() {
        Course mad302 = new Course(1, "Java Desktop Apps", "MAD 302", "Cai Filiault");
        mad302.addAssignment(new Assignment(1, "Assignment 1", "Lab", "2026-11-20", false));
        mad302.addAssignment(new Assignment(2, "Assignment 2", "Quiz", "2026-11-27", false));
        mad302.addAssignment(new Assignment(3, "Assignment 3", "Test", "2026-11-06", true));

        Course mad402 = new Course(2, "UX Design", "MAD 402", "Instructor B");
        mad402.addAssignment(new Assignment(4, "Assignment 1", "Lab", "2026-10-30", true));
        mad402.addAssignment(new Assignment(5, "Assignment 2", "Quiz", "2026-11-22", false));
        mad402.addAssignment(new Assignment(6, "Assignment 3", "Test", "2026-12-04", false));

        courses.add(mad302);
        courses.add(mad402);
    }
}
