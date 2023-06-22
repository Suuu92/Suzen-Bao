package com.suzen.librarysystem;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

// Current user ID will be used to access the database when returning or borrowing books
import static com.suzen.librarysystem.Main.currentUserID;

public class BooksWindow implements Initializable {
    public ObservableList<Book> books = FXCollections.observableArrayList();
    public TableColumn titleCol;
    public TableColumn authorCol;
    public TableColumn genreCol;
    public TableColumn quantityCol;
    public TableColumn idCol;
    public TableView table;
    // Display the user ID and book taken out
    public Label lblTitle;
    public Label lblID;

    public static class Book {
        // Create fields for book object
        private final SimpleStringProperty title;
        private final SimpleStringProperty author;
        private final SimpleStringProperty genre;
        private final SimpleIntegerProperty quantity;
        private final SimpleIntegerProperty id;
        public static DatabaseHandler handler;

        // Create a book object
        public Book (String title, String author, String genre, int quantity, int id) {
            this.title = new SimpleStringProperty(title);
            this.author = new SimpleStringProperty(author);
            this.genre = new SimpleStringProperty(genre);
            this.quantity = new SimpleIntegerProperty(quantity);
            this.id = new SimpleIntegerProperty(id);
        }

        public String getTitle() {
            return title.get();
        }

        public String getAuthor() {
            return author.get();
        }

        public String getGenre() {
            return genre.get();
        }

        public int getQuantity() {
            return quantity.get();
        }

        public int getId() {
            return id.get();
        }

        // Add a book into the database table
        public static void addBook(Book book) {
            handler = DatabaseHandler.getHandler();
            String qu = "INSERT INTO BOOK VALUES (" +
                    "'" + book.getTitle() + "'," +
                    "'" + book.getAuthor() + "'," +
                    "'" + book.getGenre() + "'," +
                    book.getQuantity() + "," +
                    book.getId() + ")";
            handler.execAction(qu);
            System.out.println("Book is added");
        }
    }

    public void borrowBook(ActionEvent actionEvent) {
        // Choose a book (row) from the tableview
        Book temp;
        temp = (Book) table.getSelectionModel().getSelectedItem();
        // Get the chosen book's id and quantity
        int bookID = temp.getId();
        int bookQuantity = temp.getQuantity();
        String bookTitle = temp.getTitle();

        // Borrow a book by adding the book id into the user's table
        DatabaseHandler handler = DatabaseHandler.getHandler();
        String qu = "UPDATE USERS SET BOOK_ID = " + bookID +
                "WHERE ID = " + currentUserID;
        handler.execAction(qu);
        // Display the book that is taken out
        lblTitle.setText(bookTitle);

        // Reduce the book quantity by 1
        bookQuantity--;
        // Update the quantity in the book database
        String qu2 = "UPDATE BOOK SET QUANTITY = " + bookQuantity +
                "WHERE ID = " + bookID;
        handler.execAction(qu2);
        System.out.println("Book is taken out");
    }

    public void returnBook(ActionEvent actionEvent) throws SQLException {
        // Get the book title and quantity from the book table
        String bookTitle = getBookTitle(currentUserID);
        int bookQuantity = getBookQuantity(currentUserID);

        // Return a book by removing the book id from the user's table
        DatabaseHandler handler = DatabaseHandler.getHandler();
        String qu = "UPDATE USERS SET BOOK_ID = null WHERE ID = " + currentUserID;
        handler.execAction(qu);
        // Change the label back to null when the book is returned
        lblTitle.setText("");

        // Increase the book quantity by 1
        bookQuantity++;
        // Update the quantity in the book database
        String qu2 = "UPDATE BOOK SET QUANTITY = " + bookQuantity +
                "WHERE TITLE = '" + bookTitle + "'";
        handler.execAction(qu2);
        System.out.println("Book is returned");
    }

    // Pop up a window for the user to fill out the info of a new book
    public void openAddBookWindow(ActionEvent actionEvent) {
        loadWindow("addBookWindow.fxml", "Add a new book");
    }

    // Open a new window
    private void loadWindow(String location, String title) {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Initialize the user ID, book borrowed and tableview
    @Override
    public void initialize (URL location, ResourceBundle resources) {
        lblID.setText(Integer.toString(currentUserID));
        initiCol();
        // Show if the user borrowed a book
        try {
            lblTitle.setText(getBookTitle(currentUserID));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Initialize columns of the tableview
    private void initiCol() {
        titleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("Author"));
        genreCol.setCellValueFactory(new PropertyValueFactory<>("Genre"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    // Load the information of books from the database table
    // Enable the user to refresh each time when they add/borrow/return a book
    public void loadData() throws SQLException{
        // Clear the list first to avoid duplication
        books.clear();
        DatabaseHandler handler = DatabaseHandler.getHandler();
        String qu = "SELECT * FROM BOOK";
        ResultSet rs = handler.execQuery(qu);
        while (rs.next()) {
            String title = rs.getString("title");
            String author = rs.getString("author");
            String genre = rs.getString("genre");
            int quantity = Integer.parseInt(rs.getString("quantity"));
            int id = Integer.parseInt(rs.getString("id"));
            books.add(new Book(title, author, genre, quantity, id));
        }
        // Display all the books' info in the tableview
        table.getItems().setAll(books);
    }

    // Get the book borrowed from the user ID
    private String getBookTitle(int userID) throws SQLException {
        DatabaseHandler handler = DatabaseHandler.getHandler();
        int bookID = 0;
        // Use the current user ID to get the book ID from the users table
        String qu = "SELECT * FROM USERS WHERE ID = " + userID;
        ResultSet rs = handler.execQuery(qu);
        while(rs.next()) {
            bookID = rs.getInt("BOOK_ID");
        }

        String bookTitle = "";
        // Use the book ID to get the book title from the book table
        String qu2 = "SELECT * FROM BOOK WHERE ID = " + bookID;
        ResultSet rs2 = handler.execQuery(qu2);
        while (rs2.next()) {
            bookTitle = rs2.getString("TITLE");
        }
        return bookTitle;
    }

    // Get the book quantity from the user ID
    private int getBookQuantity(int userID) throws SQLException {
        DatabaseHandler handler = DatabaseHandler.getHandler();
        int bookID = 0;
        // Use the current user ID to get the book ID from the users table
        String qu = "SELECT * FROM USERS WHERE ID = " + userID;
        ResultSet rs = handler.execQuery(qu);
        while (rs.next()) {
            bookID = rs.getInt("BOOK_ID");
        }

        int quantity = 0;
        // Use the book ID to get the book quantity from the book table
        String qu2 = "SELECT * FROM BOOK WHERE ID = " + bookID;
        ResultSet rs2 = handler.execQuery(qu2);
        while (rs2.next()) {
            quantity = rs2.getInt("QUANTITY");
        }
        return quantity;
    }
}
