package com.example.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByName(String name);
    Member findByPhone(String phone);
    Member findByStartDate(String startDate);
}


