package org.example.system_design.design_patterns.structural.decorator;

public class SMSNotifierDecorator extends NotifierDecorator{

    protected SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
        notifier.send(message);
    }
}
