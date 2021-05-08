package com.mrsen.logger;

public class Logger {
    private Class clazz;
    private LoggerQueue queue;

    Logger(final Class clazz, final LoggerQueue queue) {
        this.clazz = clazz;
        this.queue = queue;
    }

    public void info(String message){
         createLogMessage(message,LogLevel.INFO);
    }

    public void debug(String message){
        createLogMessage(message,LogLevel.DEBUG);
    }

    private  LogMessage createLogMessage(String message, LogLevel logLevel){
        return new LogMessage(logLevel,message,clazz.getName());
    }
}
