package icons;

import com.gitlabci.plugin.language.GitlabYamlBundle;
import com.intellij.openapi.util.IconLoader;
import javax.swing.Icon;

public class GitlabYamlPluginIcons {
    public static final Icon GitlabYamlIcon = IconLoader.getIcon(GitlabYamlBundle.message("icon.gitlabyaml.main"), GitlabYamlPluginIcons.class);
    public static final Icon GitlabYamlGlobalKeywordIcon = IconLoader.getIcon(GitlabYamlBundle.message("icon.gitlabyaml.global-keyword"), GitlabYamlPluginIcons.class);
    public static final Icon GitlabYamlJobKeywordIcon = IconLoader.getIcon(GitlabYamlBundle.message("icon.gitlabyaml.job-keyword"), GitlabYamlPluginIcons.class);
    public static final Icon GitlabYamlInputIcon = IconLoader.getIcon(GitlabYamlBundle.message("icon.gitlabyaml.input"), GitlabYamlPluginIcons.class);
}