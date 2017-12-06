package day06

import Answer

class Reallocation : Answer {
    override fun showAnswer(): String {
        val input = arrayOf(10, 3, 15, 10, 5, 15, 5, 15, 9, 2, 5, 8, 5, 2, 3, 6).toIntArray()
        val pair = iterate(arrayOf(), input, 0)
        return "iterations: ${pair.first}, cycles: ${pair.second}"
    }

    tailrec fun iterate(known: Array<String>, current: IntArray, counter: Int): Pair<Int, Int> {
        val hash = current.joinToString { it.toString() }
        val pos = known.indexOf(hash)
        if (pos != -1) {
            return Pair(counter, known.size - pos)
        }
        val newKnown = known + hash
        val newValue = distribute(current)
        return iterate(newKnown, newValue, counter + 1)
    }

    fun distribute(numbers: IntArray): IntArray {
        val max = numbers.max()
        val s = numbers.size
        val maxPos = numbers.indexOfFirst { it == max }
        val parts = split(max!!, s, maxPos + 1)
        return numbers.mapIndexed { i, v -> v + parts[i] - (if (i == maxPos) max else 0) }.toIntArray()
    }

    fun split(number: Int, length: Int, offset: Int): IntArray {
        val mod = number / length
        val rest = number % length
        val offPositive = (offset / length + 1) * length - offset
        return IntArray(length, { i -> mod + (if ((i + offPositive) % length < rest) 1 else 0) })

    }

    fun abs(n: Int) = if (n > 0) n else -n
}