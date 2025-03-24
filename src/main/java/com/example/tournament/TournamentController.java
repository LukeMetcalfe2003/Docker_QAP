package com.example.tournament;

import com.example.member.Member;
import com.example.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/allTournaments")
    public ResponseEntity<List<Tournament>> getAllTournaments(){
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        if(tournaments.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(tournaments);
    }

    @PostMapping("/addTournament")
    public Tournament addTournament(@RequestBody Tournament newTournament){
        return tournamentService.createTournament(newTournament);
    }

    @GetMapping("/getTournamentByStartDate/{startDate}")
    public ResponseEntity<List<Tournament>> getTournamentByStartDate(@PathVariable String startDate){
        List<Tournament> tournaments = tournamentService.getTournamentByStartDate(startDate);
        if(tournaments.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(tournaments);
    }

    @GetMapping("/getTournamentByLocation/{location}")
    public ResponseEntity<List<Tournament>> getTournamentByLocation(@PathVariable String location){
        List<Tournament> tournaments = tournamentService.getTournamentByLocation(location);
        if(tournaments.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(tournaments);
    }

    @GetMapping("/getMembersInTournament/{id}")
    public List<Member> getMembersInTournament(@PathVariable long id) {
        Tournament tournament = tournamentService.getTournamentById(id);
        return tournament.getParticipants();
    }
}

