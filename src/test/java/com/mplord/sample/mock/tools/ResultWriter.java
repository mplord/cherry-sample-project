package com.mplord.sample.mock.tools;

import java.util.List;

public class ResultWriter {
    public void outputResults(String prefix, List<String> results, boolean suppress) {
        if (suppress)
            return;
        System.out.println("");
        for (String result : results) {
            System.out.println(prefix + result);
        }
    }
}
