package com.psk.pyragas.ToolRent.utils.interceptors;

import com.psk.pyragas.ToolRent.entities.Profile;
import com.psk.pyragas.ToolRent.utils.LoggerToFile;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
    private LoggerToFile logger;

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    @AroundInvoke
    public Object logMethodInfo(InvocationContext context) throws Exception {
        String logMessage = "";
        logMessage += "--METHOD LOGGER START--" + "\n";
        Profile profile = (Profile)(externalContext.getSessionMap().get("user"));
        logMessage += "Profile id: " + (profile==null ? null : profile.getId()) + "\n";
        logMessage += "Time before method call: " + new Timestamp(System.currentTimeMillis()) + "\n";
        logMessage += "Entering method: " + context.getMethod().getName() + "\n";
        logMessage += "Entering class: " + context.getTarget().getClass() + "\n";
        logger.logToFile(logMessage);
        Object methodResult = context.proceed();
        logMessage = "";
        logMessage += "Time after method call: " + new Timestamp(System.currentTimeMillis()) + "\n";
        logMessage += "Called method: " + context.getMethod().getName() + "\n";
        logMessage += "Caller class: " + context.getTarget().getClass() + "\n";
        logMessage += "Method result: " + (methodResult == null ? "No Result (void)" : methodResult.toString()) + "\n";
        logMessage += "--METHOD LOGGER END--" + "\n";
        logger.logToFile(logMessage);
        return methodResult;
    }
}
