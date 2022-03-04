plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 16
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles("consumer-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.2.0-alpha04"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // AndroidX
    implementation(dependencyNotation = "androidx.core:core-ktx:1.7.0")
    implementation(dependencyNotation = "androidx.appcompat:appcompat:1.4.1")
    implementation(dependencyNotation = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation(dependencyNotation = "androidx.fragment:fragment-ktx:1.4.1")

    // Material
    implementation(dependencyNotation = "com.google.android.material:material:1.5.0")

    // Compose
    implementation(dependencyNotation = "androidx.compose.compiler:compiler:1.2.0-alpha04")
    implementation(dependencyNotation = "androidx.compose.runtime:runtime:1.2.0-alpha04")
    implementation(dependencyNotation = "androidx.compose.ui:ui:1.2.0-alpha04")
    implementation(dependencyNotation = "androidx.compose.ui:ui-tooling-preview:1.2.0-alpha04")

    // Test
    testImplementation(dependencyNotation = "junit:junit:4.13.2")
    testImplementation(dependencyNotation = "org.mockito.kotlin:mockito-kotlin:4.0.0")
    androidTestImplementation(dependencyNotation = "androidx.test.ext:junit:1.1.3")
    androidTestImplementation(dependencyNotation = "androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation(dependencyNotation = "androidx.compose.ui:ui-test-junit4:1.2.0-alpha04")
    debugImplementation(dependencyNotation = "androidx.compose.ui:ui-tooling:1.2.0-alpha04")
}