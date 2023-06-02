package com.crackelets.bigfun.platform.payment.domain.model;


import com.crackelets.bigfun.platform.booking.domain.model.Event;
import com.crackelets.bigfun.platform.profile.domain.model.Attendee;
import com.crackelets.bigfun.platform.profile.domain.model.Organizer;
import com.crackelets.bigfun.platform.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "payments")
public class Payment extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @NotNull
    @NotBlank
    @Size(max=500)
    @Column(unique = true)
    private String qrImg;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "organizer_id", nullable = false)
    @JsonIgnore
    private Organizer organizer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    @JsonIgnore
    private Event event;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "attendee_id", nullable = false)
    @JsonIgnore
    private Attendee attendee;
}