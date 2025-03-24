package com.example.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member newMember) {
        return memberRepository.save(newMember);
    }

    public List<Member> getMembers() {
        return (List<Member>) memberRepository.findAll();
    }

    public Member getByName(String name) {
        return memberRepository.findByName(name);
    }

    public Member getByStartDate(String startDate) {
        return memberRepository.findByStartDate(startDate);
    }

    public Member getByPhone(String phone) {
        return memberRepository.findByPhone(phone);
    }
}
