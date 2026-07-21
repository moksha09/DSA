package org.example.system_design.design_patterns.structural.decorator;

public class WhatsappNotifierDecorator extends NotifierDecorator {

    public WhatsappNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        System.out.println("Sending WhatsApp message: " + message);
        notifier.send(message);
    }
}
