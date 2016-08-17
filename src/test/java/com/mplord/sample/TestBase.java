package com.mplord.sample;

import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mplord.sample.guice.GuiceModule;

import cucumber.api.guice.CucumberModules;

public class TestBase {
    protected Injector injector = Guice.createInjector(CucumberModules.SCENARIO, new GuiceModule());

    @Before
    public void setup() {
        injector.injectMembers(this);
    }
}