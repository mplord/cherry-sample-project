package com.mplord.sample.cherry.memory;

import com.mplord.sample.mock.objects.FilingHistory;

import io.magentys.commons.typemap.TypedKey;

public class FilingHistoryKey extends TypedKey<FilingHistory> {

    public FilingHistoryKey() {
        super("filing-history");
    }
}
