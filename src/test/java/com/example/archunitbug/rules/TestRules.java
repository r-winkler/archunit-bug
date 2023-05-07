package com.example.archunitbug.rules;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.context.annotation.Configuration;

public class TestRules {

    private static final String TEST_CLASS_NAME_ENDING_WITH = "Test";
    private static final String TEST_CLASS_NAME_STARTING_WITH = "Test";

    @ArchTest
    public static final ArchRule haveNamingEndingWithTest =
            ArchRuleDefinition.classes()
                    .that().areNotAnnotatedWith(Configuration.class)
                    .and().resideOutsideOfPackage("..rules..")
                    .should().haveSimpleNameEndingWith(TEST_CLASS_NAME_ENDING_WITH)
                    .orShould().haveSimpleNameStartingWith(TEST_CLASS_NAME_STARTING_WITH);
}
