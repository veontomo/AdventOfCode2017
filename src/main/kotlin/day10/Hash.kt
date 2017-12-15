package day10

import Answer

class Hash : Answer {
    override fun showAnswer(): String {
        val input = intArrayOf(46, 41, 212, 83, 1, 255, 157, 65, 139, 52, 39, 254, 2, 86, 0, 204)
        val result = iterate(IntArray(256, { it }), input)
        val answer = result[0] * result[1]
        val answer2 = denseHash("46,41,212,83,1,255,157,65,139,52,39,254,2,86,0,204")
        return "0: ${result[0]}, 1: ${result[1]}, answer: $answer, hash: $answer2"
    }

    fun iterate(input: IntArray, blockSizes: IntArray, iterations: Int = 1): IntArray {
        var currentIndex = 0
        var offset = 0
        var arr = input
        val s = input.size
        repeat(iterations, {
            for (blockSize in blockSizes) {
                arr = reverseBlock(arr, currentIndex, blockSize)
                currentIndex = (currentIndex + blockSize + offset) % s
                offset = (offset + 1) % s
            }
        })
        return arr
    }

    fun reverseBlock(target: IntArray, blockStart: Int, blockLength: Int): IntArray {

        if (blockStart + blockLength > target.size) {
            val offset = blockStart + blockLength - target.size
            val longer = target.slice(blockStart..(target.size - 1)) + target.slice(0..(offset - 1))
            assert(longer.size == blockLength, { "1: wrong block size" })
            val longerReverse = longer.reversed()
            val part1 = longerReverse.slice((blockLength - offset)..(blockLength - 1))
            val part2 = target.slice(offset..(blockStart - 1))
            val part3 = longerReverse.slice(0..(-blockStart + target.size - 1))

            return (part1 + part2 + part3).toIntArray()
        } else {
            val block = target.slice(blockStart..(blockStart + blockLength - 1)).reversed()
            assert(block.size == blockLength, { "2: wrong block size" })
            return (target.slice(0..(blockStart - 1))
                    + block
                    + target.slice((blockStart + blockLength)..(target.size - 1))).toIntArray()
        }
    }

    fun denseHash(blockSizes: String): String {
        val lengths = blockSizes.toCharArray().map { it.toInt() }.toIntArray() + intArrayOf(17, 31, 73, 47, 23)
        val hashTmp = iterate(IntArray(256, { it }), lengths, 64)
        val blocks = (0..15).map { it -> hashTmp.slice((it * 16)..(it * 16 + 15)) }
                .map {
                    xor(it)
                }
                .map {
                    it.toString(16).padStart(2, '0')

                }


        return blocks.joinToString(separator = "", transform = { it.toString() })
    }

    fun xor(input: List<Int>): Int {
        val s = input.size
        var result = input[0].xor(input[1])
        assert(result > 0, { "xor is negative" })
        for (i in 2..s - 1) {
            result = result.xor(input[i])
            assert(result >= 0, { "xor produces negative at step $i, number ${input[i]}: " + input.joinToString { it.toString() } + " -> " + result.toString() })
        }
        return result
    }
}