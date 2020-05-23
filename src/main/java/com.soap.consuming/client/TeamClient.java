package com.soap.consuming.client;


import com.soap.consuming.wsdl.*;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Service
public class TeamClient extends WebServiceGatewaySupport {
    
    public GetTeamResponse getTeam(String name){
        GetTeamRequest request = new ObjectFactory().createGetTeamRequest();
        
        request.setName(name);

        return (GetTeamResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/", request);
    }

    public SaveTeamResponse saveTeam(String name){
        SaveTeamRequest request = new ObjectFactory().createSaveTeamRequest();

        request.setName(name);

        return (SaveTeamResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/", request);
    }
}
