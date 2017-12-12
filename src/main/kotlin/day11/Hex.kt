package day11

import Answer

class Hex : Answer {

    private var maxDist = 0

    private val shifts = mapOf("ne" to Pair(0, 1),
            "se" to Pair(1, 0),
            "s" to Pair(1, -1),
            "sw" to Pair(0, -1),
            "nw" to Pair(-1, 0),
            "n" to Pair(-1, 1))

    override fun showAnswer(): String {
        val input = readLines("day11.txt")[0]
        val finalPos = pathToCoord(input.split(Regex(",")), Pair(0, 0), 0)
        val dist = dist(finalPos)
        return "x: ${finalPos.first}, y: ${finalPos.second}, distance: $dist, max dist: $maxDist"
    }


    tailrec fun pathToCoord(path: List<String>, pos: Pair<Int, Int>, currentStep: Int): Pair<Int, Int> {
        if (currentStep == path.size) {
            return pos
        }
        val dir = path[currentStep]
        val offset = shifts[dir]!!
        val newPos = Pair(pos.first + offset.first, pos.second + offset.second)
        val newDist = dist(newPos)
        if (newDist > maxDist) {
            maxDist = newDist
        }
        return pathToCoord(path, newPos, currentStep + 1)
    }

    private fun dist(p: Pair<Int, Int>) = maxOf(abs(p.first), abs(p.second))


    private fun abs(n: Int) = if (n >= 0) n else -n

}