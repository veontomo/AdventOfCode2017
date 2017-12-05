import day01.CaptchaDigitSum
import day02.CheckSum
import day03.SpiralMemory
import day04.Passphrase
import day05.Trampoline

/**
 * This is a solution to the advent of code 2017 problems.
 * @see http://adventofcode.com/2017
 */
fun main(v: Array<String>) {
    println(CaptchaDigitSum().showAnswer())
    println(CheckSum().showAnswer())
    println(SpiralMemory().showAnswer())
    println(Passphrase().showAnswer())

    println(Trampoline().showAnswer())
}
