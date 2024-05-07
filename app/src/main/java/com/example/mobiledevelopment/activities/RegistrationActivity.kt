package com.example.mobiledevelopment.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mobiledevelopment.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class RegistrationActivity : AppCompatActivity() {
    private val db = Firebase.firestore

    private lateinit var passwordET: EditText
    private lateinit var emailTV: EditText

    private lateinit var bOne: Button
    private lateinit var bTwo: Button
    private lateinit var bThree: Button
    private lateinit var bFour: Button
    private lateinit var bFive: Button
    private lateinit var bSix: Button
    private lateinit var bSeven: Button
    private lateinit var bEight: Button
    private lateinit var bNine: Button
    private lateinit var bZero: Button
    private lateinit var bClear: Button
    private lateinit var bOK: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        passwordET = findViewById(R.id.password_ed)
        emailTV = findViewById(R.id.email)

        bOne = findViewById(R.id.b_one)
        bTwo = findViewById(R.id.b_two)
        bThree = findViewById(R.id.b_three)
        bFour = findViewById(R.id.b_four)
        bFive = findViewById(R.id.b_five)
        bSix = findViewById(R.id.b_six)
        bSeven = findViewById(R.id.b_seven)
        bEight = findViewById(R.id.b_eight)
        bNine = findViewById(R.id.b_nine)
        bZero = findViewById(R.id.b_zero)
        bClear = findViewById(R.id.b_clear)
        bOK = findViewById(R.id.b_enter)

        bOne.setOnClickListener {
            val value: String = passwordET.text.toString()
            passwordET.setText(value + "1")
        }

        bTwo.setOnClickListener {
            val value: String = passwordET.text.toString()
            passwordET.setText(value + "2")
        }

        bThree.setOnClickListener {
            val value: String = passwordET.text.toString()
            passwordET.setText(value + "3")
        }

        bFour.setOnClickListener {
            val value: String = passwordET.text.toString()
            passwordET.setText(value + "4")
        }

        bFive.setOnClickListener {
            val value: String = passwordET.text.toString()
            passwordET.setText(value + "5")
        }

        bSix.setOnClickListener {
            val value: String = passwordET.text.toString()
            passwordET.setText(value + "6")
        }

        bSeven.setOnClickListener {
            val value: String = passwordET.text.toString()
            passwordET.setText(value + "7")
        }

        bEight.setOnClickListener {
            val value: String = passwordET.text.toString()
            passwordET.setText(value + "8")
        }

        bNine.setOnClickListener {
            val value: String = passwordET.text.toString()
            passwordET.setText(value + "9")
        }

        bZero.setOnClickListener {
            val value: String = passwordET.text.toString()
            passwordET.setText(value + "0")
        }

        bClear.setOnClickListener {
            val value: String = passwordET.text.toString()
            if (value.isNotEmpty()) {
                val newValue = value.substring(0, value.length - 1)
                passwordET.setText(newValue)
                passwordET.setSelection(newValue.length)
            }
        }

        bOK.setOnClickListener {
            val pin = passwordET.text.toString()
            val email = emailTV.text.toString()
            val абоба = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
            val ахуха = Regex("\\d{4}")

            if (абоба.matches(email) && ахуха.matches(pin)) {
                saveCredentials(pin, email)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    this,
                    "Пожалуйста, введите адрес электронной почты и пароль",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        applySavedTheme()
    }

    private fun saveCredentials(pin: String, email: String) {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("pin", pin)
        editor.putString("email", email)
        editor.putBoolean("isRegistered", true)
        editor.apply()
    }


    private fun applyTheme(themeId: Int) {
        when (themeId) {
            1 -> {

                val constraintLayout: RelativeLayout = findViewById(R.id.registration_layout)
                val gradientDrawable = ContextCompat.getDrawable(this, R.drawable.background)
                constraintLayout.background = gradientDrawable

            }
            2 -> {

                val constraintLayout: RelativeLayout = findViewById(R.id.registration_layout)
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
                    this@RegistrationActivity,
                    "Failed to read theme ID from Firestore!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
    }
}