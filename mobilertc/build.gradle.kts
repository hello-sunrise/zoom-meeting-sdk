plugins {
    id("maven-publish")
}

configurations.maybeCreate("default")
val artifact = artifacts.add("default", file("zoom-mobilertc.aar"))

publishing {
    publications {
        create<MavenPublication>("mobilertc") {
            artifactId = "mobilertc"
            group = "us.zoom.sdk"
            version = "5.16.2"
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
