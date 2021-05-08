package com.mrsen.logger.writer;

import com.mrsen.logger.LogMessage;

public abstract class AbstractLogWriter {
   abstract void log(LogMessage message);

}
