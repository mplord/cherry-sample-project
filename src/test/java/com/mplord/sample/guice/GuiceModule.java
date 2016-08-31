package com.mplord.sample.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.mplord.sample.cherry.memory.TheFilingHistory;
import com.mplord.sample.cherry.memory.TheResponseRecord;
import com.mplord.sample.mock.tools.QueueReader;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(QueueReader.class).in(Scopes.SINGLETON);
        bind(TheFilingHistory.class).in(Scopes.SINGLETON);
        bind(TheResponseRecord.class).in(Scopes.SINGLETON);
        // bind(MongoWriter.class).in(Scopes.SINGLETON); - singleton not needed
        // bind(ResultWriter.class).in(Scopes.SINGLETON); - singleton not needed
    }

}
