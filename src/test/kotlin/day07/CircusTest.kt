package day07

import org.junit.Test

import org.junit.Assert.*

class CircusTest {

    @Test
    fun splitSingleChild() {
        val c = Circus()
        val result = c.split("root")
        assertEquals("root", result.first)
        assertTrue(result.second.isEmpty())
    }

    @Test
    fun splitSingleChildWithWeight() {
        val c = Circus()
        val result = c.split("xyz (2332)")
        assertEquals("xyz", result.first)
        assertTrue(result.second.isEmpty())
    }

    @Test
    fun splitBranchWithWeightAndSingleChild() {
        val c = Circus()
        val result = c.split("xyz (2332) -> abc")
        assertEquals("xyz", result.first)
        assertEquals(1, result.second.size)
        assertTrue(result.second.contains("abc"))
    }

    @Test
    fun splitBranchWithWeightAndThreeChildren() {
        val c = Circus()
        val result = c.split("fgh (32) -> abc, qqq, www")
        assertEquals("fgh", result.first)
        assertEquals(3, result.second.size)
        assertTrue(result.second.contains("abc"))
        assertTrue(result.second.contains("qqq"))
        assertTrue(result.second.contains("www"))
    }

    @Test
    fun splitToTripleNoChildren() {
        val c = Circus()
        assertEquals(Triple("root", 10, setOf<String>()), c.splitToTriple("root (10)"))
    }

    @Test
    fun splitToTripleSingleChild() {
        val c = Circus()
        assertEquals(Triple("abc", 233, setOf<String>("xyzw")), c.splitToTriple("abc (233) -> xyzw"))
    }

    @Test
    fun splitToTripleThreeChildren() {
        val c = Circus()
        assertEquals(
                Triple("vcezyqj", 8443, setOf("luxlkxu", "dpmsnm", "yxfyvw")),
                c.splitToTriple("vcezyqj (8443) -> luxlkxu, dpmsnm, yxfyvw"))
    }
}