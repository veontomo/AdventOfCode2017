package day07

import org.junit.Test

import org.junit.Assert.*

class ForestTest {

    @Test
    fun getTrees() {
        val forest = Forest(setOf())
        forest.add(Tree("pbga", 66))
        forest.add(Tree("xhth", 57))
        forest.add(Tree("ebii", 61))
        forest.add(Tree("havc", 66))
        forest.add(Tree("ktlj", 57))
        forest.add(Tree("fwft", 72, setOf("ktlj", "cntj", "xhth")))
        forest.add(Tree("qoyq", 66))
        forest.add(Tree("padx", 45, setOf("pbga", "havc", "qoyq")))
        forest.add(Tree("padx", 45, setOf("pbga", "havc", "qoyq")))
        forest.add(Tree("tknk", 41, setOf("ugml", "padx", "fwft")))
        forest.add(Tree("jptl", 61))
        forest.add(Tree("ugml", 68, setOf("gyxo", "ebii", "jptl")))
        forest.add(Tree("gyxo", 61))
        forest.add(Tree("cntj", 57))

        assertEquals(1, forest.trees.size)
        assertEquals("tknk", forest.trees.first().name)

    }

}