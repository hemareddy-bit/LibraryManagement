package com.example.LibraryManagement.Service;

import com.example.LibraryManagement.DAO.MemberDAO;
import com.example.LibraryManagement.Model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberDAO memberRepository;

    // Method to add a new member
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    // Method to get a member by ID
    public Optional<Member> getMember(String memberId) {
        return memberRepository.findById(memberId);
    }

    // Method to get all members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Method to delete a member by ID
    public void deleteMember(String memberId) {
        memberRepository.deleteById(memberId);
    }
}
