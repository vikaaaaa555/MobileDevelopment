package com.example.mobiledevelopment.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevelopment.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class HistoryActivity : AppCompatActivity() {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
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
            collectionRef.get().addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot.documents) {
                    document.reference.delete()
                }
                Toast.makeText(this, "Все документы удалены", Toast.LENGTH_SHORT).show()
            }
            loadFirestoreData()
        }
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
            .addOnFailureListener { exception ->
                Toast.makeText(
                    this@HistoryActivity,
                    "Коллекция пуста",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}
