package com.example.LibraryManagement.Service;

import com.example.LibraryManagement.DAO.BorrowDAO;
import com.example.LibraryManagement.Model.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {

    private final BorrowDAO borrowDAO;

    @Autowired
    public BorrowService(BorrowDAO borrowDAO) {
        this.borrowDAO = borrowDAO;
    }

    public List<Borrow> findAllBorrows() {
        return borrowDAO.findAll();
    }

    public Borrow saveBorrow(Borrow borrow) {
        return borrowDAO.save(borrow);
    }

    // Add the borrowBook method
    public Borrow borrowBook(Borrow borrow) {
        // You might want to add some business logic here
        return borrowDAO.save(borrow);
    }
}
