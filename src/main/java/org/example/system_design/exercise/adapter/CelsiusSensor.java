package org.example.system_design.exercise.adapter;

public class CelsiusSensor implements Thermometer{

    @Override
    public double getTemperature() {
        return 25.0;
    }
}
