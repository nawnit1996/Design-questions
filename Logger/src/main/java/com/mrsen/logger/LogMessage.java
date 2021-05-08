package com.mrsen.logger;

import java.time.Instant;

public class LogMessage {

    private LogLevel logLevel;
    private String logMessage;
    private Instant timestamp ;
    private String className;

    public LogMessage(final LogLevel logLevel, final String logMessage, final String className) {
        this.logLevel = logLevel;
        this.logMessage = logMessage;
        this.className = className;
        this.timestamp = Instant.now();
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getClassName() {
        return className;
    }
}
