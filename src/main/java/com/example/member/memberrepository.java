package com.example.member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface memberrepository extends CrudRepository<member, Long> {
    public member findByName(String name);
    public member findByPhone(String phone);
    public member findBystart_date(String start_date);
}
