package com.gitlabci.plugin.language.highlighter;

import com.gitlabci.plugin.language.GitLabYamlBundle;
import com.gitlabci.plugin.language.GitLabYamlFileType;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class GitLabYamlColorSettingsPage implements ColorSettingsPage {

    private static final String DEMO_TEXT =
      "image: docker:latest #test document\n"
    + "int_test: 123\n"
    + "some_array: [1, 'test']\n"
    + "stages:\n"
    + "  - Deploy to registry\n"
    + "  - Trigger deploy to kubernetes\n"
    + "variables:\n"
    + "  TEST_VAR: 'TEST_VAR'";

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[] {
        new AttributesDescriptor(GitLabYamlBundle.message("color.settings.gitlabyaml.string"), GitLabYamlHighlighter.STRING),
        new AttributesDescriptor(GitLabYamlBundle.message("color.settings.gitlabyaml.sign"), GitLabYamlHighlighter.SIGN),
        new AttributesDescriptor(GitLabYamlBundle.message("color.settings.gitlabyaml.comment"), GitLabYamlHighlighter.COMMENT),
        new AttributesDescriptor(GitLabYamlBundle.message("color.settings.gitlabyaml.id"), GitLabYamlHighlighter.ID),
        new AttributesDescriptor(GitLabYamlBundle.message("color.settings.gitlabyaml.int"), GitLabYamlHighlighter.INT),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return GitLabYamlFileType.INSTANCE.getIcon();
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new GitLabYamlSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return DEMO_TEXT;
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    @NotNull
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    @NotNull
    public ColorDescriptor [] getColorDescriptors() {
        return new ColorDescriptor[0];
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "GitLab YAML";
    }
}
