package com.example.LibraryManagement.DAO;

import com.example.LibraryManagement.Model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowDAO extends JpaRepository<Borrow, Long> {
    // You can add custom query methods here if needed
}
