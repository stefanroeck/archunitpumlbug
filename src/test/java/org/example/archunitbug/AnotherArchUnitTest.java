package org.example.archunitbug;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "org.example", importOptions = { ImportOption.DoNotIncludeTests.class })
public class AnotherArchUnitTest {

    // Uncomment to verify that JUnit runner/Maven is executing other ArchUnit tests
    //@ArchTest
    public static final ArchRule anotherFailingTest = classes().should().bePrivate();
}
