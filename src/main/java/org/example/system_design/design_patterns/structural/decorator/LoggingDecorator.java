package org.example.system_design.design_patterns.structural.decorator;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LoggingDecorator extends NotifierDecorator {

    public LoggingDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        System.out.println("Sending message at: " + LocalDateTime.now());
        notifier.send(message);
        System.out.println("Message sent at: " + LocalDateTime.now());
    }


}
