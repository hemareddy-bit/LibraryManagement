package com.example.LibraryManagement.Model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Member {

    @Id
    private String memberId;
    private String name;
    private String contactInformation;

    @ElementCollection
    private List<Long> borrowingHistory;

    // Default constructor
    public Member() {}

    // Constructor with parameters
    public Member(String memberId, String name, String contactInformation, List<Long> borrowingHistory) {
        this.memberId = memberId;
        this.name = name;
        this.contactInformation = contactInformation;
        this.borrowingHistory = borrowingHistory;
    }

    // Getters and Setters
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public List<Long> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void setBorrowingHistory(List<Long> borrowingHistory) {
        this.borrowingHistory = borrowingHistory;
    }
}
