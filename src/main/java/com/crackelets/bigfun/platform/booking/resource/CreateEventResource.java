package com.crackelets.bigfun.platform.booking.resource;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor

public class CreateEventResource {

    @NotNull
    @NotBlank
    @Size(max= 50)
    @Size(min = 10)
    private String name;


    @Size(max =240)
    @Size(min = 100)
    private String address;


    @NotNull
    private int capacity;


    @NotNull
    private Date date;
    @NotNull
    private Time hour;
    @NotNull
    private int cost;

    @Size(max = 50)
    @Size(min = 20)
    @NotNull
    private String district;


}
