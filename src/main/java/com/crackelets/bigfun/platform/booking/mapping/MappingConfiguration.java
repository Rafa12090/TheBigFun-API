package com.crackelets.bigfun.platform.booking.mapping;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("EventMappingConfiguration")
public class MappingConfiguration {

@Bean
    public EventMapper eventMapper(){return new EventMapper();}

}
