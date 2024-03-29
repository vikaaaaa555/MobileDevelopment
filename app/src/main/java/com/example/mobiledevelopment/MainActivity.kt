package com.example.mobiledevelopment

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var result: TextView
    private lateinit var main_tv: TextView

    private lateinit var b_brace1: Button
    private lateinit var b_brace2: Button
    private lateinit var b_ac: Button
    private lateinit var b_clear: Button
    private lateinit var b_sin: Button
    private lateinit var b_cos: Button
    private lateinit var b_tan: Button
    private lateinit var b_log: Button
    private lateinit var b_ln: Button
    private lateinit var b_fact: Button
    private lateinit var b_square: Button
    private lateinit var b_sqrt: Button
    private lateinit var b_inv: Button
    private lateinit var b_div: Button

    private lateinit var b_1: Button
    private lateinit var b_2: Button
    private lateinit var b_3: Button
    private lateinit var b_4: Button
    private lateinit var b_5: Button
    private lateinit var b_6: Button
    private lateinit var b_7: Button
    private lateinit var b_8: Button
    private lateinit var b_9: Button
    private lateinit var b_0: Button

    private lateinit var b_mul: Button
    private lateinit var b_min: Button
    private lateinit var b_plus: Button
    val PI_VALUE: Double = 3.141592
    private lateinit var b_pi: Button
    private lateinit var b_dot: Button
    private lateinit var b_equal: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById<TextView>(R.id.result)
        main_tv = findViewById<TextView>(R.id.operation)

        b_brace1 = findViewById<Button>(R.id.brace1)
        b_brace2 = findViewById<Button>(R.id.brace2)
        b_ac = findViewById<Button>(R.id.ac)
        b_clear = findViewById<Button>(R.id.clear)
        b_sin = findViewById<Button>(R.id.sin)
        b_cos = findViewById<Button>(R.id.cos)
        b_tan = findViewById<Button>(R.id.tan)
        b_log = findViewById<Button>(R.id.log)
        b_ln = findViewById<Button>(R.id.ln)
        b_fact = findViewById<Button>(R.id.fact)
        b_square = findViewById<Button>(R.id.square)
        b_sqrt = findViewById<Button>(R.id.sqrt)
        b_inv = findViewById<Button>(R.id.inv)
        b_div = findViewById<Button>(R.id.div)

        b_1 = findViewById<Button>(R.id.one)
        b_2 = findViewById<Button>(R.id.two)
        b_3 = findViewById<Button>(R.id.three)
        b_4 = findViewById<Button>(R.id.four)
        b_5 = findViewById<Button>(R.id.five)
        b_6 = findViewById<Button>(R.id.six)
        b_7 = findViewById<Button>(R.id.seven)
        b_8 = findViewById<Button>(R.id.eight)
        b_9 = findViewById<Button>(R.id.nine)
        b_0 = findViewById<Button>(R.id.zero)

        b_mul = findViewById<Button>(R.id.mul)
        b_min = findViewById<Button>(R.id.min)
        b_plus = findViewById<Button>(R.id.plus)
        b_pi = findViewById<Button>(R.id.pi)
        b_dot = findViewById<Button>(R.id.dot)
        b_equal = findViewById<Button>(R.id.equal)

        //привязка кнопок
        b_1.setOnClickListener {
            main_tv.text = "${main_tv.text}1"
        }
        b_2.setOnClickListener {
            main_tv.text = "${main_tv.text}2"
        }
        b_3.setOnClickListener {
            main_tv.text = "${main_tv.text}3"
        }
        b_4.setOnClickListener {
            main_tv.text = "${main_tv.text}4"
        }
        b_5.setOnClickListener {
            main_tv.text = "${main_tv.text}5"
        }
        b_6.setOnClickListener {
            main_tv.text = "${main_tv.text}6"
        }
        b_7.setOnClickListener {
            main_tv.text = "${main_tv.text}7"
        }
        b_8.setOnClickListener {
            main_tv.text = "${main_tv.text}8"
        }
        b_9.setOnClickListener {
            main_tv.text = "${main_tv.text}9"
        }
        b_0.setOnClickListener {
            main_tv.text = "${main_tv.text}0"
        }
        b_pi.setOnClickListener {
            main_tv.text = "${main_tv.text}${PI_VALUE}"
        }

        b_ac.setOnClickListener {
            main_tv.text = ""
            result.text = ""
        }
        b_clear.setOnClickListener {
            val valStr = main_tv.text.toString()
            if (valStr.isNotEmpty()) {
                val newStr = valStr.substring(0, valStr.length - 1)
                main_tv.text = newStr
            }
        }

        b_plus.setOnClickListener {
            handleOperatorClick("+")
        }



    }

    private fun handleOperatorClick(operator: String) {
        var expression = main_tv.text.toString()

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
        main_tv.text = "$expression$operator"
    }

}
