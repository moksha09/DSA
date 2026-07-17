package org.example.system_design.exercise.facade;

public class Main {

    public static void main(String[] args){
        SmartLightSystem smartLightSystem = new SmartLightSystem();
        SecuritySystem securitySystem = new SecuritySystem();
        ThermostatSystem thermostatSystem = new ThermostatSystem();

        SmartHomeFacade home = new SmartHomeFacade(securitySystem, smartLightSystem, thermostatSystem);
        home.leaveHome();
        home.arriveHome();
    }
}
