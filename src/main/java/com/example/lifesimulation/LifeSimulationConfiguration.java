package com.example.lifesimulation;

import com.example.lifesimulation.Game.ControlClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class LifeSimulationConfiguration {
    @Bean
    @Scope("singleton")
    public ControlClass getControlClass() {
        return ControlClass.getInstance();
    }
}
