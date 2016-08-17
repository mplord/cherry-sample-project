package com.mplord.sample;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mplord.sample.guice.GuiceModule;

import cucumber.api.guice.CucumberModules;

public class InjectorSource implements cucumber.runtime.java.guice.InjectorSource {
    @Override
    public Injector getInjector() {
        // return Guice.createInjector(CucumberModules.SCENARIO, new GuiceModule(), new ConfigModule());
        return Guice.createInjector(CucumberModules.SCENARIO, new GuiceModule());
    }
}
