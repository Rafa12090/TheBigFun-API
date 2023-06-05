package com.crackelets.bigfun.platform.booking.service;

import com.crackelets.bigfun.platform.booking.api.internal.BookingAnalyticsService;
import com.crackelets.bigfun.platform.booking.api.internal.BookingContextFacade;

public class BookingAnalyticsServiceImpl implements BookingAnalyticsService {

    private final BookingContextFacade bookingContextFacade;

    public BookingAnalyticsServiceImpl(BookingContextFacade bookingContextFacade){
        this.bookingContextFacade = bookingContextFacade;
    }

    @Override
    public int getTotalEvents(){
        return bookingContextFacade.getAllEvents().size();
    }
}
