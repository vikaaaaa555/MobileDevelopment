package com.example.mobiledevelopment.expression_handling

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager

class FlashClass(private val context: Context) {
    private var cameraManager: CameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    private var cameraId: String? = null
    private var isTorchOn = false

    init {

        try {
            cameraId = cameraManager?.cameraIdList?.get(0)
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    fun toggleTorch() {
        try {
            isTorchOn = if (isTorchOn) {
                cameraManager?.setTorchMode(cameraId!!, false)
                false
            } else {
                cameraManager?.setTorchMode(cameraId!!, true)
                true
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }
}