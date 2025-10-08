package com.yourname.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private  List <Member> members;

    public Library(){
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(int bookId){
        Book bookToRemove = findBook(bookId);
        if (bookToRemove != null){
            books.remove(bookToRemove);
            System.out.println("Book removed: " + bookToRemove.getTitle());
        }else {
            System.out.println("Book not found!");
        }
    }

    public Book findBook(int bookID){
        for (Book book:books){
            if (book.getBookID() == bookID){
                return book;
            }
        }
        return null;
    }

    public Book findBookByTitle(String title){
        for (Book book:books){
            if (book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;
    }

    public List<Book> getAllBooks(){
        return new ArrayList<>(books);
    }

    public void registerMember(Member member){
        members.add(member);
        System.out.println("Member registered: " + member.getName());
    }

    public void removeMember(int memberId){
        Member memberToRemove = findMember(memberId);
        if (memberToRemove != null){
            members.remove(memberToRemove);
            System.out.println("Member removed: " + memberToRemove.getName());
        }else {
            System.out.println("Member not found!");
        }

    }

    public Member findMember(int memberId){
        for (Member member : members){
            if (member.getMemberID() == memberId){
                return member;
            }
        }
        return null;
    }

    public List<Member> getAllMembers(){
        return new ArrayList<>(members);
    }

    public void issueBook(int memberId, int bookId){
        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member == null){
            System.out.println("Member not found!");
            return;
        }

        if (book == null){
            System.out.println("Book not found!");
            return;
        }

        member.borrowBook(book);
    }
    public void returnBook(int memberId, int bookId){

        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member == null){
            System.out.println("Member not found!");
            return;
        }

        if (book == null){
            System.out.println("Book not found!");
            return;
        }

        member.returnBook(book);
    }

    public void searchBooks(String keyword){
        System.out.println("Search results for: " + keyword);
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getISBN().contains(keyword)) {
                System.out.println("-" + book.getTitle() + " by " + book.getAuthor() + "ID: " + book.getBookID() + ", Available: " + book.isAvailable() + ")");
                found = true;
            }
        }
        if (!found){
            System.out.println("No books found matching your search.");
        }
    }



}
