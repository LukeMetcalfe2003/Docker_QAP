package com.example.tournament;
import com.example.member.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class tournamentservice {
    @Autowired
    tournamentrepository tournamentrepository;

    public tournament createtournament(tournament newTournament){return tournamentrepository.save(newTournament);}

    public List<tournament> getAllTournaments(){return (List<tournament>) tournamentrepository.findAll();}

    public List<tournament> getTournamentByStart_date(String start_date){return tournamentrepository.findBystart_date(start_date);}

    public tournament getTournamentById(long id){return tournamentrepository.findById(id);}

    public List<tournament> getTournamentByLocation(String location){return tournamentrepository.findByLocation(location);}


}
