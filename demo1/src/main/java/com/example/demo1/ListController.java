package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.*;

public class ListController { // ✅ NAME HERE — FIXES ERROR
    @FXML private TableView<Student> table;
    @FXML private TableColumn<Student, Integer> colId;
    @FXML private TableColumn<Student, String> colName;
    @FXML private TableColumn<Student, String> colCourse;
    @FXML private TableColumn<Student, Integer> colYear;

    private final ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(d -> d.getValue().idProperty().asObject());
        colName.setCellValueFactory(d -> d.getValue().nameProperty());
        colCourse.setCellValueFactory(d -> d.getValue().courseProperty());
        colYear.setCellValueFactory(d -> d.getValue().yearLevelProperty().asObject());
        loadData();
    }

    private void loadData() {
        studentList.clear();
        Connection conn = DBConnection.connect();
        if (conn == null) return;
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
            while (rs.next()) {
                studentList.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getInt("year_level")
                ));
            }
            table.setItems(studentList);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToForm() throws Exception {
        MainApp.switchToForm();
    }
}