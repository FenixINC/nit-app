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
//        useIR = true
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-rc01"
        kotlinCompilerVersion = "1.6.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":di"))
    implementation(project(":navigation"))
    implementation(project(":feature-splash"))
    implementation(project(":feature-login"))

    // AndroidX
    implementation(dependencyNotation = "androidx.core:core-ktx:1.7.0")
    implementation(dependencyNotation = "androidx.appcompat:appcompat:1.4.1")

    // Material
    implementation(dependencyNotation = "com.google.android.material:material:1.5.0")

    // Hilt
    implementation(dependencyNotation = "com.google.dagger:hilt-android:2.40.5")
    kapt(dependencyNotation = "com.google.dagger:hilt-android-compiler:2.40.5")

    // Dagger
    implementation(dependencyNotation = "com.google.dagger:dagger:2.40.5")
    kapt(dependencyNotation = "com.google.dagger:dagger-compiler:2.40.5")

    // Compose
    implementation(dependencyNotation = "androidx.compose.ui:ui:1.1.0-rc01")
    implementation(dependencyNotation = "androidx.compose.material:material:1.1.0-rc01")
    implementation(dependencyNotation = "androidx.compose.ui:ui-tooling-preview:1.1.0-rc01")
    implementation(dependencyNotation = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation(dependencyNotation = "androidx.activity:activity-compose:1.4.0")

    // Navigation Compose
    implementation(dependencyNotation = "androidx.navigation:navigation-compose:2.4.0-rc01")

    // Test
    testImplementation(dependencyNotation = "junit:junit:4.13.2")
    testImplementation(dependencyNotation = "org.mockito.kotlin:mockito-kotlin:3.2.0")
    androidTestImplementation(dependencyNotation = "androidx.test.ext:junit:1.1.3")
    androidTestImplementation(dependencyNotation = "androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation(dependencyNotation = "androidx.compose.ui:ui-test-junit4:1.1.0-rc01")
    debugImplementation(dependencyNotation = "androidx.compose.ui:ui-tooling:1.1.0-rc01")
}