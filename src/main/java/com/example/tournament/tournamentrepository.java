package com.example.tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface tournamentrepository extends CrudRepository<tournament,Long>{
    public tournament findById(long id);
    public List<tournament> findBystart_date(String start_date);
    public List<tournament> findByLocation(String location);
}
