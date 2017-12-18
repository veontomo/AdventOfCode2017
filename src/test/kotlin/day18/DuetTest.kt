package day18

import org.junit.Test

import org.junit.Assert.*

class DuetTest {

    @Test
    fun elaborate() {
        val input = listOf("set a 1", "add a 2", "mul a a", "mod a 5", "snd a", "set a 0",
                "rcv a", "jgz a -1", "set a 1", "jgz a -2").map { it.split(Regex("\\s+")) }
        val c = Duet()
        assertEquals(4, c.elaborate(mapOf(), input, 0, 0))
    }
}