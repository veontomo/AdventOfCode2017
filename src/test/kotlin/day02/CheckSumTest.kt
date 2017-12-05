package day02

import org.junit.Test

import org.junit.Assert.*

class CheckSumTest {

    @Test
    fun checksum() {
        val multiline = arrayOf("5 1 9 5", "7 5 3", "2 4 6 8")
        val c = CheckSum()
        assertEquals(18, c.checksum(multiline))
    }

    @Test
    fun `5 9 2 8 return 4`() {
        val c = CheckSum()
        assertEquals(4, c.divisible("5 9 2 8"))
    }


    @Test
    fun `9 4 7 3 return 3`() {
        val c = CheckSum()
        assertEquals(3, c.divisible("9 4 7 3"))
    }

    @Test
    fun `3 8 6 5 return 2`() {
        val c = CheckSum()
        assertEquals(2, c.divisible("3 8 6 5"))
    }
}