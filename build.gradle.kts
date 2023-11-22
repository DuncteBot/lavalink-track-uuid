plugins {
    java
    `maven-publish`
    alias(libs.plugins.lavalink)
}

group = "com.dunctebot"
version = "0.1.0"

lavalinkPlugin {
    name = "track-uuid"
    path = "$group.track-uuid"
    apiVersion = libs.versions.lavalink.api
    serverVersion = libs.versions.lavalink.server
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
}

dependencies {
    // add your dependencies here
}

publishing {
    repositories {
        maven {
            name = "lavalink"
            url = uri("https://maven.lavalink.dev/releases")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("PASSWORD")
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
}
