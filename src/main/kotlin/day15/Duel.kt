package day15

import Answer

class Duel : Answer {
    val g1 = Generator(679, 16807, 4)
    val g2 = Generator(771, 48271, 8)
    override fun showAnswer(): String {
        var result = calculate(5000000)
        return "number of matching: $result"
    }

    private fun calculate(total: Int): Int {
        var counter = 0
        for (i in 1..total) {
            if (binaryLastBits(g1.nextValue()) == binaryLastBits(g2.nextValue())) {
                counter++
            }

        }
        return counter
    }

    private fun binaryLastBits(num: Long): String {
        val length = 16
        val binary = num.toString(2)
        val pad = binary.padStart(length, '0')
        return pad.substring(pad.length - length)
    }
}