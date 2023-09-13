package org.example.archunitbug;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition.Configuration.consideringOnlyDependenciesInAnyPackage;
import static com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition.adhereToPlantUmlDiagram;
import static java.util.Objects.requireNonNull;

import java.net.URL;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "org.example", importOptions = { ImportOption.DoNotIncludeTests.class })
public class PlantUmlArchitectureTest {

    private static final URL PLANT_UML_DIAGRAM = PlantUmlArchitectureTest.class.getClassLoader().getResource("invalidDiagram.puml");

    @ArchTest
    public static final ArchRule verifyDependenciesFromPlantUmlDiagram =
            classes()
                    .should(adhereToPlantUmlDiagram(requireNonNull(PLANT_UML_DIAGRAM), consideringOnlyDependenciesInAnyPackage("org.example..")));

}
