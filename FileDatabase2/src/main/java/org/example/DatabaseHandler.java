package org.example;

import java.sql.*;

public class DatabaseHandler {
    private static final String DB_url = "jdbc:derby:database/forum;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    public static String name;
    public static DatabaseHandler handler;

    public DatabaseHandler() {
        createConnection();
        createTable();
    }

    public static DatabaseHandler getHandler() {
        // Initiate the handler every time
        if (handler == null) {
            handler = new DatabaseHandler();
        }
        return handler;
    }
    private void createConnection() {
        // Connect to the database
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_url);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void createTable() {
        // Create a table with the name of directory
        String TABLE_NAME = name;
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, TABLE_NAME, null);
            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + " already exists");
            } else {
                // Apart from id, add four fields to the table: file name, path, extension, size in bytes
                String statement = "CREATE TABLE " + TABLE_NAME + "("
                        + "id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), \n"
                        + "file_name varchar(200),\n"
                        + "path varchar(200),\n"
                        + "extension varchar(200),\n"
                        + "size_in_bytes varchar(200))";
                System.out.println(statement);
                stmt.execute(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Send information to the table
    public boolean execAction (String qu) {
        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Pull information from the table and return it as a result set
    public ResultSet execQuery (String qu) {
        ResultSet resultSet;
        try {
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(qu);
        } catch (SQLException e) {
            System.out.println("Exception at Execute query");
            return null;
        }
        return resultSet;
    }
}
