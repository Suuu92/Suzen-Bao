package com.suzen.librarysystem;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddBookWindow {
    public TextField textTitle;
    public TextField textAuthor;
    public TextField textGenre;
    public TextField textQuantity;
    public TextField textID;
    public Button addAndCloseButton;

    public void getBookInfo(ActionEvent actionEvent) {
        // Get the information of the book
        String title = textTitle.getText();
        String author = textAuthor.getText();
        String genre = textGenre.getText();
        int quantity = Integer.parseInt(textQuantity.getText());
        int bookID = Integer.parseInt(textID.getText());
        // Create a new book and add it to the table
        BooksWindow.Book book = new BooksWindow.Book(title, author, genre, quantity, bookID);
        BooksWindow.Book.addBook(book);

        // Clear the fields
        textTitle.clear();
        textAuthor.clear();
        textGenre.clear();
        textQuantity.clear();
        textID.clear();
    }
}
