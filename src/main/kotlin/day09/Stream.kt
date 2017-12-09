package day09

import Answer

class Stream : Answer {
    override fun showAnswer(): String {
        val input = readLines("day09.txt")
        return score(input[0]).toString()
    }

    fun score(input: String): Int {
        return process(input, 0, 0, 0, 0, false)
    }

    tailrec private fun process(input: String, pos: Int, depth: Int, totalScore: Int, prevGroupScore: Int, isGarbage: Boolean): Int {
        val s = input.length
        if (pos >= s) {
            check(depth == 0, { "unexpected end of input. Unclosed group are present." })
            return totalScore
        }
        val character = input[pos]
        if (isGarbage) {
            val jump = if(character == '!') 2 else 1
            return process(input, pos + jump, depth, totalScore, prevGroupScore, character != '>')
        }
        assert(!isGarbage, {"should be not garbage at this point"})
        return when (character) {
            '{' -> process(input, pos + 1, depth + 1, totalScore, prevGroupScore + 1, isGarbage)
            '}' -> process(input, pos + 1, depth - 1, totalScore + prevGroupScore, prevGroupScore - 1, isGarbage)
            '<' -> process(input, pos + 1, depth, totalScore, prevGroupScore, true)
            '!' -> process(input, pos + 2, depth, totalScore, prevGroupScore, isGarbage)
            else -> process(input, pos + 1, depth, totalScore, prevGroupScore, isGarbage)
        }

    }

}