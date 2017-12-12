package day10

import org.junit.Test

import org.junit.Assert.*

class HashTest {

    @Test
    fun reverseFirstIteration() {
        val c = Hash()
        assertArrayEquals(intArrayOf(2, 1, 0, 3, 4), c.reverseBlock(intArrayOf(0, 1, 2, 3, 4), 0, 3))
    }

    @Test
    fun reverseSecondIteration() {
        val c = Hash()
        assertArrayEquals(intArrayOf(4, 3, 0, 1, 2), c.reverseBlock(intArrayOf(2, 1, 0, 3, 4), 3, 4))
    }

    @Test
    fun reverseThirdIteration() {
        val c = Hash()
        assertArrayEquals(intArrayOf(4, 3, 0, 1, 2), c.reverseBlock(intArrayOf(4, 3, 0, 1, 2), 2, 1))
    }

    @Test
    fun reverseFourthIteration() {
        val c = Hash()
        assertArrayEquals(intArrayOf(3, 4, 2, 1, 0), c.reverseBlock(intArrayOf(4, 3, 0, 1, 2), 1, 5))
    }

    @Test
    fun iterateMulti() {
        val c = Hash()
        val result = c.iterate(intArrayOf(0, 1, 2, 3, 4), intArrayOf(3, 4, 1, 5), 1)
        println(result.joinToString { it.toString() })
        assertArrayEquals(intArrayOf(3, 4, 2, 1, 0), result)
    }

    @Test
    fun hashEmptyString() {
        val c = Hash()
        assertEquals("a2582a3a0e66e6e86e3812dcb672a272", c.denseHash(""))

    }

    @Test
    fun hashAoC() {
        val c = Hash()
        assertEquals("33efeb34ea91902bb2f59c9920caa6cd", c.denseHash("AoC 2017"))
    }

    @Test
    fun hash123() {
        val c = Hash()
        assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", c.denseHash("1,2,3"))
    }

    @Test
    fun hash124() {
        val c = Hash()
        assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", c.denseHash("1,2,4"))
    }

    @Test
    fun xorTest() {
        val c = Hash()
        assertEquals(64, c.xor(listOf(65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22)))
    }

    @Test
    fun hashrimbuod() {
        val c = Hash()
        assertEquals("044392e3fec2fac3209c2f5c22717cd3", c.denseHash("rimbuod"))
    }

    @Test
    fun hashRimbuod() {
        val c = Hash()
        assertEquals("46093e85204d0b5f2372895c515cbbff", c.denseHash("Rimbuod"))
    }

    @Test
    fun hashRIMBUOD() {
        val c = Hash()
        assertEquals("8279c6a413685a576570b14906c73bf8", c.denseHash("RIMBUOD"))
    }
}

