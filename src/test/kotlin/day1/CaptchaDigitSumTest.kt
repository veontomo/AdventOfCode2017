package day1

import org.junit.Test

import org.junit.Assert.*

class CaptchaDigitSumTest {

    /**
     * Test suit for summing the matching digits.
     * Partition the input as follows:
     * 1. the length: 0, 1, 2, > 1
     * 2. the first digit contributes: true, false
     * 3. the before-last digit contributes: true, false
     * 4. the last digit contributes: true, false
     */

    /**
     * Cover:
     * 1. the length: 0
     */
    @Test
    fun `return zero for empty list`() {
        val c = CaptchaDigitSum()
        assertEquals(0, c.sum(""))
    }

    /**
     * Cover:
     * 1. the length: 1
     * 2. the first digit contributes: true
     */
    @Test
    fun `return the digit value for a single element list`() {
        val c = CaptchaDigitSum()
        assertEquals(5, c.sum("5"))
    }

    /**
     * Cover:
     * 1. the length: 2
     * 2. the first digit contributes: false
     */
    @Test
    fun `return zero for 2-elem list of different digits`() {
        val c = CaptchaDigitSum()
        assertEquals(0, c.sum("34"))
    }

    /**
     * Cover:
     * 1. the length: 2
     * 2. the first digit contributes: true
     */
    @Test
    fun `return sum of the digits for 2-elem list of equal digits`() {
        val c = CaptchaDigitSum()
        assertEquals(14, c.sum("77"))
    }

    /**
     * Cover:
     * 1. the length: > 1
     * 2. the first digit contributes: true
     * 3. the before-last digit contributes: true
     * 4. the last digit contributes: true
     */
    @Test
    fun `return 3 when input is 1122`() {
        val c = CaptchaDigitSum()
        assertEquals(3, c.sum("1122"))
    }

    /**
     * Cover:
     * 1. the length: > 1
     * 2. the first digit contributes: true
     * 3. the before-last digit contributes: true
     * 4. the last digit contributes: true
     */
    @Test
    fun `return 4 when input is 1111`() {
        val c = CaptchaDigitSum()
        assertEquals(4, c.sum("1111"))
    }

    /**
     * Cover:
     * 1. the length: > 1
     * 2. the first digit contributes: false
     * 3. the before-last digit contributes: false
     * 4. the last digit contributes: false
     */
    @Test
    fun `return 0 when input is 1234`() {
        val c = CaptchaDigitSum()
        assertEquals(0, c.sum("1234"))
    }

    /**
     * Cover:
     * 1. the length: > 1
     * 2. the first digit contributes: false
     * 3. the before-last digit contributes: false
     * 4. the last digit contributes: false
     */
    @Test
    fun `return 9 when input is 91212129`() {
        val c = CaptchaDigitSum()
        assertEquals(9, c.sum("91212129"))
    }
}