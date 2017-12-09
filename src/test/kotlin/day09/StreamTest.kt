package day09

import org.junit.Test

import org.junit.Assert.*

class StreamTest() {
    @Test
    fun `{}, score of 1`() {
        val c = Stream()
        assertEquals(1, c.score("{}"))
    }

    @Test
    fun `{{{}}}, score of 1 + 2 + 3 = 6`() {
        val c = Stream()
        assertEquals(6, c.score("{{{}}}"))
    }

    @Test
    fun `{{},{}}, score of 1 + 2 + 2 = 5`() {
        val c = Stream()
        assertEquals(5, c.score("{{}, {}}"))
    }

    @Test
    fun `{{{},{},{{}}}}, score of 1 + 2 + 3 + 3 + 3 + 4 = 16`() {
        val c = Stream()
        assertEquals(16, c.score("{{{},{},{{}}}}"))
    }

    @Test
    fun `single group with garbage`() {
        val input = "{<a>,<a>,<a>,<a>}"
        val c = Stream()
        assertEquals(1, c.score(input))
    }

    @Test
    fun `group with four nested  garbages`() {
        val input = "{{<ab>},{<ab>},{<ab>},{<ab>}}"
        val c = Stream()
        assertEquals(9, c.score(input))
    }

    @Test
    fun `group with comments`() {
        val input = "{{<!!>},{<!!>},{<!!>},{<!!>}}"
        val c = Stream()
        assertEquals(9, c.score(input))

    }

    @Test
    fun `group with comments 2`() {
        val input = "{{<a!>},{<a!>},{<a!>},{<ab>}}"
        val c = Stream()
        assertEquals(3, c.score(input))
    }
}