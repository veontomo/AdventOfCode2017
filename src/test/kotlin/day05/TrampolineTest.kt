package day05

import org.junit.Test

import org.junit.Assert.*

class TrampolineTest {

    @Test
    fun `0 3 0 1 -3 falls out in five jumps`() {
        val c = Trampoline()
        assertEquals(5, c.move(arrayOf(0, 3, 0, 1, -3),0, 0))
    }
    @Test
    fun `0 3 0 1 -3 falls out in 10 strange jumps`() {
        val c = Trampoline()
        assertEquals(10, c.moveStrange(arrayOf(0, 3, 0, 1, -3),0, 0))
    }
}