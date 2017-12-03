package day1

/**
 * First day of advent of code.
 */
class CaptchaDigitSum {

    /**
     * Calculates the sum of all digits that match the next digit in the list.
     * The captcha requires you to review a sequence of digits (your puzzle input)
     * and find the sum of all digits that match the next digit in the list.
     * The list is circular, so the digit after the last digit is the first digit in the list.
     * @param input digits given as a string
     * @return integer
     */
    fun sum(input: String): Int {
        val digits = ((input + if (input.isNotEmpty()) input.first().toString() else "")
                .toCharArray())
                .map { it.toString().toInt() }
        val size = digits.size
        return digits.foldIndexed(0, {i, acc, c -> acc + if (i < size-1 && c == digits[i+1]) c else 0 } )
    }


}