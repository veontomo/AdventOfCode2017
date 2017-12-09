package day09

import Answer

class Stream : Answer {


    override fun showAnswer(): String {
        val input = readLines("day09.txt")
        val result = score(input[0])
        return "score: ${result.first}, garbage length: ${result.second}"
    }

    fun score(input: String): Pair<Int, Int> {
        return process(input, 0, 0, 0, 0, false, 0)
    }

    tailrec private fun process(input: String,
                                pos: Int,
                                depth: Int,
                                totalScore: Int,
                                prevGroupScore: Int,
                                isGarbage: Boolean,
                                garbageLength: Int
    ): Pair<Int, Int> {
        val s = input.length
        if (pos >= s) {
            check(depth == 0, { "unexpected end of input. Unclosed group are present." })
            return Pair(totalScore, garbageLength)
        }
        val character = input[pos]
        if (isGarbage) {
            val isGarbageEnd = character == '>'
            val shouldJump = character == '!'
            val jump = if (shouldJump) 2 else 1
            val count = if (shouldJump || isGarbageEnd) 0 else 1

            return process(input, pos + jump, depth, totalScore, prevGroupScore, !isGarbageEnd, garbageLength + count)
        }
        assert(!isGarbage, { "should be not garbage at this point" })
        return when (character) {
            '{' -> process(input, pos + 1, depth + 1, totalScore, prevGroupScore + 1, isGarbage, garbageLength)
            '}' -> process(input, pos + 1, depth - 1, totalScore + prevGroupScore, prevGroupScore - 1, isGarbage, garbageLength)
            '<' -> process(input, pos + 1, depth, totalScore, prevGroupScore, true, garbageLength)
            '!' -> process(input, pos + 1, depth, totalScore, prevGroupScore, isGarbage, garbageLength)
            else -> process(input, pos + 1, depth, totalScore, prevGroupScore, isGarbage, garbageLength)
        }

    }

}