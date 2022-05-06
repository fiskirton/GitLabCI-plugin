package com.gitlabci.plugin.language.highlighter;

import com.gitlabci.plugin.language.GitlabYamlBundle;
import com.gitlabci.plugin.language.GitlabYamlFileType;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class GitlabYamlColorSettingsPage implements ColorSettingsPage {

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
        new AttributesDescriptor(GitlabYamlBundle.message("color.settings.gitlabyaml.string"), GitlabYamlHighlighter.STRING),
        new AttributesDescriptor(GitlabYamlBundle.message("color.settings.gitlabyaml.sign"), GitlabYamlHighlighter.SIGN),
        new AttributesDescriptor(GitlabYamlBundle.message("color.settings.gitlabyaml.comment"), GitlabYamlHighlighter.COMMENT),
        new AttributesDescriptor(GitlabYamlBundle.message("color.settings.gitlabyaml.id"), GitlabYamlHighlighter.ID),
        new AttributesDescriptor(GitlabYamlBundle.message("color.settings.gitlabyaml.int"), GitlabYamlHighlighter.INT),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return GitlabYamlFileType.INSTANCE.getIcon();
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new GitlabYamlSyntaxHighlighter();
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
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return new ColorDescriptor[0];
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Gitlab YAML";
    }
}
