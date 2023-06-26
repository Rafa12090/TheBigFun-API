package com.crackelets.bigfun.platform.booking.domain.model;

import com.crackelets.bigfun.platform.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
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
    @NotNull
    private Long organizerId;





    @OneToMany
    private Set<EventAttendee> attendees;

    public void addAttendee(Long attendeeId, Event event){
        this.attendees.add(new EventAttendee(this, attendeeId));
    }

}
