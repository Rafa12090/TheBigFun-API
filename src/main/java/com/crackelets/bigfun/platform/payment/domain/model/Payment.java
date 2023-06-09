package com.crackelets.bigfun.platform.payment.domain.model;


import com.crackelets.bigfun.platform.shared.domain.model.AuditModel;
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


    @NotNull
    private Long organizerId;

    @NotNull
    private Long eventId;

    @NotNull
    private Long attendeeId;
}