package com.mplord.sample.junit;

import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mplord.sample.guice.GuiceModule;


public class TestBase {
    protected Injector injector = Guice.createInjector(new GuiceModule());

    @Before
    public void setup() {
        injector.injectMembers(this);
    }
}