package com.psk.pyragas.ToolRent.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class MockData {

    @PostConstruct
    private void init() {
        System.out.println("CREATED MOCK DATA");
    }
}
