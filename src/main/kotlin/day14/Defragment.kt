package day14

import Answer
import day10.Hash
import java.lang.Long.parseLong

class Defragment : Answer {
    override fun showAnswer(): String {
        val base = "ffayrhll"
        val c = Hash()
        val gridInput = (0..127).map { it -> c.denseHash("$base-$it") }
        val binaryInput = gridInput.map { toBinary(it).toCharArray().map { it.toString() } }
        val map = binaryInput
                .mapIndexed { index1, value -> value.mapIndexed { index2, s -> Triple(index1, index2, s) } }
                .flatten()
                .filter { it.third == "1" }
                .map { Pair(it.first, it.second) }
                .toSet()
        val cl = clusters(map)
        return "number of 1s:  ${map.size}, number of clusters: ${cl.size}"
    }

    fun toBinary(hex: String): String {
        return hex.toCharArray().map { parseLong(it.toString(), 16).toString(2).padStart(4, '0') }
                .joinToString(separator = "") { it }
    }

    fun sumBits(binary: String): Int {
        val l = binary.length
        assert(l == 128, { "input $binary has length $l" })
        val result = binary.toCharArray().map { if (it.toString() == "0") 0 else 1 }.sum()
        assert(result < 129, { "sum of bits is too big: $result" })
        return result
    }

    fun clusters(map: Set<Pair<Int, Int>>): Set<Set<Pair<Int, Int>>> {
        return groupByNeighbors(setOf(), map)
    }

    private fun groupByNeighbors(clusters: Set<Set<Pair<Int, Int>>>, map: Set<Pair<Int, Int>>): Set<Set<Pair<Int, Int>>> {
        if (map.isEmpty()) {
            return clusters
        }
        val pivot = map.first()
        val pivotCluster: Set<Pair<Int, Int>> = findAllElementsByPivot(pivot, map) + setOf(pivot)
        val rest = map.filter { !pivotCluster.contains(it) }.toSet()
        return groupByNeighbors(clusters + setOf(pivotCluster), rest)
    }

    private fun findAllElementsByPivot(pivot: Pair<Int, Int>, map: Set<Pair<Int, Int>>): Set<Pair<Int, Int>> {
        val seed = mutableSetOf(pivot)
        var neighbours = getExternalNeighbours(seed, map)
        while (neighbours.isNotEmpty()) {
            seed.addAll(neighbours)
            neighbours = getExternalNeighbours(seed, map)
        }
        return seed
    }

    /**
     * Return neighbours of elements in seed that do not belong to seed (external neighbours)
     */
    private fun getExternalNeighbours(seed: Set<Pair<Int, Int>>, map: Set<Pair<Int, Int>>): Set<Pair<Int, Int>> {
        val offsets = setOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
        val neighbours = mutableSetOf<Pair<Int, Int>>()
        for (elem in seed) {
            val singleElemNeighbours = offsets
                    .map { Pair(it.first + elem.first, it.second + elem.second) }
                    .filter { map.contains(it) }
                    .filter { !seed.contains(it) }

            neighbours.addAll(singleElemNeighbours)
        }
        return neighbours
    }
}