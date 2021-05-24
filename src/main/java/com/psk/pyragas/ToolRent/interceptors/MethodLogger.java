package com.psk.pyragas.ToolRent.interceptors;

import com.psk.pyragas.ToolRent.utils.FileIO;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.sql.Timestamp;

@Interceptor
@WillBeLogged
public class MethodLogger implements Serializable {

    @Inject
    private FileIO fileWriter;

    private final String logFileLocation = "methodLogs.txt";

    @AroundInvoke
    public Object logMethodInfo(InvocationContext context) throws Exception {
        String logMessage = "";
        logMessage += "--METHOD LOGGER START--" + "\n";
        logMessage += "Time before method call: " + new Timestamp(System.currentTimeMillis()) + "\n";
        fileWriter.writeToTextFile(logFileLocation, logMessage);
        Object methodResult = context.proceed();
        logMessage = "";
        logMessage += "Time after method call: " + new Timestamp(System.currentTimeMillis()) + "\n";
        logMessage += "Called method: " + context.getMethod().getName() + "\n";
        logMessage += "Caller class: " + context.getTarget().getClass() + "\n";
        logMessage += "Method result: " + (methodResult == null ? "No Result (void)" : methodResult.toString()) + "\n";
        logMessage += "--METHOD LOGGER END--" + "\n";
        fileWriter.writeToTextFile(logFileLocation, logMessage);
        return methodResult;
    }
}
