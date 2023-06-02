package com.crackelets.bigfun.platform.profile.domain.persistence;

import com.crackelets.bigfun.platform.profile.domain.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizerRepository extends JpaRepository <Organizer,Long> {

    //I make the queries with the attributes I want

    List<Organizer> findAllBy(String name);

    Organizer findByName(String name);
    Organizer findByUserName(String userName);
    Organizer findByEmail(String email);

}
