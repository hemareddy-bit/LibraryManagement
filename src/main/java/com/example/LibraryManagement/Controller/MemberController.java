package com.example.LibraryManagement.Controller;

import com.example.LibraryManagement.Model.Member;
import com.example.LibraryManagement.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Endpoint to add a new member
    @PostMapping
    public ResponseEntity<String> addMember(@RequestBody Member member) {
        memberService.addMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body("Member added successfully: " + member.getName());
    }

    // Endpoint to get a member by ID
    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable String memberId) {
        return memberService.getMember(memberId)
                .map(member -> ResponseEntity.ok(member))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Endpoint to get all members
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    // Endpoint to delete a member by ID
    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable String memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.ok("Member deleted successfully with ID: " + memberId);
    }
}
