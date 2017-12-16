package day16


interface Move {
    fun execute(state: String): String
}

class Spin(private val s: Int) : Move {
    override fun execute(state: String): String {
        val head = state.substring(0, s)
        val tail = state.substring(s)
        return tail + head
    }
}

class Exchange(private val pos1: Int, private val pos2: Int) : Move {
    override fun execute(state: String): String {
        val chars = state.toCharArray().toMutableList()
        val c0 = state[pos1]
        val c1 = state[pos2]
        chars[pos1] = c1
        chars[pos2] = c0
        return chars.joinToString(separator = "") { it.toString() }
    }
}

class Partner(private val name1: String, private val name2: String) : Move {
    override fun execute(state: String): String {
        val pos1 = state.indexOf(name1)
        val pos2 = state.indexOf(name2)
        val chars = state.toCharArray().toMutableList()
        val c0 = state[pos1]
        val c1 = state[pos2]
        chars[pos1] = c1
        chars[pos2] = c0
        return chars.joinToString(separator = "") { it.toString() }
    }

}

