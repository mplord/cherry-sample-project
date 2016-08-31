package com.mplord.sample.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.mplord.sample.cherry.memory.FilingHistoryKey;
import com.mplord.sample.cherry.memory.ResponseRecordKey;
import com.mplord.sample.mock.tools.QueueReader;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(QueueReader.class).in(Scopes.SINGLETON);
        bind(FilingHistoryKey.class).in(Scopes.SINGLETON);
        bind(ResponseRecordKey.class).in(Scopes.SINGLETON);
        // bind(MongoWriter.class).in(Scopes.SINGLETON); - singleton not needed
        // bind(ResultWriter.class).in(Scopes.SINGLETON); - singleton not needed
    }

}
