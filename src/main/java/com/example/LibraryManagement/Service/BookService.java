package com.example.LibraryManagement.Service;

import com.example.LibraryManagement.DAO.BookDAO;
import com.example.LibraryManagement.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookDAO bookRepository;

    // Method to add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Method to get a book by ID
    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    // Method to get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Method to delete a book by ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Method to update a book
    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}
