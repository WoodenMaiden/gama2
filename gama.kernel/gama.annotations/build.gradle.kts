/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    `java-library`
    `maven-publish`
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

group = "gama.kernel"
version = "2.0.0-SNAPSHOT"
description = "gama.annotations"
java.sourceCompatibility = JavaVersion.VERSION_17

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

tasks.jar {
    manifest {
        from ("META-INF/MANIFEST.MF")
    }
}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("src"))
        }
        /*resources {
            setSrcDirs(listOf("src"))
        }*/
    }
}

