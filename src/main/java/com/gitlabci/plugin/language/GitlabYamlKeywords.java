package com.gitlabci.plugin.language;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public final class GitlabYamlKeywords {
    public static final String DEFAULT = "default";
    public static final String INCLUDE = "include";
    public static final String LOCAL = "local";
    public static final String FILE = "file";
    public static final String REMOTE = "remote";
    public static final String TEMPLATE = "template";
    public static final String PROJECT = "project";
    public static final String REF = "ref";
    public static final String STAGES = "stages";
    public static final String VARIABLES = "variables";
    public static final String WORKFLOW = "workflow";
    public static final String AFTER_SCRIPT = "after_script";
    public static final String ALLOW_FAILURE = "allow_failure";
    public static final String EXIT_CODES = "exit_codes";
    public static final String ARTIFACTS = "artifacts";
    public static final String PATHS = "paths";
    public static final String EXCLUDE = "exclude";
    public static final String EXPIRE_IN = "expire_in";
    public static final String EXPOSE_AS = "expose_as";
    public static final String NAME = "name";
    public static final String PUBLIC = "public";
    public static final String REPORTS = "reports";
    public static final String UNTRACKED = "untracked";
    public static final String WHEN = "when";
    public static final String BEFORE_SCRIPT = "before_script";
    public static final String CACHE = "cache";
    public static final String KEY = "key";
    public static final String FILES = "files";
    public static final String PREFIX = "prefix";
    public static final String POLICY = "policy";
    public static final String COVERAGE = "coverage";
    public static final String DAST_CONFIGURATION = "dast_configuration";
    public static final String SITE_PROFILE = "site_profile";
    public static final String SCANNER_PROFILE = "scanner_profile";
    public static final String DEPENDENCIES = "dependencies";
    public static final String ENVIRONMENT = "environment";
    public static final String URL = "url";
    public static final String ON_STOP = "on_stop";
    public static final String ACTION = "action";
    public static final String AUTO_STOP_IN = "auto_stop_in";
    public static final String KUBERNETES = "kubernetes";
    public static final String DEPLOYMENT_TIER = "deployment_tier";
    public static final String EXCEPT = "except";
    public static final String REFS = "refs";
    public static final String CHANGES = "changes";
    public static final String EXTENDS = "extends";
    public static final String IMAGE = "image";
    public static final String ENTRYPOINT = "entrypoint";
    public static final String INHERIT = "inherit";
    public static final String INTERRUPTIBLE = "interruptible";
    public static final String NEEDS = "needs";
    public static final String PIPELINE = "pipeline";
    public static final String JOB = "job";
    public static final String OPTIONAL = "optional";
    public static final String ONLY = "only";
    public static final String PAGES = "pages";
    public static final String PARALLEL = "parallel";
    public static final String MATRIX = "matrix";
    public static final String RELEASE = "release";
    public static final String TAG_NAME = "tag_name";
    public static final String DESCRIPTION = "description";
    public static final String MILESTONES = "milestones";
    public static final String RELEASED_AT = "released_at";
    public static final String ASSETS = "assets";
    public static final String LINKS = "links";
    public static final String FILEPATH = "filepath";
    public static final String LINK_TYPE = "link_type";
    public static final String RESOURCE_GROUP = "resource_group";
    public static final String RETRY = "retry";
    public static final String MAX = "max";
    public static final String RULES = "rules";
    public static final String IF = "if";
    public static final String EXISTS = "exists";
    public static final String SCRIPT = "script";
    public static final String SECRETS = "secrets";
    public static final String VAULT = "vault";
    public static final String ENGINE = "engine";
    public static final String PATH = "path";
    public static final String FIELD = "field";
    public static final String SERVICES = "services";
    public static final String ALIAS = "alias";
    public static final String COMMAND = "command";
    public static final String STAGE = "stage";
    public static final String TAGS = "tags";
    public static final String TIMEOUT = "timeout";
    public static final String TRIGGER = "trigger";
    public static final String STRATEGY = "strategy";
    public static final String FORWARD = "forward";
    public static final String PIPELINE_VARIABLES = "pipeline_variables";
    public static final String YAML_VARIABLES = "yaml_variables";
    public static final String JUNIT = "junit";
    public static final String NAMESPACE = "namespace";
    public static final String PROVIDER = "PROVIDER";
    public static final String STACK = "STACK";
    public static final String VALUE = "value";

    public static final String API = "api";
    public static final String BRANCHES = "branches";
    public static final String CHAT = "chat";
    public static final String EXTERNAL = "external";
    public static final String EXTERNAL_PULL_REQUESTS = "external_pull_requests";
    public static final String MERGE_REQUESTS = "merge_requests";
    public static final String PIPELINES = "pipelines";
    public static final String PUSHES = "pushes";
    public static final String SCHEDULES = "schedules";
    public static final String TRIGGERS = "triggers";
    public static final String WEB = "web";
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String ON_FAILURE = "on_failure";
    public static final String ON_SUCCESS = "on_success";
    public static final String ALWAYS = "always";
    public static final String MANUAL = "manual";
    public static final String DELAYED = "delayed";
    public static final String NEVER = "never";
    public static final String PULL = "pull";
    public static final String PUSH = "push";
    public static final String PULL_PUSH = "pull-push";
    public static final String START = "start";
    public static final String PREPARE = "prepare";
    public static final String STOP = "stop";
    public static final String VERIFY = "verify";
    public static final String ACCESS = "access";
    public static final String PRODUCTION = "production";
    public static final String STAGING = "staging";
    public static final String TESTING = "testing";
    public static final String DEVELOPMENT = "development";
    public static final String OTHER = "other";


    public static final List<String> specialApiKeywords = List.of(
            API,
            BRANCHES,
            CHAT,
            EXTERNAL,
            EXTERNAL_PULL_REQUESTS,
            MERGE_REQUESTS,
            PIPELINES,
            PUSHES,
            SCHEDULES,
            TAGS,
            TRIGGERS,
            WEB
    );

    public static final List<String> topLevelKeywords = List.of(
            AFTER_SCRIPT,
            BEFORE_SCRIPT,
            CACHE,
            DEFAULT,
            IMAGE,
            INCLUDE,
            PAGES,
            SERVICES,
            STAGES,
            VARIABLES,
            WORKFLOW
    );

    public static final List<String> predefinedStages = List.of(
            ".pre",
            "build",
            "test",
            "deploy",
            ".post"
    );

    public static final Map<String, List<String>> sequencePossibleInputs = Map.ofEntries(
            entry(INCLUDE, List.of(LOCAL, FILE, REMOTE, TEMPLATE, PROJECT, REF)),
            entry(NEEDS, List.of(JOB, ARTIFACTS, PIPELINE, PROJECT, REF, OPTIONAL)),
            entry(MATRIX, List.of(PROVIDER, STACK)),
            entry(RULES, List.of(IF, WHEN, CHANGES, ALLOW_FAILURE, EXISTS, VARIABLES)),
            entry(LINKS, List.of(NAME, URL, FILEPATH, LINK_TYPE)),
            entry(SERVICES, List.of(NAME, ALIAS, ENTRYPOINT, COMMAND)),
            entry(ONLY, specialApiKeywords),
            entry(EXCEPT, specialApiKeywords),
            entry(REFS, specialApiKeywords)
    );
    public static final List<String> booleanInput = List.of(TRUE, FALSE);
    public static final Map<String, List<String>> inlinePossibleInputs = Map.ofEntries(
            entry(ALLOW_FAILURE, booleanInput),
            entry(EXPIRE_IN, List.of(NEVER)),
            entry(PUBLIC, booleanInput),
            entry(UNTRACKED, booleanInput),
            entry(WHEN, List.of(ON_FAILURE, ON_SUCCESS, ALWAYS, MANUAL, DELAYED, NEVER)),
            entry(POLICY, List.of(PULL, PUSH, PULL_PUSH)),
            entry(ACTION, List.of(START, PREPARE, STOP, VERIFY, ACCESS)),
            entry(DEPLOYMENT_TIER, List.of(PRODUCTION, STAGING, TESTING, DEVELOPMENT, OTHER)),
            entry(DEFAULT, booleanInput),
            entry(INTERRUPTIBLE, booleanInput)

    );
    public static final Map<String, String> keywordTypes = Map.<String, String>ofEntries(
            entry(DEFAULT, "global"),
            entry(INCLUDE, "global"),
            entry(LOCAL, "input"),
            entry(FILE, "input"),
            entry(REMOTE, "input"),
            entry(TEMPLATE, "input"),
            entry(PROJECT, "input"),
            entry(REF, "input"),
            entry(STAGES, "global"),
            entry(VARIABLES, "global"),
            entry(WORKFLOW, "global"),
            entry(AFTER_SCRIPT, "job"),
            entry(ALLOW_FAILURE, "job"),
            entry(EXIT_CODES, "input"),
            entry(ARTIFACTS, "job"),
            entry(PATHS, "input"),
            entry(EXCLUDE, "input"),
            entry(EXPIRE_IN, "input"),
            entry(EXPOSE_AS, "input"),
            entry(NAME, "input"),
            entry(PUBLIC, "input"),
            entry(REPORTS, "input"),
            entry(UNTRACKED, "input"),
            entry(WHEN, "job"),
            entry(BEFORE_SCRIPT, "job"),
            entry(CACHE, "job"),
            entry(KEY, "input"),
            entry(FILES, "input"),
            entry(PREFIX, "input"),
            entry(POLICY, "input"),
            entry(COVERAGE, "job"),
            entry(DAST_CONFIGURATION, "job"),
            entry(SITE_PROFILE, "input"),
            entry(SCANNER_PROFILE, "input"),
            entry(DEPENDENCIES, "job"),
            entry(ENVIRONMENT, "job"),
            entry(URL, "input"),
            entry(ON_STOP, "input"),
            entry(ACTION, "input"),
            entry(AUTO_STOP_IN, "input"),
            entry(KUBERNETES, "input"),
            entry(DEPLOYMENT_TIER, "input"),
            entry(EXCEPT, "job"),
            entry(REFS, "input"),
            entry(CHANGES, "input"),
            entry(EXTENDS, "job"),
            entry(IMAGE, "job"),
            entry(ENTRYPOINT, "input"),
            entry(INHERIT, "job"),
            entry(INTERRUPTIBLE, "job"),
            entry(NEEDS, "job"),
            entry(PIPELINE, "input"),
            entry(JOB, "input"),
            entry(OPTIONAL, "input"),
            entry(ONLY, "job"),
            entry(PAGES, "job"),
            entry(PARALLEL, "job"),
            entry(MATRIX, "input"),
            entry(RELEASE, "job"),
            entry(TAG_NAME, "input"),
            entry(DESCRIPTION, "input"),
            entry(MILESTONES, "input"),
            entry(RELEASED_AT, "input"),
            entry(ASSETS, "input"),
            entry(LINKS, "input"),
            entry(FILEPATH, "input"),
            entry(LINK_TYPE, "input"),
            entry(RESOURCE_GROUP, "job"),
            entry(RETRY, "job"),
            entry(MAX, "input"),
            entry(RULES, "job"),
            entry(IF, "input"),
            entry(EXISTS, "input"),
            entry(SCRIPT, "job"),
            entry(SECRETS, "job"),
            entry(VAULT, "input"),
            entry(ENGINE, "input"),
            entry(PATH, "input"),
            entry(FIELD, "input"),
            entry(SERVICES, "job"),
            entry(ALIAS, "input"),
            entry(COMMAND, "input"),
            entry(STAGE, "job"),
            entry(TAGS, "job"),
            entry(TIMEOUT, "job"),
            entry(TRIGGER, "job"),
            entry(STRATEGY, "input"),
            entry(FORWARD, "input"),
            entry(PIPELINE_VARIABLES, "input"),
            entry(YAML_VARIABLES, "input"),
            entry(JUNIT, "input"),
            entry(NAMESPACE, "input"),
            entry(PROVIDER, "input"),
            entry(STACK, "input"),
            entry(VALUE, "input"),
            entry(API, "input"),
            entry(BRANCHES, "input"),
            entry(CHAT, "input"),
            entry(EXTERNAL, "input"),
            entry(EXTERNAL_PULL_REQUESTS, "input"),
            entry(MERGE_REQUESTS, "input"),
            entry(PIPELINES, "input"),
            entry(PUSHES, "input"),
            entry(SCHEDULES, "input"),
            entry(TRIGGERS, "input"),
            entry(WEB, "input"),
            entry(TRUE, "input"),
            entry(FALSE, "input"),
            entry(ON_FAILURE, "input"),
            entry(ON_SUCCESS, "input"),
            entry(ALWAYS, "input"),
            entry(MANUAL, "input"),
            entry(DELAYED, "input"),
            entry(NEVER, "input"),
            entry(PULL, "input"),
            entry(PUSH, "input"),
            entry(PULL_PUSH, "input"),
            entry(START, "input"),
            entry(PREPARE, "input"),
            entry(STOP, "input"),
            entry(VERIFY, "input"),
            entry(ACCESS, "input"),
            entry(PRODUCTION, "input"),
            entry(STAGING, "input"),
            entry(TESTING, "input"),
            entry(DEVELOPMENT, "input"),
            entry(OTHER, "input")
    );
    public static final Map<String, List<String>> blockPossibleInputs = Map.ofEntries(
            entry(DEFAULT, List.of(AFTER_SCRIPT, ARTIFACTS, BEFORE_SCRIPT, CACHE, IMAGE, INTERRUPTIBLE, RETRY, SERVICES, TAGS, TIMEOUT)),
            entry(WORKFLOW, List.of(RULES)),
            entry(ARTIFACTS, List.of(EXCLUDE, EXPIRE_IN, EXPOSE_AS, NAME, PATHS, PUBLIC, REPORTS, UNTRACKED, WHEN)),
            entry(REPORTS, List.of(JUNIT)),
            entry(CACHE, List.of(PATHS, KEY, UNTRACKED, WHEN, POLICY)),
            entry(KEY, List.of(FILES, PREFIX)),
            entry(DAST_CONFIGURATION, List.of(SITE_PROFILE, SCANNER_PROFILE)),
            entry(ENVIRONMENT, List.of(NAME, URL, ON_STOP, ACTION, AUTO_STOP_IN, KUBERNETES, DEPLOYMENT_TIER)),
            entry(KUBERNETES, List.of(NAMESPACE)),
            entry(IMAGE, List.of(NAME, ENTRYPOINT)),
            entry(INHERIT, List.of(DEFAULT, VARIABLES)),
            entry(ONLY, List.of(REFS, VARIABLES, CHANGES, KUBERNETES)),
            entry(EXCEPT, List.of(REFS, VARIABLES, CHANGES, KUBERNETES)),
            entry(PAGES, List.of(STAGE, SCRIPT, ARTIFACTS, RULES)),
            entry(PARALLEL, List.of(MATRIX)),
            entry(RELEASE, List.of(TAG_NAME, NAME, DESCRIPTION, REF, MILESTONES, RELEASED_AT, ASSETS)),
            entry(ASSETS, List.of(LINKS)),
            entry(RETRY, List.of(WHEN)),
            entry(SECRETS, List.of(VAULT, FILE)),
            entry(VAULT, List.of(ENGINE, PATH, FIELD)),
            entry(ENGINE, List.of(NAME, PATH)),
            entry(TRIGGER, List.of(INCLUDE, STRATEGY, FORWARD)),
            entry(FORWARD, List.of(PIPELINE_VARIABLES, YAML_VARIABLES)),
            entry(VARIABLES, List.of(VALUE, DESCRIPTION))
    );

}
