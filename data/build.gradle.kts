plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    compileSdk = 31
    defaultConfig {
        minSdk = 28
        targetSdk = 31
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    // Kotlin Coroutines
    implementation(dependencyNotation = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

    // Hilt
    implementation(dependencyNotation = "com.google.dagger:hilt-android:2.40.5")
    kapt(dependencyNotation = "com.google.dagger:hilt-android-compiler:2.40.5")

    // Ktor
    implementation(dependencyNotation = "io.ktor:ktor-client-android:1.6.7")
    implementation(dependencyNotation = "io.ktor:ktor-client-serialization:1.6.7")
    implementation(dependencyNotation = "io.ktor:ktor-client-logging-jvm:1.6.7")
    implementation(dependencyNotation = "io.ktor:ktor-client-auth:1.6.7")

    // Kotlin Serialization
    implementation(dependencyNotation = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    // Test
    testImplementation(dependencyNotation = "junit:junit:4.13.2")
    testImplementation(dependencyNotation = "org.mockito.kotlin:mockito-kotlin:3.2.0")
    androidTestImplementation(dependencyNotation = "androidx.test.ext:junit:1.1.3")
    androidTestImplementation(dependencyNotation = "androidx.test.espresso:espresso-core:3.4.0")
    testImplementation(dependencyNotation = "com.squareup.okhttp3:mockwebserver:3.12.0")
}