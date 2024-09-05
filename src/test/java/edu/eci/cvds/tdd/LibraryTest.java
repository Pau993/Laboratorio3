package edu.eci.cvds.tdd;

import edu.eci.cvds.tdd.library.Library;
import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Library.
 */
public class LibraryTest extends TestCase {
    
    private Library library;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LibraryTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(LibraryTest.class);
    }

    /**
     * Set up the test environment
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        library = new Library();
    }

    /**
     * Test adding a user twice.
     */
    public void testAddUserTwice() {
        User user = new User();
        user.setId("30351");
        user.setName("Andres");

        assertTrue(library.addUser(user));  // Add user once
        assertFalse(library.addUser(user)); // Try adding the same user again
    }

    /**
     * Test for addBook method
     */
    public void testAddBook() {
        Book book = new Book("Frankenstein", "mary shelley", "978-0134685991");
        assertTrue(library.addBook(book));
        assertTrue(library.addBook(book)); // Test for adding the same book again
    }

    /**
     * Test for loanABook method
     */
    public void testLoanABook() {
        User user = new User();
        user.setId("30351");
        user.setName("Andres");
        library.addUser(user);
        
        Book book = new Book("Frankestein", "mary shelley", "978-0134685991");
        library.addBook(book);
        
        Loan loan = library.loanABook("30351", "978-0134685991");
        assertNotNull(loan);
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
        assertEquals(user, loan.getUser());
        assertEquals(book, loan.getBook());
        assertNotNull(loan.getLoanDate());
    }

    /**
     * Test for returnLoan method
     */
    public void testReturnLoan() {
        User user = new User();
        user.setId("30351");
        user.setName("Andres");
        library.addUser(user);
        
        Book book = new Book("Frankestein", "mary shelley", "978-0134685991");
        library.addBook(book);
        
        Loan loan = library.loanABook("30351", "978-0134685991");
        Loan returnedLoan = library.returnLoan(loan);
        
        assertNotNull(returnedLoan);
        assertEquals(LoanStatus.RETURNED, returnedLoan.getStatus());
        assertNotNull(returnedLoan.getReturnDate());
    }

    public void testReturnNullLoan() {
        Loan loan = library.returnLoan(null);
        assertNull(loan); // Returning a null loan should return null
    }

    /**
     * Test loaning a non-existent book.
     */
    public void testLoanNonExistentBook() {
        User user = new User();
        user.setId("30351");
        user.setName("Andres");
        library.addUser(user);

        Loan loan = library.loanABook("30351", "999-9999999999"); // Non-existent book
        assertNull(loan); // Loan should not be created
    }

    public void testAddBookTwice() {
        Book book = new Book("Frankestein", "mary shelley", "978-0134685991");
        assertTrue(library.addBook(book));  // Add book once
        assertTrue(library.addBook(book));  // Add the same book again
    }

    public void testLoanBookAlreadyOnLoan() {
        User user = new User();
        user.setId("30351");
        user.setName("Andres");
        library.addUser(user);

        Book book = new Book("Frankestein", "mary shelley", "978-0134685991");
        library.addBook(book);

        // Loan the book for the first time
        Loan loan1 = library.loanABook("30351", "978-0134685991");
        assertNotNull(loan1); // First loan should succeed

        // Try to loan the same book again
        Loan loan2 = library.loanABook("30351", "978-0134685991");
        assertNull(loan2); // Second loan should fail
    }

}