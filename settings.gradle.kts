rootProject.name = "zoom-meeting-sdk"

buildscript {
    repositories {
        gradlePluginPortal()
        google()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.1.1")
        classpath(kotlin("gradle-plugin", "1.9.10"))
    }
}

include(
    ":core",
    ":mobilertc",
    ":android"
)