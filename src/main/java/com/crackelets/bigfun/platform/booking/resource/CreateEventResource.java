package com.crackelets.bigfun.platform.booking.resource;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor

public class CreateEventResource {

    @NotNull
    @NotBlank
    @Size(max= 50)
    private String name;
}
