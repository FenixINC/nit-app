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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-rc01"
        kotlinCompilerVersion = "1.6.0"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":navigation"))

    // Hilt
    implementation(dependencyNotation = "com.google.dagger:hilt-android:2.40.5")
    kapt(dependencyNotation = "com.google.dagger:hilt-android-compiler:2.40.5")

    // Compose
    implementation(dependencyNotation = "androidx.compose.compiler:compiler:1.1.0-rc01")
    implementation(dependencyNotation = "androidx.compose.runtime:runtime:1.1.0-rc01")
    implementation(dependencyNotation = "androidx.compose.ui:ui: 1.1.0-rc01")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation(dependencyNotation = "androidx.compose.foundation:foundation: 1.1.0-rc01")
    // Material Design, Icons
    implementation(dependencyNotation = "androidx.compose.material:material:1.2.0-alpha01")
//    implementation("androidx.compose.material:material-icons-core: 1.1.0-rc01")
//    implementation("androidx.compose.material:material-icons-extended: 1.1.0-rc01")
    // Integration with activities
    implementation(dependencyNotation = "androidx.activity:activity-compose:1.4.0")
    // Integration with ViewModels
    implementation(dependencyNotation = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")
    // Integration with observables
//    implementation("androidx.compose.runtime:runtime-livedata: 1.1.0-rc01")
    // Compose Animations
//    implementation("androidx.compose.animation:animation: 1.1.0-rc01")
    // Compose Constraint
    implementation(dependencyNotation = "androidx.constraintlayout:constraintlayout-compose:1.0.0")
    // Navigation Hilt
    implementation(dependencyNotation = "androidx.hilt:hilt-navigation-compose:1.0.0-rc01")

    // Coil
    implementation(dependencyNotation = "io.coil-kt:coil-compose:1.4.0")

    // Test
    testImplementation(dependencyNotation = "junit:junit:4.13.2")
    testImplementation(dependencyNotation = "org.mockito.kotlin:mockito-kotlin:3.2.0")
    androidTestImplementation(dependencyNotation = "androidx.test.ext:junit:1.1.3")
    androidTestImplementation(dependencyNotation = "androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation(dependencyNotation = "androidx.compose.ui:ui-test-junit4:1.1.0-rc01")
    debugImplementation(dependencyNotation = "androidx.compose.ui:ui-tooling:1.1.0-rc01")
}