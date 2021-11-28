package com.example.lifesimulation;

import com.example.lifesimulation.GameObjects.ControlClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:63342/", maxAge = 3600)
public class LifeSimulationRestController {
    public static ControlClass game;
    @GetMapping("/LifeSimulation")
    public ResponseEntity<String> gettingInformationAboutWorld() throws JsonProcessingException {
        game = new ControlClass();
        ObjectMapper serialization = new ObjectMapper();
        String json = serialization.writeValueAsString(game.getMap());
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(json);
    }
}
