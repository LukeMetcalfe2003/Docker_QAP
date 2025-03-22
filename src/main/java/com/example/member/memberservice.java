package com.example.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class memberservice {
    @Autowired
    private memberrepository memberRepository;

    public member createMember(member newMember) {return memberRepository.save(newMember);}

    public List<member> getMembers() {return (List<member>) memberRepository.findAll();}

    public member getByName(String name) {return memberRepository.findByName(name);}

    public member getByStart_date(String start_date) {return memberRepository.findBystart_date(start_date);}

    public member getByPhone(String phone) {return memberRepository.findByPhone(phone);}
}
