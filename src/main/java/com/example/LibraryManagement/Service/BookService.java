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
    private BookDAO bookDAO;

    public void addBook(Book book) {
        bookDAO.save(book);
    }

    public void updateBook(String bookId, Book updatedBook) {
        Optional<Book> existingBookOpt = bookDAO.findById(bookId);
        if (existingBookOpt.isPresent()) {
            bookDAO.save(updatedBook);
        }
    }

    public Optional<Book> getBook(String bookId) {
        return bookDAO.findById(bookId);
    }

    public void deleteBook(String bookId) {
        bookDAO.deleteById(bookId);
    }

    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }
}
