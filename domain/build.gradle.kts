plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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
    implementation(project(":data"))

    // Kotlin Coroutines
    implementation(dependencyNotation = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

    // Hilt
    implementation(dependencyNotation = "com.google.dagger:hilt-android:2.40.5")
    kapt(dependencyNotation = "com.google.dagger:hilt-android-compiler:2.40.5")

    // Test
    testImplementation(dependencyNotation = "junit:junit:4.13.2")
    testImplementation(dependencyNotation = "org.mockito.kotlin:mockito-kotlin:4.0.0")
    androidTestImplementation(dependencyNotation = "androidx.test.ext:junit:1.1.3")
}