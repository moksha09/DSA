package org.example.system_design.design_patterns.structural.decorator;

public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        System.out.println("Sending slack message: " + message);
        notifier.send(message);
    }
}
