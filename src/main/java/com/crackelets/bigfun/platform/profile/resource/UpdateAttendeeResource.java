package com.crackelets.bigfun.platform.profile.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateAttendeeResource {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String userName;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String email;
}
