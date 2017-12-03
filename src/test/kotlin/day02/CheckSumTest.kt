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
}