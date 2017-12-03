package day03

import org.junit.Test

import org.junit.Assert.*

class SpiralMemoryTest {

    /**
     * Test suit for getting the spiral coordinates
     * Partition the input as follows:
     * 1. direction: Left, Right, Up, Down
     * 2. position on the branch: start, middle
     */

    /**
     * Cover
     * 1. direction: Right
     * 2. position: start
     */
    @Test
    fun `return (-1, -1) when input is 7`() {
        val c = SpiralMemory()
        assertEquals(Pair(-1, -1), c.coordinate(7))
    }

    /**
     * Cover
    .     * 1. direction: Right
     * 2. position: middle
     */
    @Test
    fun `return (1, -2) when input is 24`() {
        val c = SpiralMemory()
        assertEquals(Pair(1, -2), c.coordinate(24))
    }

    /**
     * Cover
     * 1. direction: Up
     * 2. position: start
     */
    @Test
    fun `return (2, -1) when input is 10`() {
        val c = SpiralMemory()
        assertEquals(Pair(2, -1), c.coordinate(10))
    }


    /**
     * Cover
     * 1. direction: Up
     * 2. position: middle
     */
    @Test
    fun `return (1, -2) when input is 11`() {
        val c = SpiralMemory()
        assertEquals(Pair(2, 0), c.coordinate(11))
    }

    /**
     * Cover
     * 1. direction: Down
     * 2. position: start
     */
    @Test
    fun `return (-2, 2) when input is 17`() {
        val c = SpiralMemory()
        assertEquals(Pair(-2, 2), c.coordinate(17))
    }


    /**
     * Cover
     * 1. direction: Down
     * 2. position: middle
     */
    @Test
    fun `return (-1, 0) when input is 6`() {
        val c = SpiralMemory()
        assertEquals(Pair(-1, 0), c.coordinate(6))
    }

    /**
     * Cover
     * 1. direction: Left
     * 2. position: start
     */
    @Test
    fun `return (2, -1) when input is 13`() {
        val c = SpiralMemory()
        assertEquals(Pair(2, 2), c.coordinate(13))
    }


    /**
     * Cover
     * 1. direction: Left
     * 2. position: middle
     */
    @Test
    fun `return (0, 1) when input is 2`() {
        val c = SpiralMemory()
        assertEquals(Pair(1, 0), c.coordinate(2))
    }
}