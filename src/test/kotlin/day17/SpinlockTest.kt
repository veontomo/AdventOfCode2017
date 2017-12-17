package day17

import org.junit.Test

import org.junit.Assert.*

class SpinlockTest {

    @Test
    fun insert() {
        val c = Spinlock()
        assertEquals(listOf(0, 1), c.insert(listOf(0), 3, 1, 0, 1))
    }

    @Test
    fun insert2() {
        val c = Spinlock()
        assertEquals(listOf(0, 2, 3, 1), c.insert(listOf(0), 3, 1, 0, 3))
    }
}