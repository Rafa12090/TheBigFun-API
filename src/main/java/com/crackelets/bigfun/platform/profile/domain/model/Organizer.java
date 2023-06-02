package com.crackelets.bigfun.platform.profile.domain.model;

import com.crackelets.bigfun.platform.booking.domain.model.Event;
import com.crackelets.bigfun.platform.payment.domain.model.Payment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organizers")

public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autogenerate value
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String userName;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String email;


    //Relationships

    //private EventList eventList;
    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="organizer")
    private Set<Event> events = new HashSet<>();

    //business rule
    public Organizer addEvent(String eventName) {

        if (events == null) {
            events = new HashSet<>();
        }

        //add event to organizer
        events.add(new Event()
                .withName(eventName)
                .withOrganizer(this));
        return this;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="organizer")
    private Set<Payment> payments = new HashSet<>();

    //business rule
    public Organizer addPayment(Long paymentId) {

        if (payments == null) {
            payments = new HashSet<>();
        }

        //add payment to organizer
        payments.add(new Payment()
                .withId(paymentId)
                .withOrganizer(this));
        return this;
    }

}
