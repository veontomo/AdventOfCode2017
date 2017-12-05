package day05

import org.junit.Test

import org.junit.Assert.*

class TrampolineTest {

    @Test
    fun `0 3 0 1 -3 returns 5`() {
        val c = Trampoline()
        assertEquals(5, c.move(arrayOf(0, 3, 0, 1, -3),0, 0))
    }
}