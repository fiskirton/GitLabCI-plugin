package com.gitlabci.plugin.language;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

public class GitlabYamlBundle extends DynamicBundle {
    @NonNls private static final String BUNDLE_PATH = "messages.GitlabYamlBundle";
    private static final GitlabYamlBundle INSTANCE = new GitlabYamlBundle();

    public GitlabYamlBundle() {
        super(BUNDLE_PATH);
    }

    @NotNull
    public static @Nls String message(@NotNull @PropertyKey(resourceBundle = BUNDLE_PATH) String key, Object @NotNull ... params) {
        return INSTANCE.getMessage(key, params);
    }
}
