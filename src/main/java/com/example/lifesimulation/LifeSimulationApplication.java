package com.example.lifesimulation;

import com.example.lifesimulation.GameObjects.ControlClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class LifeSimulationApplication {
    public static ControlClass startGame;
    @RequestMapping(value = "api/v1/gameField", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public static void main(String[] args) {
        SpringApplication.run(LifeSimulationApplication.class, args);

        startGame = new ControlClass();
    }
}
