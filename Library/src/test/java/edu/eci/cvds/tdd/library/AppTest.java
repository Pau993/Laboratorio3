package edu.eci.cvds.tdd.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import edu.eci.cvds.library.Library;
import edu.eci.cvds.library.book.Book;
import edu.eci.cvds.library.loan.Loan;
import edu.eci.cvds.library.loan.LoanStatus;
import edu.eci.cvds.library.user.User;

class AppTest {

    private Library library;
    private User user;
    private Book book;

    @BeforeEach
    void setUp() {
        library = new Library();
        user = new User();
        user.setId("12345");
        user.setName("John Doe");

        book = new Book("Effective Java", "Joshua Bloch", "9780134685991");

        library.addUser(user);
    }

    @Test
    void testAddBookNewBook() {
        assertTrue(library.addBook(book), "El libro debería ser añadido exitosamente.");
        // Añadir el mismo libro nuevamente y asegurar que se incremente el conteo, si está implementado.
        assertTrue(library.addBook(book), "El libro debería ser añadido nuevamente, incrementando el conteo.");
    }

    @Test
    void testLoanABook() {
        library.addBook(book);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        assertNotNull(loan, "El préstamo debería ser creado exitosamente.");
        assertEquals(LoanStatus.ACTIVE, loan.getStatus(), "El estado del préstamo debería ser ACTIVO.");
        assertEquals(user, loan.getUser(), "El préstamo debería estar asociado con el usuario correcto.");
        assertEquals(book, loan.getBook(), "El préstamo debería estar asociado con el libro correcto.");
    }

    @Test
    void testLoanABookUnavailable() {
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        assertNull(loan, "El préstamo no debería ser creado ya que el libro no está disponible.");
    }

    @Test
    void testReturnLoan() {
        library.addBook(book);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        Loan returnedLoan = library.returnLoan(loan);
        assertNotNull(returnedLoan, "El préstamo debería ser devuelto exitosamente.");
        assertEquals(LoanStatus.RETURNED, returnedLoan.getStatus(), "El estado del préstamo debería ser DEVUELTO.");
        assertNotNull(returnedLoan.getReturnDate(), "La fecha de devolución debería estar establecida.");
    }

    @Test
    void testAddUser() {
        User newUser = new User();
        newUser.setId("67890");
        newUser.setName("Jane Doe");
        assertTrue(library.addUser(newUser), "El usuario debería ser añadido exitosamente.");
    }
}

