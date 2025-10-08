package com.yourname.library;

public class Book {

    private int bookID;
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public Book(int bookID, String title, String author, String ISBN, boolean available) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = available;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
