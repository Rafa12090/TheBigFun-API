package com.crackelets.bigfun.platform.profile.domain.model;

import com.crackelets.bigfun.platform.booking.domain.model.Event;
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
@Table(name = "attendees")
public class Attendee {

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

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="attendee")
    private Set<Event> events = new HashSet<>();

    //private Set<Payment> payments = new HashSet<>();

    public Attendee addEvent(String eventName){
        if(events==null){
            events=new HashSet<>();
        }

        events.add(new Event()
                .withName(eventName).withAttendee(this));

        return this;
    }

}
