package com.gitlabci.plugin.language.documentation;

import com.gitlabci.plugin.language.GitlabYamlBundle;
import com.gitlabci.plugin.language.GitlabYamlKeywords;
import com.intellij.lang.documentation.DocumentationMarkup;
import com.intellij.openapi.util.text.HtmlBuilder;
import com.intellij.openapi.util.text.HtmlChunk;
import org.jetbrains.annotations.NotNull;

public class GitlabYamlDocumentationBuilder {
    public static String buildDoc(String keyword, String possibleInputs) {
        HtmlBuilder docBuilder = new HtmlBuilder();
        String keywordType = GitlabYamlKeywords.keywordTypes.get(keyword);

        docBuilder.append(
                HtmlChunk.styleTag(GitlabYamlDocumentationHTML.style)
        );

        docBuilder.append(wrapDocumentationMarkupElement(DocumentationMarkup.DEFINITION_START));
        docBuilder.append(".gitlab-ci.yml keyword ");
        if (GitlabYamlDocumentationHTML.keywordDefinitions.containsKey(keyword)) {
            docBuilder.append(HtmlChunk.link(GitlabYamlBundle.message("link.gitlab.docs") + keyword, keyword));

        } else {
            docBuilder.append(HtmlChunk.tag("code").addText(keyword));
        }
        docBuilder.append(wrapDocumentationMarkupElement(DocumentationMarkup.SECTIONS_START));
        addKeyValueSection("Keyword type:", HtmlChunk.text(keywordType), docBuilder);
        if (possibleInputs != null) {
            addKeyValueSection("Possible inputs:", HtmlChunk.text(possibleInputs), docBuilder);
        } else {
            HtmlChunk gitlabDocsLink = HtmlChunk.link(GitlabYamlBundle.message("link.gitlab.docs"), "Please check full documentation");
            addKeyValueSection("Possible inputs:", gitlabDocsLink, docBuilder);
        }
        docBuilder.append(wrapDocumentationMarkupElement(DocumentationMarkup.SECTIONS_END));
        docBuilder.append(wrapDocumentationMarkupElement(DocumentationMarkup.DEFINITION_END));

        docBuilder.append(wrapDocumentationMarkupElement(DocumentationMarkup.CONTENT_START));
        if (GitlabYamlDocumentationHTML.keywordDefinitions.containsKey(keyword)) {
            addKeywordDefinitionSection(keyword, docBuilder);
            docBuilder.append(HtmlChunk.br());
            docBuilder.append(HtmlChunk.br());
        }
        if (GitlabYamlDocumentationHTML.examples.containsKey(keyword)) {
            addExamplesSection(keyword, docBuilder);
        }
        docBuilder.append(wrapDocumentationMarkupElement(DocumentationMarkup.CONTENT_END));

        return docBuilder.toString();
    }

    private static void addKeywordDefinitionSection(String keyword, HtmlBuilder docBuilder) {
        docBuilder.append(HtmlChunk.div().addRaw(GitlabYamlDocumentationHTML.keywordDefinitions.get(keyword)));
    }

    private static @NotNull HtmlChunk wrapDocumentationMarkupElement(String element) {
        return HtmlChunk.raw(element);
    }

    private static void addExamplesSection(String keyword, HtmlBuilder docBuilder) {
        docBuilder.append(HtmlChunk.text("Examples:").bold());
        docBuilder.append(HtmlChunk.br());
        docBuilder.append(HtmlChunk.br());
        docBuilder.append(HtmlChunk.div().addRaw(GitlabYamlDocumentationHTML.examples.get(keyword)));
    }

    private static void addKeyValueSection(String key, HtmlChunk value, HtmlBuilder docBuilder) {
        docBuilder.append(wrapDocumentationMarkupElement(DocumentationMarkup.SECTION_HEADER_START));
        docBuilder.append(HtmlChunk.text(key));
        docBuilder.append(wrapDocumentationMarkupElement(DocumentationMarkup.SECTION_SEPARATOR));
        docBuilder.append(wrapDocumentationMarkupElement("<p>"));
        docBuilder.append(value);
        docBuilder.append(wrapDocumentationMarkupElement(DocumentationMarkup.SECTION_END));
    }
}
