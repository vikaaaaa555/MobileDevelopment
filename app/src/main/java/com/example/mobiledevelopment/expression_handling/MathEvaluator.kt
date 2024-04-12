package com.example.mobiledevelopment.expression_handling

import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

class MathEvaluator(private val expression: String) {
    private var pos = -1
    private var ch: Char = ' '

    private fun nextChar() {
        ch = if (++pos < expression.length) expression[pos] else (-1).toChar()
    }

    private fun eat(charToEat: Char): Boolean {
        while (ch == ' ') nextChar()
        if (ch == charToEat) {
            nextChar()
            return true
        }
        return false
    }

    fun eval(): Double {
        nextChar()
        val x = parseExpression()
        if (pos < expression.length) throw RuntimeException("Unexpected: $ch")
        return x
    }

    private fun parseExpression(): Double {
        var x = parseTerm()
        while (true) {
            x = when {
                eat('+') -> x + parseTerm() // addition
                eat('-') -> x - parseTerm() // subtraction
                else -> return x
            }
        }
    }

    private fun parseTerm(): Double {
        var x = parseFactor()
        while (true) {
            x = when {
                eat('*') -> x * parseFactor() // multiplication
                eat('/') -> x / parseFactor() // division
                else -> return x
            }
        }
    }

    private fun parseFactor(): Double {
        if (eat('+')) return parseFactor() // unary plus
        if (eat('-')) return -parseFactor() // unary minus

        val startPos = pos
        var x: Double
        when {
            eat('(') -> { // parentheses
                x = parseExpression()
                eat(')')
            }
            (ch in '0'..'9' || ch == '.') -> { // numbers
                while (ch in '0'..'9' || ch == '.') nextChar()
                x = expression.substring(startPos, pos).toDouble()
            }
            else -> {
                while (ch in 'a'..'z') nextChar() // functions
                val func = expression.substring(startPos, pos)
                x = parseFactor()
                x = when (func) {
                    "sqrt" -> sqrt(x)
                    "sin" -> sin(Math.toRadians(x))
                    "cos" -> cos(Math.toRadians(x))
                    "tg" -> tan(Math.toRadians(x))
                    "ctg" -> 1 / tan(Math.toRadians(x))
                    "log" -> log10(x)
                    "ln" -> ln(x)
                    else -> throw RuntimeException("Unknown function: $func")
                }
            }
        }

        if (eat('^')) x = x.pow(parseFactor()) // exponentiation

        return x
    }

}

fun eval(expression: String): Double {
    return MathEvaluator(expression).eval()
}