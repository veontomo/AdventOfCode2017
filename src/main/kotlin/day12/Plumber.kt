package day12

import Answer

class Plumber : Answer {
    override fun showAnswer(): String {
        val input = readLines("day12.txt")
        val sets = input.map { it.split(Regex("<->|,")).map { it.trim().toInt() }.toSet() }
        val merged = merge(sets, 1)
        val zeroSet = merged.filter { it -> it.contains(0) }
        assert(zeroSet.size == 1, { "there must be exactly one set containing 0" })
        return "size of the set containing zero: ${zeroSet.first().size}, number of groups: ${merged.size}"
    }

    tailrec fun merge(sets: List<Set<Int>>, pos: Int): List<Set<Int>> {
//        println(sets)
//        println("pos: $pos")

        if (pos >= sets.size) {
            return sets
        }
        val head = sets.subList(0, pos)
        val tail = sets.subList(pos + 1, sets.size)
        val pivot = sets[pos]
        //       print("head: ")
        //      println(head)
        //     print("tail: ")
        //    println(tail)
        //   print("pivot: ")
        //  println(pivot)

        val indicesBool = head
                .map { s -> s.intersect(pivot).isNotEmpty() }
        //    print("indices bool: ")
        //   println(indicesBool)
        val indices = indicesBool.mapIndexed { ind, v -> if (v) ind else -1 }
                .filter { it != -1 }
        //  print("indices of head to be merged with the pivot: ")
        //  println(indices)
        val m: Set<Int> = indices.fold(setOf<Int>(), { accum, s -> accum + head[s] }) + pivot
        //       print("m: ")
        //      println(m)
        val rest: MutableList<Set<Int>> = head.filterIndexed { i, _ -> !indices.contains(i) }.toMutableList()
        rest.add(m)
        //     print("rest: ")
        //     println(rest)
        return merge(rest + tail, rest.size)

    }


}