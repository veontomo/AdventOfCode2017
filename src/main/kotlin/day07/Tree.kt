package day07

class Tree(val name: String, val weight: Int, val children: Set<String> = setOf()) {


    /**
     * Return a sub-tree  with given name or null if no such sub-tree exists.
     */
    fun find(name: String): Tree? {
        if (this.name == name) {
            return this
        }
        return null
    }

}