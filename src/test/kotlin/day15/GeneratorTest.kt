package day15

import org.junit.Test

import org.junit.Assert.*

class GeneratorTest {

    @Test
    fun firstValue() {
        val g = Generator(65, 16807)
        assertEquals(1092455, g.nextValue())
    }

    @Test
    fun secondValue() {
        val g = Generator(65, 16807)
        g.nextValue()
        assertEquals(1181022009, g.nextValue())
    }

    @Test
    fun thirdValue() {
        val g = Generator(65, 16807)
        repeat(2, { g.nextValue() })
        assertEquals(245556042, g.nextValue())
    }

    @Test
    fun fourthValue() {
        val g = Generator(65, 16807)
        repeat(3, { g.nextValue() })
        assertEquals(1744312007, g.nextValue())
    }

    @Test
    fun fifthValue() {
        val g = Generator(65, 16807)
        repeat(4, { g.nextValue() })
        assertEquals(1352636452, g.nextValue())
    }
}