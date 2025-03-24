package com.example.tournament;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {
    Tournament findById(long id);
    List<Tournament> findByStartDate(String startDate);
    List<Tournament> findByLocation(String location);
}

