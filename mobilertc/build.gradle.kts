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
            version = "5.15.12"
            artifact(artifact)
        }
    }
}
