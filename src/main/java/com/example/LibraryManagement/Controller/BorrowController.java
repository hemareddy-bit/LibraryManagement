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

    @Autowired
    private BorrowService borrowService;

    // Endpoint to get all borrow records
    @GetMapping
    public ResponseEntity<List<Borrow>> getAllBorrows() {
        List<Borrow> borrows = borrowService.findAllBorrows();
        return ResponseEntity.ok(borrows);
    }

    // Endpoint to borrow a book
    @PostMapping
    public ResponseEntity<String> borrowBook(@RequestBody Borrow borrow) {
        borrowService.borrowBook(borrow);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book borrowed successfully!");
    }

    // Endpoint to return a book
    @DeleteMapping("/{borrowId}")
    public ResponseEntity<String> returnBook(@PathVariable Long borrowId) {
        borrowService.returnBook(borrowId);
        return ResponseEntity.ok("Book returned successfully!");
    }
}
