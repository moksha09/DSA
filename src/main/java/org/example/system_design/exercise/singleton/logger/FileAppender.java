package org.example.system_design.exercise.singleton.logger;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{

    private final String fileName;

    public FileAppender(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void append(String message) {

        try(FileWriter writer = new FileWriter(fileName, true)){
            writer.write(message);
            writer.write(System.lineSeparator());
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
