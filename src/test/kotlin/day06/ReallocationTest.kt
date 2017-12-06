package day06

import org.junit.Test

import org.junit.Assert.*

class ReallocationTest {

    @Test
    fun `0 2 7 0 becomes 2 4 1 2`() {
        val c = Reallocation()
        assertArrayEquals(intArrayOf(2, 4, 1, 2), c.distribute(intArrayOf(0, 2, 7, 0)))
    }

    @Test
    fun `2 4 1 2 becomes 3 1 2 3`() {
        val c = Reallocation()
        assertArrayEquals(intArrayOf(3, 1, 2, 3), c.distribute(intArrayOf(2, 4, 1, 2)))
    }

    @Test
    fun `3 1 2 3 becomes 0 2 3 4`() {
        val c = Reallocation()
        assertArrayEquals(intArrayOf(0, 2, 3, 4), c.distribute(intArrayOf(3, 1, 2, 3)))
    }


    @Test
    fun `0 2 3 4 becomes 1 3 4 1`() {
        val c = Reallocation()
        assertArrayEquals(intArrayOf(1, 3, 4, 1), c.distribute(intArrayOf(0, 2, 3, 4)))
    }

    @Test
    fun `1 3 4 1 becomes 2 4 1 2`() {
        val c = Reallocation()
        assertArrayEquals(intArrayOf(2, 4, 1, 2), c.distribute(intArrayOf(1, 3, 4, 1)))
    }

    @Test
    fun `split 7 over 3 slots with offset 0`() {
        val c = Reallocation()
        assertArrayEquals(intArrayOf(3, 2, 2), c.split(7, 3, 0))
    }

    @Test
    fun `split 4 over 6 slots with offset 0`() {
        val c = Reallocation()
        assertArrayEquals(intArrayOf(1, 1, 1, 1, 0, 0), c.split(4, 6, 0))
    }

    @Test
    fun `split 7 over 1 slots with offset 0`() {
        val c = Reallocation()
        assertArrayEquals(intArrayOf(7), c.split(7, 1, 0))
    }

    @Test
    fun `split 7 over 3 slots with offset 2`() {
        val c = Reallocation()
        val result = c.split(7, 3, 2)
        print(result.joinToString { it.toString() })
        assertArrayEquals(intArrayOf(2, 2, 3), c.split(7, 3, 2))
    }

    @Test
    fun `split 6 over 3 slots with offset 2`() {
        val c = Reallocation()
        val result = c.split(6, 3, 0)
        print(result.joinToString { it.toString() })
        assertArrayEquals(intArrayOf(2, 2, 2), result)
    }

    @Test
    fun `split 5 over 10 slots with offset 1`() {
        val c = Reallocation()
        val result = c.split(5, 10, 1)
        print(result.joinToString { it.toString() })
        assertArrayEquals(intArrayOf(0, 1, 1, 1, 1, 1, 0, 0, 0, 0), result)
    }

    @Test
    fun `loop 0 2 7 0 in five iterations`() {
        val c = Reallocation()
        val result = c.iterate(setOf(), arrayOf(0, 2, 7, 0).toIntArray(), 0)
        assertEquals(5, result)
    }

}