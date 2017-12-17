package day17

import Answer

class Spinlock : Answer {
    override fun showAnswer(): String {
//        val data = insert(listOf(0), 354, 1, 0, 2017)
//        val index = data.indexOf(2017)
//        return data.slice((index - 1)..(index + 3)).joinToString { it.toString() }
        val data = insert2(listOf(0), 354, 1, 0, 50000000)
        return data.joinToString { it.toString() }
    }


    tailrec fun insert(numbers: List<Int>, jumpSize: Int, numberToInsert: Int, currentPos: Int, maxNum: Int): List<Int> {
        if (numberToInsert > maxNum) {
            return numbers
        }
        val size = numbers.size
        val newPos = (currentPos + jumpSize) % size + 1
        if (newPos == 1) {
            println("inserting at pos 1: $numberToInsert")
        }
        val newNumbers = numbers.toMutableList()
        newNumbers.add(newPos, numberToInsert)
        return insert(newNumbers, jumpSize, numberToInsert + 1, newPos, maxNum)
    }

    tailrec fun insert2(firstNumbers: List<Int>, jumpSize: Int, numberToInsert: Int, currentPos: Int, maxNum: Int): List<Int> {
        if (numberToInsert > maxNum) {
            return firstNumbers
        }
        val size = numberToInsert
        val newPos = (currentPos + jumpSize) % size + 1
        val newNumbers =  if (newPos == 1) {
            listOf(firstNumbers[0], numberToInsert)
        } else firstNumbers
        return insert2(newNumbers, jumpSize, numberToInsert + 1, newPos, maxNum)
    }
}