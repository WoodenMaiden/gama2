/*******************************************************************************************************
 *
 * build.gradle.kts, in gama.processor, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2023-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

group = "gama.build"
version = "2.0.0-SNAPSHOT"
description = "gama.processor"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

plugins {
    `java-library`
    `maven-publish`
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

dependencies {
    implementation("org.apache.maven.plugins:maven-compiler-plugin:3.11.0")
    implementation("org.eclipse.tycho:tycho-compiler-plugin:3.0.4")
    implementation("org.eclipse.tycho:tycho-maven-plugin:3.0.4")
    implementation("org.eclipse.tycho:target-platform-configuration:3.0.4")
    implementation("org.apache.maven:maven-plugin-api:3.9.1")
    implementation("gama.kernel:gama.annotations:" + project.version)
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

tasks.jar {
    manifest {
        from ("META-INF/MANIFEST.MF")
    }
}
