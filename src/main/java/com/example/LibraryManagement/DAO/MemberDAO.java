package com.example.LibraryManagement.DAO;

import com.example.LibraryManagement.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO extends JpaRepository<Member, String> {
    // You can define custom query methods here if needed
}
