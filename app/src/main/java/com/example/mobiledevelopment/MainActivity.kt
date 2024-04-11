package com.example.mobiledevelopment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.mobiledevelopment.expression_handling.MathEvaluator
import kotlin.math.pow
import kotlin.math.sqrt


class MainActivity : ComponentActivity() {

    private lateinit var result: TextView
    private lateinit var mainTV: TextView

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
    val PI_VALUE: Double = 3.141592
    private lateinit var bPI: Button
    private lateinit var bDot: Button
    private lateinit var bEqual: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById<TextView>(R.id.result)
        mainTV = findViewById<TextView>(R.id.operation)

        bBrace1 = findViewById<Button>(R.id.brace1)
        bBrace2 = findViewById<Button>(R.id.brace2)
        bAC = findViewById<Button>(R.id.ac)
        bClear = findViewById<Button>(R.id.clear)
        bSin = findViewById<Button>(R.id.sin)
        bCos = findViewById<Button>(R.id.cos)
        bTan = findViewById<Button>(R.id.tan)
        bLog = findViewById<Button>(R.id.log)
        bLn = findViewById<Button>(R.id.ln)
        bFact = findViewById<Button>(R.id.fact)
        bSquare = findViewById<Button>(R.id.square)
        bSqrt = findViewById<Button>(R.id.sqrt)
        bInv = findViewById<Button>(R.id.inv)
        bDiv = findViewById<Button>(R.id.div)

        b1 = findViewById<Button>(R.id.one)
        b2 = findViewById<Button>(R.id.two)
        b3 = findViewById<Button>(R.id.three)
        b4 = findViewById<Button>(R.id.four)
        b5 = findViewById<Button>(R.id.five)
        b6 = findViewById<Button>(R.id.six)
        b7 = findViewById<Button>(R.id.seven)
        b8 = findViewById<Button>(R.id.eight)
        b9 = findViewById<Button>(R.id.nine)
        b0 = findViewById<Button>(R.id.zero)

        bMul = findViewById<Button>(R.id.mul)
        bMin = findViewById<Button>(R.id.min)
        bPlus = findViewById<Button>(R.id.plus)
        bPI = findViewById<Button>(R.id.pi)
        bDot = findViewById<Button>(R.id.dot)
        bEqual = findViewById<Button>(R.id.equal)

        b1.setOnClickListener(View.OnClickListener {
            clearIfOnlyZero()
            if (!isLargeNumber()) {
                val value: String = mainTV.text.toString()
                if (value.isNotEmpty() && value[value.length - 1] == ')') {
                    mainTV.text = "$value×1"
                } else {
                    mainTV.text = value + "1"
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
                val `val`: String = mainTV.text.toString()
                if (`val`.isNotEmpty() && `val`[`val`.length - 1] == ')') {
                    mainTV.text = "$`val`×2"
                } else {
                    mainTV.text = `val` + "2"
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
                val `val`: String = mainTV.text.toString()
                if (`val`.isNotEmpty() && `val`[`val`.length - 1] == ')') {
                    mainTV.text = "$`val`×3"
                } else {
                    mainTV.text = `val` + "3"
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
                val `val`: String = mainTV.text.toString()
                if (`val`.isNotEmpty() && `val`[`val`.length - 1] == ')') {
                    mainTV.text = "$`val`×4"
                } else {
                    mainTV.text = `val` + "4"
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
                val `val`: String = mainTV.text.toString()
                if (`val`.isNotEmpty() && `val`[`val`.length - 1] == ')') {
                    mainTV.text = "$`val`×5"
                } else {
                    mainTV.text = `val` + "5"
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
                val `val`: String = mainTV.text.toString()
                if (`val`.isNotEmpty() && `val`[`val`.length - 1] == ')') {
                    mainTV.text = "$`val`×6"
                } else {
                    mainTV.text = `val` + "6"
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
                val `val`: String = mainTV.text.toString()
                if (`val`.isNotEmpty() && `val`[`val`.length - 1] == ')') {
                    mainTV.text = "$`val`×7"
                } else {
                    mainTV.text = `val` + "7"
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
                val `val`: String = mainTV.text.toString()
                if (`val`.isNotEmpty() && `val`[`val`.length - 1] == ')') {
                    mainTV.text = "$`val`×8"
                } else {
                    mainTV.text = `val` + "8"
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
                val `val`: String = mainTV.text.toString()
                if (`val`.isNotEmpty() && `val`[`val`.length - 1] == ')') {
                    mainTV.text = "$`val`×9"
                } else {
                    mainTV.text = `val` + "9"
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
                val `val`: String = mainTV.text.toString()
                if (`val`.isNotEmpty() && `val`[`val`.length - 1] == ')') {
                    mainTV.text = "$`val`×0"
                } else {
                    mainTV.text = `val` + "0"
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
                    mainTV.text = "$value×$PI_VALUE"
                } else {
                    mainTV.text = value + "$PI_VALUE"
                }
            } else {
                Toast.makeText(this@MainActivity, "Невозможно ввести более 10 цифр", Toast.LENGTH_SHORT).show()
            }
        }

        bDot.setOnClickListener {
            val expression = mainTV.text.toString()

            // Разделяем выражение на отдельные числа и операторы
            val tokens = expression.split("(?<=[-+*/^()])|(?=[-+*/^()])").toTypedArray()

            // Проверяем последний токен на наличие десятичной точки
            val lastToken = tokens[tokens.size - 1]
            val isAfterBracket = lastToken == ")"

            if (!lastToken.contains(".") && !isAfterBracket) {
                //После триг. функций хочу, чтобы писалась не просто точка, а "0."
                if (lastToken.matches("sin|cos|tg|log|ln".toRegex())) {
                    mainTV.text = expression + "0."
                } else {
                    mainTV.text = "$expression."
                }
            }
        }
        bBrace1.setOnClickListener {
            val expression = mainTV.text.toString()

            if (expression.isNotEmpty() && (expression.last() == ')' || expression.last().isDigit())) {
                mainTV.text = "$expression×("
            } else {
                mainTV.text = "$expression("
            }
        }
        bBrace2.setOnClickListener {
            val expression = mainTV.text.toString()

            if (expression.isNotEmpty() && (expression.last() == ')' || expression.last().isDigit())) {
                mainTV.text = "$expression)"
            } else {
                mainTV.text = "0)"
            }
        }

        bAC.setOnClickListener {
            mainTV.text = ""
            result.text = ""
        }
        bClear.setOnClickListener {
            val valStr = mainTV.text.toString()
            if (valStr.isNotEmpty()) {
                val newStr = valStr.substring(0, valStr.length - 1)
                mainTV.text = newStr
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
                if (valString.isEmpty() || isOperator(valString.last()) || valString.last() == ')' || valString.last() == '(') {
                    Toast.makeText(this@MainActivity, "Введите сначала число для извлечения корня", Toast.LENGTH_SHORT).show()
                } else {
                    val intValue = valString.toIntOrNull()
                    if (intValue == null) {
                        Toast.makeText(this@MainActivity, "Факториал можно вычислить только для целых чисел", Toast.LENGTH_SHORT).show()
                    } else {
                        fun factorial(n: Int): Int = if (n < 2) 1 else n * factorial(n - 1)
                        val res = factorial(intValue)
                        mainTV.text = res.toString()
                    }
                }
            }
        }
        bSqrt.setOnClickListener {
            if (canAddSquareRootOrSquare()) {
                val valString = mainTV.text.toString().replace(',', '.')
                if (valString.isEmpty() || isOperator(valString.last()) || valString.last() == ')' || valString.last() == '(') {
                    Toast.makeText(this@MainActivity, "Введите сначала число для извлечения корня", Toast.LENGTH_SHORT).show()
                } else {
                    val res = sqrt(valString.toDouble())
                    mainTV.text = if (res % 1 == 0.0) {
                        res.toInt().toString()
                    } else {
                        res.toString()
                    }
                }
            }
        }
        bSquare.setOnClickListener {
            if (canAddSquareRootOrSquare()) {
                val value = mainTV.text.toString().replace(',', '.')
                if (value.isEmpty() || isOperator(value.last()) || value.last() == ')' || value.last() == '(') {
                    Toast.makeText(this@MainActivity, "Введите сначала число для возведения в квадрат", Toast.LENGTH_SHORT).show()
                } else {
                    val number = value.toDouble()
                    val res = number.pow(2.0)
                    mainTV.text = if (res % 1 == 0.0) {
                        res.toInt().toString()
                    } else {
                        res.toString()
                    }
                }
            }
        }
        bInv.setOnClickListener {
            val value = mainTV.text.toString()
            if(value.isEmpty()) {
                mainTV.text = "${mainTV.text}1^(-1)"
            } else {
                mainTV.text = "${mainTV.text}^(-1)"
            }
        }

        bSin.setOnClickListener {
            val expression = mainTV.text.toString()

            if (expression.isNotEmpty() || expression.last() != '(') {
                mainTV.text = "$expression×sin("
            } else {
                mainTV.text = "sin("
            }
        }
        bCos.setOnClickListener {
            val expression = mainTV.text.toString()

            if (expression.isNotEmpty() || expression.last() != '(') {
                mainTV.text = "$expression×cos("
            } else {
                mainTV.text = "cos("
            }
        }
        bTan.setOnClickListener {
            val expression = mainTV.text.toString()

            if (expression.isNotEmpty() || expression.last() != '(') {
                mainTV.text = "$expression×tg("

            } else {
                mainTV.text = "tg("
            }
        }
        bLog.setOnClickListener {
            val expression = mainTV.text.toString()

            if (expression.isNotEmpty() || expression.last() != '(') {
                mainTV.text = "$expression×log("
            } else {
                mainTV.text = "log("
            }
        }
        bLn.setOnClickListener {
            val expression = mainTV.text.toString()

            if (expression.isNotEmpty() || expression.last() != '(') {
                val lastChar = expression.last()
                if (lastChar.isDigit() || lastChar == ')') {
                    mainTV.text = "$expression×ln("
                } else {
                    mainTV.text = "$expression+ln("
                }
            } else {
                mainTV.text = "ln("
            }
        }

        bEqual.setOnClickListener {
            val value = mainTV.text.toString()
            val replacedStr = value.replace('÷', '/').replace('×', '*').replace(',', '.')
            val regex = Regex("[+\\-*/(]$")
            if (replacedStr.isEmpty() || regex.containsMatchIn(replacedStr)) {
                Toast.makeText(this@MainActivity, "Введите выражение", Toast.LENGTH_SHORT).show()
            } else {
                try {
                    val resultVal = eval(replacedStr)
                    if (resultVal.isInfinite() || resultVal.isNaN()) {
                        Toast.makeText(this@MainActivity, "Невозможно выполнить деление на ноль", Toast.LENGTH_SHORT).show()
                    } else {
                        var formattedResult = String.format("%.6f", resultVal)
                        while (formattedResult.last() == '0') {
                            formattedResult = formattedResult.substring(0, formattedResult.length - 1)
                        }
                        if (formattedResult.last() == '.' || formattedResult.last() == ',') {
                            formattedResult = formattedResult.substring(0, formattedResult.length - 1)
                        }
                        mainTV.text = formattedResult
                        result.text = value
                    }
                } catch (e: RuntimeException) {
                    Toast.makeText(this@MainActivity, "Hекорректное выражение", Toast.LENGTH_SHORT).show()
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
        val expression: String = mainTV.getText().toString()
        if (!expression.isEmpty()) {
            val lastChar = expression[expression.length - 1]
            return !(lastChar == 'n' || lastChar == 's' || lastChar == 'g' || lastChar == 't')
        }
        return true
    }

    @SuppressLint("SetTextI18n")
    private fun handleOperatorClick(operator: String) {
        var expression = mainTV.text.toString()

        // Проверяем, если строка пустая или у нас (, то не добавляем оператор
        if (expression.isEmpty() || expression[expression.length - 1] == '(') {
            return
        }

        // Проверяем, если последний символ в строке является оператором,
        // то заменяем его на новый оператор
        if (isOperator(expression[expression.length - 1])) {
            // Удаляем последний символ (старый оператор)
            expression = expression.substring(0, expression.length - 1)
        }

        // Добавляем новый оператор к текущему выражению
        mainTV.text = "$expression$operator"
    }

    private fun clearIfOnlyZero() {
        val value = mainTV.text.toString()
        if (value == "0") {
            mainTV.text = ""
        } else {
            val newValue = value.replace(Regex("(?<!\\d)0"), "")
            if (newValue != value) {
                mainTV.text = newValue
            }
        }
    }
}

fun eval(expression: String): Double {
    return MathEvaluator(expression).eval()
}
