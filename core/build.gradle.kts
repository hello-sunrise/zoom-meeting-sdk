plugins {
    id("maven-publish")
}

configurations.maybeCreate("default")
val artifact = artifacts.add("default", file("zoom-core.aar"))

publishing {
    publications {
        create<MavenPublication>("core") {
            artifactId = "core"
            group = "us.zoom.sdk"
            version = "5.15.12"
            artifact(artifact)
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
