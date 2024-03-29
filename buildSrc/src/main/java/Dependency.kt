object Dependency {

    object RETROFIT {
        const val RETROFIT_CLIENT = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
        const val GSON_CONVERT = "com.squareup.retrofit2:converter-gson:${Version.RETROFIT}"
    }

    object OKHTTP {
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Version.OKHTTP}"
        const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Version.OKHTTP}"
    }

    object HILT {
        const val HILT = "com.google.dagger:hilt-android:${Version.HILT}"
        const val HILT_COMPILE = "com.google.dagger:hilt-android-compiler:${Version.HILT}"
    }

    object ORBIT {
        const val VIEWMODEL = "org.orbit-mvi:orbit-viewmodel:${Version.ORBIT_MVI}"
        const val COMPOSE = "org.orbit-mvi:orbit-compose:${Version.ORBIT_MVI}"
    }

    object COMPOSE {
        const val ACTIVITY = "androidx.activity:activity-compose:${Version.COMPOSE_ACTIVITY}"
        const val BOM = "androidx.compose:compose-bom:${Version.COMPOSE_BOM}"
        const val NAVIGATION = "androidx.navigation:navigation-compose:${Version.COMPOSE_NAVIGATION}"
        const val NAVIGATION_HILT = "androidx.hilt:hilt-navigation-compose:${Version.COMPOSE_NAVIGATION_HILT}"
    }

    object ANDROIDX {
        const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LIFECYCLE_RUNTIME_KTX}"
        const val CORE = "androidx.core:core-ktx:${Version.CORE_KTX}"
        const val ACTIVITY = "androidx.activity:activity-ktx:${Version.ACTIVITY_KTX}"
        const val FRAGMENT = "androidx.fragment:fragment-ktx:${Version.FRAGMENT_KTX}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Version.APPCOMPAT}"
        const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL}"
    }
}