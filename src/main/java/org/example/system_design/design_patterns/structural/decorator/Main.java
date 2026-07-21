package org.example.system_design.design_patterns.structural.decorator;

public class Main {

    public static void main(String[] args){

        String message = "Hello World!!!";

        // 1) Send a standard email notification using just the BasicEmailNotifier.
        BasicEmailNotifier basicEmailNotifier = new BasicEmailNotifier();
        basicEmailNotifier.send(message);
        System.out.println();

        // 2) Wrap the email notifier so that a single send() call delivers via Email + SMS + Slack.
        SMSNotifierDecorator smsNotifierDecorator = new SMSNotifierDecorator(basicEmailNotifier);
        SlackNotifierDecorator slackNotifierDecorator = new SlackNotifierDecorator(smsNotifierDecorator);
        slackNotifierDecorator.send(message);
        System.out.println();

        // 3) Send a critical alert that is Logged, Encrypted, and delivered via Email + WhatsApp.
        String alert = "Alert - Security Issue !!!";
        BasicEmailNotifier alertNotifier = new BasicEmailNotifier();
        WhatsappNotifierDecorator whatsappNotifierDecorator = new WhatsappNotifierDecorator(alertNotifier);
        EncryptionDecorator encryptionDecorator = new EncryptionDecorator(whatsappNotifierDecorator);
        LoggingDecorator loggingDecorator = new LoggingDecorator(encryptionDecorator);

        loggingDecorator.send(alert);
        System.out.println();

        // 4) Stack EncryptionDecorator above WhatsAppNotifierDecorator vs. below it.
        // Verify how changing the wrapping order changes which channels receive encrypted text vs. raw text.
        BasicEmailNotifier alertNotifier2 = new BasicEmailNotifier();
        EncryptionDecorator encryptionDecorator2 = new EncryptionDecorator(alertNotifier2);
        WhatsappNotifierDecorator whatsappNotifierDecorator2 = new WhatsappNotifierDecorator(encryptionDecorator2);
        LoggingDecorator loggingDecorator2 = new LoggingDecorator(whatsappNotifierDecorator2);

        loggingDecorator2.send(alert);

        // 5) Check the deduplicate message warning -
        DeduplicateDecorator decorator = new DeduplicateDecorator(basicEmailNotifier);
        decorator.send(message);
        decorator.send(message);

    }
}
