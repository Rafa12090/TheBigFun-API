package com.crackelets.bigfun.platform.booking.domain.service;

import com.crackelets.bigfun.platform.booking.domain.model.EventPayment;

import java.util.List;

public interface EventPaymentService {

    List<EventPayment> getAll();

    List<EventPayment> getAllByEventId(Long eventId);

}
