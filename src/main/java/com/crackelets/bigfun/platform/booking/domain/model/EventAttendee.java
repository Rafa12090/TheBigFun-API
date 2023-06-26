
package com.crackelets.bigfun.platform.booking.domain.model;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name="event_attendees")
public class EventAttendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Event event;
    private Long attendeeId;

    public EventAttendee(Event event, Long attendeeId) {
        this.event = event;
        this.attendeeId = attendeeId;
    }
}