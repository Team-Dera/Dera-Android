plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.HILT_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    namespace = ProjectProperties.NAME_SPACE_DI
    compileSdk = ProjectProperties.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectProperties.MIN_SDK

        testInstrumentationRunner = ProjectProperties.TEST_RUNNER
        consumerProguardFiles(ProjectProperties.PROGUARD_RULES)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ProjectProperties.PROGUARD),
                ProjectProperties.PROGUARD_RULES
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = ProjectProperties.JVM_VERSION
    }
    buildFeatures {
        buildConfig = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(Dependency.ANDROIDX.CORE)
    implementation(Dependency.ANDROIDX.APPCOMPAT)
    implementation(Dependency.ANDROIDX.MATERIAL)

    implementation(Dependency.HILT.HILT)
    kapt(Dependency.HILT.HILT_COMPILE)

    implementation(Dependency.OKHTTP.OKHTTP)
    implementation(Dependency.OKHTTP.LOGGING_INTERCEPTOR)

    implementation(Dependency.RETROFIT.RETROFIT_CLIENT)
    implementation(Dependency.RETROFIT.GSON_CONVERT)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
