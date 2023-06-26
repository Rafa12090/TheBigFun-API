package com.crackelets.bigfun.platform.booking.domain.model;

import com.crackelets.bigfun.platform.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "events")
public class Event extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String name;

    @Size(max =240)
    private String address;

    @NotNull
    private int capacity;

    @Size(max = 500)
    private String image;

    @NotNull
    private Date date;

    @NotNull
    private int cost;

    @Size(max = 50)
    @NotNull
    private String district;
/*    @NotNull
    private Long organizerId;*/



    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "event")
    private Set<EventAttendee> attendeesListByEvent;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "event")
    private Set<EventPayment> payments;

    public Event addAttendee(Event event,Long attendeeId){

        if(attendeesListByEvent ==null) attendeesListByEvent = new HashSet<>();

        this.attendeesListByEvent.add(new EventAttendee(this, attendeeId));

        return this;
    }

    public Event addPayment(Event event,Long paymentId){

        if(payments ==null) payments = new HashSet<>();

        this.payments.add(new EventPayment(this, paymentId));

        return this;
    }

}
