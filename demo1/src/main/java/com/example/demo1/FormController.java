package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.*;

public class FormController {
    @FXML private TextField txtName;
    @FXML private TextField txtCourse;
    @FXML private TextField txtYear;

    @FXML
    private void saveStudent() {
        Connection conn = DBConnection.connect();
        if (conn == null) return;

        try {
            String sql = "INSERT INTO students (name, course, year_level) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtName.getText());
            pstmt.setString(2, txtCourse.getText());
            pstmt.setInt(3, Integer.parseInt(txtYear.getText()));
            pstmt.executeUpdate();
            conn.close();
            goToList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToList() throws Exception {
        MainApp.switchToList();
    }
}