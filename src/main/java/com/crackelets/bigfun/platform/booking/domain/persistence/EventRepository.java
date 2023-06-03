package com.crackelets.bigfun.platform.booking.domain.persistence;


import com.crackelets.bigfun.platform.booking.domain.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByName(String name);
    List<Event> findByDate(Date date);
    List<Event> findByEventId(Long eventId);
    Page<Event> findByEventId (Long eventId, Pageable pageable);
    Optional<Event> findByNameAndDate(String name, Date date);


}
