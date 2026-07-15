package org.example.system_design.exercise.adapter;

public class Main {
    public static void main(String[] args){
        Thermometer celcius = new CelsiusSensor();
        System.out.println(celcius.getTemperature());

        FahrenheitSensor sensor = new FahrenheitSensor();
        Thermometer fahrenheit = new FahrenheitAdapter(sensor);
        System.out.println(fahrenheit.getTemperature());
    }
}
