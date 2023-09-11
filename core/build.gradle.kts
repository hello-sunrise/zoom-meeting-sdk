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
}
