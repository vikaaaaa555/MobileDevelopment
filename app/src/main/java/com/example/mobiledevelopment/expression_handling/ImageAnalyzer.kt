//package com.example.mobiledevelopment.expression_handling
//
//
//import android.content.Context
//import android.widget.Toast
//import androidx.camera.core.ExperimentalGetImage
//import androidx.camera.core.ImageProxy
//import com.example.mobiledevelopment.MainActivity
//import com.google.firebase.ml.vision.FirebaseVision
//import com.google.firebase.ml.vision.common.FirebaseVisionImage
//import com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata
//import com.google.firebase.ml.vision.text.FirebaseVisionText
//
//@ExperimentalGetImage class ImageAnalyzer (private val context: Context,
//                                           private val mainActivity: MainActivity) {
//
//    private fun degreesToFirebaseRotation(degrees: Int): Int = when(degrees) {
//        0 -> FirebaseVisionImageMetadata.ROTATION_0
//        90 -> FirebaseVisionImageMetadata.ROTATION_90
//        180 -> FirebaseVisionImageMetadata.ROTATION_180
//        270 -> FirebaseVisionImageMetadata.ROTATION_270
//        else -> throw Exception("Rotation must be 0, 90, 180, or 270.")
//    }
//
//    fun analyze(imageProxy: ImageProxy?, degrees: Int) {
//        val mediaImage = imageProxy?.image
//        val imageRotation = degreesToFirebaseRotation(degrees)
//        if (mediaImage != null) {
//            val image = FirebaseVisionImage.fromMediaImage(mediaImage, imageRotation)
//            val detector = FirebaseVision.getInstance().onDeviceTextRecognizer
//
//            val result = detector.processImage(image)
//                .addOnSuccessListener { firebaseVisionText ->
//                    processTextResult(firebaseVisionText)
//                }
//                .addOnFailureListener { e ->
//                    Toast.makeText(context, "Текст не распознан", Toast.LENGTH_SHORT).show()
//                }
//        }
//    }
//
//    private fun processTextResult(visionText: FirebaseVisionText) {
//        val recognizedText = visionText.text
//        mainActivity.handleRecognizedText(recognizedText)
//    }
//
//
//}