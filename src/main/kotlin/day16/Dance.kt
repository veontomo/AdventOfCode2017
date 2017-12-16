package day16

import Answer

class Dance : Answer {
    override fun showAnswer(): String {

        val initialState = ('a'..'p').joinToString(separator = "") { it.toString() }
        val commands = readLines("day16.txt")[0].split(",").map { it.trim() }
                .map { createCommand(initialState.length, it) }
        var currentState = initialState

        val cache = mutableListOf<String>()
        val big = 1000000000
        println("0: $currentState")
        while(!cache.contains(currentState)){
            cache.add(currentState)
            currentState = makeMoves(currentState, commands, commands.size, 0)
        }
        val size = cache.size
        val pos = cache.indexOf(currentState)
        val res = (big - pos) % size
        return "size: $size, pos = $pos, string: ${cache[res]}"
    }

    private fun createCommand(length: Int, command: String): Move {

        val commandName = command.first()
        val params = command.substring(1).split("/")
        return when (commandName) {
            's' -> Spin(length - params[0].toInt(10))
            'x' -> Exchange(params[0].toInt(10), params[1].toInt())
            'p' -> Partner(params[0], params[1])
            else -> throw RuntimeException("Unknown command name in command $command")
        }
    }

    tailrec fun makeMoves(state: String, commands: List<Move>, size: Int, pos: Int): String {
        if (pos >= size) {
            return state
        }
        val newState = commands[pos].execute(state)
        return makeMoves(newState, commands, size, pos + 1)
    }

    fun changeState(state: String, command: String): String {
        val commandName = command.first()
        val params = command.substring(1)
        return when (commandName) {
            's' -> spin(state, params)
            'x' -> exchange(state, params)
            'p' -> partner(state, params)
            else -> throw RuntimeException("Unknown command name in command $command")
        }

    }

    private fun partner(state: String, params: String): String {
        val paramNums = params.split("/").map { state.indexOf(it) }
        return exchangeByPos(state, paramNums)
    }

    private fun exchangeByPos(state: String, positions: List<Int>): String {
        assert(positions.size == 2, { "exchange positions must be exactly two!!!" })

        val chars = state.toCharArray().toMutableList()
        val c0 = state[positions[0]]
        val c1 = state[positions[1]]
        chars[positions[0]] = c1
        chars[positions[1]] = c0
        return chars.joinToString(separator = "") { it.toString() }
    }

    private fun exchange(state: String, params: String): String {
        val positions = params.split("/").map { it.toInt(10) }
        return exchangeByPos(state, positions)
    }

    private fun spin(state: String, params: String): String {
        val blockSize = params.toInt(10)
        val splitPos = state.length - blockSize
        val head = state.substring(0, splitPos)
        val tail = state.substring(splitPos)
        return tail + head
    }
}