package day09

import org.junit.Test

import org.junit.Assert.*

class StreamTest() {
    @Test
    fun `{}, score of 1`() {
        val c = Stream()
        assertEquals(1, c.score("{}").first)
    }

    @Test
    fun `{{{}}}, score of 1 + 2 + 3 = 6`() {
        val c = Stream()
        assertEquals(6, c.score("{{{}}}").first)
    }

    @Test
    fun `{{},{}}, score of 1 + 2 + 2 = 5`() {
        val c = Stream()
        assertEquals(5, c.score("{{}, {}}").first)
    }

    @Test
    fun `{{{},{},{{}}}}, score of 1 + 2 + 3 + 3 + 3 + 4 = 16`() {
        val c = Stream()
        assertEquals(16, c.score("{{{},{},{{}}}}").first)
    }

    @Test
    fun `single group with garbage`() {
        val input = "{<a>,<a>,<a>,<a>}"
        val c = Stream()
        assertEquals(1, c.score(input).first)
    }

    @Test
    fun `group with four nested  garbages`() {
        val input = "{{<ab>},{<ab>},{<ab>},{<ab>}}"
        val c = Stream()
        assertEquals(9, c.score(input).first)
    }

    @Test
    fun `group with comments`() {
        val input = "{{<!!>},{<!!>},{<!!>},{<!!>}}"
        val c = Stream()
        assertEquals(9, c.score(input).first)
    }

    @Test
    fun `group with comments 2`() {
        val input = "{{<a!>},{<a!>},{<a!>},{<ab>}}"
        val c = Stream()
        assertEquals(3, c.score(input).first)
    }

    @Test
    fun emptyAngleBrackets() {
        val input = "<>"
        val c = Stream()
        assertEquals(0, c.score(input).second)
    }

    @Test
    fun expressionInAngleBrackets() {
        val input = "<random characters>"
        val c = Stream()
        assertEquals(17, c.score(input).second)
    }

    @Test
    fun angleBrackets() {
        val input = "<<<<>"
        val c = Stream()
        assertEquals(3, c.score(input).second)
    }

    @Test
    fun singleJump() {
        val c = Stream()
        assertEquals(2, c.score("<{!>}>").second)
    }

    @Test
    fun twoJumps() {
        val c = Stream()
        assertEquals(0, c.score("<!!>").second)
    }

    @Test
    fun doubleJumps() {
        val c = Stream()
        assertEquals(0, c.score("<!!!>>").second)
    }

    @Test
    fun realistic() {
        val c = Stream()
        assertEquals(10, c.score("<{o\"i!a,<{i<a>").second)
    }

}