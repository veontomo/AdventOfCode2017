package day13

import Answer

class Firewall : Answer {
    override fun showAnswer(): String {
        val input = readLines("day13.txt").map { it.split(Regex(":\\s?")).map { it.toInt() } }
                .fold(mapOf<Int, Int>(), {acc, v -> acc + Pair(v[0], v[1])})
        val firewallsNum = input.keys.max()!! + 1
        val data = IntArray(firewallsNum,  {index -> if (input.containsKey(index)) input[index]!! else 0} )
        return data.joinToString { it.toString() }
    }
}