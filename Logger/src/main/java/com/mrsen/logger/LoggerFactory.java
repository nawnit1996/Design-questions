package com.mrsen.logger;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

public class LoggerFactory {

    private static Map<Class, Logger> LOGGER_INSTANCES = new HashMap<>();
    private static LoggerQueue LOGGER_QUEUE;
    private static String CONFIG_FILE_NAME = "logConfig.properties";

    private LoggerFactory() {

    }

    public static Logger getLogger(Class clazz) {
        if (Objects.isNull(LOGGER_QUEUE)) {
            initLoggerQueue();
        }
        LOGGER_INSTANCES.put(clazz, createLoggerInstance(clazz));
        return LOGGER_INSTANCES.get(clazz);
    }

    private static synchronized void initLoggerQueue() {
        if (LOGGER_QUEUE != null) {
            return;
        }
        Properties appProps = new Properties();
        try {

            appProps.load(new FileInputStream(CONFIG_FILE_NAME));
            Integer intialCapacity = Integer.parseInt((String) appProps.get("logging.queue.initialCapactiy"));
            final Map<String, LogLevel> collect = appProps.entrySet().stream().filter(entry -> ((String) entry.getKey()).startsWith("logging.level"))
                    .collect(Collectors.toMap(entry -> ((String) entry.getKey())
                            .replace("logging.level", ""), entry -> LogLevel.valueOf((String) entry.getValue())));
            LOGGER_QUEUE = new LoggerQueue(intialCapacity, collect);

        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }


    }

    static private Logger createLoggerInstance(Class clazz) {
        return new Logger(clazz, LOGGER_QUEUE);
    }
}
