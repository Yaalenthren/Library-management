package com.yourname.library;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

    public static Library library = new Library();
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {


        while (true) {
            showMenu();
            int option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    registerMember();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    listAllBooks();
                    break;
                case 7:
                    listAllMembers();
                    break;
                case 8:
                    System.out.println("Thank you for using library management system!");
                    return;

            }
            System.out.println("\nPress Enter to continue...");
            scan.nextLine();
        }


        }

    private static void showMenu() {
        System.out.println("==== Library Menu ====");
        System.out.println("1. Add Book\n" +
                "2. Register Member\n" +
                "3. Borrow Book\n" +
                "4. Return Book\n" +
                "5. Search Book\n" +
                "6. List All Books\n" +
                "7. List Members\n" +
                "8. Exit");
        System.out.println("Choose an option: ");

        }

    private static void addBook(){
            System.out.println("Enter book id: ");
            int bookId = scan.nextInt();
            scan.nextLine();

            System.out.println("Enter title: ");
            String title = scan.nextLine();

            System.out.println("Enter Author: ");
            String author = scan.nextLine();

            System.out.println("Enter ISBN: ");
            String isbn = scan.nextLine();

            Book book = new Book(bookId,title,author,isbn, true);
            library.addBook(book);
    }

    private static void registerMember(){
        System.out.println("Enter member id: ");
        int memberId = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter name: ");
        String name = scan.nextLine();
        System.out.println("Enter email: ");
        String email = scan.nextLine();

        Member member = new Member(memberId, name, email, new ArrayList<>());
        library.registerMember(member);
    }

    private static void borrowBook(){
        System.out.println("Enter member id: ");
        int memberId = scan.nextInt();
        System.out.println("Enter the book id: ");
        int bookId = scan.nextInt();

        library.issueBook(memberId,bookId);
    }

    private static void returnBook(){
        System.out.println("Enter member id: ");
        int memberId = scan.nextInt();
        System.out.println("Enter book id: ");
        int bookId = scan.nextInt();

        library.returnBook(memberId, bookId);
    }

    private static void searchBook(){
        System.out.println("Enter search keyword (title/author/ISBN): ");
        String keyword = scan.nextLine();
        library.searchBooks(keyword);
    }

    private static void listAllBooks(){
        List<Book> books = library.getAllBooks();
        if (books.isEmpty()){
            System.out.println("No books in the library.");
        }else {
            System.out.println("\n=== All Books ===");
            for (Book book : books){
                System.out.println("ID: " + book.getBookID() +
                        ", Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor() +
                        ", Available: " + book.isAvailable());
            }
        }
    }

    private static void listAllMembers(){
        List<Member> members = library.getAllMembers();
        if (members.isEmpty()){
            System.out.println("No members registered.");
        }else {
            System.out.println("\n=== All Members ===");
            for (Member member : members){
                System.out.println("ID: " + member.getMemberID() +
                        ", Name: " + member.getName() +
                        ", Email: " + member.getEmail());
                member.listBorrowedBooks();

            }
        }
    }


}
