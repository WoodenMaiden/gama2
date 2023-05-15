/*
 * This file was generated by the Gradle 'init' task.
 */

rootProject.name = "gama"

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal()
        mavenCentral()
        // Custom maven repository
        maven { url = uri("https://repo.maven.apache.org/maven2/") }
        maven { url = uri("https://download.eclipse.org/releases/2022-12") }
        maven { url = uri("https://buchen.github.io/maven-repo") }
        maven { url = uri("https://maven.jzy3d.org/releases/") }
    }
}

include(
    "gama.kernel:gama.annotations",
    "gama.build:gama.processor"
)