plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 25
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
// AndroidX
    implementation(dependencyNotation = "androidx.core:core-ktx:1.7.0")
    implementation(dependencyNotation = "androidx.appcompat:appcompat:1.4.1")
    implementation(dependencyNotation = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    // Navigation
    api(dependencyNotation = "androidx.navigation:navigation-fragment-ktx:2.4.1")

    // Material
    implementation(dependencyNotation = "com.google.android.material:material:1.5.0")

    // Compose
    implementation(dependencyNotation = "androidx.compose.compiler:compiler:1.2.0-alpha04")
    implementation(dependencyNotation = "androidx.compose.runtime:runtime:1.2.0-alpha04")
    implementation(dependencyNotation = "androidx.compose.ui:ui:1.2.0-alpha04")
    implementation(dependencyNotation = "androidx.compose.ui:ui-tooling-preview:1.2.0-alpha04")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation(dependencyNotation = "androidx.compose.foundation:foundation:1.2.0-alpha04")
    // Material Design, Icons
    implementation(dependencyNotation = "androidx.compose.material:material:1.2.0-alpha04")
    implementation(dependencyNotation = "androidx.compose.material:material-icons-core:1.2.0-alpha04")
    implementation(dependencyNotation = "androidx.compose.material:material-icons-extended:1.2.0-alpha04")
    // Integration with activities
    implementation(dependencyNotation = "androidx.activity:activity-compose:1.4.0")
    // Integration with ViewModels
    implementation(dependencyNotation = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")
    // Compose Animations
    implementation(dependencyNotation = "androidx.compose.animation:animation:1.2.0-alpha04")
    // Navigation Hilt
    implementation(dependencyNotation = "androidx.hilt:hilt-navigation-compose:1.0.0")
    // Navigation Compose
    implementation(dependencyNotation = "androidx.navigation:navigation-compose:2.5.0-alpha03")
    // Accompanist Shimmer
    implementation(dependencyNotation = "com.google.accompanist:accompanist-placeholder-material:0.24.1-alpha")
    // Navigation Compose Animations
    implementation(dependencyNotation = "com.google.accompanist:accompanist-navigation-animation:0.24.2-alpha")

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
    testImplementation(dependencyNotation = "org.mockito.kotlin:mockito-kotlin:4.0.0")
    androidTestImplementation(dependencyNotation = "androidx.test.ext:junit:1.1.3")
    androidTestImplementation(dependencyNotation = "androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation(dependencyNotation = "androidx.compose.ui:ui-test-junit4:1.2.0-alpha04")
    debugImplementation(dependencyNotation = "androidx.compose.ui:ui-tooling:1.2.0-alpha04")
}