import android.content.Context
import android.hardware.SensorManager
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.Sensor

class CompassHandler(context: Context) : SensorEventListener {

    private val sensorManager: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometer: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    private val magnetometer: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

    private var lastAccelerometer: FloatArray = FloatArray(3)
    private var lastMagnetometer: FloatArray = FloatArray(3)
    private var lastAccelerometerSet = false
    private var lastMagnetometerSet = false

    private val R = FloatArray(9)
    private val I = FloatArray(9)
    private val orientation = FloatArray(3)

    private var listener: OnDirectionChangeListener? = null

    interface OnDirectionChangeListener {
        fun onDirectionChanged(direction: Int)
    }

    fun setOnDirectionChangeListener(listener: OnDirectionChangeListener) {
        this.listener = listener
    }

    fun start() {
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun stop() {
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return
        if (event.sensor == accelerometer) {
            System.arraycopy(event.values, 0, lastAccelerometer, 0, event.values.size)
            lastAccelerometerSet = true
        } else if (event.sensor == magnetometer) {
            System.arraycopy(event.values, 0, lastMagnetometer, 0, event.values.size)
            lastMagnetometerSet = true
        }
        if (lastAccelerometerSet && lastMagnetometerSet) {
            SensorManager.getRotationMatrix(R, I, lastAccelerometer, lastMagnetometer)
            SensorManager.getOrientation(R, orientation)
            val azimuthInRadians = orientation[0]
            val azimuthInDegrees = Math.toDegrees(azimuthInRadians.toDouble()).toFloat()
            val direction = ((azimuthInDegrees + 360) % 360).toInt() // Определяем направление в градусах
            listener?.onDirectionChanged(direction)
        }
    }
}

