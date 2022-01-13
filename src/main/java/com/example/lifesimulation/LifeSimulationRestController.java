package com.example.lifesimulation;

import com.example.lifesimulation.Game.ControlClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:63342/", maxAge = 3600)
public class LifeSimulationRestController {
    AnnotationConfigApplicationContext contextForLifeSimulation;
    ControlClass game;

    public LifeSimulationRestController() {
        contextForLifeSimulation = new AnnotationConfigApplicationContext(LifeSimulationConfiguration.class);
        game = contextForLifeSimulation.getBean(ControlClass.class);
    }

    private String Info() throws JsonProcessingException {
        ObjectMapper serialization = new ObjectMapper();
        var map = game.getMap();
        var entities = game.getEntities();
        return serialization.writeValueAsString(new LifeSimulationViewModel(map, entities));
    }

    @GetMapping("/LifeSimulation")
    public ResponseEntity<String> gettingInformationAboutWorld() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(Info());
    }
}
