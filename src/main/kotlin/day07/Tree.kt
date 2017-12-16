package day07

class Tree(val name: String, val weight: Int, val children: Set<Tree> = setOf()) {

    fun totalWeight(): Int = weight + childWeights()


    fun childWeights() = children.map { it.totalWeight() }.sum()

    fun getChildByName(name: String): Tree? {
        return children.first { it.name == name }
    }
}