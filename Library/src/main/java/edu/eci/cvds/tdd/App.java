package edu.eci.cvds.tdd;

import edu.eci.cvds.library.Library;
import edu.eci.cvds.library.book.Book;
import edu.eci.cvds.library.user.User;
import edu.eci.cvds.library.loan.Loan;

public class App {
    public static void main(String[] args) {
        // Create the library
        Library library = new Library();

        // Create users
        User user = new User();
        user.setId("1");
        user.setName("Alice");

        // Create a book
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991");

        // Add user and book to the library
        library.addUser(user);
        library.addBook(book);

        // Loan a book
        Loan loan = library.loanABook(user.getId(), book.getIsbn());

        // Return the book
        if (loan != null) {
            library.returnLoan(loan);
        }
    }
}

