package com.example.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    public Tournament createTournament(Tournament newTournament) {
        return tournamentRepository.save(newTournament);
    }

    public List<Tournament> getAllTournaments() {
        return (List<Tournament>) tournamentRepository.findAll();
    }

    public List<Tournament> getTournamentByStartDate(String startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public Tournament getTournamentById(long id) {
        return tournamentRepository.findById(id);
    }

    public List<Tournament> getTournamentByLocation(String location) {
        return tournamentRepository.findByLocation(location);
    }
}

