package day13

import Answer

class Firewall : Answer {
    override fun showAnswer(): String {
        val input = readLines("day13.txt").map { it.split(Regex(":\\s?")).map { it.toInt() } }
                .fold(mapOf<Int, Int>(), { acc, v -> acc + Pair(v[0], v[1]) })
        val firewallsNum = input.keys.max()!! + 1
        val data = IntArray(firewallsNum, { index -> if (input.containsKey(index)) input[index]!! else 0 })
        val result = calculate(data)
        return result.toString()
    }

    fun calculate(data: IntArray): Int {
        val tmp = data.mapIndexed { i, v -> if (v >= 0 && (i % (2 * v - 2) == 0)) i * v else 0 }
        print(tmp)
        return tmp.sum()

    }
}