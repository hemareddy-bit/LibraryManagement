package com.example.LibraryManagement.DAO;

import com.example.LibraryManagement.Model.Book;
import java.util.List;
import java.util.Optional;

public interface BookDAO {
    void save(Book book);
    Optional<Book> findById(String id);
    void deleteById(String id);
    List<Book> findAll();
}
