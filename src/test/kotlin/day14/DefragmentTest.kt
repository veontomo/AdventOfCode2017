package day14

import org.junit.Test

import org.junit.Assert.*

class DefragmentTest {

    @Test
    fun toBinary() {
        val c = Defragment()
        assertEquals("1010000011000010000000010111",
                c.toBinary("a0c2017"))
    }

    @Test
    fun sumBits() {
        val c = Defragment()
        assertEquals(3, c.sumBits("0010001001"))
    }

    @Test
    fun clustersEmpty() {
        val c = Defragment()
        assertTrue(c.clusters(setOf()).isEmpty())
    }

    @Test
    fun clustersSingleElem() {
        val c = Defragment()
        assertEquals(setOf(setOf(Pair(1, 1))), c.clusters(setOf(Pair(1, 1))))
    }

    @Test
    fun clustersThreeElemOneCluster() {
        val c = Defragment()
        val map = setOf(Pair(1, 2), Pair(2, 1), Pair(2, 2), Pair(2, 5), Pair(2, 6), Pair(3, 4), Pair(4, 3), Pair(4, 5), Pair(5, 2), Pair(5, 3), Pair(5, 4), Pair(5, 5), Pair(6, 3))
        assertEquals(
                setOf(
                        setOf(Pair(1, 2), Pair(2, 1), Pair(2, 2)),
                        setOf(Pair(3, 4)),
                        setOf(Pair(2, 5), Pair(2, 6)),
                        setOf(Pair(4, 3), Pair(4, 5), Pair(5, 2), Pair(5, 3), Pair(5, 4), Pair(5, 5), Pair(6, 3))
                ),
                c.clusters(map))
    }
}
