package com.mplord.sample.cherry.missions.api;

import java.util.List;

public class ApiMission {
    public void outputResults(String prefix, List<String> results, boolean suppress) {
        if (suppress)
            return;
        System.out.println("");
        for (String result : results) {
            System.out.println(prefix + result);
        }
    }
}
