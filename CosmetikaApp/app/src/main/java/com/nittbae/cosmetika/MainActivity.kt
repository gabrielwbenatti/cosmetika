package com.nittbae.cosmetika

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nittbae.cosmetika.ui.common.HomeEntry

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            window.addFlags(FLAG_LAYOUT_IN_SCREEN or FLAG_LAYOUT_NO_LIMITS)
//        }
        enableEdgeToEdge()

        setContent {
            HomeEntry()
        }
    }
}