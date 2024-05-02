package com.example.mobiledevelopment.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mobiledevelopment.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore

class HistoryActivity : AppCompatActivity() {
    private val db = Firebase.firestore
    private lateinit var historyTV: TextView
    private lateinit var bClose: ImageButton
    private lateinit var bDelete: Button
    private lateinit var data: StringBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        historyTV = findViewById(R.id.history_text_view)
        bClose = findViewById(R.id.btn_close)
        bDelete = findViewById(R.id.btn_delete)

        loadFirestoreData()

        bClose.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        bDelete.setOnClickListener {
            val collectionRef = db.collection("results")
            collectionRef
                .get()
                .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot.documents) {
                    document.reference.delete()
                }
                Toast.makeText(
                    this,
                    "История очищена",
                    Toast.LENGTH_SHORT
                ).show()
            }
            loadFirestoreData()
        }

        applySavedTheme()
    }

    private fun loadFirestoreData() {
        val resultsCollection = db.collection("results")

        resultsCollection
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { documents ->
                data = StringBuilder()
                for (document in documents) {
                    val result = document.data["expression"].toString()

                    data.append(result + "\n")
                }

                historyTV.text = data.toString()
            }
            .addOnFailureListener {
                Toast.makeText(
                    this@HistoryActivity,
                    "История пуста",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun applyTheme(themeId: Int) {
        when (themeId) {
            1 -> {

                val constraintLayout: RelativeLayout = findViewById(R.id.his_layout)
                val gradientDrawable = ContextCompat.getDrawable(this, R.drawable.background)
                constraintLayout.background = gradientDrawable

            }
            2 -> {

                val constraintLayout: RelativeLayout = findViewById(R.id.his_layout)
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
                    this@HistoryActivity,
                    "Failed to read theme ID from Firestore!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
    }
}
