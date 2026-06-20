package com.example.demo1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection connect() {
        try {
            // ✅ Driver is now present, no error
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/studentdb_new", // ✅ YOUR NEW DB
                    "postgres",
                    "YOUR_PASSWORD_HERE" // ✅ YOUR PASSWORD
            );
        } catch (Exception e) {
            System.err.println("❌ Connection Failed: " + e.getMessage());
            return null;
        }
    }
}
