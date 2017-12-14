package day13

import Answer

class Firewall : Answer {
    override fun showAnswer(): String {
        val input = readLines("day13.txt").map { it.split(Regex(":\\s?")).map { it.toInt() } }
                .fold(mapOf<Int, Int>(), { acc, v -> acc + Pair(v[0], v[1]) })
        val firewallsNum = input.keys.max()!! + 1
        val data = IntArray(firewallsNum, { index -> if (input.containsKey(index)) input[index]!! else 0 })
        val severity = calculate(data)
        val minDelay = findOffset(data)
        return "severity: $severity, min delay: $minDelay"
    }

    fun calculate(data: IntArray, delay: Int = 0): Int {
        val m = mask(data, delay)
        return data.mapIndexed { index, value -> if (m[index]) index * value else 0 }.sum()
//        val tmp = data.mapIndexed { i, v -> if (v >= 0 && ((i + delay) % (2 * v - 2) == 0)) i * v else 0 }
        //      return tmp.sum()

    }

    /**
     * Return array of booleans: if at cell n you get caught, then the n-th value if true, otherwise - false
     */
    fun mask(data: IntArray, delay: Int = 0): BooleanArray {
        return data.mapIndexed { index, value -> value > 0 && ((index + delay) % (2 * value - 2) == 0) }.toBooleanArray()

    }


    fun findOffset(data: IntArray): Int {
        var offset = 0
        while (mask(data, offset).any { it }) {
            offset++
        }
        return offset
    }
}