package com.mrsen.logger;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Optional;

public class LoggerQueue {

    private Map<String, LogLevel> logConfig;

    ArrayDeque<LogMessage> logQueue;

    LoggerQueue(int initialCapacity, Map<String, LogLevel> logConfig) {
        logQueue = new ArrayDeque(initialCapacity);
        this.logConfig = logConfig;
    }

    public void addMessage(LogMessage logMessage) {
        if (shouldLog(logMessage)) {
            logQueue.add(logMessage);
        }
    }

    public LogMessage poll() {
      return  logQueue.poll();
    }

    private boolean shouldLog(final LogMessage logMessage) {
        final Optional<Map.Entry<String, LogLevel>> any = logConfig.entrySet().stream().filter((pckg) -> logMessage.getClass().getName().startsWith(pckg.getKey())).findAny();
        return (!any.isPresent()) || (any.get().getValue().level >= logMessage.getLogLevel().level);
    }

}
