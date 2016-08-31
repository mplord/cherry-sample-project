package com.mplord.sample.cherry.memory;

import com.mplord.sample.mock.objects.FilingHistory;

import io.magentys.commons.typemap.TypedKey;

public class TheFilingHistory extends TypedKey<FilingHistory> {

    public TheFilingHistory() {
        super("filing-history");
    }
}
