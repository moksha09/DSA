package org.example.system_design.design_patterns.structural.decorator;
import java.util.Base64;

public class EncryptionDecorator extends NotifierDecorator {

    public EncryptionDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        String encryptedString = Base64.getEncoder().encodeToString(message.getBytes());
        notifier.send(encryptedString);
    }
}
