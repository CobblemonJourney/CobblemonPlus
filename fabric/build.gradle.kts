plugins {
    id("pokemoncobbled.platform-conventions")
}

architectury {
    platformSetupLoomIde()
    fabric()
}

val generatedResources = file("src/generated/resources")
val accessWidenerFile = project(":common").file("src/main/resources/pokemoncobbled-common.accesswidener")

loom {
    accessWidenerPath.set(accessWidenerFile)
}

sourceSets {
    main {
        resources {
            srcDir(generatedResources)
        }
    }
}

val kotlin_version: String by project
val annotations_version: String by project
val coroutines_version: String by project
val serialization_version: String by project

repositories {
    maven(url = "https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
}

dependencies {
    implementation(project(":common", configuration = "namedElements")) {
        isTransitive = false
    }
    "developmentFabric"(project(":common", configuration = "namedElements")) {
        isTransitive = false
    }
    bundle(project(path = ":common", configuration = "transformProductionFabric")) {
        isTransitive = false
    }

    modImplementation("net.fabricmc:fabric-loader:${rootProject.property("fabric_loader_version")}")
    modApi("net.fabricmc.fabric-api:fabric-api:${rootProject.property("fabric_api_version")}")
    modApi("dev.architectury:architectury-fabric:${rootProject.property("architectury_version")}")
    modApi("net.fabricmc:fabric-language-kotlin:${rootProject.property("fabric_kotlin")}")

    // For Kotlin
    bundle(libs.stdlib)
    bundle(libs.reflect)
    bundle(libs.jetbrainsAnnotations)
    bundle(libs.serializationCore)
    bundle(libs.serializationJson)

    // For Showdown
    bundle("com.caoccao.javet:javet:1.1.3") // Linux or Windows
    bundle("com.caoccao.javet:javet-macos:1.1.0") // Mac OS
    bundle("com.eliotlash.molang:molang:18")
    bundle("com.eliotlash.mclib:mclib:18")
    runtimeOnly("com.caoccao.javet:javet:1.1.3") // Linux or Windows
    runtimeOnly("com.caoccao.javet:javet-macos:1.1.0") // Mac OS (x86_64 Only)
    runtimeOnly("com.eliotlash.molang:molang:18")
    runtimeOnly("com.eliotlash.mclib:mclib:18")
//    common group: 'commons-io', name: 'commons-io', version: '2.6'
}

tasks {
    // The AW file is needed in :fabric project resources when the game is run.
    val copyAccessWidener by registering(Copy::class) {
        from(accessWidenerFile)
        into(generatedResources)
    }

    shadowJar {}

    processResources {
        dependsOn(copyAccessWidener)
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }
}