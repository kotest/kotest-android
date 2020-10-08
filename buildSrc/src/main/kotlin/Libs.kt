object Libs {
   const val kotlinVersion = "1.4.10"
   const val dokkaVersion = "0.10.1"
   const val adarshrTestLoggerVersion = "2.0.0"
   const val gradleVersionsPluginVersion = "0.28.0"
   const val desugarJdk = "com.android.tools:desugar_jdk_libs:1.0.10"

   object AndroidX {
      object Testing {
         private const val version = "1.3.0"

         const val extJUnit = "androidx.test.ext:junit:1.1.2"
         const val runner = "androidx.test:runner:$version"
         const val rules = "androidx.test:rules:$version"
         const val monitor = "androidx.test:monitor:$version"
      }
   }

   object Mocking {
      const val mockk = "io.mockk:mockk:1.9.3"
   }

   object Coroutines {
      private const val version = "1.3.4"
      const val coreCommon = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$version"
      const val jdk8 = "org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$version"
      const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
      const val coreJs = "org.jetbrains.kotlinx:kotlinx-coroutines-core-js:$version"
      const val coreNative = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$version"
   }

   object Kotest {
      private const val version = Ci.releaseVersion
      const val Mpp = "io.kotest:kotest-mpp:$version"
      const val Junit4Runner = "io.kotest:kotest-runner-junit4:$version"
      const val Core = "io.kotest:kotest-core:$version"
      const val Assertions = "io.kotest:kotest-assertions-core:$version"
   }
}
