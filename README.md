## Archunit Bug

#### Reproduce:
1. Run `mvn test`

#### Expected
- The mvn build fails, because the test throws an error during initialization.

#### Actual
- Error is written to log as warning, but build succeeds

```
$ mvn test
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< org.example:archunitbugpuml >---------------------
[INFO] Building archunitbugpuml 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ archunitbugpuml ---
[INFO] skip non existing resourceDirectory C:\Dev\IdeaProjects\archunitbugpuml\src\main\resources
[INFO]
[INFO] --- compiler:3.11.0:compile (default-compile) @ archunitbugpuml ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ archunitbugpuml ---
[INFO] Copying 1 resource from src\test\resources to target\test-classes
[INFO]
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ archunitbugpuml ---
[INFO] Changes detected - recompiling the module! :input tree
[INFO] Compiling 1 source file with javac [debug target 17] to target\test-classes
[INFO] 
[INFO] --- surefire:2.22.2:test (default-test) @ archunitbugpuml ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
Sept. 13, 2023 4:16:37 PM org.junit.platform.launcher.core.DefaultLauncher handleThrowable
WARNUNG: TestEngine with ID 'archunit' failed to discover tests
java.lang.ExceptionInInitializerError
        at java.base/java.lang.Class.forName0(Native Method)
        at java.base/java.lang.Class.forName(Class.java:467)
        at com.tngtech.archunit.base.ClassLoaders.loadClass(ClassLoaders.java:31)
        at com.tngtech.archunit.junit.internal.ElementResolver.classOf(ElementResolver.java:107)
        at com.tngtech.archunit.junit.internal.ElementResolver.resolveClass(ElementResolver.java:56)
        at com.tngtech.archunit.junit.internal.ArchUnitTestDescriptor.resolve(ArchUnitTestDescriptor.java:67)
        at com.tngtech.archunit.junit.internal.ArchUnitTestEngine.lambda$resolveRequestedClasses$3(ArchUnitTestEngine.java:126)
        at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:179)
        at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
        at com.tngtech.archunit.junit.internal.ArchUnitTestEngine.resolveRequestedClasses(ArchUnitTestEngine.java:126)
        at com.tngtech.archunit.junit.internal.ArchUnitTestEngine.discover(ArchUnitTestEngine.java:88)
        at org.junit.platform.launcher.core.DefaultLauncher.discoverEngineRoot(DefaultLauncher.java:168)
        at org.junit.platform.launcher.core.DefaultLauncher.discoverRoot(DefaultLauncher.java:155)
        at org.junit.platform.launcher.core.DefaultLauncher.discover(DefaultLauncher.java:120)
        at org.apache.maven.surefire.junitplatform.TestPlanScannerFilter.accept(TestPlanScannerFilter.java:56)
        at org.apache.maven.surefire.util.DefaultScanResult.applyFilter(DefaultScanResult.java:102)
        at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.scanClasspath(JUnitPlatformProvider.java:143)
        at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.invoke(JUnitPlatformProvider.java:124)
        at org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:384)
        at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:345)
        at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:126)
        at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:418)
Caused by: com.tngtech.archunit.library.plantuml.rules.IllegalDiagramException: There is no Component with name or alias = 'invalid'. Components must be specified separately from dependencies.
        at com.tngtech.archunit.library.plantuml.rules.PlantUmlComponents.findComponentWith(PlantUmlComponents.java:51)
        at com.tngtech.archunit.library.plantuml.rules.PlantUmlParser.findComponentMatching(PlantUmlParser.java:121)
        at com.tngtech.archunit.library.plantuml.rules.PlantUmlParser.parseDependencies(PlantUmlParser.java:82)
        at com.tngtech.archunit.library.plantuml.rules.PlantUmlParser.createDiagram(PlantUmlParser.java:50)
        at com.tngtech.archunit.library.plantuml.rules.PlantUmlParser.parse(PlantUmlParser.java:42)
        at com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition.create(PlantUmlArchCondition.java:242)
        at com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition.adhereToPlantUmlDiagram(PlantUmlArchCondition.java:214)
        at org.example.archunitbug.PlantUmlArchitectureTest.<clinit>(PlantUmlArchitectureTest.java:23)
        ... 30 more

[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 0, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.356 s
[INFO] Finished at: 2023-09-13T16:16:37+02:00
[INFO] ------------------------------------------------------------------------

```