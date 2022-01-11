package com.example.lifesimulation.ViewModel;

import com.example.lifesimulation.GameObjects.ControlClass;
import com.example.lifesimulation.GameObjects.Entity;
import com.example.lifesimulation.GameObjects.Map;
import com.example.lifesimulation.LifeSimulationConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Vector;

public class InfoAboutGame {
    AnnotationConfigApplicationContext contextForLifeSimulation;
    ControlClass game;

    public InfoAboutGame() {
        contextForLifeSimulation = new AnnotationConfigApplicationContext(LifeSimulationConfiguration.class);
        game = contextForLifeSimulation.getBean(ControlClass.class);
    }

    public String Info() throws JsonProcessingException {
        ObjectMapper serialization = new ObjectMapper();
        var map = game.getMap();
        var entities = game.getEntities();
        return serialization.writeValueAsString(new InfoAboutGameViewModel(map, entities));
    }
}
