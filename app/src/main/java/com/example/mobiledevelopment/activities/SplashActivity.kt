package com.example.mobiledevelopment.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mobiledevelopment.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, PasswordActivity/*MainActivity*/::class.java))
            finish()
        }, 2000)

        applySavedTheme()
    }

    private fun applyTheme(themeId: Int) {
        when (themeId) {
            1 -> {

                val constraintLayout: RelativeLayout = findViewById(R.id.splash_layout)
                val gradientDrawable = ContextCompat.getDrawable(this, R.drawable.background)
                constraintLayout.background = gradientDrawable

            }
            2 -> {

                val constraintLayout: RelativeLayout = findViewById(R.id.splash_layout)
                val gradientDrawable = ContextCompat.getDrawable(this, R.drawable.green_background)
                constraintLayout.background = gradientDrawable
            }
        }
    }

    private fun applySavedTheme() {
        db.collection("theme")
            .document("p0dlz6suAzc1ZgwHZQE0")
            .get()
            .addOnSuccessListener { documentSnapshot ->
                val dbThemeId = documentSnapshot
                    .getLong("id")
                    ?.toInt() ?: return@addOnSuccessListener
                //setAppTheme(dbThemeId)
                applyTheme(dbThemeId)
            }
            .addOnFailureListener { e ->
                Toast.makeText(
                    this@SplashActivity,
                    "Failed to read theme ID from Firestore!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
    }
}
