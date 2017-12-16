package day15

import java.math.BigInteger

class Generator(val start: Long, val factor: Long, val m: Long = 1) {
    private val mod = 2147483647

    private var next = start

    fun nextValue(): Long {
        do {
            next = (next * factor) % mod
        } while (next % m != 0L)
        return next
    }
}