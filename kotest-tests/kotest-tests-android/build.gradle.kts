import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
   id("com.android.application")
   kotlin("android")
   kotlin("android.extensions")
   kotlin("kapt")
}

android {
   compileSdkVersion(30)

   defaultConfig {
      applicationId = "io.kotlintest.androidtests"
      multiDexEnabled = true
      minSdkVersion(26) // TODO: bring this down to 21 when solving bug io.github.classgraph min API 26
      targetSdkVersion(30)

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
   }

   compileOptions {
      isCoreLibraryDesugaringEnabled = true
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
   }

   kotlinOptions {
      jvmTarget = JavaVersion.VERSION_1_8.toString()
   }

   lintOptions {
      tasks.lint.get().enabled = false
   }

   testOptions {
      unitTests.isIncludeAndroidResources = true
   }

   packagingOptions {
      exclude("META-INF/LICENSE.md")
      exclude("META-INF/LICENSE-notice.md")
   }
}

dependencies {
   coreLibraryDesugaring(Libs.desugarJdk)

   // Kotlin
   implementation(kotlin("stdlib-jdk8", KotlinCompilerVersion.VERSION))
   implementation(kotlin("reflect", KotlinCompilerVersion.VERSION))

   // Android
   implementation("androidx.core:core-ktx:1.7.0")

   // AndroidTest
   androidTestImplementation(Libs.AndroidX.Testing.runner)
   androidTestImplementation(Libs.AndroidX.Testing.rules)

   androidTestImplementation(Libs.Kotest.Junit4Runner)
   androidTestImplementation(project(":kotest-assertions:kotest-assertions-android"))
   androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
   androidTestImplementation("androidx.test:core-ktx:1.3.0")
}

allprojects {
   configurations.all {
      resolutionStrategy.force("org.objenesis:objenesis:2.6")
   }
}
