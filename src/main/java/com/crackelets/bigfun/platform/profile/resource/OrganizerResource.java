package com.crackelets.bigfun.platform.profile.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor

public class OrganizerResource {

    private Long id;
    private String userName;
    private String name;
    private String email;
}
