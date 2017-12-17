package day07

import Answer

class Circus : Answer {
    override fun showAnswer(): String {
        val branches = readLines("day07.txt")
        val input = branches.map { splitToTriple(it) }
                .map { Pair(it.first, Pair(it.second, it.third)) }
                .toMap()
        val r = roots(branches.toTypedArray())
        assert(r.size == 1, { "found roots: ${r.joinToString { it }}" })
        val tree = createFullTree(r.first(), input)

        tree.children.forEach { it ->
            println("${it.name}: ${it.totalWeight()}")
        }
        tree.getChildByName("zklwp")!!.children.forEach {
            println("${it.name}: ${it.totalWeight()}")
        }
        val culprit = tree.getChildByName("zklwp")!!.getChildByName("lahahn")!!.getChildByName("utnrb")!!
        println("tree utnrb proper weight: ${culprit.weight}")

        culprit.children.forEach {
            println("${it.name}: ${it.totalWeight()}")
        }
        return "tree: ${tree.children.size}, child weights: ${tree.childWeights()}"
    }

    fun createFullTree(name: String, branches: Map<String, Pair<Int, Set<String>>>): Tree {
        val weight = branches[name]!!.first
        val children = branches[name]!!.second.map { it -> createFullTree(it, branches) }.toSet()
        return Tree(name, weight, children)
    }

    fun roots(branches: Array<String>): Set<String> {
        val roots = mutableSetOf<String>()
        val children = mutableSetOf<String>()
        for (branch in branches) {
            val p = split(branch)
            if (!children.contains(p.first)) {
                roots.add(p.first)
            }
            children.addAll(p.second)
            val falseRoots = roots.filter { children.contains(it) }
            falseRoots.forEach { roots.remove(it) }
        }
        return roots
    }

    fun split(branch: String): Pair<String, Set<String>> {
        val parts = branch.split(Regex("->"))
        val s = parts.size
        if (s == 0 || s > 2) {
            println("Line $branch has unsupported format")
            throw RuntimeException("Unexpected line format")
        }
        val root = parts[0].trim().replace(Regex("[(]\\d+[)]"), "").trim()
        val children = if (s == 2) {
            parts[1].trim().split(Regex(",\\s*")).toSet()
        } else setOf()
        return Pair(root, children)

    }

    fun splitToTriple(branch: String): Triple<String, Int, Set<String>> {
        val pattern = Regex("(\\w+)\\s+\\((\\d+)\\)(\\s+->(.*?))?")
        val res = pattern.matchEntire(branch)
        val groups = res!!.groupValues
        assert(groups.size == 5, { "branch $branch has wrong format." })

        val name = groups[1]
        val weight = groups[2].toInt(10)
        val children = if (groups.size == 5) groups[4].split(",").map { it.trim() }.filter { it.isNotEmpty() }.toSet() else setOf()
        return Triple(name, weight, children)
    }
}