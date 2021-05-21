package com.psk.pyragas.ToolRent.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.sql.Timestamp;

@Interceptor
@WillBeLogged
public class MethodLogger implements Serializable {
    @AroundInvoke
    public Object logMethodInfo(InvocationContext context) throws Exception {
        System.out.println("--METHOD LOGGER START--");
        System.out.println("Time before method call: " + new Timestamp(System.currentTimeMillis()));
        System.out.println("Entering method: " + context.getMethod().getName());
        System.out.println("Entering class: " + context.getTarget().getClass());
        //injectedComponentMethod();
        Object methodResult = context.proceed();
        System.out.println("Time after method call: " + new Timestamp(System.currentTimeMillis()));
        System.out.println("Called method: " + context.getMethod().getName());
        System.out.println("Caller class: " + context.getTarget().getClass());
        System.out.println("Method result: " + (methodResult == null ? "No Result (void)" : methodResult.toString()));
        System.out.println("--METHOD LOGGER END--");
        //injectedComponentMethod();
        return methodResult;
    }
}
