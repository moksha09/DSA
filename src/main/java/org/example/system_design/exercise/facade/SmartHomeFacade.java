package org.example.system_design.exercise.facade;

public class SmartHomeFacade {

    private SecuritySystem securitySystem;
    private SmartLightSystem smartLightSystem;
    private ThermostatSystem thermostatSystem;

    public SmartHomeFacade(SecuritySystem securitySystem,
                           SmartLightSystem smartLightSystem,
                           ThermostatSystem thermostatSystem){
        this.securitySystem = securitySystem;
        this.smartLightSystem = smartLightSystem;
        this.thermostatSystem = thermostatSystem;
    }

    public void leaveHome(){
        System.out.println("Leaving home");
        securitySystem.armed();
        smartLightSystem.off();
        thermostatSystem.setMode("ECO");
        thermostatSystem.setTemperature(18);
        System.out.println("Home secured");
    }

    public void arriveHome() {
        System.out.println("Arrived home");
        securitySystem.disarmed();
        smartLightSystem.on();
        thermostatSystem.setMode("Comfort");
        thermostatSystem.setTemperature(22);
        System.out.println("Welcome home!!!");
    }
}
