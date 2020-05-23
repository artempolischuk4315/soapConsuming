package com.soap.consuming.configuration;

import com.soap.consuming.client.TeamClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class TeamConfiguration {
    
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.soap.consuming.wsdl");
        return marshaller;
    }
    
    @Bean
    public TeamClient courseClient(Jaxb2Marshaller marshaller){
        TeamClient client = new TeamClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
