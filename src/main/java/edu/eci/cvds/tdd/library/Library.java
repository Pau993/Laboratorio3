package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    /**
     * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the book is store in a Map that contains
     * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books available, if the book already exist the
     * amount should increase by 1 and if the book is new the amount should be 1, this method returns true if the
     * operation is successful false otherwise.
     *
     * @param book The book to store in the map.
     *
     * @return true if the book was stored false otherwise.
     */
    public boolean addBook(Book book) {
        if (book == null) {
            return false;
        }
        if (books.containsKey(book)) {
            books.put(book, books.get(book) + 1);
        } else {
            books.put(book, 1);
        }
        return true;
    }

    /**
     * This method creates a new loan with for the User identify by the userId and the book identify by the isbn,
     * the loan should be store in the list of loans, to successfully create a loan is required to validate that the
     * book is available, that the user exist and the same user could not have a loan for the same book
     * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these requirements are meet the amount of books is
     * decreased and the loan should be created with {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
     * the loan date should be the current date.
     *
     * @param userId id of the user.
     * @param isbn book identification.
     *
     * @return The new created loan.
     */
public Loan loanABook(String userId, String isbn) {
    // Validar que el usuario existe
    User user = null;
    for (User u : users) {
        if (u.getId().equals(userId)) {
            user = u;
            break;
        }
    }
    if (user == null) {
        return null; // Usuario no existe
    }

    // Validar que el libro está disponible
    Book book = null;
    for (Book b : books.keySet()) {
        if (b.getIsbn().equals(isbn)) {
            book = b;
            break;
        }
    }
    if (book == null || books.get(book) == 0) {
        return null; // Libro no disponible o no existe
    }

    // Validar que el usuario no tiene ya un préstamo activo del mismo libro
    for (Loan loan : loans) {
        if (loan.getUser().getId().equals(userId) && loan.getBook().getIsbn().equals(isbn) && loan.getStatus() == LoanStatus.ACTIVE) {
            return null; // El usuario ya tiene un préstamo activo de este libro
        }
    }

    // Crear el nuevo préstamo
    Loan newLoan = new Loan();
    newLoan.setUser(user);
    newLoan.setBook(book);
    newLoan.setLoanDate(LocalDateTime.now());
    newLoan.setStatus(LoanStatus.ACTIVE);

    // Agregar el préstamo a la lista de préstamos y decrementar la cantidad de libros disponibles
    loans.add(newLoan);
    books.put(book, books.get(book) - 1);

    return newLoan;
}

    /**
     * This method return a loan, meaning that the amount of books should be increased by 1, the status of the Loan
     * in the loan list should be {@link edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
     * date should be the current date, validate that the loan exist.
     *
     * @param loan loan to return.
     *
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        if (loan == null || !loans.contains(loan)) {
            return null; // El préstamo no existe en el sistema
        }
    
        // Incrementar la cantidad de libros disponibles
        Book book = loan.getBook();
        books.put(book, books.get(book) + 1);
    
        // Cambiar el estado del préstamo a RETURNED y establecer la fecha de devolución
        loan.setStatus(LoanStatus.RETURNED);
        loan.setReturnDate(LocalDateTime.now());
    
        return loan;
    }

    public boolean addUser(User user) {
        // Validar si el usuario ya existe en la lista
        for (User u : users) {
            if (u.getId().equals(user.getId())) {
                return false; // El usuario ya existe, retornar false
            }
        }
        return users.add(user); // El usuario no existe, agregarlo y retornar true
    }
    

}
