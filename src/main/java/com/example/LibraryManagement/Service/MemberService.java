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
    private MemberDAO memberDAO;

    public void addMember(Member member) {
        memberDAO.save(member);
    }

    public void updateMember(String memberId, Member updatedMember) {
        Optional<Member> existingMemberOpt = memberDAO.findById(memberId);
        if (existingMemberOpt.isPresent()) {
            Member existingMember = existingMemberOpt.get();
            // Update the member's properties
            existingMember.setName(updatedMember.getName());
            existingMember.setContactInformation(updatedMember.getContactInformation());
            // Update other properties as needed
            memberDAO.save(existingMember);
        } else {
            throw new IllegalArgumentException("Member with ID " + memberId + " not found.");
        }
    }

    public void deleteMember(String memberId) {
        memberDAO.deleteById(memberId);
    }

    public Member getMemberById(String memberId) {
        return memberDAO.findById(memberId).orElse(null);
    }

    public List<Member> getAllMembers() {
        return memberDAO.findAll();
    }
}
