package com.example.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class membercontroller {
    @Autowired
    private memberservice memberService;

    @GetMapping("/getMembers")
    public List<member> getAllMembers(){
        return memberService.getMembers();
    }

    @PostMapping("/addMember")
    public member addMember(@RequestBody member newMember){
        return memberService.createMember(newMember);
    }

    @GetMapping("/getMemberByName/{name}")
    public ResponseEntity<member> getMemberByName(@PathVariable String name){
        member member = memberService.getByName(name);
        if(member == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/getMemberByPhone/{phone}")
    public ResponseEntity<member> getMemberByPhone(@PathVariable String phone){
        member member = memberService.getByPhone(phone);
        if(member == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/getMemberByStartDate/{start_date}")
    public ResponseEntity<member> getMemberByStartDate(@PathVariable String start_date){
        member member = memberService.getByStart_date(start_date);
        if(member == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
