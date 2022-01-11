package com.example.lifesimulation;

import com.example.lifesimulation.ViewModel.InfoAboutGame;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:63342/", maxAge = 3600)
public class LifeSimulationRestController {
    @GetMapping("/LifeSimulation")
    public ResponseEntity<String> gettingInformationAboutWorld() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        var info = new InfoAboutGame();
        return ResponseEntity.ok().headers(headers).body(info.Info());
    }
}
