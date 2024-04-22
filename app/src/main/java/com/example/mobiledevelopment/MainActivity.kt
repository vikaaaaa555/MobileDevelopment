package com.example.mobiledevelopment

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.mobiledevelopment.expression_handling.FlashClass
import com.example.mobiledevelopment.expression_handling.eval
import kotlin.math.pow
import kotlin.math.sqrt


class MainActivity : ComponentActivity() {

    private lateinit var result: EditText
    private lateinit var mainTV: EditText

    private lateinit var bBrace1: Button
    private lateinit var bBrace2: Button
    private lateinit var bAC: Button
    private lateinit var bClear: Button
    private lateinit var bSin: Button
    private lateinit var bCos: Button
    private lateinit var bTan: Button
    private lateinit var bLog: Button
    private lateinit var bLn: Button
    private lateinit var bFact: Button
    private lateinit var bSquare: Button
    private lateinit var bSqrt: Button
    private lateinit var bInv: Button
    private lateinit var bDiv: Button

    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var b8: Button
    private lateinit var b9: Button
    private lateinit var b0: Button

    private lateinit var bMul: Button
    lateinit var bMin: Button
    lateinit var bPlus: Button
    private val PI_VALUE: Double = 3.141592
    private lateinit var bPI: Button
    private lateinit var bDot: Button
    private lateinit var bEqual: Button

    private lateinit var flashClass: FlashClass

//    private lateinit var lSwipeDetector: GestureDetectorCompat
//    private lateinit var mainLayout: LinearLayout
//
//    private var lastX: Float = 0.0f
//    private var lastY: Float = 0.0f
//    private var lastZ: Float = 0.0f
//    companion object {
//        private const val SWIPE_MIN_DISTANCE = 130
//        private const val SWIPE_MAX_DISTANCE = 300
//        private const val SWIPE_MIN_VELOCITY = 200
//    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mainLayout = findViewById(R.id.main_layout)

        flashClass = FlashClass(this)

        result = findViewById(R.id.result)
        mainTV = findViewById(R.id.operation)

        bBrace1 = findViewById(R.id.brace1)
        bBrace2 = findViewById(R.id.brace2)
        bAC = findViewById(R.id.ac)
        bClear = findViewById(R.id.clear)
        bSin = findViewById(R.id.sin)
        bCos = findViewById(R.id.cos)
        bTan = findViewById(R.id.tan)
        bLog = findViewById(R.id.log)
        bLn = findViewById(R.id.ln)
        bFact = findViewById(R.id.fact)
        bSquare = findViewById(R.id.square)
        bSqrt = findViewById(R.id.sqrt)
        bInv = findViewById(R.id.inv)
        bDiv = findViewById(R.id.div)

        b1 = findViewById(R.id.one)
        b2 = findViewById(R.id.two)
        b3 = findViewById(R.id.three)
        b4 = findViewById(R.id.four)
        b5 = findViewById(R.id.five)
        b6 = findViewById(R.id.six)
        b7 = findViewById(R.id.seven)
        b8 = findViewById(R.id.eight)
        b9 = findViewById(R.id.nine)
        b0 = findViewById(R.id.zero)

        bMul = findViewById(R.id.mul)
        bMin = findViewById(R.id.min)
        bPlus = findViewById(R.id.plus)
        bPI = findViewById(R.id.pi)
        bDot = findViewById(R.id.dot)
        bEqual = findViewById(R.id.equal)

        b1.setOnClickListener {
            clearIfOnlyZero()
            if (!isLargeNumber()) {
                val value: String = mainTV.text.toString()
                if (value.isNotEmpty() && value[value.length - 1] == ')') {
                    mainTV.setText("$value×1")
                } else {
                    mainTV.setText(value+"1")
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Невозможно ввести более 10 цифр",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        b2.setOnClickListener {
            clearIfOnlyZero()
            if (!isLargeNumber()) {
                val value: String = mainTV.text.toString()
                if (value.isNotEmpty() && value[value.length - 1] == ')') {
                    mainTV.setText("$value×2")
                } else {
                    mainTV.setText(value+"2")
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Невозможно ввести более 10 цифр",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        b3.setOnClickListener {
            clearIfOnlyZero()
            if (!isLargeNumber()) {
                val value: String = mainTV.text.toString()
                if (value.isNotEmpty() && value[value.length - 1] == ')') {
                    mainTV.setText("$value×3")
                } else {
                    mainTV.setText(value+"3")
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Невозможно ввести более 10 цифр",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        b4.setOnClickListener {
            clearIfOnlyZero()
            if (!isLargeNumber()) {
                val value: String = mainTV.text.toString()
                if (value.isNotEmpty() && value[value.length - 1] == ')') {
                    mainTV.setText(value+"4")
                } else {
                    mainTV.setText(value+"4")
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Невозможно ввести более 10 цифр",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        b5.setOnClickListener {
            clearIfOnlyZero()
            if (!isLargeNumber()) {
                val value: String = mainTV.text.toString()
                if (value.isNotEmpty() && value[value.length - 1] == ')') {
                    mainTV.setText(value+"5")
                } else {
                    mainTV.setText(value+"5")
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Невозможно ввести более 10 цифр",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        b6.setOnClickListener {
            clearIfOnlyZero()
            if (!isLargeNumber()) {
                val value: String = mainTV.text.toString()
                if (value.isNotEmpty() && value[value.length - 1] == ')') {
                    mainTV.setText(value+"6")
                } else {
                    mainTV.setText(value+"6")
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Невозможно ввести более 10 цифр",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        b7.setOnClickListener {
            clearIfOnlyZero()
            if (!isLargeNumber()) {
                val value: String = mainTV.text.toString()
                if (value.isNotEmpty() && value[value.length - 1] == ')') {
                    mainTV.setText(value+"7")
                } else {
                    mainTV.setText(value+"7")
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Невозможно ввести более 10 цифр",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        b8.setOnClickListener {
            clearIfOnlyZero()
            if (!isLargeNumber()) {
                val value: String = mainTV.text.toString()
                if (value.isNotEmpty() && value[value.length - 1] == ')') {
                    mainTV.setText(value+"8")
                } else {
                    mainTV.setText(value+"8")
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Невозможно ввести более 10 цифр",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        b9.setOnClickListener{
            clearIfOnlyZero()
            if (!isLargeNumber()) {
                val value: String = mainTV.text.toString()
                if (value.isNotEmpty() && value[value.length - 1] == ')') {
                    mainTV.setText(value+"9")
                } else {
                    mainTV.setText(value+"9")
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Невозможно ввести более 10 цифр",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        b0.setOnClickListener {
            clearIfOnlyZero()
            if (!isLargeNumber()) {
                val value: String = mainTV.text.toString()
                if (value.isNotEmpty() && value[value.length - 1] == ')') {
                    mainTV.setText(value+"0")
                } else {
                    mainTV.setText(value+"0")
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Невозможно ввести более 10 цифр",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        bPI.setOnClickListener {
            clearIfOnlyZero()
            if (!isLargeNumber()) {
                val value = mainTV.text.toString()
                val reg = Regex("\\d")
                if (value.isNotEmpty() && (value.last() == ')' ) || reg.containsMatchIn(value)) {
                    mainTV.setText(value + PI_VALUE)
                } else {
                    mainTV.setText(value + PI_VALUE)
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Невозможно ввести более 10 цифр",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        bDot.setOnClickListener {
            val expression: String = mainTV.text.toString()

            val tokens = expression.split("(?<=[-+*/^()])|(?=[-+*/^()])".toRegex())
                .dropLastWhile { it.isEmpty() }
                .toTypedArray()

            val lastToken = tokens[tokens.size - 1]
            val isAfterBracket = lastToken == ")"
            if (!lastToken.contains(".") && !isAfterBracket) {
                // "\\(|\\+|-|×|÷"
                if (lastToken.matches("[(+\\-×÷]".toRegex())) {
                    mainTV.setText(expression + "0.")
                } else {
                    mainTV.setText("$expression.")
                }
            }
        }
        bBrace1.setOnClickListener {
            val expression: String = mainTV.text.toString()
            if (expression[expression.length - 1] == ')' || Character.isDigit(expression[expression.length - 1])) {
                mainTV.setText("$expression×(")
            } else if(expression[expression.length - 1] == '.'){
                mainTV.setText(expression + "0×(")
            } else {
                mainTV.setText("$expression(")
            }
        }
        bBrace2.setOnClickListener {
            val expression: String = mainTV.text.toString()
            var openBracketCount = 0
            var closeBracketCount = 0

            for (c in expression.toCharArray()) {
                if (c == '(') {
                    openBracketCount++
                } else if (c == ')') {
                    closeBracketCount++
                }
            }
            if (openBracketCount > closeBracketCount && (expression.isEmpty() || Character.isDigit(
                    expression[expression.length - 1]
                ) || expression[expression.length - 1] == ')')
            ) {
                mainTV.setText("$expression)")
            }
        }

        bAC.setOnClickListener {
            mainTV.setText("")
            result.setText("")
        }
        bClear.setOnClickListener {
            val valStr = mainTV.text.toString()
            if (valStr.isNotEmpty()) {
                val newStr = valStr.substring(0, valStr.length - 1)
                mainTV.setText(newStr)
            }
        }

        bPlus.setOnClickListener {
            handleOperatorClick("+")
        }
        bMin.setOnClickListener {
            handleOperatorClick("-")
        }
        bMul.setOnClickListener {
            handleOperatorClick("×")
        }
        bDiv.setOnClickListener {
            handleOperatorClick("÷")
        }

        bFact.setOnClickListener {
            if (canAddSquareRootOrSquare()) {
                val valString = mainTV.text.toString().replace(',', '.')
                if (valString.isEmpty() || isOperator(valString.last()) || valString.last() == ')'
                    || valString.last() == '(') {
                    Toast.makeText(
                        this@MainActivity,
                        "Введите число для вычисления факториала",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val intValue = valString.toIntOrNull()
                    if (intValue == null) {
                        Toast.makeText(
                            this@MainActivity,
                            "Факториал можно вычислить только для целых чисел",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        fun factorial(n: Int): Int = if (n < 2) 1 else n * factorial(n - 1)
                        val res = factorial(intValue)
                        mainTV.setText(res.toString())
                    }
                }
            }
        }
        bSqrt.setOnClickListener {
            if (canAddSquareRootOrSquare()) {
                val valString = mainTV.text.toString().replace(',', '.')
                if (valString.isEmpty() || isOperator(valString.last()) || valString.last() == ')'
                    || valString.last() == '(') {
                    Toast.makeText(
                        this@MainActivity,
                        "Введите число для извлечения корня",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val res = sqrt(valString.toDouble())
                    val resultText = if (res % 1 == 0.0) {
                        res.toInt().toString()
                    } else {
                        res.toString()
                    }
                    mainTV.setText(resultText)
                }
            }
        }
        bSquare.setOnClickListener {
            if (canAddSquareRootOrSquare()) {
                val value = mainTV.text.toString().replace(',', '.')
                if (value.isEmpty() || isOperator(value.last()) || value.last() == ')'
                    || value.last() == '(') {
                    Toast.makeText(
                        this@MainActivity,
                        "Введите число для возведения в квадрат",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val number = value.toDouble()
                    val res = number.pow(2.0)
                    mainTV.setText(res.toString())
                }
            }
        }
        bInv.setOnClickListener {
            val value = mainTV.text.toString()
            if(value.isEmpty()) {
                mainTV.setText("${mainTV.text}1^(-1)")
            } else {
                mainTV.setText("${mainTV.text}^(-1)")
            }
        }

        bSin.setOnClickListener {
            val expression = mainTV.text.toString().trim()
            if(expression.isEmpty()){
                mainTV.setText("sin(")
            } else {
                val lastChar = expression.lastOrNull()
                val isLastCharOperator = lastChar!! in "+-×÷("

                val newText = if (isLastCharOperator) {
                    expression + "sin("
                } else {
                    "$expression×sin("
                }
                mainTV.setText(newText)
            }
        }
        bCos.setOnClickListener {
            val expression = mainTV.text.toString().trim()
            if(expression.isEmpty()){
                mainTV.setText("cos(")
            } else {
                val lastChar = expression.lastOrNull()
                val isLastCharOperator = lastChar!! in "+-×÷("

                val newText = if (isLastCharOperator) {
                    expression + "cos("
                } else {
                    "$expression×cos("
                }
                mainTV.setText(newText)
            }
        }
        bTan.setOnClickListener {
            val expression = mainTV.text.toString().trim()
            if(expression.isEmpty()){
                mainTV.setText("tg(")
            } else {
                val lastChar = expression.lastOrNull()
                val isLastCharOperator = lastChar!! in "+-×÷("

                val newText = if (isLastCharOperator) {
                    expression + "tg("
                } else {
                    "$expression×tg("
                }
                mainTV.setText(newText)
            }
        }
        bLog.setOnClickListener {
            val expression = mainTV.text.toString().trim()
            if(expression.isEmpty()){
                mainTV.setText("log(")
            } else {
                val lastChar = expression.lastOrNull()
                val isLastCharOperator = lastChar!! in "+-×÷("

                val newText = if (isLastCharOperator) {
                    expression + "log("
                } else {
                    "$expression×log("
                }
                mainTV.setText(newText)
            }
        }
        bLn.setOnClickListener {
            val expression = mainTV.text.toString().trim()
            if(expression.isEmpty()){
                mainTV.setText("ln(")
            } else {
                val lastChar = expression.lastOrNull()
                val isLastCharOperator = lastChar!! in "+-×÷("

                val newText = if (isLastCharOperator) {
                    expression + "ln("
                } else {
                    "$expression×ln("
                }
                mainTV.setText(newText)
            }
        }

        bEqual.setOnClickListener {
            val value = mainTV.text.toString()
            val replacedStr = value.replace('÷', '/').replace('×', '*')
                .replace(',', '.')
            val regex = Regex("[+\\-*/(]$")
            if (replacedStr.isEmpty() || regex.containsMatchIn(replacedStr)) {
                Toast.makeText(
                    this@MainActivity,
                    "Введите выражение",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                try {
                    val resultVal = eval(replacedStr)
                    if (resultVal.isInfinite() || resultVal.isNaN()) {
                        Toast.makeText(
                            this@MainActivity,
                            "Невозможно выполнить деление на ноль",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        var formattedResult = String.format("%.6f", resultVal)
                        while (formattedResult.last() == '0') {
                            formattedResult = formattedResult.substring(0, formattedResult.length - 1)
                        }
                        if (formattedResult.last() == '.' || formattedResult.last() == ',') {
                            formattedResult = formattedResult.substring(0, formattedResult.length - 1)
                        }
                        mainTV.setText(formattedResult)
                        result.setText(value)
                    }
                } catch (e: RuntimeException) {
                    Toast.makeText(
                        this@MainActivity,
                        "Hекорректное выражение",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            flashClass.toggleTorch()
        }

//        lSwipeDetector = GestureDetectorCompat(this, MyGestureListener())
//
//        mainLayout.setOnTouchListener { _, event ->
//            lSwipeDetector.onTouchEvent(event)
//            true
//        }
    }

    private fun isOperator(c: Char): Boolean {
        return c == '+' || c == '-' || c == '×' || c == '÷'
    }

    private fun isLargeNumber(): Boolean {
        val expression = StringBuilder(mainTV.text.toString())
        var count = 0
        while (expression.isNotEmpty() && expression.last().isDigit()) {
            count++
            expression.deleteCharAt(expression.length - 1)
        }
        return count > 9
    }

    private fun canAddSquareRootOrSquare(): Boolean {
        val expression: String = mainTV.text.toString()
        if (expression.isNotEmpty()) {
            val lastChar = expression[expression.length - 1]
            return !(lastChar == 'n' || lastChar == 's' || lastChar == 'g' || lastChar == 't')
        }
        return true
    }

    @SuppressLint("SetTextI18n")
    private fun handleOperatorClick(operator: String) {
        var expression = mainTV.text.toString()

        if (expression.isEmpty() || expression[expression.length - 1] == '('
            || expression[expression.length - 1] == '.') {
            return
        }

        if (isOperator(expression[expression.length - 1])) {
            expression = expression.substring(0, expression.length - 1)
        }

        mainTV.setText("$expression$operator")
    }

    private fun clearIfOnlyZero() {
        val value = mainTV.text.toString()
        if (value == "0") {
            mainTV.setText("")
        } else {
            val newValue = value.replace(Regex("(?<=\\d)0+(?=\\.)"), "")
            if (newValue != value) {
                mainTV.setText(newValue)
            }
        }
    }

//    inner class MyGestureListener : GestureDetector.SimpleOnGestureListener() {
//        override fun onDown(e: MotionEvent): Boolean {
//            return true
//        }
//
//        override fun onFling(
//            e1: MotionEvent?,
//            e2: MotionEvent,
//            velocityX: Float,
//            velocityY: Float
//        ): Boolean {
//            val deltaX = e2.x - e1!!.x
//            val deltaY = e2.y - e1.y
//            val deltaXAbs = Math.abs(deltaX)
//            val deltaYAbs = Math.abs(deltaY)
//
//            if (deltaXAbs > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY) {
//                if (deltaX > 0) {
//                    bPlus.performClick()
//                    //Toast.makeText(this@MainActivity, "Swipe Right", Toast.LENGTH_SHORT).show()
//                } else {
//                    bMin.performClick()
//                    //Toast.makeText(this@MainActivity, "Swipe Left", Toast.LENGTH_SHORT).show()
//                }
//                return true
//            }
//
//            if (deltaYAbs > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_MIN_VELOCITY) {
//                if (deltaY > 0) {
//                    bDiv.performClick()
//                    //Toast.makeText(this@MainActivity, "Swipe Down", Toast.LENGTH_SHORT).show()
//                } else {
//                    bMul.performClick()
//                    //Toast.makeText(this@MainActivity, "Swipe Up", Toast.LENGTH_SHORT).show()
//                }
//                return true
//            }
//
//            return false
//        }
//    }
}
