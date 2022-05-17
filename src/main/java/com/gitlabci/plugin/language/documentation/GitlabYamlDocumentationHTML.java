package com.gitlabci.plugin.language.documentation;

import com.gitlabci.plugin.language.GitlabYamlKeywords;

import java.util.Map;
import static java.util.Map.entry;

public final class GitlabYamlDocumentationHTML {

    public static final String style = "<style type=\"text/css\">\n" +
            "  .s0 { color: #808080;}\n" +
            "  .s1 { color: #a9b7c6;}\n" +
            "  .s2 { color: #cc7832;}\n" +
            "  .s3 { color: #6a8759;}\n" +
            "  .s4 { color: #6897bb;}\n" +
            "\n" +
            "  .code-block {\n" +
            "\t  background-color: #2b2b2b;\n" +
            "    padding: 10px;\n" +
            "    border-radius: 5px;\n" +
            "    overflow:hidden;\n" +
            "  }\n" +
            "\n" +
            "  code {\n" +
            "    font-weight: bold;\n" +
            "  }";

    public static final Map<String, String> examples = Map.ofEntries(
            entry(GitlabYamlKeywords.DEFAULT, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">default</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">image</span><span class=\"s1\">: </span><span class=\"s3\">ruby:3.0</span>\n" +
                    "\n" +
                    "<span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">bundle exec rspec</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.INCLUDE, "<div>\n" +
                    "<code>include:local</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">include</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">local</span><span class=\"s1\">: </span><span class=\"s3\">'/templates/.gitlab-ci-template.yml'</span>\n" +
                    "\n" +
                    "<span class=\"s0\"># inline</span>\n" +
                    "<span class=\"s2\">include</span><span class=\"s1\">: </span><span class=\"s3\">'.gitlab-ci-production.yml'</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>include:file</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">include</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">project</span><span class=\"s1\">: </span><span class=\"s3\">'my-group/my-project'</span>\n" +
                    "  <span class=\"s2\">file</span><span class=\"s1\">: </span><span class=\"s3\">'/templates/.gitlab-ci-template.yml'</span>\n" +
                    "\n" +
                    "<span class=\"s0\"># With ref</span>\n" +
                    "<span class=\"s2\">include</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">project</span><span class=\"s1\">: </span><span class=\"s3\">'my-group/my-project'</span>\n" +
                    "  <span class=\"s2\">ref</span><span class=\"s1\">: </span><span class=\"s3\">main</span>\n" +
                    "  <span class=\"s2\">file</span><span class=\"s1\">: </span><span class=\"s3\">'/templates/.gitlab-ci-template.yml'</span>\n" +
                    "\n" +
                    "<span class=\"s0\"># Multiple files</span>\n" +
                    "<span class=\"s2\">include</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">project</span><span class=\"s1\">: </span><span class=\"s3\">'my-group/my-project'</span>\n" +
                    "  <span class=\"s2\">ref</span><span class=\"s1\">: </span><span class=\"s3\">main</span>\n" +
                    "  <span class=\"s2\">file</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">'/templates/.builds.yml'</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">'/templates/.tests.yml'</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>inlcude:remote</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">include</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">remote</span><span class=\"s1\">: </span><span class=\"s3\">'https://gitlab.com/example-project/-/raw/main/.gitlab-ci.yml'</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>include:template</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s0\"># File sourced from the GitLab template collection</span>\n" +
                    "<span class=\"s2\">include</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">template</span><span class=\"s1\">: </span><span class=\"s3\">Auto-DevOps.gitlab-ci.yml</span>\n" +
                    "\n" +
                    "<span class=\"s0\"># multiple templates</span>\n" +
                    "<span class=\"s2\">include</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">template</span><span class=\"s1\">: </span><span class=\"s3\">Android-Fastlane.gitlab-ci.yml</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">template</span><span class=\"s1\">: </span><span class=\"s3\">Auto-DevOps.gitlab-ci.yml</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.STAGES, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">stages</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">deploy</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.WORKFLOW, "<div>\n" +
                    "<code>workflow:rules</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">workflow</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">rules</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_TITLE =~ /-draft$/</span>\n" +
                    "    <span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">never</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_PIPELINE_SOURCE == &quot;merge_request_event&quot;</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_BRANCH == $CI_DEFAULT_BRANCH</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>workflow:rules:variables</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">DEPLOY_VARIABLE</span><span class=\"s1\">: </span><span class=\"s3\">&quot;default-deploy&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">workflow</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">rules</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_REF_NAME == $CI_DEFAULT_BRANCH</span>\n" +
                    "    <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s2\">DEPLOY_VARIABLE</span><span class=\"s1\">: </span><span class=\"s3\">&quot;deploy-production&quot;  </span><span class=\"s0\"># Override globally-defined DEPLOY_VARIABLE</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_REF_NAME =~ /feature/</span>\n" +
                    "    <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s2\">IS_A_FEATURE</span><span class=\"s1\">: </span><span class=\"s3\">&quot;true&quot;          </span><span class=\"s0\"># Define a new variable.</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">always              </span><span class=\"s1\"># </span><span class=\"s3\">Run the pipeline in other cases</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">DEPLOY_VARIABLE</span><span class=\"s1\">: </span><span class=\"s3\">&quot;job1-default-deploy&quot;</span>\n" +
                    "  <span class=\"s2\">rules</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_REF_NAME == $CI_DEFAULT_BRANCH</span>\n" +
                    "    <span class=\"s2\">variables</span><span class=\"s1\">:                   # </span><span class=\"s3\">Override DEPLOY_VARIABLE defined</span>\n" +
                    "    <span class=\"s2\">DEPLOY_VARIABLE</span><span class=\"s1\">: </span><span class=\"s3\">&quot;job1-deploy-production&quot;  </span><span class=\"s0\"># at the job level.</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">on_success               </span><span class=\"s1\"># </span><span class=\"s3\">Run the job in other cases</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Run script with $DEPLOY_VARIABLE as an argument&quot;</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Run another script if $IS_A_FEATURE exists&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Run script with $DEPLOY_VARIABLE as an argument&quot;</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Run another script if $IS_A_FEATURE exists&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.AFTER_SCRIPT, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;An example script section.&quot;</span>\n" +
                    "  <span class=\"s2\">after_script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Execute this command after the `script` section completes.&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.ALLOW_FAILURE, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">execute_script_1</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">execute_script_2</span>\n" +
                    "  <span class=\"s2\">allow_failure</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job3</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">deploy_to_staging</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>allow_failure:exit_codes</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">test_job_1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Run a script that results in exit code 1. This job fails.&quot;</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">exit 1</span>\n" +
                    "  <span class=\"s2\">allow_failure</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">exit_codes</span><span class=\"s1\">: </span><span class=\"s4\">137</span>\n" +
                    "\n" +
                    "<span class=\"s2\">test_job_2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Run a script that results in exit code 137. This job is allowed to fail.&quot;</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">exit 137</span>\n" +
                    "  <span class=\"s2\">allow_failure</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">exit_codes</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s4\">137</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s4\">255</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.ARTIFACTS, "<div>\n" +
                    "<code>artifacts:exclude</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">binaries/</span>\n" +
                    "  <span class=\"s2\">exclude</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">binaries/**/*.o</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>artifacts:expire_in</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">expire_in</span><span class=\"s1\">: </span><span class=\"s3\">1 week</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>artifacts:expose_as</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">test</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: [</span><span class=\"s3\">&quot;echo 'test' &gt; file.txt&quot;</span><span class=\"s1\">]</span>\n" +
                    "  <span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">expose_as</span><span class=\"s1\">: </span><span class=\"s3\">'artifact 1'</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">: [</span><span class=\"s3\">'file.txt'</span><span class=\"s1\">]</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>artifacts:name</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">&quot;job1-artifacts-file&quot;</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">binaries/</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>artifacts:paths</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">binaries/</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">.config</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>artifacts:public</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">public</span><span class=\"s1\">: </span><span class=\"s3\">false</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>artifacts:reports</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">bundle install</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">rspec --format RspecJunitFormatter --out rspec.xml</span>\n" +
                    "  <span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">reports</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s2\">junit</span><span class=\"s1\">: </span><span class=\"s3\">rspec.xml</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>artifacts:untracked</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">untracked</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>artifacts:when</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">on_failure</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.BEFORE_SCRIPT, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">before_script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Execute this command before any 'script:' commands.&quot;</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This command executes after the job's 'before_script' commands.&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.CACHE, "<div>\n" +
                    "<code>cache:paths</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job uses a cache.&quot;</span>\n" +
                    "  <span class=\"s2\">cache</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">key</span><span class=\"s1\">: </span><span class=\"s3\">binaries-cache</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">binaries/*.apk</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">.config</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>cache:key</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">cache-job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job uses a cache.&quot;</span>\n" +
                    "  <span class=\"s2\">cache</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">key</span><span class=\"s1\">: </span><span class=\"s3\">binaries-cache-$CI_COMMIT_REF_SLUG</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">binaries/</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>cache:key:files</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">cache-job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job uses a cache.&quot;</span>\n" +
                    "  <span class=\"s2\">cache</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">key</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s2\">files</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">Gemfile.lock</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">package.json</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">vendor/ruby</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">node_modules</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>cache:key:prefix</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This rspec job uses a cache.&quot;</span>\n" +
                    "  <span class=\"s2\">cache</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">key</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s2\">files</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">Gemfile.lock</span>\n" +
                    "    <span class=\"s2\">prefix</span><span class=\"s1\">: </span><span class=\"s3\">$CI_JOB_NAME</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">vendor/ruby</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>cache:untracked</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">cache</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">untracked</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "\n" +
                    "<span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">cache</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">untracked</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">binaries/</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>cache:when</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">rspec</span>\n" +
                    "  <span class=\"s2\">cache</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">rspec/</span>\n" +
                    "  <span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">'always'</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>cache:policy</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">prepare-dependencies-job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s2\">cache</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">key</span><span class=\"s1\">: </span><span class=\"s3\">gems</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">vendor/bundle</span>\n" +
                    "  <span class=\"s2\">policy</span><span class=\"s1\">: </span><span class=\"s3\">push</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job only downloads dependencies and builds the cache.&quot;</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Downloading dependencies...&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">faster-test-job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">cache</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">key</span><span class=\"s1\">: </span><span class=\"s3\">gems</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">vendor/bundle</span>\n" +
                    "  <span class=\"s2\">policy</span><span class=\"s1\">: </span><span class=\"s3\">pull</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job script uses the cache, but does not update it.&quot;</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Running tests...&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.COVERAGE, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">rspec</span>\n" +
                    "  <span class=\"s2\">coverage</span><span class=\"s1\">: </span><span class=\"s3\">'/Code coverage: \\d+\\.\\d+/'</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.DAST_CONFIGURATION, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">stages</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">dast</span>\n" +
                    "\n" +
                    "<span class=\"s2\">include</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">template</span><span class=\"s1\">: </span><span class=\"s3\">DAST.gitlab-ci.yml</span>\n" +
                    "\n" +
                    "<span class=\"s2\">dast</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">dast_configuration</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">site_profile</span><span class=\"s1\">: </span><span class=\"s3\">&quot;Example Co&quot;</span>\n" +
                    "  <span class=\"s2\">scanner_profile</span><span class=\"s1\">: </span><span class=\"s3\">&quot;Quick Passive Test&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.DEPENDENCIES, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">build osx</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">make build:osx</span>\n" +
                    "  <span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">binaries/</span>\n" +
                    "\n" +
                    "<span class=\"s2\">build linux</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">make build:linux</span>\n" +
                    "  <span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">binaries/</span>\n" +
                    "\n" +
                    "<span class=\"s2\">test osx</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">make test:osx</span>\n" +
                    "  <span class=\"s2\">dependencies</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">build osx</span>\n" +
                    "\n" +
                    "<span class=\"s2\">test linux</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">make test:linux</span>\n" +
                    "  <span class=\"s2\">dependencies</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">build linux</span>\n" +
                    "\n" +
                    "<span class=\"s2\">deploy</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">make deploy</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.ENVIRONMENT, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">deploy to production</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">git push production HEAD:main</span>\n" +
                    "  <span class=\"s2\">environment</span><span class=\"s1\">: </span><span class=\"s3\">production</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>environment:name</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">deploy to production</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">git push production HEAD:main</span>\n" +
                    "  <span class=\"s2\">environment</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">production</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>environment:url</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">deploy to production</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">git push production HEAD:main</span>\n" +
                    "  <span class=\"s2\">environment</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">production</span>\n" +
                    "  <span class=\"s2\">url</span><span class=\"s1\">: </span><span class=\"s3\">https://prod.example.com</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>environment:action</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">stop_review_app</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">GIT_STRATEGY</span><span class=\"s1\">: </span><span class=\"s3\">none</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">make delete-app</span>\n" +
                    "  <span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">manual</span>\n" +
                    "  <span class=\"s2\">environment</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">review/$CI_COMMIT_REF_SLUG</span>\n" +
                    "  <span class=\"s2\">action</span><span class=\"s1\">: </span><span class=\"s3\">stop</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>environment:auto_stop_in</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">review_app</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">deploy-review-app</span>\n" +
                    "  <span class=\"s2\">environment</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">review/$CI_COMMIT_REF_SLUG</span>\n" +
                    "  <span class=\"s2\">auto_stop_in</span><span class=\"s1\">: </span><span class=\"s3\">1 day</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>environment:kubernetes</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">deploy</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">make deploy-app</span>\n" +
                    "  <span class=\"s2\">environment</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">production</span>\n" +
                    "  <span class=\"s2\">kubernetes</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s2\">namespace</span><span class=\"s1\">: </span><span class=\"s3\">production</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>environment:deployment_tier</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">deploy</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo</span>\n" +
                    "  <span class=\"s2\">environment</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">customer-portal</span>\n" +
                    "  <span class=\"s2\">deployment_tier</span><span class=\"s1\">: </span><span class=\"s3\">production</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.EXTENDS, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">tests</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">rake test</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">only</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">refs</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">branches</span>\n" +
                    "\n" +
                    "<span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">extends</span><span class=\"s1\">: </span><span class=\"s3\">.tests</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">rake rspec</span>\n" +
                    "  <span class=\"s2\">only</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">$RSPEC</span>\n" +
                    "\n" +
                    "<span class=\"s0\"># result of extends</span>\n" +
                    "<span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">rake rspec</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">only</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">refs</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">branches</span>\n" +
                    "  <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">$RSPEC</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.IMAGE, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">default</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">image</span><span class=\"s1\">: </span><span class=\"s3\">ruby:3.0</span>\n" +
                    "\n" +
                    "<span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">bundle exec rspec</span>\n" +
                    "\n" +
                    "<span class=\"s2\">rspec </span><span class=\"s4\">2</span><span class=\"s1\">.</span><span class=\"s4\">7</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">image</span><span class=\"s1\">: </span><span class=\"s3\">registry.example.com/my-group/my-project/ruby:2.7</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">bundle exec rspec</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>image:name</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">image</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">&quot;registry.example.com/my/image:latest&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>image:entrypoint</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">image</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">super/sql:experimental</span>\n" +
                    "  <span class=\"s2\">entrypoint</span><span class=\"s1\">: [</span><span class=\"s3\">&quot;&quot;</span><span class=\"s1\">]</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.INHERIT, "<div>\n" +
                    "<code>inherit:default</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">default</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">retry</span><span class=\"s1\">: </span><span class=\"s4\">2</span>\n" +
                    "  <span class=\"s2\">image</span><span class=\"s1\">: </span><span class=\"s3\">ruby:3.0</span>\n" +
                    "  <span class=\"s2\">interruptible</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;This job does not inherit any default keywords.&quot;</span>\n" +
                    "  <span class=\"s2\">inherit</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">default</span><span class=\"s1\">: </span><span class=\"s3\">false</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;This job inherits only the two listed default keywords. It does not inherit 'interruptible'.&quot;</span>\n" +
                    "  <span class=\"s2\">inherit</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">default</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">retry</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">image</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>inherit:variables</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">VARIABLE1</span><span class=\"s1\">: </span><span class=\"s3\">&quot;This is variable 1&quot;</span>\n" +
                    "  <span class=\"s2\">VARIABLE2</span><span class=\"s1\">: </span><span class=\"s3\">&quot;This is variable 2&quot;</span>\n" +
                    "  <span class=\"s2\">VARIABLE3</span><span class=\"s1\">: </span><span class=\"s3\">&quot;This is variable 3&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;This job does not inherit any global variables.&quot;</span>\n" +
                    "  <span class=\"s2\">inherit</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">variables</span><span class=\"s1\">: </span><span class=\"s3\">false</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;This job inherits only the two listed global variables. It does not inherit 'VARIABLE3'.&quot;</span>\n" +
                    "  <span class=\"s2\">inherit</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">VARIABLE1</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">VARIABLE2</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.INTERRUPTIBLE, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">stages</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">stage1</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">stage2</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">stage3</span>\n" +
                    "\n" +
                    "<span class=\"s2\">step-1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">stage1</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Can be canceled.&quot;</span>\n" +
                    "  <span class=\"s2\">interruptible</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "\n" +
                    "<span class=\"s2\">step-2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">stage2</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Can not be canceled.&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">step-3</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">stage3</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Because step-2 can not be canceled, this step can never be canceled, even though it's set as interruptible.&quot;</span>\n" +
                    "  <span class=\"s2\">interruptible</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.NEEDS, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">linux</span><span class=\"s1\">:</span><span class=\"s2\">build</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;Building linux...&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">mac</span><span class=\"s1\">:</span><span class=\"s2\">build</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;Building mac...&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">lint</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">needs</span><span class=\"s1\">: []</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;Linting...&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">linux</span><span class=\"s1\">:</span><span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">needs</span><span class=\"s1\">: [</span><span class=\"s3\">&quot;linux:build&quot;</span><span class=\"s1\">]</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;Running rspec on linux...&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">mac</span><span class=\"s1\">:</span><span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">needs</span><span class=\"s1\">: [</span><span class=\"s3\">&quot;mac:build&quot;</span><span class=\"s1\">]</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;Running rspec on mac...&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">production</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;Running production...&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>needs:artifacts</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">test-job1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">needs</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">job</span><span class=\"s1\">: </span><span class=\"s3\">build_job1</span>\n" +
                    "    <span class=\"s2\">artifacts</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "\n" +
                    "<span class=\"s2\">test-job2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">needs</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">job</span><span class=\"s1\">: </span><span class=\"s3\">build_job2</span>\n" +
                    "    <span class=\"s2\">artifacts</span><span class=\"s1\">: </span><span class=\"s3\">false</span>\n" +
                    "\n" +
                    "<span class=\"s2\">test-job3</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">needs</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">job</span><span class=\"s1\">: </span><span class=\"s3\">build_job1</span>\n" +
                    "    <span class=\"s2\">artifacts</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">job</span><span class=\"s1\">: </span><span class=\"s3\">build_job2</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">build_job3</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>needs:project</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">build_job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">ls -lhR</span>\n" +
                    "  <span class=\"s2\">needs</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">project</span><span class=\"s1\">: </span><span class=\"s3\">$CI_PROJECT_PATH</span>\n" +
                    "    <span class=\"s2\">job</span><span class=\"s1\">: </span><span class=\"s3\">$DEPENDENCY_JOB_NAME</span>\n" +
                    "    <span class=\"s2\">ref</span><span class=\"s1\">: </span><span class=\"s3\">$ARTIFACTS_DOWNLOAD_REF</span>\n" +
                    "    <span class=\"s2\">artifacts</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>needs:pipeline:job</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">create-artifact</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;sample artifact&quot; &gt; artifact.txt</span>\n" +
                    "  <span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">: [</span><span class=\"s2\">artifact</span><span class=\"s1\">.</span><span class=\"s2\">txt</span><span class=\"s1\">]</span>\n" +
                    "\n" +
                    "<span class=\"s2\">child-pipeline</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">trigger</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">include</span><span class=\"s1\">: </span><span class=\"s3\">child.yml</span>\n" +
                    "  <span class=\"s2\">strategy</span><span class=\"s1\">: </span><span class=\"s3\">depend</span>\n" +
                    "  <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">PARENT_PIPELINE_ID</span><span class=\"s1\">: </span><span class=\"s3\">$CI_PIPELINE_ID</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<span class=\"s0\"># child pipeline</span>\n" +
                    "<span class=\"s2\">use-artifact</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">cat artifact.txt</span>\n" +
                    "  <span class=\"s2\">needs</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">pipeline</span><span class=\"s1\">: </span><span class=\"s3\">$PARENT_PIPELINE_ID</span>\n" +
                    "    <span class=\"s2\">job</span><span class=\"s1\">: </span><span class=\"s3\">create-artifact</span>\n" +
                    "\n" +
                    "<code>needs:optional</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">build</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s2\">rules</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_BRANCH == $CI_DEFAULT_BRANCH</span>\n" +
                    "\n" +
                    "<span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">needs</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">job</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "    <span class=\"s2\">optional</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>needs:pipeline</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">upstream_bridge</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">needs</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">pipeline</span><span class=\"s1\">: </span><span class=\"s3\">other/project</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.ONLY, "<div>\n" +
                    "<code>only:refs</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo</span>\n" +
                    "  <span class=\"s2\">only</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">main</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">/^issue-.*$/</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">merge_requests</span>\n" +
                    "\n" +
                    "<span class=\"s0\"># refs explicit</span>\n" +
                    "<span class=\"s2\">job2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo</span>\n" +
                    "  <span class=\"s2\">only</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">refs</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">branches</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>only:variables</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">deploy</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">cap staging deploy</span>\n" +
                    "  <span class=\"s2\">only</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">$RELEASE == &quot;staging&quot;</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">$STAGING</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>only:changes</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">docker build</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">docker build -t my-image:$CI_COMMIT_REF_SLUG .</span>\n" +
                    "  <span class=\"s2\">only</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">refs</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">branches</span>\n" +
                    "  <span class=\"s2\">changes</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">Dockerfile</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">docker/scripts/*</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">dockerfiles/**/*</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">more_scripts/*.{rb,py,sh}</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">&quot;**/*.json&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>only:kubernetes</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">deploy</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">only</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">kubernetes</span><span class=\"s1\">: </span><span class=\"s3\">active</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.EXCEPT, "<div>\n" +
                    "  <code>except:refs</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "  <pre>\n" +
                    "<span class=\"s2\">job2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo</span>\n" +
                    "  <span class=\"s2\">except</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">main</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">/^stable-branch.*$/</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">schedules</span>\n" +
                    "\n" +
                    "<span class=\"s0\"># refs explicit</span>\n" +
                    "<span class=\"s2\">job2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo</span>\n" +
                    "  <span class=\"s2\">except</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">refs</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">branches</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "<code>except:variables</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">deploy</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">cap staging deploy</span>\n" +
                    "  <span class=\"s2\">except</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">$RELEASE == &quot;staging&quot;</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">$STAGING</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>except:changes</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">docker build</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">docker build -t my-image:$CI_COMMIT_REF_SLUG .</span>\n" +
                    "  <span class=\"s2\">except</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">refs</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">branches</span>\n" +
                    "  <span class=\"s2\">changes</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">Dockerfile</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">docker/scripts/*</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">dockerfiles/**/*</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">more_scripts/*.{rb,py,sh}</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">&quot;**/*.json&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>except:kubernetes</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">deploy</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">except</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">kubernetes</span><span class=\"s1\">: </span><span class=\"s3\">active</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.PAGES, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">pages</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">mkdir .public</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">cp -r * .public</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">mv .public public</span>\n" +
                    "  <span class=\"s2\">artifacts</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">paths</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">public</span>\n" +
                    "  <span class=\"s2\">rules</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_BRANCH == $CI_DEFAULT_BRANCH</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>\n"),
            entry(GitlabYamlKeywords.PARALLEL, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">test</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">rspec</span>\n" +
                    "  <span class=\"s2\">parallel</span><span class=\"s1\">: </span><span class=\"s4\">5</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>parallel:matrix</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">deploystacks</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">bin/deploy</span>\n" +
                    "  <span class=\"s2\">parallel</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">matrix</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s2\">PROVIDER</span><span class=\"s1\">: </span><span class=\"s3\">aws</span>\n" +
                    "    <span class=\"s2\">STACK</span><span class=\"s1\">:</span>\n" +
                    "      <span class=\"s1\">- </span><span class=\"s3\">monitoring</span>\n" +
                    "      <span class=\"s1\">- </span><span class=\"s3\">app1</span>\n" +
                    "      <span class=\"s1\">- </span><span class=\"s3\">app2</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s2\">PROVIDER</span><span class=\"s1\">: </span><span class=\"s3\">ovh</span>\n" +
                    "    <span class=\"s2\">STACK</span><span class=\"s1\">: [</span><span class=\"s2\">monitoring</span><span class=\"s1\">, </span><span class=\"s2\">backup</span><span class=\"s1\">, </span><span class=\"s2\">app</span><span class=\"s1\">]</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s2\">PROVIDER</span><span class=\"s1\">: </span><span class=\"s3\">[gcp, vultr]</span>\n" +
                    "    <span class=\"s2\">STACK</span><span class=\"s1\">: [</span><span class=\"s2\">data</span><span class=\"s1\">, </span><span class=\"s2\">processing</span><span class=\"s1\">]</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<span class=\"s0\"># parallel:matrix result</span>\n" +
                    "<span class=\"s2\">deploystacks</span><span class=\"s1\">: [</span><span class=\"s2\">aws</span><span class=\"s1\">, </span><span class=\"s2\">monitoring</span><span class=\"s1\">]</span>\n" +
                    "<span class=\"s2\">deploystacks</span><span class=\"s1\">: [</span><span class=\"s2\">aws</span><span class=\"s1\">, </span><span class=\"s2\">app1</span><span class=\"s1\">]</span>\n" +
                    "<span class=\"s2\">deploystacks</span><span class=\"s1\">: [</span><span class=\"s2\">aws</span><span class=\"s1\">, </span><span class=\"s2\">app2</span><span class=\"s1\">]</span>\n" +
                    "<span class=\"s2\">deploystacks</span><span class=\"s1\">: [</span><span class=\"s2\">ovh</span><span class=\"s1\">, </span><span class=\"s2\">monitoring</span><span class=\"s1\">]</span>\n" +
                    "<span class=\"s2\">deploystacks</span><span class=\"s1\">: [</span><span class=\"s2\">ovh</span><span class=\"s1\">, </span><span class=\"s2\">backup</span><span class=\"s1\">]</span>\n" +
                    "<span class=\"s2\">deploystacks</span><span class=\"s1\">: [</span><span class=\"s2\">ovh</span><span class=\"s1\">, </span><span class=\"s2\">app</span><span class=\"s1\">]</span>\n" +
                    "<span class=\"s2\">deploystacks</span><span class=\"s1\">: [</span><span class=\"s2\">gcp</span><span class=\"s1\">, </span><span class=\"s2\">data</span><span class=\"s1\">]</span>\n" +
                    "<span class=\"s2\">deploystacks</span><span class=\"s1\">: [</span><span class=\"s2\">gcp</span><span class=\"s1\">, </span><span class=\"s2\">processing</span><span class=\"s1\">]</span>\n" +
                    "<span class=\"s2\">deploystacks</span><span class=\"s1\">: [</span><span class=\"s2\">vultr</span><span class=\"s1\">, </span><span class=\"s2\">data</span><span class=\"s1\">]</span>\n" +
                    "<span class=\"s2\">deploystacks</span><span class=\"s1\">: [</span><span class=\"s2\">vultr</span><span class=\"s1\">, </span><span class=\"s2\">processing</span><span class=\"s1\">]</span>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.RELEASE, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">release_job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">release</span>\n" +
                    "  <span class=\"s2\">image</span><span class=\"s1\">: </span><span class=\"s3\">registry.gitlab.com/gitlab-org/release-cli:latest</span>\n" +
                    "  <span class=\"s2\">rules</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_TAG          </span><span class=\"s1\"># </span><span class=\"s3\">Run this job when a tag is created manually</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Running the release job.&quot;</span>\n" +
                    "  <span class=\"s2\">release</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">tag_name</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_TAG</span>\n" +
                    "  <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">'Release $CI_COMMIT_TAG'</span>\n" +
                    "  <span class=\"s2\">description</span><span class=\"s1\">: </span><span class=\"s3\">'Release created using the release-cli.'</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>release:tag_name</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;Running the release job for the new tag.&quot;</span>\n" +
                    "  <span class=\"s2\">release</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">tag_name</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_TAG</span>\n" +
                    "  <span class=\"s2\">description</span><span class=\"s1\">: </span><span class=\"s3\">'Release description'</span>\n" +
                    "  <span class=\"s2\">rules</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_TAG</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>release:name</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">release_job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">release</span>\n" +
                    "  <span class=\"s2\">release</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">'Release $CI_COMMIT_TAG'</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>release:description</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">release</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">tag_name</span><span class=\"s1\">: </span><span class=\"s3\">${MAJOR}_${MINOR}_${REVISION}</span>\n" +
                    "  <span class=\"s2\">description</span><span class=\"s1\">: </span><span class=\"s3\">'./path/to/CHANGELOG.md'</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>release:released_at</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">released_at</span><span class=\"s1\">: </span><span class=\"s3\">'2021-03-15T08:00:00Z'</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>release:assets:links</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">assets</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">links</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">'asset1'</span>\n" +
                    "    <span class=\"s2\">url</span><span class=\"s1\">: </span><span class=\"s3\">'https://example.com/assets/1'</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">'asset2'</span>\n" +
                    "    <span class=\"s2\">url</span><span class=\"s1\">: </span><span class=\"s3\">'https://example.com/assets/2'</span>\n" +
                    "    <span class=\"s2\">filepath</span><span class=\"s1\">: </span><span class=\"s3\">'/pretty/url/1' </span><span class=\"s0\"># optional</span>\n" +
                    "    <span class=\"s2\">link_type</span><span class=\"s1\">: </span><span class=\"s3\">'other' </span><span class=\"s0\"># optional</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>\n"),
            entry(GitlabYamlKeywords.RESOURCE_GROUP, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">deploy-to-production</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">resource_group</span><span class=\"s1\">: </span><span class=\"s3\">production</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.RETRY, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">test</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">rspec</span>\n" +
                    "  <span class=\"s2\">retry</span><span class=\"s1\">: </span><span class=\"s4\">2</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>retry:when</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">test</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">rspec</span>\n" +
                    "  <span class=\"s2\">retry</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">max</span><span class=\"s1\">: </span><span class=\"s4\">2</span>\n" +
                    "  <span class=\"s2\">when</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">runner_system_failure</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">stuck_or_timeout_failure</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.RULES, "<div>\n" +
                    "<code>rules:if</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;Hello, Rules!&quot;</span>\n" +
                    "  <span class=\"s2\">rules</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_MERGE_REQUEST_SOURCE_BRANCH_NAME =~ /^feature/ &amp;&amp; $CI_MERGE_REQUEST_TARGET_BRANCH_NAME != $CI_DEFAULT_BRANCH</span>\n" +
                    "    <span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">never</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_MERGE_REQUEST_SOURCE_BRANCH_NAME =~ /^feature/</span>\n" +
                    "    <span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">manual</span>\n" +
                    "    <span class=\"s2\">allow_failure</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_MERGE_REQUEST_SOURCE_BRANCH_NAME</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>rules:changes</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">docker build</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">docker build -t my-image:$CI_COMMIT_REF_SLUG .</span>\n" +
                    "  <span class=\"s2\">rules</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_PIPELINE_SOURCE == &quot;merge_request_event&quot;</span>\n" +
                    "    <span class=\"s2\">changes</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">Dockerfile</span>\n" +
                    "    <span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">manual</span>\n" +
                    "    <span class=\"s2\">allow_failure</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>rules:exists</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">docker build -t my-image:$CI_COMMIT_REF_SLUG .</span>\n" +
                    "  <span class=\"s2\">rules</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">exists:</span>\n" +
                    "    <span class=\"s1\">- </span><span class=\"s3\">Dockerfile</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>rules:allow_failure</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">echo &quot;Hello, Rules!&quot;</span>\n" +
                    "  <span class=\"s2\">rules</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_MERGE_REQUEST_TARGET_BRANCH_NAME == $CI_DEFAULT_BRANCH</span>\n" +
                    "    <span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">manual</span>\n" +
                    "    <span class=\"s2\">allow_failure</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>rules:variables</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">DEPLOY_VARIABLE</span><span class=\"s1\">: </span><span class=\"s3\">&quot;default-deploy&quot;</span>\n" +
                    "  <span class=\"s2\">rules</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_REF_NAME == $CI_DEFAULT_BRANCH</span>\n" +
                    "    <span class=\"s2\">variables</span><span class=\"s1\">:                # </span><span class=\"s3\">Override DEPLOY_VARIABLE defined</span>\n" +
                    "    <span class=\"s2\">DEPLOY_VARIABLE</span><span class=\"s1\">: </span><span class=\"s3\">&quot;deploy-production&quot;  </span><span class=\"s0\"># at the job level.</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">if</span><span class=\"s1\">: </span><span class=\"s3\">$CI_COMMIT_REF_NAME =~ /feature/</span>\n" +
                    "    <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s2\">IS_A_FEATURE</span><span class=\"s1\">: </span><span class=\"s3\">&quot;true&quot;          </span><span class=\"s0\"># Define a new variable.</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Run script with $DEPLOY_VARIABLE as an argument&quot;</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;Run another script if $IS_A_FEATURE exists&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>\n"),
            entry(GitlabYamlKeywords.SCRIPT, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">&quot;bundle exec rspec&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s0\"># script multiline</span>\n" +
                    "<span class=\"s2\">job2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">uname -a</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">bundle exec rspec</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.SECRETS, "<div>\n" +
                    "<code>secrets:vault</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">secrets</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">DATABASE_PASSWORD</span><span class=\"s1\">:  # </span><span class=\"s3\">Store the path to the secret in this CI/CD variable</span>\n" +
                    "    <span class=\"s2\">vault</span><span class=\"s1\">:  # </span><span class=\"s3\">Translates to secret: `ops/data/production/db`, field: `password`</span>\n" +
                    "    <span class=\"s2\">engine</span><span class=\"s1\">:</span>\n" +
                    "      <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">kv-v2</span>\n" +
                    "      <span class=\"s2\">path</span><span class=\"s1\">: </span><span class=\"s3\">ops</span>\n" +
                    "    <span class=\"s2\">path</span><span class=\"s1\">: </span><span class=\"s3\">production/db</span>\n" +
                    "    <span class=\"s2\">field</span><span class=\"s1\">: </span><span class=\"s3\">password</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>secrets:file</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">secrets</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">DATABASE_PASSWORD</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s2\">vault</span><span class=\"s1\">: </span><span class=\"s3\">production/db/password@ops</span>\n" +
                    "    <span class=\"s2\">file</span><span class=\"s1\">: </span><span class=\"s3\">false</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.SERVICES, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">default</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">image</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">ruby:2.6</span>\n" +
                    "  <span class=\"s2\">entrypoint</span><span class=\"s1\">: [</span><span class=\"s3\">&quot;/bin/bash&quot;</span><span class=\"s1\">]</span>\n" +
                    "\n" +
                    "  <span class=\"s2\">services</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s2\">name</span><span class=\"s1\">: </span><span class=\"s3\">my-postgres:11.7</span>\n" +
                    "    <span class=\"s2\">alias</span><span class=\"s1\">: </span><span class=\"s3\">db-postgres</span>\n" +
                    "    <span class=\"s2\">entrypoint</span><span class=\"s1\">: [</span><span class=\"s3\">&quot;/usr/local/bin/db-postgres&quot;</span><span class=\"s1\">]</span>\n" +
                    "    <span class=\"s2\">command</span><span class=\"s1\">: [</span><span class=\"s3\">&quot;start&quot;</span><span class=\"s1\">]</span>\n" +
                    "\n" +
                    "  <span class=\"s2\">before_script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">bundle install</span>\n" +
                    "\n" +
                    "<span class=\"s2\">test</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">bundle exec rake spec</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.STAGE, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">stages</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">deploy</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job compiles code.&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job tests the compiled code. It runs when the build stage completes.&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job3</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job also runs in the test stage&quot;.</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job4</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job deploys the code. It runs when the test stage completes.&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>stage: .pre</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">stages</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">test</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job runs in the build stage.&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">first-job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">.pre</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job runs in the .pre stage, before all other stages.&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job runs in the test stage.&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>stage: .post</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">stages</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">test</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job runs in the build stage.&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">last-job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">.post</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job runs in the .post stage, after all other stages.&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">job2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">echo &quot;This job runs in the test stage.&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.TAGS, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">tags</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">ruby</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">postgres</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.TIMEOUT, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">build</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">build.sh</span>\n" +
                    "  <span class=\"s2\">timeout</span><span class=\"s1\">: </span><span class=\"s3\">3 hours 30 minutes</span>\n" +
                    "\n" +
                    "<span class=\"s2\">test</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">rspec</span>\n" +
                    "  <span class=\"s2\">timeout</span><span class=\"s1\">: </span><span class=\"s3\">3h 30m</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.TRIGGER, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s0\"># trigger multi-project pipeline</span>\n" +
                    "<span class=\"s2\">rspec</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">: </span><span class=\"s3\">bundle exec rspec</span>\n" +
                    "\n" +
                    "<span class=\"s2\">staging</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">trigger</span><span class=\"s1\">: </span><span class=\"s3\">my/deployment</span>\n" +
                    "\n" +
                    "<span class=\"s0\"># trigger child pipelines</span>\n" +
                    "<span class=\"s2\">trigger_job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">trigger</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">include</span><span class=\"s1\">: </span><span class=\"s3\">path/to/child-pipeline.yml</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>trigger:strategy</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">trigger_job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">trigger</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">include</span><span class=\"s1\">: </span><span class=\"s3\">path/to/child-pipeline.yml</span>\n" +
                    "  <span class=\"s2\">strategy</span><span class=\"s1\">: </span><span class=\"s3\">depend</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>trigger:forward</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">variables</span><span class=\"s1\">: # </span><span class=\"s3\">default variables for each job</span>\n" +
                    "  <span class=\"s2\">VAR</span><span class=\"s1\">: </span><span class=\"s3\">value</span>\n" +
                    "\n" +
                    "<span class=\"s0\"># Default behavior:</span>\n" +
                    "<span class=\"s0\"># - VAR is passed to the child</span>\n" +
                    "<span class=\"s0\"># - MYVAR is not passed to the child</span>\n" +
                    "<span class=\"s2\">child1</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">trigger</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">include</span><span class=\"s1\">: </span><span class=\"s3\">.child-pipeline.yml</span>\n" +
                    "\n" +
                    "<span class=\"s0\"># Forward pipeline variables:</span>\n" +
                    "<span class=\"s0\"># - VAR is passed to the child</span>\n" +
                    "<span class=\"s0\"># - MYVAR is passed to the child</span>\n" +
                    "<span class=\"s2\">child2</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">trigger</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">include</span><span class=\"s1\">: </span><span class=\"s3\">.child-pipeline.yml</span>\n" +
                    "  <span class=\"s2\">forward</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s2\">pipeline_variables</span><span class=\"s1\">: </span><span class=\"s3\">true</span>\n" +
                    "\n" +
                    "<span class=\"s0\"># Do not forward YAML variables:</span>\n" +
                    "<span class=\"s0\"># - VAR is not passed to the child</span>\n" +
                    "<span class=\"s0\"># - MYVAR is not passed to the child</span>\n" +
                    "<span class=\"s2\">child3</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">trigger</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">include</span><span class=\"s1\">: </span><span class=\"s3\">.child-pipeline.yml</span>\n" +
                    "  <span class=\"s2\">forward</span><span class=\"s1\">:</span>\n" +
                    "    <span class=\"s2\">yaml_variables</span><span class=\"s1\">: </span><span class=\"s3\">false</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>"),
            entry(GitlabYamlKeywords.VARIABLES, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">DEPLOY_SITE</span><span class=\"s1\">: </span><span class=\"s3\">&quot;https://example.com/&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">deploy_job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">deploy-script --url $DEPLOY_SITE --path &quot;/&quot;</span>\n" +
                    "\n" +
                    "<span class=\"s2\">deploy_review_job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">REVIEW_PATH</span><span class=\"s1\">: </span><span class=\"s3\">&quot;/review&quot;</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">deploy-review-script --url $DEPLOY_SITE --path $REVIEW_PATH</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "\n" +
                    "<code>variables:description</code>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">variables</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">DEPLOY_ENVIRONMENT</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">value</span><span class=\"s1\">: </span><span class=\"s3\">&quot;staging&quot;</span>\n" +
                    "  <span class=\"s2\">description</span><span class=\"s1\">: </span><span class=\"s3\">&quot;The deployment target. Change this variable to 'canary' or 'production' if needed.&quot;</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>\n"),
            entry(GitlabYamlKeywords.WHEN, "<div>\n" +
                    "<div class=\"code-block\">\n" +
                    "<pre>\n" +
                    "<span class=\"s2\">stages</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">cleanup_build</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">cleanup</span>\n" +
                    "\n" +
                    "<span class=\"s2\">build_job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">build</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">make build</span>\n" +
                    "\n" +
                    "<span class=\"s2\">cleanup_build_job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">cleanup_build</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">cleanup build when failed</span>\n" +
                    "  <span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">on_failure</span>\n" +
                    "\n" +
                    "<span class=\"s2\">test_job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">test</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">make test</span>\n" +
                    "\n" +
                    "<span class=\"s2\">deploy_job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">deploy</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">make deploy</span>\n" +
                    "  <span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">manual</span>\n" +
                    "\n" +
                    "<span class=\"s2\">cleanup_job</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s2\">stage</span><span class=\"s1\">: </span><span class=\"s3\">cleanup</span>\n" +
                    "  <span class=\"s2\">script</span><span class=\"s1\">:</span>\n" +
                    "  <span class=\"s1\">- </span><span class=\"s3\">cleanup after jobs</span>\n" +
                    "  <span class=\"s2\">when</span><span class=\"s1\">: </span><span class=\"s3\">always</span>\n" +
                    "</pre>\n" +
                    "</div>\n" +
                    "</div>")
    );

    public static final Map<String, String> keywordDefinitions = Map.ofEntries(
            entry(GitlabYamlKeywords.DEFAULT,  "<p>You can set global defaults for some keywords. Jobs that do not define one or more\n" +
                    "of the listed keywords use the value defined in the <code class=highlighter-rouge>default</code> section."),
            entry(GitlabYamlKeywords.INCLUDE,  "<p>Use <code class=highlighter-rouge>include</code> to include external YAML files in your CI/CD configuration.\n" +
                    "\tYou can split one long <code class=highlighter-rouge>.gitlab-ci.yml</code> file into multiple files to increase\n" +
                    "\treadability,\n" +
                    "\tor reduce duplication of the same configuration in multiple places.\n" +
                    "\t<p>You can also store template files in a central repository and include them in projects.\n" +
                    "\t\t<p>The <code class=highlighter-rouge>include</code> files are:\n" +
                    "\t\t\t<ul>\n" +
                    "\t\t\t\t<li>Merged with those in the <code class=highlighter-rouge>.gitlab-ci.yml</code> file.\n" +
                    "\t\t\t\t<li>Always evaluated first and then merged with the content of the\n" +
                    "\t\t\t\t\t<code class=highlighter-rouge>.gitlab-ci.yml</code> file,\n" +
                    "\t\t\t\t\tregardless of the position of the <code class=highlighter-rouge>include</code> keyword.\n" +
                    "\t\t\t</ul>\n" +
                    "\t\t\t<p>You can <a href=includes.html#use-nested-includes>nest</a> up to 100 includes. In <a\n" +
                    "\t\t\t\t\thref=https://gitlab.com/gitlab-org/gitlab/-/issues/28987>GitLab 14.9 and later</a>, the same file\n" +
                    "\t\t\t\t\tcan be included multiple times in nested includes, but duplicates are ignored. <p>In <a\n" +
                    "\t\t\t\t\t\thref=https://gitlab.com/gitlab-org/gitlab/-/issues/28212>GitLab 12.4 and later</a>, the time\n" +
                    "\t\t\t\t\t\tlimit to resolve all files is 30 seconds."),
            entry(GitlabYamlKeywords.STAGES,  "<p>Use <code class=highlighter-rouge>stages</code> to define stages that contain groups of jobs. Use <a href=#stage><code class=highlighter-rouge>stage</code></a>\n" +
                    "in a job to configure the job to run in a specific stage.\n" +
                    "<p>If <code class=highlighter-rouge>stages</code> is not defined in the <code class=highlighter-rouge>.gitlab-ci.yml</code> file, the default pipeline stages are:\n" +
                    "<ul>\n" +
                    "<li><a href=#stage-pre><code class=highlighter-rouge>.pre</code></a>\n" +
                    "<li><code class=highlighter-rouge>build</code>\n" +
                    "<li><code class=highlighter-rouge>test</code>\n" +
                    "<li><code class=highlighter-rouge>deploy</code>\n" +
                    "<li><a href=#stage-post><code class=highlighter-rouge>.post</code></a>\n" +
                    "</ul>\n" +
                    "<p>The order of the items in <code class=highlighter-rouge>stages</code> defines the execution order for jobs:\n" +
                    "<ul>\n" +
                    "<li>Jobs in the same stage run in parallel.\n" +
                    "<li>Jobs in the next stage run after the jobs from the previous stage complete successfully.\n" +
                    "</ul>"),
            entry(GitlabYamlKeywords.WORKFLOW,  "<p>Use <a href=workflow.html><code class=highlighter-rouge>workflow</code></a> to control pipeline behavior.\n" +
                    "<p><strong>Related topics</strong>:\n" +
                    "<ul>\n" +
                    "<li><a href=workflow.html#workflow-rules-examples><code class=highlighter-rouge>workflow: rules</code> examples</a>\n" +
                    "<li><a href=workflow.html#switch-between-branch-pipelines-and-merge-request-pipelines>Switch between branch pipelines and merge request pipelines</a>\n" +
                    "</ul>\n" +
                    "<h4 id=workflowrules>\n" +
                    "<code class=highlighter-rouge>workflow:rules</code><a href=#workflowrules title=Permalink class=anchor></a>\n" +
                    "</h4>\n" +
                    "<p>The <code class=highlighter-rouge>rules</code> keyword in <code class=highlighter-rouge>workflow</code> is similar to <a href=#rules><code class=highlighter-rouge>rules</code> defined in jobs</a>,\n" +
                    "but controls whether or not a whole pipeline is created.\n" +
                    "<p>When no rules evaluate to true, the pipeline does not run."),
            entry(GitlabYamlKeywords.AFTER_SCRIPT,  "<p>Use <code class=highlighter-rouge>after_script</code> to define an array of commands that run after each job, including failed jobs."),
            entry(GitlabYamlKeywords.ALLOW_FAILURE,  "<p>Use <code class=highlighter-rouge>allow_failure</code> to determine whether a pipeline should continue running when a job fails.\n" +
                    "<ul>\n" +
                    "<li>To let the pipeline continue running subsequent jobs, use <code class=highlighter-rouge>allow_failure: true</code>.\n" +
                    "<li>To stop the pipeline from running subsequent jobs, use <code class=highlighter-rouge>allow_failure: false</code>.\n" +
                    "</ul>\n" +
                    "<p>When jobs are allowed to fail (<code class=highlighter-rouge>allow_failure: true</code>) an orange warning (<svg role=\"img\" class=\"gl-icon ml-1 mr-1 s16\"><use href=\"/assets/images/icons.svg#status_warning\"/><title/></svg>)\n" +
                    "indicates that a job failed. However, the pipeline is successful and the associated commit\n" +
                    "is marked as passed with no warnings.\n" +
                    "<p>This same warning is displayed when:\n" +
                    "<ul>\n" +
                    "<li>All other jobs in the stage are successful.\n" +
                    "<li>All other jobs in the pipeline are successful.\n" +
                    "</ul>\n" +
                    "<p>The default value for <code class=highlighter-rouge>allow_failure</code> is:\n" +
                    "<ul>\n" +
                    "<li>\n" +
                    "<code class=highlighter-rouge>true</code> for <a href=../jobs/job_control.html#create-a-job-that-must-be-run-manually>manual jobs</a>.\n" +
                    "<li>\n" +
                    "<code class=highlighter-rouge>false</code> for jobs that use <code class=highlighter-rouge>when: manual</code> inside <a href=#rules><code class=highlighter-rouge>rules</code></a>.\n" +
                    "<li>\n" +
                    "<code class=highlighter-rouge>false</code> in all other cases.\n" +
                    "</ul>"),
            entry(GitlabYamlKeywords.ARTIFACTS,  "<p>Use <code class=highlighter-rouge>artifacts</code> to specify which files to save as <a href=../pipelines/job_artifacts.html>job artifacts</a>.\n" +
                    "Job artifacts are a list of files and directories that are\n" +
                    "attached to the job when it <a href=#artifactswhen>succeeds, fails, or always</a>.\n" +
                    "<p>The artifacts are sent to GitLab after the job finishes. They are\n" +
                    "available for download in the GitLab UI if the size is smaller than the\n" +
                    "the <a href=../../user/gitlab_com/index.html#gitlab-cicd>maximum artifact size</a>.\n" +
                    "<p>By default, jobs in later stages automatically download all the artifacts created\n" +
                    "by jobs in earlier stages. You can control artifact download behavior in jobs with\n" +
                    "<a href=#dependencies><code class=highlighter-rouge>dependencies</code></a>.\n" +
                    "<p>When using the <a href=#needs><code class=highlighter-rouge>needs</code></a> keyword, jobs can only download\n" +
                    "artifacts from the jobs defined in the <code class=highlighter-rouge>needs</code> configuration.\n" +
                    "<p>Job artifacts are only collected for successful jobs by default, and\n" +
                    "artifacts are restored after <a href=#cache>caches</a>.\n" +
                    "<p><a href=../pipelines/job_artifacts.html>Read more about artifacts</a>."),
            entry(GitlabYamlKeywords.BEFORE_SCRIPT,  "<p>Use <code class=highlighter-rouge>before_script</code> to define an array of commands that should run before each job’s\n" +
                    "<code class=highlighter-rouge>script</code> commands, but after <a href=#artifacts>artifacts</a> are restored."),
            entry(GitlabYamlKeywords.CACHE,  "<p>Use <code class=highlighter-rouge>cache</code> to specify a list of files and directories to\n" +
                    "cache between jobs. You can only use paths that are in the local working copy.\n" +
                    "<p>Caching is shared between pipelines and jobs. Caches are restored before <a href=#artifacts>artifacts</a>.\n" +
                    "<p>Learn more about caches in <a href=../caching/index.html>Caching in GitLab CI/CD</a>."),
            entry(GitlabYamlKeywords.COVERAGE,  "<p>Use <code class=highlighter-rouge>coverage</code> with a custom regular expression to configure how code coverage\n" +
                    "is extracted from the job output. The coverage is shown in the UI if at least one\n" +
                    "line in the job output matches the regular expression.\n" +
                    "<p>To extract the code coverage value from the match, GitLab uses\n" +
                    "this smaller regular expression: <code class=highlighter-rouge>\\d+(\\.\\d+)?</code>.\n" +
                    "<p><strong>Possible inputs</strong>:"),
            entry(GitlabYamlKeywords.DAST_CONFIGURATION,  "<p>Use the <code class=highlighter-rouge>dast_configuration</code> keyword to specify a site profile and scanner profile to be used in a\n" +
                    "CI/CD configuration. Both profiles must first have been created in the project. The job’s stage must\n" +
                    "be <code class=highlighter-rouge>dast</code>."),
            entry(GitlabYamlKeywords.DEPENDENCIES,  "<p>Use the <code class=highlighter-rouge>dependencies</code> keyword to define a list of jobs to fetch <a href=#artifacts>artifacts</a> from.\n" +
                    "You can also set a job to download no artifacts at all.\n" +
                    "<p>If you do not use <code class=highlighter-rouge>dependencies</code>, all artifacts from previous stages are passed to each job."),
            entry(GitlabYamlKeywords.ENVIRONMENT,  "<p>Use <code class=highlighter-rouge>environment</code> to define the <a href=../environments/index.html>environment</a> that a job deploys to."),
            entry(GitlabYamlKeywords.EXTENDS,  "<p>Use <code class=highlighter-rouge>extends</code> to reuse configuration sections. It’s an alternative to <a href=yaml_optimization.html#anchors>YAML anchors</a>\n" +
                    "and is a little more flexible and readable."),
            entry(GitlabYamlKeywords.IMAGE,  "<p>Use <code class=highlighter-rouge>image</code> to specify a Docker image that the job runs in.\n" +
                    "<p><strong>Keyword type</strong>: Job keyword. You can use it only as part of a job or in the\n" +
                    "<a href=#default><code class=highlighter-rouge>default</code> section</a>."),
            entry(GitlabYamlKeywords.INHERIT,  "<p>Use <code class=highlighter-rouge>inherit</code> to <a href=../jobs/index.html#control-the-inheritance-of-default-keywords-and-global-variables>control inheritance of default keywords and variables</a>.\n" +
                    "<h4 id=inheritdefault>\n" +
                    "<code class=highlighter-rouge>inherit:default</code><a href=#inheritdefault title=Permalink class=anchor></a>\n" +
                    "</h4>\n" +
                    "<p>Use <code class=highlighter-rouge>inherit:default</code> to control the inheritance of <a href=#default>default keywords</a>."),
            entry(GitlabYamlKeywords.INTERRUPTIBLE,  "<p>Use <code class=highlighter-rouge>interruptible</code> if a job should be canceled when a newer pipeline starts before the job completes.\n" +
                    "<p>This keyword is used with the <a href=../pipelines/settings.html#auto-cancel-redundant-pipelines>automatic cancellation of redundant pipelines</a>\n" +
                    "feature. When enabled, a running job with <code class=highlighter-rouge>interruptible: true</code> can be cancelled when\n" +
                    "a new pipeline starts on the same branch.\n" +
                    "<p>You can’t cancel subsequent jobs after a job with <code class=highlighter-rouge>interruptible: false</code> starts."),
            entry(GitlabYamlKeywords.NEEDS,  "<p>Use <code class=highlighter-rouge>needs</code> to execute jobs out-of-order. Relationships between jobs\n" +
                    "that use <code class=highlighter-rouge>needs</code> can be visualized as a <a href=../directed_acyclic_graph/index.html>directed acyclic graph</a>.\n" +
                    "<p>You can ignore stage ordering and run some jobs without waiting for others to complete.\n" +
                    "Jobs in multiple stages can run concurrently."),
            entry(GitlabYamlKeywords.ONLY,  "<code class=highlighter-rouge>only</code> and <code class=highlighter-rouge>except</code> are not being actively\n" +
                    "developed. <a href=#rules><code class=highlighter-rouge>rules</code></a> is the preferred\n" +
                    "keyword to control when to add jobs to pipelines." +
                    "<p>You can use <code class=highlighter-rouge>only</code> and <code class=highlighter-rouge>except</code> to control when\n" +
                    "\tto add jobs to pipelines.\n" +
                    "\t<ul>\n" +
                    "\t\t<li>Use <code class=highlighter-rouge>only</code> to define when a job runs.\n" +
                    "\t\t<li>Use <code class=highlighter-rouge>except</code> to define when a job <strong>does not</strong> run.\n" +
                    "\t</ul>"),
            entry(GitlabYamlKeywords.EXCEPT,  "<code class=highlighter-rouge>only</code> and <code class=highlighter-rouge>except</code> are not being actively\n" +
                    "developed. <a href=#rules><code class=highlighter-rouge>rules</code></a> is the preferred\n" +
                    "keyword to control when to add jobs to pipelines." +
                    "<p>You can use <code class=highlighter-rouge>only</code> and <code class=highlighter-rouge>except</code> to control when\n" +
                    "\tto add jobs to pipelines.\n" +
                    "\t<ul>\n" +
                    "\t\t<li>Use <code class=highlighter-rouge>only</code> to define when a job runs.\n" +
                    "\t\t<li>Use <code class=highlighter-rouge>except</code> to define when a job <strong>does not</strong> run.\n" +
                    "\t</ul>"),
            entry(GitlabYamlKeywords.PAGES,  "<p>Use <code class=highlighter-rouge>pages</code> to define a <a href=../../user/project/pages/index.html>GitLab Pages</a> job that\n" +
                    "uploads static content to GitLab. The content is then published as a website."),
            entry(GitlabYamlKeywords.PARALLEL,  "<p>Use <code class=highlighter-rouge>parallel</code> to run a job multiple times in parallel in a single pipeline.\n" +
                    "<p>Multiple runners must exist, or a single runner must be configured to run multiple jobs concurrently.\n" +
                    "<p>Parallel jobs are named sequentially from <code class=highlighter-rouge>job_name 1/N</code> to <code class=highlighter-rouge>job_name N/N</code>."),
            entry(GitlabYamlKeywords.RELEASE,  "<p>Use <code class=highlighter-rouge>release</code> to create a <a href=../../user/project/releases/index.html>release</a>.\n" +
                    "<p>The release job must have access to the <a href=https://gitlab.com/gitlab-org/release-cli/-/tree/master/docs><code class=highlighter-rouge>release-cli</code></a>,\n" +
                    "which must be in the <code class=highlighter-rouge>$PATH</code>.\n" +
                    "<p>If you use the <a href=https://docs.gitlab.com/runner/executors/docker.html>Docker executor</a>,\n" +
                    "you can use this image from the GitLab Container Registry: <code class=highlighter-rouge>registry.gitlab.com/gitlab-org/release-cli:latest</code>"),
            entry(GitlabYamlKeywords.RESOURCE_GROUP,  "<p>Use <code class=highlighter-rouge>resource_group</code> to create a <a href=../resource_groups/index.html>resource group</a> that\n" +
                    "ensures a job is mutually exclusive across different pipelines for the same project.\n" +
                    "<p>For example, if multiple jobs that belong to the same resource group are queued simultaneously,\n" +
                    "only one of the jobs starts. The other jobs wait until the <code class=highlighter-rouge>resource_group</code> is free.\n" +
                    "<p>Resource groups behave similar to semaphores in other programming languages.\n" +
                    "<p>You can define multiple resource groups per environment. For example,\n" +
                    "when deploying to physical devices, you might have multiple physical devices. Each device\n" +
                    "can be deployed to, but only one deployment can occur per device at any given time.\n" +
                    "<p><strong>Keyword type</strong>: Job keyword. You can use it only as part of a job."),
            entry(GitlabYamlKeywords.RETRY,  "<p>Use <code class=highlighter-rouge>retry</code> to configure how many times a job is retried if it fails.\n" +
                    "If not defined, defaults to <code class=highlighter-rouge>0</code> and jobs do not retry.\n" +
                    "<p>When a job fails, the job is processed up to two more times, until it succeeds or\n" +
                    "reaches the maximum number of retries.\n" +
                    "<p>By default, all failure types cause the job to be retried. Use <a href=#retrywhen><code class=highlighter-rouge>retry:when</code></a>\n" +
                    "to select which failures to retry on."),
            entry(GitlabYamlKeywords.RULES,  "<p>Use <code class=highlighter-rouge>rules</code> to include or exclude jobs in pipelines.\n" +
                    "<p>Rules are evaluated when the pipeline is created, and evaluated <em>in order</em>\n" +
                    "until the first match. When a match is found, the job is either included or excluded from the pipeline,\n" +
                    "depending on the configuration.\n" +
                    "<p>You cannot use dotenv variables created in job scripts in rules, because rules are evaluated before any jobs run.\n" +
                    "<p><code class=highlighter-rouge>rules</code> replaces <a href=#only--except><code class=highlighter-rouge>only/except</code></a> and they can’t be used together\n" +
                    "in the same job. If you configure one job to use both keywords, the GitLab returns\n" +
                    "a <code class=highlighter-rouge>key may not be used with rules</code> error.\n" +
                    "<p><code class=highlighter-rouge>rules</code> accepts an array of rules defined with:\n" +
                    "<ul>\n" +
                    "<li><code class=highlighter-rouge>if</code>\n" +
                    "<li><code class=highlighter-rouge>changes</code>\n" +
                    "<li><code class=highlighter-rouge>exists</code>\n" +
                    "<li><code class=highlighter-rouge>allow_failure</code>\n" +
                    "<li><code class=highlighter-rouge>variables</code>\n" +
                    "<li><code class=highlighter-rouge>when</code>\n" +
                    "</ul>\n" +
                    "<p>You can combine multiple keywords together for <a href=../jobs/job_control.html#complex-rules>complex rules</a>.\n" +
                    "<p>The job is added to the pipeline:\n" +
                    "<ul>\n" +
                    "<li>If an <code class=highlighter-rouge>if</code>, <code class=highlighter-rouge>changes</code>, or <code class=highlighter-rouge>exists</code> rule matches and also has <code class=highlighter-rouge>when: on_success</code> (default),\n" +
                    "<code class=highlighter-rouge>when: delayed</code>, or <code class=highlighter-rouge>when: always</code>.\n" +
                    "<li>If a rule is reached that is only <code class=highlighter-rouge>when: on_success</code>, <code class=highlighter-rouge>when: delayed</code>, or <code class=highlighter-rouge>when: always</code>.\n" +
                    "</ul>\n" +
                    "<p>The job is not added to the pipeline:\n" +
                    "<ul>\n" +
                    "<li>If no rules match.\n" +
                    "<li>If a rule matches and has <code class=highlighter-rouge>when: never</code>.\n" +
                    "</ul>\n" +
                    "<p>You can use <a href=yaml_optimization.html#reference-tags><code class=highlighter-rouge>!reference</code> tags</a> to <a href=../jobs/job_control.html#reuse-rules-in-different-jobs>reuse <code class=highlighter-rouge>rules</code> configuration</a>\n" +
                    "in different jobs."),
            entry(GitlabYamlKeywords.SCRIPT,  "<p>Use <code class=highlighter-rouge>script</code> to specify commands for the runner to execute.\n" +
                    "<p>All jobs except <a href=#trigger>trigger jobs</a> require a <code class=highlighter-rouge>script</code> keyword."),
            entry(GitlabYamlKeywords.SECRETS,  "<p>Use <code class=highlighter-rouge>secrets</code> to specify <a href=../secrets/index.html>CI/CD secrets</a> to: <ul>\n" +
                    "\t\t<li>Retrieve from an external secrets provider.\n" +
                    "\t\t<li>Make available in the job as <a href=../variables/index.html>CI/CD variables</a> (<a\n" +
                    "\t\t\t\thref=../variables/index.html#cicd-variable-types> <code class=highlighter-rouge>file</code> type</a> by\n" +
                    "\tdefault).\n" +
                    "\t</ul>\n" +
                    "\t<p>This keyword must be used with <code class=highlighter-rouge>secrets:vault</code>."),
            entry(GitlabYamlKeywords.SERVICES,  "<p>Use <code class=highlighter-rouge>services</code> to specify an additional Docker image to run scripts in. The <a href=../services/index.html><code class=highlighter-rouge>services</code> image</a> is linked\n" +
                    "to the image specified in the <a href=#image><code class=highlighter-rouge>image</code></a> keyword."),
            entry(GitlabYamlKeywords.STAGE,  "<p>Use <code class=highlighter-rouge>stage</code> to define which <a href=#stages>stage</a> a job runs in. Jobs in the same\n" +
                    "<code class=highlighter-rouge>stage</code> can execute in parallel (see <strong>Additional details</strong>).\n" +
                    "<p>If <code class=highlighter-rouge>stage</code> is not defined, the job uses the <code class=highlighter-rouge>test</code> stage by default."),
            entry(GitlabYamlKeywords.TAGS,  "<p>Use <code class=highlighter-rouge>tags</code> to select a specific runner from the list of all runners that are\n" +
                    "available for the project.\n" +
                    "<p>When you register a runner, you can specify the runner’s tags, for\n" +
                    "example <code class=highlighter-rouge>ruby</code>, <code class=highlighter-rouge>postgres</code>, or <code class=highlighter-rouge>development</code>. To pick up and run a job, a runner must\n" +
                    "be assigned every tag listed in the job."),
            entry(GitlabYamlKeywords.TIMEOUT,  "<p>Use <code class=highlighter-rouge>timeout</code> to configure a timeout for a specific job. If the job runs for longer\n" +
                    "than the timeout, the job fails.\n" +
                    "<p>The job-level timeout can be longer than the <a href=../pipelines/settings.html#set-a-limit-for-how-long-jobs-can-run>project-level timeout</a>.\n" +
                    "but can’t be longer than the <a href=../runners/configure_runners.html#set-maximum-job-timeout-for-a-runner>runner’s timeout</a>."),
            entry(GitlabYamlKeywords.TRIGGER,  "<p>Use <code class=highlighter-rouge>trigger</code> to start a downstream pipeline that is either:\n" +
                    "<ul>\n" +
                    "<li>\n" +
                    "<a href=../pipelines/multi_project_pipelines.html>A multi-project pipeline</a>.\n" +
                    "<li>\n" +
                    "<a href=../pipelines/parent_child_pipelines.html>A child pipeline</a>.\n" +
                    "</ul>"),
            entry(GitlabYamlKeywords.VARIABLES,  "<p><a href=../variables/index.html>CI/CD variables</a> are configurable values that are passed to jobs.\n" +
                    "Use <code class=highlighter-rouge>variables</code> to create <a href=../variables/index.html#custom-cicd-variables>custom variables</a>.\n" +
                    "<p>Variables are always available in <code class=highlighter-rouge>script</code>, <code class=highlighter-rouge>before_script</code>, and <code class=highlighter-rouge>after_script</code> commands.\n" +
                    "You can also use variables as inputs in some job keywords.\n" +
                    "<p><strong>Keyword type</strong>: Global and job keyword. You can use it at the global level,\n" +
                    "and also at the job level.\n" +
                    "<p>If you define <code class=highlighter-rouge>variables</code> at the global level, each variable is copied to\n" +
                    "every job configuration when the pipeline is created. If the job already has that\n" +
                    "variable defined, the <a href=../variables/index.html#cicd-variable-precedence>job-level variable takes precedence</a>."),
            entry(GitlabYamlKeywords.WHEN, "<p>Use <code class=highlighter-rouge>when</code> to configure the conditions for when jobs run. If not defined in a job,\n" +
                    "the default value is <code class=highlighter-rouge>when: on_success</code>.")
    );
}