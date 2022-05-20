package com.gitlabci.plugin.language.editor;

import com.gitlabci.plugin.language.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.CustomFoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.SourceTreeToPsiMap;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class GitLabYamlFoldingBuilder extends CustomFoldingBuilder implements DumbAware {

    private static void getRegions(@NotNull PsiElement element, @NotNull List<FoldingDescriptor> descriptors) {
        TextRange elementTextRange = element.getTextRange();

        if (elementTextRange.getLength() < 2) {
            return;
        }

        if (element instanceof GitLabYamlTopLevelMapping) {
            if (PsiTreeUtil.findChildrenOfAnyType(element.getParent(), GitLabYamlTopLevelMapping.class).size() > 1) {
                descriptors.add(new FoldingDescriptor(element, elementTextRange));
            }
        } else if (element instanceof GitLabYamlSequenceItem) {
            PsiElement endOfLine = PsiTreeUtil.findChildrenOfType(element, GitLabYamlEndOfLine.class).stream().reduce((first, second) -> second).orElse(null);
            if (endOfLine != null) {
                elementTextRange = new TextRange(elementTextRange.getStartOffset(), elementTextRange.getEndOffset() - 1);
            }
            descriptors.add(new FoldingDescriptor(element, elementTextRange));

        } else if (element instanceof GitLabYamlPair) {
            PsiElement dedent = PsiTreeUtil.findChildrenOfType(element, GitLabYamlBlockEnd.class).stream().reduce((first, second) -> second).orElse(null);
            if (dedent != null && !(element.getParent().getParent() instanceof GitLabYamlTopLevelMapping)) {
                // exclude dedent + eol elements from pair
                elementTextRange = new TextRange(elementTextRange.getStartOffset(), elementTextRange.getEndOffset() - dedent.getTextLength() - 1);
            } else if (element.getLastChild() instanceof GitLabYamlBlockEnd) {
                elementTextRange = new TextRange(elementTextRange.getStartOffset(), elementTextRange.getEndOffset() - element.getLastChild().getTextLength() - 1);
            }

            descriptors.add(new FoldingDescriptor(element, elementTextRange));

        }

        for (var child : element.getChildren()) {
            getRegions(child, descriptors);
        }

    }

    @Override
    protected void buildLanguageFoldRegions(@NotNull List<FoldingDescriptor> descriptors, @NotNull PsiElement root, @NotNull Document document, boolean quick) {
        getRegions(root, descriptors);
    }

    @Override
    protected String getLanguagePlaceholderText(@NotNull ASTNode node, @NotNull TextRange range) {
        return getPlaceholderText(SourceTreeToPsiMap.treeElementToPsi(node));
    }

    @NotNull
    private static String getPlaceholderText(PsiElement element) {
        if (element == null) {
            return "...";
        }
        if (element instanceof GitLabYamlPair) {
            String pairId = element.getFirstChild().getText();
            PsiElement nestedBlock = getFirstNestedElement(element);
            return pairId + ": " + getPlaceholderText(nestedBlock);
        } else if (element instanceof GitLabYamlMapping) {
            int num = getDirectChildrenNum(element, GitLabYamlPair.class);
            String suffix = (num > 1) ? "s" : "";
            return "<" + num + " key" + suffix + ">";
        } else if (element instanceof GitLabYamlSequence) {
            int num = getDirectChildrenNum(element, GitLabYamlSequenceItem.class);
            String suffix = (num > 1) ? "s" : "";
            return "[" + num + " item" + suffix + "]";
        }
        return "...";
    }

    private static PsiElement getFirstNestedElement(PsiElement element) {
        for (var child : element.getChildren()) {
            if (child instanceof GitLabYamlMapping || child instanceof GitLabYamlSequence) {
                return child;
            }
        }
        return null;
    }
    private static int getDirectChildrenNum(PsiElement element, @NotNull Class<? extends PsiElement> aClass) {
        int counter = 0;
        for (var child : element.getChildren()) {
            if (aClass.isInstance(child)) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    protected boolean isRegionCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
