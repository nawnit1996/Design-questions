package com.mrsen.logger;

import com.mrsen.logger.writer.AbstractLogWriter;

import java.util.Map;

public class LogHandler {
    private LoggerQueue queue;
    private Map<LogLevel,AbstractLogWriter> logWriterConfig;

    public LogHandler(final LoggerQueue queue, final Map<LogLevel, AbstractLogWriter> logWriterConfig) {
        this.queue = queue;
        this.logWriterConfig = logWriterConfig;
        initWriters();
    }

    private void initWriters() {

    }
}
