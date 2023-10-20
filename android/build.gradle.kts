plugins {
    id("com.android.library")
    kotlin("android")
    id("maven-publish")
}

android {
    namespace = "us.zoom.sdk"
    compileSdk = 34
    buildToolsVersion = "33.0.1"

    defaultConfig {
        minSdk = 23
        @Suppress("DEPRECATION")
        targetSdk = 33
    }

    kotlin.jvmToolchain(17)
}

repositories {
    mavenCentral()
    google()
    @Suppress("DEPRECATION")
    jcenter()
}

dependencies {
    api(project(":core"))
    api(project(":mobilertc"))
    implementation("com.google.android.exoplayer:exoplayer-core:2.19.1")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.19.1")
    implementation("com.google.android:flexbox:2.0.1")
    implementation("com.google.code.gson:gson:2.10")
    implementation("com.github.bumptech.glide:annotations:4.13.0")
    implementation("com.github.bumptech.glide:glide:4.13.0")
    implementation("com.airbnb.android:lottie:6.1.0")
    implementation("androidx.window:window-java:1.1.0")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("meeting") {
                artifactId = "meeting"
                group = "us.zoom.sdk"
                version = "5.16.2"
                from(components["release"])
            }
        }
        repositories {
            maven("https://maven.pkg.github.com/hello-sunrise/zoom-meeting-sdk") {
                credentials {
                    username = requireNotNull(extra["sunrise.maven.username"] as? String) {
                        "Missing \"sunrise.maven.username\" in gradle.properties"
                    }
                    password = requireNotNull(extra["sunrise.maven.password"] as? String) {
                        "Missing \"sunrise.maven.password\" in gradle.properties"
                    }
                }
            }
        }
    }
}
