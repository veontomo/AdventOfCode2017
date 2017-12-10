package day07

class Forest(t: Set<Tree>) {

    private var treesInternal = t.toMutableSet()

    var trees: MutableSet<Tree> = treesInternal
        get() = treesInternal

    fun add(tree: Tree) {
        treesInternal.add(tree)
    }

}