package com.jstore.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jstore.android.ui.navigation.JStoreNavigation
import com.jstore.android.ui.theme.JStoreAndroidTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JStoreAndroidTheme {
                JStoreNavigation()
            }
        }
    }
}