package com.crackelets.bigfun.platform.booking.domain.model;

import com.crackelets.bigfun.platform.profile.domain.model.Attendee;
import com.crackelets.bigfun.platform.profile.domain.model.Organizer;
import com.crackelets.bigfun.platform.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Time;
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
    @Size(min = 10)
    private String name;
    @Size(max =255)
    @Size(min = 100)
    private String address;

    @NotNull
    private int capacity;

    @Size(max = 500)
    private String image;

    @NotNull
    private Date date;
    @NotNull
    private Time hour;
    @NotNull
    private int cost;

    @Size(max = 50)
    @Size(min =20)
    @NotNull
    private String district;

    @JsonIgnore
    @ManyToMany(mappedBy = "events")
    private Set<Attendee> attendees = new HashSet<>();




    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "organizer_id", nullable = false)
    @JsonIgnore
    private Organizer organizer;

    public Event withAttendee(Attendee attendee) {

        if (attendees == null){
            attendees = new HashSet<>();
        }

        attendees.add(attendee);
        return this;

    }


}