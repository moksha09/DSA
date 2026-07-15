package org.example.system_design.exercise.adapter;

public class FahrenheitAdapter implements Thermometer{

    private final FahrenheitSensor fahrenheitSensor;

    public FahrenheitAdapter(FahrenheitSensor sensor){
        this.fahrenheitSensor = sensor;
    }

    @Override
    public double getTemperature() {
        double tempf = fahrenheitSensor.readFahrenheit();
        return ((tempf - 32)*5.0)/9.0;
    }
}
