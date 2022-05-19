package com.gitlabci.plugin.utils;

import com.gitlabci.plugin.ui.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {
    public static String listToString(List<String> list) {
        return String.join(", ", list);
    }

    public static List<Map.Entry<String, Stage>> getSortedStages(Map<String, Stage> map) {
        List<Map.Entry<String, Stage>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        return entries;
    }
}
