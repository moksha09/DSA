package org.example.system_design.design_patterns.structural.decorator;

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier notifier; // protected so that its subclass - smsnotifier can
    // access it call the default concrete class implementation through it

    protected NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
}
