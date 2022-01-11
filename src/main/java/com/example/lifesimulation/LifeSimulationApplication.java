package com.example.lifesimulation;

import com.example.lifesimulation.GameObjects.ControlClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LifeSimulationApplication {
    public static void main(String[] args) {
        var contextForLifeSimulation = new AnnotationConfigApplicationContext(LifeSimulationConfiguration.class);
        var game = contextForLifeSimulation.getBean(ControlClass.class);
        SpringApplication.run(LifeSimulationApplication.class, args);
        while (true) {
            game.LiveOneTick();
            try {
                Thread.sleep(980);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
