package com.gitlabci.plugin.language.completion;

import com.gitlabci.plugin.language.psi.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;


public class GitlabYamlPatterns {
    static class TopLevelKeywordsPatterns extends PlatformPatterns {
        public static PsiElementPattern.Capture<PsiElement> topLevelKeywordsPattern() {
            return psiElement().withParent(GitlabYamlFile.class).andNot(
                    psiElement().andOr(
                            psiElement()
                                    .afterLeaf(psiElement(GitlabYamlTokenTypes.INDENT)
                                            .withParent(psiElement(GitlabYamlPair.class)
                                            .withChild(psiElement(GitlabYamlIdentifier.class)))),
                            psiElement()
                                    .afterLeaf(psiElement(GitlabYamlTokenTypes.DEDENT)
                                    .withSuperParent(4, psiElement(GitlabYamlPair.class)
                                            .withChild(psiElement(GitlabYamlIdentifier.class)))),
                            psiElement()
                                    .afterLeaf(psiElement(GitlabYamlTokenTypes.DASH)
                                    .withSuperParent(2, psiElement(GitlabYamlSequence.class)
                                            .withParent(psiElement(GitlabYamlPair.class)
                                                    .withChild(psiElement(GitlabYamlIdentifier.class))))),
                            psiElement()
                                    .afterLeaf(psiElement(GitlabYamlTokenTypes.EOL)
                                    .withSuperParent(3, psiElement(GitlabYamlPair.class)
                                            .withChild(psiElement(GitlabYamlIdentifier.class)))),
                            psiElement()
                                    .afterLeaf(psiElement(GitlabYamlTokenTypes.COLON)
                                    .withParent(psiElement(GitlabYamlPair.class)
                                            .withChild(psiElement(GitlabYamlIdentifier.class)))),
                            psiElement()
                                    .afterLeaf(psiElement(GitlabYamlTokenTypes.EOL)
                                    .withSuperParent(4, psiElement(GitlabYamlSequence.class)
                                            .withParent(psiElement(GitlabYamlPair.class)
                                                    .withChild(psiElement(GitlabYamlIdentifier.class)))))

                    )
            );
        }
    }

    interface PossibleInputsPattern {
        PsiElementPattern.Capture<PsiElement> matchPattern(String keyword);
    }

    static class PossibleInputsPatterns extends PlatformPatterns {

        public static PossibleInputsPattern afterIndentPossibleInputsPattern = (keyword) ->
                psiElement().afterLeaf(psiElement(GitlabYamlTokenTypes.INDENT)
                        .withParent(psiElement(GitlabYamlPair.class)
                                .withChild(psiElement(GitlabYamlIdentifier.class)
                                        .withText(keyword)
                                )
                        )
                );

        public static PossibleInputsPattern afterDedentPossibleInputsPattern = (keyword) ->
                psiElement().afterLeaf(psiElement(GitlabYamlTokenTypes.DEDENT)
                        .withSuperParent(4, psiElement(GitlabYamlPair.class)
                                .withChild(psiElement(GitlabYamlIdentifier.class)
                                        .withText(keyword)
                                )
                        )
                );


        public static PossibleInputsPattern afterPairPossibleInputsPattern = (keyword) ->
                psiElement()
                        .afterLeaf(psiElement(GitlabYamlTokenTypes.EOL)
                                .withSuperParent(3, psiElement(GitlabYamlPair.class)
                                        .withChild(psiElement(GitlabYamlIdentifier.class)
                                                .withText(keyword)
                                        )
                                )
                        );

        public static PossibleInputsPattern startMultiplePossibleInputsPattern = (keyword) ->
                psiElement().afterLeaf(psiElement(GitlabYamlTokenTypes.DASH)
                        .withSuperParent(2, psiElement(GitlabYamlSequence.class)
                                .withParent(psiElement(GitlabYamlPair.class)
                                        .withChild(psiElement(GitlabYamlIdentifier.class)
                                                .withText(keyword)
                                        )
                                )
                        )
                );
        public static PossibleInputsPattern continueMultiplePossibleInputsPattern = (keyword) ->
                psiElement().afterLeaf(psiElement(GitlabYamlTokenTypes.EOL)
                        .withSuperParent(4, psiElement(GitlabYamlSequence.class)
                                .withParent(psiElement(GitlabYamlPair.class)
                                        .withChild(psiElement(GitlabYamlIdentifier.class)
                                                .withText(keyword)
                                        )
                                )
                        )
                );
        public static PossibleInputsPattern inlineExprPossibleInputsPattern = (keyword) ->
                psiElement().afterLeaf(psiElement(GitlabYamlTokenTypes.COLON)
                        .withParent(psiElement(GitlabYamlPair.class)
                                        .withChild(psiElement(GitlabYamlIdentifier.class)
                                                .withText(keyword)
                                        )
                        )
                );

    }
}
