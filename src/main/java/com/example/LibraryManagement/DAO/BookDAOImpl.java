package com.example.LibraryManagement.DAO;

import com.example.LibraryManagement.Model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookDAOImpl implements BookDAO {

    private final List<Book> bookList = new ArrayList<>(); // Simulating a database

    @Override
    public void save(Book book) {
        Optional<Book> existingBookOpt = findById(book.getId());
        if (existingBookOpt.isPresent()) {
            bookList.remove(existingBookOpt.get()); // Remove existing book
        }
        bookList.add(book); // Add or update the book
    }

    @Override
    public Optional<Book> findById(String id) {
        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(String id) {
        bookList.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookList);
    }
}
