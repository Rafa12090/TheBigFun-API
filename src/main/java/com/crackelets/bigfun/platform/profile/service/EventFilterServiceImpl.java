package com.crackelets.bigfun.platform.profile.service;

import com.crackelets.bigfun.platform.booking.api.internal.BookingFilterFacade;
import com.crackelets.bigfun.platform.booking.domain.model.Event;
import com.crackelets.bigfun.platform.profile.domain.service.EventFilterService;

import java.util.List;

public class EventFilterServiceImpl implements EventFilterService {
    private final BookingFilterFacade bookingFilterFacade;

    public EventFilterServiceImpl(BookingFilterFacade bookingFilterFacade) {
        this.bookingFilterFacade = bookingFilterFacade;
    }


    @Override
    public List<Event> getAllEventsByOrganizer(Long id) {
        return bookingFilterFacade.getAllByOrganizerId(id);
    }
}
