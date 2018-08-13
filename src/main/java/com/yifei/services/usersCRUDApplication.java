package com.yifei.services;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


public class usersCRUDApplication extends Application {
    private Set<Object> singletons = new HashSet<>();
    private Set<Class<?>> empty = new HashSet<>();

    public usersCRUDApplication() {
        singletons.add(new usersCRUDService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses()
    {
        return empty;
    }
}
