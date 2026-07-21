package org.example.system_design.design_patterns.structural.decorator;

import java.util.concurrent.ConcurrentHashMap;
import javax.swing.plaf.synth.SynthOptionPaneUI;

public class DeduplicateDecorator extends NotifierDecorator {

    private final ConcurrentHashMap<String, Long> recentMessages = new ConcurrentHashMap<>();
    private static final long DEDUP_WINDOW_MS = 5000; // 5 seconds

    public DeduplicateDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        Long currentTime = System.currentTimeMillis();
        Long lastSent = recentMessages.get(message);

        if(lastSent != null && (currentTime-lastSent) < DEDUP_WINDOW_MS){
            System.out.println("[Suppressed Duplicate Alert]: " + message);
            return;
        }

        recentMessages.put(message, currentTime);
        notifier.send(message);

    }
}
