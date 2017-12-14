package day13

import org.junit.Test

import org.junit.Assert.*

class FirewallTest {

    @Test
    fun calculate() {
        val c = Firewall()
        assertEquals(24, c.calculate(intArrayOf(3, 2, 0, 0, 4, 0, 4)))

    }

    @Test
    fun findOffset() {
        val c = Firewall()
        assertEquals(0, c.calculate(intArrayOf(3, 2, 0, 0, 4, 0, 4), 10))
    }
}
