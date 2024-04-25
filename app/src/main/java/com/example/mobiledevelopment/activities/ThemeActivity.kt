package com.example.mobiledevelopment.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mobiledevelopment.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class ThemeActivity: AppCompatActivity() {

    val db = Firebase.firestore

    private lateinit var bPurple: Button
    private lateinit var bGreen: Button
    private lateinit var bClose: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)

        bPurple = findViewById(R.id.light_theme_btn)
        bGreen = findViewById(R.id.dark_theme_btn)
        bClose = findViewById(R.id.btn_back)

        bPurple.setOnClickListener {
            setAndReturnAppTheme(1)
        }
        bGreen.setOnClickListener {
            setAndReturnAppTheme(2)
        }
        bClose.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        applySavedTheme()
    }

//
//    override fun onBackPressed() {
//        val i = Intent(this, MainActivity::class.java)
//        startActivity(i)
//        finish()
//        super.onBackPressed()
//    }

    private fun applySavedTheme() {
        db.collection("theme")
            .document("p0dlz6suAzc1ZgwHZQE0")
            .get()
            .addOnSuccessListener { documentSnapshot ->
                val dbThemeId = documentSnapshot
                    .getLong("id")
                    ?.toInt() ?: return@addOnSuccessListener
                changeTheme(dbThemeId)
            }
            .addOnFailureListener {
                Toast.makeText(
                    this@ThemeActivity,
                    "Failed to read theme ID from Firestore!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
    }

    private fun setAndReturnAppTheme(themeId: Int) {
        val themeData = hashMapOf("id" to themeId)

        db.collection("theme")
            .document("p0dlz6suAzc1ZgwHZQE0")
            .set(themeData)
            .addOnSuccessListener {
                Toast.makeText(
                    this@ThemeActivity,
                    "Theme ID successfully written to Firestore!",
                    Toast.LENGTH_SHORT
                ).show()
                changeTheme(themeId)
            }
            .addOnFailureListener {
                Toast.makeText(
                    this@ThemeActivity,
                    "Theme ID NOT successfully written to Firestore!",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun changeTheme(themeId: Int) {
        when (themeId) {
            1 -> {
                //window.statusBarColor = ContextCompat.getColor(this, R.color.base)
                val constraintLayout: RelativeLayout = findViewById(R.id.laymain)
                val gradientDrawable = ContextCompat.getDrawable(this, R.drawable.background)
                constraintLayout.background = gradientDrawable

//                bPurple = findViewById(R.id.light_theme_btn)
//                bPurple.setBackgroundColor(ContextCompat.getColor(this, R.color.soft_purple))
//                bGreen = findViewById(R.id.dark_theme_btn)
//                bGreen.setBackgroundColor(ContextCompat.getColor(this, R.color.soft_purple))

            }

            2 -> {
                //window.statusBarColor = ContextCompat.getColor(this, R.color.green)
                val constraintLayout: RelativeLayout = findViewById(R.id.laymain)
                val gradientDrawable = ContextCompat.getDrawable(this, R.drawable.green_background)
                constraintLayout.background = gradientDrawable

//                bPurple = findViewById(R.id.light_theme_btn)
//                bPurple.setBackgroundColor(ContextCompat.getColor(this, R.color.mint))
//                bGreen = findViewById(R.id.light_theme_btn)
//                bGreen.setBackgroundColor(ContextCompat.getColor(this, R.color.mint))
            }
        }
    }
}