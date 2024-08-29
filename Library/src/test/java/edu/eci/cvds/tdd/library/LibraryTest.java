package edu.eci.cvds.tdd.library; // This should match the directory structure

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991");

        boolean added = library.addBook(book);
        assertTrue(added);
    }

    @Test
    public void testLoanABook() {
        Library library = new Library();
        User user = new User();
        user.setName("John Doe");
        user.setId("12345");

        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991");

        library.addUser(user);
        library.addBook(book);

        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
        assertEquals(user, loan.getUser());
        assertEquals(book, loan.getBook());
    }

    @Test
    public void testReturnLoan() {
        Library library = new Library();
        User user = new User();
        user.setName("John Doe");
        user.setId("12345");

        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991");

        library.addUser(user);
        library.addBook(book);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());

        Loan returnedLoan = library.returnLoan(loan);
        assertEquals(LoanStatus.RETURNED, returnedLoan.getStatus());
    }
}
