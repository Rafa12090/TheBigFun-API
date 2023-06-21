package com.crackelets.bigfun.platform.security.domain.model.entity;

import com.crackelets.bigfun.platform.security.domain.model.enumeration.Roles;
import com.crackelets.bigfun.platform.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name ="roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
public class Role extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length =  20)
    private Roles name;
}
