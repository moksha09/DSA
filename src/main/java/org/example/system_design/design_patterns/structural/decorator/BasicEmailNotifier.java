package org.example.system_design.design_patterns.structural.decorator;

public class BasicEmailNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}
