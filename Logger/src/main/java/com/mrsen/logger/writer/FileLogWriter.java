package com.mrsen.logger.writer;

import com.mrsen.logger.LogMessage;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogWriter extends AbstractLogWriter {

    private String fileName;
    private FileWriter writer;

    public FileLogWriter(String fileName) {
        try {
            this.fileName =fileName;
            writer = new FileWriter(fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
           }
    @Override
    public void log(final LogMessage message) {
        try {
            writer.write(message.getTimestamp()+" "+message.getLogLevel()+" "+message.getClassName()+" "+message.getLogMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        writer.close();
        super.finalize();
    }
}
