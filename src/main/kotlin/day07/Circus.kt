package day07

import Answer
import java.io.File

class Circus : Answer {
    override fun showAnswer(): String {
        val branches =  readLines("day07.txt")
        return roots(branches.toTypedArray()).joinToString { it }
    }

    fun roots(branches: Array<String>): Set<String> {
        val roots = mutableSetOf<String>()
        val children = mutableSetOf<String>()
        for (branch in branches){
            val p = split(branch)
            if (!children.contains(p.first)){
                roots.add(p.first)
            }
            children.addAll(p.second)
            val falseRoots = roots.filter { children.contains(it) }
            falseRoots.forEach{  roots.remove(it)}
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
}