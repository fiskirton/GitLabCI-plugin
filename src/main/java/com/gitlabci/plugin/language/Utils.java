package com.gitlabci.plugin.language;

import java.util.List;

public class Utils {
    public static String listToString(List<String> list) {
        return String.join(", ", list);
    }
}
