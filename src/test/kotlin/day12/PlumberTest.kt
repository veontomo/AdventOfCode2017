package day12

import org.junit.Test

import org.junit.Assert.*

class PlumberTest {

    @Test
    fun merge() {
        val c = Plumber()
        val result = c.merge(listOf(setOf(0, 2), setOf(1), setOf(2, 0, 3, 4), setOf(3, 2, 4),
                setOf(4, 2, 3, 6), setOf(5, 6), setOf(6, 4, 5)), 1)
        println(result)
        assertEquals(2, result.size)
        assertFalse(result[0].size == result[1].size)
    }
}