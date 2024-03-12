package com.ryan.customtoast

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ryan.customtoast.ui.theme.CustomToastTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import android.view.LayoutInflater
import android.widget.Toast
import androidx.compose.runtime.Composable
import com.ryan.customtoast.databinding.CustomToastBinding
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment

/**
 * This composable function demonstrates how to display a custom toast message in a Jetpack Compose application.
 * - The `ShowToastDemo` function creates a UI layout with a single button centered on the screen.
 * - When the button is clicked, it shows a custom toast message.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomToastTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowToastDemo()
                }
            }
        }
    }
}

@SuppressLint("SetTextI18n")
@Composable
fun ShowToastDemo() {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            val inflater = LayoutInflater.from(context)
            val binding = CustomToastBinding.inflate(inflater)
            binding.toastText.text = "Hi! You clicked the button."

            // Creating and showing the custom toast message
            with(Toast(context)) {
                duration = Toast.LENGTH_SHORT
                view = binding.root
                show()
            }
        }) {
            Text("Show Custom Toast")
        }
    }
}
