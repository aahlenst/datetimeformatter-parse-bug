Reproducer for Parsing Bug in DateTimeFormatter
===============================================

Original report: https://github.com/AdoptOpenJDK/openjdk-support/issues/109

Expected output with OpenJDK 11.0.7+10 on Linux:
```
./gradlew --console=plain --no-daemon clean test
To honour the JVM settings for this build a new JVM will be forked. Please consider using the daemon: https://docs.gradle.org/6.4.1/userguide/gradle_daemon.html.
Daemon will be stopped at the end of the build stopping after processing
> Task :clean
> Task :compileJava NO-SOURCE
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE
> Task :compileTestJava
> Task :processTestResources NO-SOURCE
> Task :testClasses
> Task :test

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.4.1/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 4s
3 actionable tasks: 3 executed
```

Actual output on OpenJDK 11.0.7 with macOS 10.15.4:

```
./gradlew --console=plain --no-daemon clean test
To honour the JVM settings for this build a new JVM will be forked. Please consider using the daemon: https://docs.gradle.org/6.4.1/userguide/gradle_daemon.html.
Daemon will be stopped at the end of the build stopping after processing
> Task :clean
> Task :compileJava NO-SOURCE
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE
> Task :compileTestJava
> Task :processTestResources NO-SOURCE
> Task :testClasses

> Task :test FAILED

net.adoptopenjdk.DateFormatterTest > parsePattern FAILED
    java.time.format.DateTimeParseException at DateFormatterTest.java:15

1 test completed, 1 failed

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':test'.
> There were failing tests. See the report at: file:///Users/andreas/Documents/AdoptOpenJDK/reproducer-109/build/reports/tests/test/index.html

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.

* Get more help at https://help.gradle.org

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.4.1/userguide/command_line_interface.html#sec:command_line_warnings

BUILD FAILED in 3s
3 actionable tasks: 3 executed
```
