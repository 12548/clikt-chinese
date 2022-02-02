buildscript {
    repositories {
        maven("https://maven.aliyun.com/repository/public/")
        maven("https://maven.aliyun.com/repository/gradle-plugin/")
        mavenCentral()
    }
    dependencies {
    }
}

plugins {
    kotlin("multiplatform") version "1.6.10"
    id("maven-publish")
    id("signing")
}

group = "cn.bugsnet.clikt"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://maven.aliyun.com/repository/public/")
    mavenCentral()
}

dependencies {
    commonMainImplementation("com.github.ajalt.clikt:clikt:3.4.0")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
    }
    js(BOTH) {
        browser {

        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting
        val jvmMain by getting {
            dependsOn(commonMain)
        }
        val jvmTest by getting
        val jsMain by getting {
            dependsOn(commonMain)
        }
        val jsTest by getting
        val nativeMain by getting {
            dependsOn(commonMain)
        }
        val nativeTest by getting
    }
}
