package com.crackelets.bigfun.platform.booking.resource;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor

public class EventResource {

    private Long id;
    private String name;
    private String address;
    private int capacity;
    private String image;
    private Date date;
    private int cost;
    private String district;






}
