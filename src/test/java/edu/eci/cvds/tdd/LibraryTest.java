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
     * Test for addBook method
     */
    public void testAddBook() {
        Book book = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        assertTrue(library.addBook(book));
        assertTrue(library.addBook(book)); // Test for adding the same book again
    }

    /**
     * Test for loanABook method
     */
    public void testLoanABook() {
        User user = new User();
        user.setId("1234");
        user.setName("John Doe");
        library.addUser(user);
        
        Book book = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        library.addBook(book);
        
        Loan loan = library.loanABook("1234", "978-0134685991");
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
        user.setId("1234");
        user.setName("John Doe");
        library.addUser(user);
        
        Book book = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        library.addBook(book);
        
        Loan loan = library.loanABook("1234", "978-0134685991");
        Loan returnedLoan = library.returnLoan(loan);
        
        assertNotNull(returnedLoan);
        assertEquals(LoanStatus.RETURNED, returnedLoan.getStatus());
        assertNotNull(returnedLoan.getReturnDate());
    }
}
