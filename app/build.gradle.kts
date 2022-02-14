plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.inquisitor.nit"
        minSdk = 28
        targetSdk = 31
        versionCode = 1
        versionName = "1.0.1"
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
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    // AndroidX
    implementation(dependencyNotation = "androidx.core:core-ktx:1.7.0")
    implementation(dependencyNotation = "androidx.appcompat:appcompat:1.4.1")
    implementation(dependencyNotation = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    // Material
    implementation(dependencyNotation = "com.google.android.material:material:1.5.0")

    // Compose
    implementation(dependencyNotation = "androidx.compose.compiler:compiler:1.2.0-alpha02")
    implementation(dependencyNotation = "androidx.compose.runtime:runtime:1.2.0-alpha02")
    implementation(dependencyNotation = "androidx.compose.ui:ui:1.2.0-alpha02")
    implementation(dependencyNotation = "androidx.compose.ui:ui-tooling-preview:1.2.0-alpha02")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation(dependencyNotation = "androidx.compose.foundation:foundation:1.2.0-alpha02")
    // Material Design, Icons
    implementation(dependencyNotation = "androidx.compose.material:material:1.2.0-alpha02")
    implementation(dependencyNotation = "androidx.compose.material:material-icons-core:1.2.0-alpha02")
    implementation(dependencyNotation = "androidx.compose.material:material-icons-extended:1.2.0-alpha02")
    // Integration with activities
    implementation(dependencyNotation = "androidx.activity:activity-compose:1.4.0")
    // Integration with ViewModels
    implementation(dependencyNotation = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")
    // Compose Animations
    implementation(dependencyNotation = "androidx.compose.animation:animation:1.2.0-alpha03")
    // Navigation Hilt
    implementation(dependencyNotation = "androidx.hilt:hilt-navigation-compose:1.0.0")
    // Navigation Compose
    implementation(dependencyNotation = "androidx.navigation:navigation-compose:2.5.0-alpha02")
    // Accompanist Shimmer
    implementation(dependencyNotation = "com.google.accompanist:accompanist-placeholder-material:0.24.1-alpha")

    // Coil
    implementation(dependencyNotation = "io.coil-kt:coil-compose:1.4.0")

    // Dagger
    implementation(dependencyNotation = "com.google.dagger:dagger:2.40.5")
    kapt(dependencyNotation = "com.google.dagger:dagger-compiler:2.40.5")

    // Hilt
    implementation(dependencyNotation = "com.google.dagger:hilt-android:2.40.5")
    kapt(dependencyNotation = "com.google.dagger:hilt-android-compiler:2.40.5")

    // Test
    testImplementation(dependencyNotation = "junit:junit:4.13.2")
    testImplementation(dependencyNotation = "org.mockito.kotlin:mockito-kotlin:3.2.0")
    androidTestImplementation(dependencyNotation = "androidx.test.ext:junit:1.1.3")
    androidTestImplementation(dependencyNotation = "androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation(dependencyNotation = "androidx.compose.ui:ui-test-junit4:1.2.0-alpha02")
    debugImplementation(dependencyNotation = "androidx.compose.ui:ui-tooling:1.2.0-alpha02")
}