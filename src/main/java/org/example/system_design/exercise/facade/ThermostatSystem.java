package org.example.system_design.exercise.facade;

public class ThermostatSystem {

    private String mode;

    public void setTemperature(int temp){
        System.out.println("Thermostat: Setting mode to " + mode + ", temperature to " + temp + " celcius");
    }

    public void setMode(String mode){
        this.mode = mode;
    }
}
