package com.crackelets.bigfun.platform.booking.domain.service;

import com.crackelets.bigfun.platform.booking.domain.model.Event;
import com.crackelets.bigfun.platform.booking.domain.model.EventAttendee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventAttendeeService {

    List<EventAttendee> getAll();

    EventAttendee getById(Long EventAttendeeId);

    EventAttendee create(EventAttendee eventAttendee);

    ResponseEntity<?> delete(Long eventAttendeeId);




}
