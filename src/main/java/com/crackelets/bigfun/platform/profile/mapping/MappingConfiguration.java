package com.crackelets.bigfun.platform.profile.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration") //sirve para diferenciarse de la clase que esta en Learning

public class MappingConfiguration {
    @Bean
    public OrganizerMapper organizerMapper(){
        return new OrganizerMapper();
    }
}
