package com.example.LibraryManagement.Controller;

import com.example.LibraryManagement.Model.Borrow;
import com.example.LibraryManagement.Service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping
    public ResponseEntity<List<Borrow>> getAllBorrows() {
        List<Borrow> borrows = borrowService.findAllBorrows();
        return new ResponseEntity<>(borrows, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> borrowBook(@RequestBody Borrow borrow) {
        try {
            Borrow savedBorrow = borrowService.borrowBook(borrow);
            return new ResponseEntity<>("Book borrowed successfully: ID " + savedBorrow.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error borrowing book: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
