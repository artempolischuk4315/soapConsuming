package com.soap.consuming;

import com.soap.consuming.client.TeamClient;
import com.soap.consuming.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.soap.consuming.configuration")
@RestController
public class Application{

    private TeamClient teamClient;

    @Autowired
    public Application(TeamClient teamClient) {
        this.teamClient = teamClient;
    }

    @PostMapping("/getTeam")
    public GetTeamResponse getTeam(@RequestBody GetTeamRequest request){

        return teamClient.getTeam(request.getName());
    }

    @PostMapping("/saveTeam")
    public SaveTeamResponse saveTeam(@RequestBody SaveTeamRequest request){

        return teamClient.saveTeam(request.getName());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
