package com.suzen.librarysystem;

import java.sql.*;

public class DatabaseHandler {
    private static final String DB_url = "jdbc:derby:database/forum;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    public static DatabaseHandler handler = null;

    public DatabaseHandler() {
        // Connect to the database and tables
        createConnection();
        createUserTable();
        createBookTable();
    }

    public static DatabaseHandler getHandler() {
        if (handler == null) {
            handler = new DatabaseHandler();
        }
        return handler;
    }

    private void createConnection() {
        // Connect to the database
        try {
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

    private void createUserTable() {
        // Create a table to store all the users' info
        String TABLE_NAME = "USERS";
        try{
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null,null, TABLE_NAME,null);
            if (tables.next()){
                System.out.println("Table " + TABLE_NAME + " already exists");
            } else {
                // Unique id for every user, book id recorded for every book taken out
                String statement = "CREATE TABLE " + TABLE_NAME + "("
                        + "id INT NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), \n"
                        + "first_name varchar(200), \n"
                        + "last_name varchar(200), \n"
                        + "pin INT, \n"
                        + "book_id INT )";
                System.out.println(statement);
                stmt.execute(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createBookTable() {
        // Create a book table to display all the books
        String TABLE_NAME = "BOOK";
        try{
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null,null, TABLE_NAME,null);
            if (tables.next()){
                System.out.println("Table " + TABLE_NAME + " already exists");
            } else {
                // add 5 fields for each book
                String statement = "CREATE TABLE " + TABLE_NAME + "("
                        + "title varchar(200), \n"
                        + "author varchar(200), \n"
                        + "genre varchar(200), \n"
                        + "quantity INT, \n"
                        + "id INT )";
                System.out.println(statement);
                stmt.execute(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean execAction(String qu) {
        try{
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("info not entered");
        }
        return false;
    }

    public ResultSet execQuery(String query) {
        ResultSet resultSet;
        try{
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultSet;
    }
}
