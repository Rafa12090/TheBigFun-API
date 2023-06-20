package com.crackelets.bigfun.platform.booking.service;

import com.crackelets.bigfun.platform.booking.api.internal.BookingFilterFacade;
import com.crackelets.bigfun.platform.booking.domain.model.Event;
import com.crackelets.bigfun.platform.booking.domain.service.EventService;

import java.util.List;

public class BookingFilterFacadeImpl implements BookingFilterFacade {
    private final EventService eventService;

    public BookingFilterFacadeImpl(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventService.getAll();
    }

    @Override
    public List<Event> getAllByOrganizerId(Long id) {
        return eventService.getAllByOrganizerId(id);
    }
}
