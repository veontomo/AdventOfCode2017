package day11

import org.junit.Test

import org.junit.Assert.*

class HexTest {

    @Test
    fun coordSameDir() {
        val c = Hex()
        assertEquals(Pair(0, 3), c.pathToCoord(listOf("NE", "NE", "NE"), Pair(0, 0), 0))
    }

    @Test
    fun coordTwoStepsTheSamePlace() {
        val c = Hex()
        assertEquals(Pair(0, 0), c.pathToCoord(listOf("NE", "NE", "SW", "SW"), Pair(0, 0), 0))
    }

    @Test
    fun pathTwoSteps() {
        val c = Hex()
        assertEquals(Pair(2, 0), c.pathToCoord(listOf("NE", "NE", "S", "S"), Pair(0, 0), 0))
    }

    @Test
    fun pathAngles() {
        val c = Hex()
        assertEquals(Pair(2, -3), c.pathToCoord(listOf("SE", "SW", "SE", "SW", "SW"), Pair(0, 0), 0))
    }
}
