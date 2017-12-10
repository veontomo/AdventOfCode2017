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
    fun iterateMulti(){
        val c = Hash()
        assertArrayEquals(intArrayOf(3, 4, 2, 1, 0), c.iterate(intArrayOf(0, 1, 2, 3, 4), intArrayOf(3, 4, 1, 5)))
    }
}