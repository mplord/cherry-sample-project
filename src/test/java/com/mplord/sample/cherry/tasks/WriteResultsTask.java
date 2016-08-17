package com.mplord.sample.cherry.tasks;

import java.util.List;

public class WriteResultsTask {
    public void outputResults(String prefix, List<String> results, boolean suppress) {
        if (suppress)
            return;
        System.out.println("");
        for (String result : results) {
            System.out.println(prefix + result);
        }
    }
}
