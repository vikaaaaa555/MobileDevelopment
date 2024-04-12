package com.example.mobiledevelopment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
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
    private lateinit var bMin: Button
    private lateinit var bPlus: Button
    private val PI_VALUE: Double = 3.141592
    private lateinit var bPI: Button
    private lateinit var bDot: Button
    private lateinit var bEqual: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        b1.setOnClickListener(View.OnClickListener {
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
        })
        b2.setOnClickListener(View.OnClickListener {
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
        })
        b3.setOnClickListener(View.OnClickListener {
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
        })
        b4.setOnClickListener(View.OnClickListener {
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
        })
        b5.setOnClickListener(View.OnClickListener {
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
        })
        b6.setOnClickListener(View.OnClickListener {
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
        })
        b7.setOnClickListener(View.OnClickListener {
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
        })
        b8.setOnClickListener(View.OnClickListener {
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
        })
        b9.setOnClickListener(View.OnClickListener {
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
        })
        b0.setOnClickListener(View.OnClickListener {
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
        })
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
                Toast.makeText(this@MainActivity, "Невозможно ввести более 10 цифр",
                    Toast.LENGTH_SHORT).show()
            }
        }

        bDot.setOnClickListener {
            val expression = mainTV.text.toString()

            if (expression.isEmpty()) {
                mainTV.setText("0.")
            } else {
                val tokens = expression.split("(?<=[-+*/^()])|(?=[-+*/^()])").toTypedArray()
                val lastToken = tokens.lastOrNull()
                val hasDecimalPoint = lastToken?.contains(".") ?: false

                if ((lastToken != null) && lastToken.matches("-?\\d+(\\.\\d+)?".toRegex())) {
                    if (!hasDecimalPoint) {
                        mainTV.setText("$expression.")
                    }
                } else {
                    mainTV.setText("$expression.")
                }
            }
        }
        bBrace1.setOnClickListener {
            val expression = mainTV.text.toString()

            if (expression.isNotEmpty() && (expression.last() == ')' || expression.last().isDigit())) {
                mainTV.setText("$expression×(")
            } else {
                mainTV.setText("$expression(")
            }
        }
        bBrace2.setOnClickListener {
            val expression = mainTV.text.toString()

            if (expression.isNotEmpty() && (expression.last() == ')' || expression.last().isDigit())) {
                mainTV.setText("$expression)")
            } else {
                mainTV.setText("0)")
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
                    Toast.makeText(this@MainActivity,
                        "Введите число для вычисления факториала", Toast.LENGTH_SHORT).show()
                } else {
                    val intValue = valString.toIntOrNull()
                    if (intValue == null) {
                        Toast.makeText(this@MainActivity,
                            "Факториал можно вычислить только для целых чисел",
                            Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(this@MainActivity,
                        "Введите число для извлечения корня", Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(this@MainActivity,
                        "Введите число для возведения в квадрат", Toast.LENGTH_SHORT).show()
                } else {
                    val number = value.toDouble()
                    val res = number.pow(2.0)
                    val resultText = if (res % 1 == 0.0) {
                        res.toInt().toString()
                    } else {
                        res.toString()
                    }
                    mainTV.setText(resultText)
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
                Toast.makeText(this@MainActivity, "Введите выражение",
                    Toast.LENGTH_SHORT).show()
            } else {
                try {
                    val resultVal = eval(replacedStr)
                    if (resultVal.isInfinite() || resultVal.isNaN()) {
                        Toast.makeText(this@MainActivity,
                            "Невозможно выполнить деление на ноль", Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(this@MainActivity, "Hекорректное выражение",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
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

        if (expression.isEmpty() || expression[expression.length - 1] == '(') {
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


//    @SuppressLint("SetTextI18n")
//    fun handleRecognizedText(text: String) {
//        mainTV.setText("$mainTV$text")
//    }
}


