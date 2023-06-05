package com.crackelets.bigfun.platform.profile.resource;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdateOrganizerResource {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String userName;

    @NotNull
    @NotBlank
    @Size(max=60)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String email;
}
