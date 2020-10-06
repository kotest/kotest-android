buildscript {
   repositories {
      mavenCentral()
      mavenLocal()
      google()
   }

   dependencies {
      classpath("com.android.tools.build:gradle:4.1.0-rc03")
      classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Libs.kotlinVersion}")
   }
}

plugins {
   id("maven-publish")
   signing
   id("com.adarshr.test-logger") version Libs.adarshrTestLoggerVersion
   id("org.jetbrains.dokka") version Libs.dokkaVersion

   // To get versions report, execute:
   // Win: .\gradlew.bat dependencyUpdates -Drevision=release
   // Other: gradle dependencyUpdates -Drevision=release
   id("com.github.ben-manes.versions") version Libs.gradleVersionsPluginVersion
}

// Configure existing Dokka task to output HTML to typical Javadoc directory
tasks.dokka {
   outputFormat = "html"
   outputDirectory = "$buildDir/javadoc"
}


allprojects {
   repositories {
      mavenCentral()
      jcenter()
      google()
   }

   group = "io.kotest.android"
   version = Ci.publishVersion.value
}

val publications: PublicationContainer = (extensions.getByName("publishing") as PublishingExtension).publications

signing {
   useGpgCmd()
   if (Ci.isReleaseVersion)
      sign(publications)
}
