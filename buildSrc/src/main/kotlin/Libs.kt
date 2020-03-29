object Libs {

   const val kotlinVersion = "1.3.70"
   const val kotestVersion = "4.0.1"
   const val dokkaVersion = "0.10.1"
   const val adarshrTestLoggerVersion = "2.0.0"
   const val gradleVersionsPluginVersion = "0.28.0"

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
      const val Mpp = "io.kotest:kotest-mpp:$kotestVersion"
      const val JunitRunner = "io.kotest:kotest-runner-junit5:$kotestVersion"
      const val Core = "io.kotest:kotest-core:$kotestVersion"
      const val Assertions = "io.kotest:kotest-assertions:$kotestVersion"

   }
}
