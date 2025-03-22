package com.example.tournament;
import com.example.member.member;
import com.example.member.memberrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin
public class tournamentcontroller {
    @Autowired
    private tournamentservice tournamentservice;

    @Autowired
    private memberrepository memberrepository;

    @GetMapping("/allTournaments")
    public ResponseEntity<List<tournament>> getAllTournaments(){
        List<tournament> tournaments = tournamentservice.getAllTournaments();
        if(tournaments.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(tournaments);
    }

    @PostMapping("/addTournament")
    public tournament addTournament(@RequestBody tournament newTournament){
        return tournamentservice.createtournament(newTournament);
    }

    @GetMapping("/getTournamentByStartDate/{start_date}")
    public ResponseEntity<List<tournament>> getTournamentByStartDate(@PathVariable String start_date){
        List<tournament> tournaments = tournamentservice.getTournamentByStart_date(start_date);
        if(tournaments.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(tournaments);
    }

    @GetMapping("/getTournamentByLocation/{location}")
    public ResponseEntity<List<tournament>> getTournamentByLocation(@PathVariable String location){
        List<tournament> tournaments = tournamentservice.getTournamentByLocation(location);
        if(tournaments.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(tournaments);
    }

    @GetMapping("/getMembersInTournament/{id}")
    public List<member> getMembersInTournament(@PathVariable long id) {
        tournament tournament = tournamentservice.getTournamentById(id);
        return tournament.getParticipants();
    }
}
