package icons;

import com.gitlabci.plugin.language.GitLabYamlBundle;
import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

public class GitLabYamlPluginIcons {
    public static final Icon GitLabYamlIcon = IconLoader.getIcon(GitLabYamlBundle.message("icon.gitlabyaml.main"), GitLabYamlPluginIcons.class);
    public static final Icon GitLabYamlGlobalKeywordIcon = IconLoader.getIcon(GitLabYamlBundle.message("icon.gitlabyaml.global-keyword"), GitLabYamlPluginIcons.class);
    public static final Icon GitLabYamlJobKeywordIcon = IconLoader.getIcon(GitLabYamlBundle.message("icon.gitlabyaml.job-keyword"), GitLabYamlPluginIcons.class);
    public static final Icon GitLabYamlInputIcon = IconLoader.getIcon(GitLabYamlBundle.message("icon.gitlabyaml.input"), GitLabYamlPluginIcons.class);
}