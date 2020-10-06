import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
   id("com.android.application")
   kotlin("android")
   kotlin("android.extensions")
   kotlin("kapt")
}

android {
   compileSdkVersion(30)

   defaultConfig{
      multiDexEnabled = true
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

   defaultConfig {
      applicationId = "io.kotlintest.androidtests"
      minSdkVersion(21)
      targetSdkVersion(30)

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
//   implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")

   // Android
   implementation("androidx.core:core-ktx:1.3.2")

   // AndroidTest
   androidTestImplementation(Libs.AndroidX.Testing.runner)
   androidTestImplementation(Libs.AndroidX.Testing.rules)

   androidTestImplementation(Libs.Kotest.Junit4Runner)
   androidTestImplementation(project(":kotest-assertions:kotest-assertions-android"))
   androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
   androidTestImplementation("androidx.test:core-ktx:1.3.0")
}
