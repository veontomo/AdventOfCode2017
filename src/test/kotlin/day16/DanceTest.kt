package day16

import org.junit.Test

import org.junit.Assert.*

class DanceTest {

    @Test
    fun changeStateSpin() {
        val c = Dance()
        assertEquals("cdeab", c.changeState("abcde", "s3"))
    }

    @Test
    fun changeStateExchange() {
        val c = Dance()
        assertEquals("eabdc", c.changeState("eabcd", "x3/4"))
    }

    @Test
    fun changeStatePartner() {
        val c = Dance()
        assertEquals("baedc", c.changeState("eabdc", "pe/b"))
    }
}