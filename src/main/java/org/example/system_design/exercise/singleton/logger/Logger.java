package org.example.system_design.exercise.singleton.logger;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import org.example.system_design.exercise.singleton.counter.EnumSingleton;

public enum Logger {
    /**
     * Problem: Implement a Logger Singleton that can be used throughout the application to log messages at different severity levels.
     * The logger should ensure that:
     *      - Only one logger instance exists in the application.
     *      - All components share the same logger configuration.
     *      - Messages are logged only if their level is equal to or higher than the currently configured log level.
     *
     * Requirements:
     *     - Log Levels: DEBUG, INFO, WARN, ERROR
     *     - Order by severity: DEBUG < INFO < WARN < ERROR
     */

    INSTANCE;

    private LogAppender appender = new ConsoleAppender();
    private volatile LogLevel currentLevel = LogLevel.INFO; // default value to prevent NPE
    private volatile List<String> logs = new ArrayList<>();

    public synchronized List<String> getLogs(){
        return new ArrayList<>(logs);
    }

    public synchronized void clearLogs(){
        logs.clear();
    }

    public void setLogLevel(LogLevel level){
        currentLevel = level;
    }

    public void setAppender(LogAppender appender){
        this.appender = appender;
    }

    public void log(LogLevel level, String message){
        if(level.getSeverity() >= currentLevel.getSeverity()){
            String log = String.format("[%s] [%s] [%s]", Instant.now(), level, message);
            appender.append(log);
            logs.add(log);
        }
    }

    public LogLevel getLogLevel(){
        return currentLevel;
    }

    public static void main(String[] args) {
        // After implementing, usage should look like:
        Logger l1 = Logger.INSTANCE;
        Logger l2 = Logger.INSTANCE;
        System.out.println("Same instance: " + (l1 == l2));

        l1.setLogLevel(LogLevel.INFO);
        l1.log(LogLevel.WARN, "This is a warning!");
        l1.log(LogLevel.ERROR, "This is an error!");
        l1.log(LogLevel.DEBUG, "This is a debug message");
    }

}
