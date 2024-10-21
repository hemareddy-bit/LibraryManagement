package com.example.LibraryManagement.Service;

import com.example.LibraryManagement.DAO.BookDAO;
import com.example.LibraryManagement.DAO.BorrowDAO;
import com.example.LibraryManagement.Model.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowDAO borrowRepository;

    @Autowired
    private BookDAO bookRepository;

    // Method to get all borrow records
    public List<Borrow> findAllBorrows() {
        return borrowRepository.findAll();
    }

    // Method to borrow a book
    public Borrow borrowBook(Borrow borrow) {
        // Check if the book is available
        var bookOpt = bookRepository.findById(borrow.getBookId());
        if (bookOpt.isPresent() && bookOpt.get().isAvailable()) {
            bookOpt.get().setAvailable(false);
            bookRepository.save(bookOpt.get());
            return borrowRepository.save(borrow);
        } else {
            throw new RuntimeException("Book not available for borrowing.");
        }
    }

    // Method to return a book
    public void returnBook(Long borrowId) {
        Borrow borrow = borrowRepository.findById(borrowId).orElseThrow(); // Find the borrow record
        var bookOpt = bookRepository.findById(borrow.getBookId());
        if (bookOpt.isPresent()) {
            bookOpt.get().setAvailable(true); // Mark book as returned
            bookRepository.save(bookOpt.get()); // Save the updated book status
            borrowRepository.delete(borrow); // Delete the borrow record
        }
    }
}
