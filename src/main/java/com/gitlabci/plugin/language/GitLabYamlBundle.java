package com.gitlabci.plugin.language;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

public class GitLabYamlBundle extends DynamicBundle {
    @NonNls private static final String BUNDLE_PATH = "messages.GitLabYamlBundle";
    private static final GitLabYamlBundle INSTANCE = new GitLabYamlBundle();

    public GitLabYamlBundle() {
        super(BUNDLE_PATH);
    }

    @NotNull
    public static @Nls String message(@NotNull @PropertyKey(resourceBundle = BUNDLE_PATH) String key, Object... params) {
        return INSTANCE.getMessage(key, params);
    }
}
