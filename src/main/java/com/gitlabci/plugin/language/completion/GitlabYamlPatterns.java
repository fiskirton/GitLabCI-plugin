package com.gitlabci.plugin.language.completion;

import com.gitlabci.plugin.language.psi.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;


public class GitLabYamlPatterns {
    static class TopLevelKeywordsPatterns extends PlatformPatterns {
        public static PsiElementPattern.Capture<PsiElement> topLevelKeywordsPattern() {
            return psiElement().withParent(GitLabYamlFile.class).andNot(
                    psiElement().andOr(
                            psiElement()
                                    .afterLeaf(psiElement(GitLabYamlTokenTypes.INDENT)
                                            .withParent(psiElement(GitLabYamlPair.class)
                                            .withChild(psiElement(GitLabYamlIdentifier.class)))),
                            psiElement()
                                    .afterLeaf(psiElement(GitLabYamlTokenTypes.DEDENT)
                                    .withSuperParent(4, psiElement(GitLabYamlPair.class)
                                            .withChild(psiElement(GitLabYamlIdentifier.class)))),
                            psiElement()
                                    .afterLeaf(psiElement(GitLabYamlTokenTypes.DASH)
                                    .withSuperParent(2, psiElement(GitLabYamlSequence.class)
                                            .withParent(psiElement(GitLabYamlPair.class)
                                                    .withChild(psiElement(GitLabYamlIdentifier.class))))),
                            psiElement()
                                    .afterLeaf(psiElement(GitLabYamlTokenTypes.EOL)
                                    .withSuperParent(3, psiElement(GitLabYamlPair.class)
                                            .withChild(psiElement(GitLabYamlIdentifier.class)))),
                            psiElement()
                                    .afterLeaf(psiElement(GitLabYamlTokenTypes.COLON)
                                    .withParent(psiElement(GitLabYamlPair.class)
                                            .withChild(psiElement(GitLabYamlIdentifier.class)))),
                            psiElement()
                                    .afterLeaf(psiElement(GitLabYamlTokenTypes.EOL)
                                    .withSuperParent(4, psiElement(GitLabYamlSequence.class)
                                            .withParent(psiElement(GitLabYamlPair.class)
                                                    .withChild(psiElement(GitLabYamlIdentifier.class)))))

                    )
            );
        }
    }

    interface PossibleInputsPattern {
        PsiElementPattern.Capture<PsiElement> matchPattern(String keyword);
    }

    static class PossibleInputsPatterns extends PlatformPatterns {

        public static PossibleInputsPattern afterIndentPossibleInputsPattern = (keyword) ->
                psiElement().afterLeaf(psiElement(GitLabYamlTokenTypes.INDENT)
                        .withParent(psiElement(GitLabYamlPair.class)
                                .withChild(psiElement(GitLabYamlIdentifier.class)
                                        .withText(keyword)
                                )
                        )
                );

        public static PossibleInputsPattern afterDedentPossibleInputsPattern = (keyword) ->
                psiElement().afterLeaf(psiElement(GitLabYamlTokenTypes.DEDENT)
                        .withSuperParent(4, psiElement(GitLabYamlPair.class)
                                .withChild(psiElement(GitLabYamlIdentifier.class)
                                        .withText(keyword)
                                )
                        )
                );


        public static PossibleInputsPattern afterPairPossibleInputsPattern = (keyword) ->
                psiElement()
                        .afterLeaf(psiElement(GitLabYamlTokenTypes.EOL)
                                .withSuperParent(3, psiElement(GitLabYamlPair.class)
                                        .withChild(psiElement(GitLabYamlIdentifier.class)
                                                .withText(keyword)
                                        )
                                )
                        );

        public static PossibleInputsPattern startMultiplePossibleInputsPattern = (keyword) ->
                psiElement().afterLeaf(psiElement(GitLabYamlTokenTypes.DASH)
                        .withSuperParent(2, psiElement(GitLabYamlSequence.class)
                                .withParent(psiElement(GitLabYamlPair.class)
                                        .withChild(psiElement(GitLabYamlIdentifier.class)
                                                .withText(keyword)
                                        )
                                )
                        )
                );
        public static PossibleInputsPattern continueMultiplePossibleInputsPattern = (keyword) ->
                psiElement().afterLeaf(psiElement(GitLabYamlTokenTypes.EOL)
                        .withSuperParent(4, psiElement(GitLabYamlSequence.class)
                                .withParent(psiElement(GitLabYamlPair.class)
                                        .withChild(psiElement(GitLabYamlIdentifier.class)
                                                .withText(keyword)
                                        )
                                )
                        )
                );
        public static PossibleInputsPattern inlineExprPossibleInputsPattern = (keyword) ->
                psiElement().afterLeaf(psiElement(GitLabYamlTokenTypes.COLON)
                        .withParent(psiElement(GitLabYamlPair.class)
                                        .withChild(psiElement(GitLabYamlIdentifier.class)
                                                .withText(keyword)
                                        )
                        )
                );

    }
}
