## Unable to resolve the aar dependencie from mavenLocal() on Gradle 6.0+

Starting from Gradle 6.0+, the `maven-publish` plugin adds the function `Gradle Module Metadata`（[Click me to view the official documentation of Gradle Module Metadata](https://docs.gradle.org/6.0/userguide/publishing_gradle_module_metadata.html )）. This function will add a file with the suffix `.module` to the released package. This file is used to describe the library like Maven's pom file, except that `.module` is dedicated to Gradle.

After actual measurement, when the local maven package contains `.module` file, The jar package can always resolve dependencies, And the aar package cannot resolve dependencies since 6.0, and Gradle does not report an error. Fortunately, the official documentation provides a configuration method to prohibit the generation of `.module` files, as follows：
```groovy
tasks.withType(GenerateModuleMetadata) {
    enabled = false
}
```
If you use [Kotlin DSL](https://github.com/gradle/kotlin-dsl) use:
```kotlin
tasks.withType<GenerateModuleMetadata> {
    enabled = false
}
```

After adding this configuration, you need to delete the existing package in the local `mavenLocal()`, and then repackage it. Because although there is no `.module` file in the new package, the previous `.module` file will not be deleted