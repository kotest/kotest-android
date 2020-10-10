import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
   id("com.android.library")
   kotlin("android")
}

repositories {
   mavenCentral()
   google()
   jcenter()
}


android {
   compileSdkVersion(30)
   defaultConfig {
      minSdkVersion(16)
      targetSdkVersion(30)
   }
   buildTypes {
      getByName("release") {
         isMinifyEnabled = false
      }
   }
   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
   }

   kotlinOptions {
      jvmTarget = JavaVersion.VERSION_1_8.toString()
   }
}

dependencies {
   implementation(kotlin("stdlib-jdk8", KotlinCompilerVersion.VERSION))
   implementation(Libs.Kotest.Assertions)
   implementation("androidx.core:core-ktx:1.3.2")
}

apply(from = "../../publish-mpp.gradle.kts")
