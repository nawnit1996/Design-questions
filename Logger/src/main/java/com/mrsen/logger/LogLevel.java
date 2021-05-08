package com.mrsen.logger;

public enum LogLevel {
INFO(1),DEBUG(2);
int level;
    LogLevel(final int i) {
        this.level= i;

    }
}
