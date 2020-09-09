# Bintray Publish
![Platform][platform_gradle_icon]
![Platform][platform_java_icon]
![Platform][platform_android_icon]
[![License][license_icon]][license_link]

Super easy way to publish your Android and Java artifacts to bintray. 

The source code is from [novoda/bintray-release], and the following improvements have been made:
* Fixed a bug that did not support gradle 6.+
* Replaced the deprecated api in the dependent android gradle plugin

## Adding to project

This library has been published to `jcenter` and private repositories `https://dl.bintray.com/panpf/maven/`, you can freely choose where to download it

Add the following dependencies to your project `build.gradle` file:
```grovvy
buildscript {
    ...
    dependencies {
        classpath 'com.github.panpf.bintraypublish:bintraypublish:$LAST_VERSION'
    }
}
```

Please replace `$LAST_VERSION` with the latest version: [![Download][version_icon]][version_link]

Add the following code to your module `build.gradle` file:

```groovy
// must be applied after your artifact generating plugin (eg. java / com.android.library)
apply plugin: 'com.github.panpf.bintraypublish' 
```

## Simple usage

Use the `publish` closure to set the info of your module `build.gradle` file:

```groovy
publish {
    userOrg = 'panpf'
    groupId = 'com.github.pnaf.bintraypublish'
    artifactId = 'bintraypublish'
    publishVersion = '1.0.0'
    desc = 'Oh hi, this is a nice description for a project, right?'
    website = 'https://github.com/panpf/bintraypublish'
}
```

If you use [Kotlin DSL](https://github.com/gradle/kotlin-dsl) use:

```kotlin
import com.github.panpf.bintray.publish.PublishExtension

configure<PublishExtension> {
  userOrg = "panpf"
  groupId = "com.github.pnaf.bintraypublish"
  artifactId = "bintraypublish"
  publishVersion = "1.0.0"
  desc = "Oh hi, this is a nice description for a project, right?"
  website = "https://github.com/panpf/bintraypublishease"
}
```

Finally, use the task `bintrayUpload` to publish (make sure you build the project first!):

```bash
$ ./gradlew clean build bintrayUpload -PbintrayUser=BINTRAY_USERNAME -PbintrayKey=BINTRAY_KEY -PdryRun=false
```

More info on the available properties and other usages in the [Github Wiki][github_wiki].

## Compatibility

* Gradle: 5.4.1+
* Android gradle plugin: 3.5.0+

## Links

Here are a list of useful links:
* If you have a problem check the [Issues Page][github_issues] first to see if we are working on it
* For further usage or to delve more deeply checkout the [Github Wiki][github_wiki]

## Change Log

Please view the [CHANGELOG.md] file

## License
    Copyright (C) 2020 panpf <panpfpanpf@outlook.com>

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.  


[platform_gradle_icon]: https://img.shields.io/badge/Platform-Gradle-green.svg
[platform_java_icon]: https://img.shields.io/badge/Platform-Java-red.svg
[platform_android_icon]: https://img.shields.io/badge/Platform-Android-green.svg
[license_icon]: https://img.shields.io/badge/License-Apache%202-blue.svg
[license_link]: https://www.apache.org/licenses/LICENSE-2.0
[version_icon]: https://api.bintray.com/packages/panpf/maven/bintraypublish/images/download.svg
[version_link]:https://bintray.com/panpf/maven/bintraypublish/_latestVersion
[github_wiki]: https://github.com/panpf/bintraypublish/wiki
[github_issues]: https://github.com/panpf/bintraypublish/issues
[CHANGELOG.md]: CHANGELOG.md

[novoda/bintray-release]: https://github.com/novoda/bintray-release