package com.example.LibraryManagement.Controller;

import com.example.LibraryManagement.Model.Member;
import com.example.LibraryManagement.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")  // Updated to match the same base path as other controllers
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<String> addMember(@RequestBody Member member) {
        memberService.addMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body("Member added successfully: " + member.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable String id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("Member deleted successfully with ID: " + id);
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }
}
