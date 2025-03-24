package com.example.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/getMembers")
    public List<Member> getAllMembers() {
        return memberService.getMembers();
    }

    @PostMapping("/addMember")
    public Member addMember(@RequestBody Member newMember) {
        return memberService.createMember(newMember);
    }

    @GetMapping("/getMemberByName/{name}")
    public ResponseEntity<Member> getMemberByName(@PathVariable String name) {
        Member member = memberService.getByName(name);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/getMemberByPhone/{phone}")
    public ResponseEntity<Member> getMemberByPhone(@PathVariable String phone) {
        Member member = memberService.getByPhone(phone);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/getMemberByStartDate/{startDate}")
    public ResponseEntity<Member> getMemberByStartDate(@PathVariable String startDate) {
        Member member = memberService.getByStartDate(startDate);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}

