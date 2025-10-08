package com.yourname.library;

import java.util.List;
import java.util.ArrayList;
public class Member {
    private int memberID;
    private String name;
    private String email;
    private List<Book> borrowedBooks;

    public Member(int memberID, String name, String email, List<Book> borrowedBooks) {
        this.memberID = memberID;
        this.name = name;
        this.email = email;
        this.borrowedBooks = borrowedBooks;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(book.getBookID()+ " borrowed successfully!");
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook(Book book){
        if (borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println(book.getTitle() + "returned successfully!");
        }else {
            System.out.println("This member has not borrowed" + book.getTitle());
        }
    }

    public void listBorrowedBooks(){
        if (borrowedBooks.isEmpty()){
            System.out.println("Noo books currently borrowed.");
        }else{
            System.out.println("Borrowed books: ");
            for (Book book:borrowedBooks){
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }




}
