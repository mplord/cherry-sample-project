package com.mplord.sample.cherry.tasks;

import java.util.List;

public class OutputResultsTask {
    public static void outputResults(String prefix, List<String> results, boolean suppress) {
        if (suppress)
            return;
        System.out.println("");
        for (String result : results) {
            System.out.println(prefix + result);
        }
    }
}
