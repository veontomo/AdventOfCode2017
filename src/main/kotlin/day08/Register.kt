package day08

import Answer

class Register : Answer {

    private var max: Int = 0

    override fun showAnswer(): String {
        val instructions = readLines("day08.txt")
        val finalState = performInstructions(mapOf(), instructions, 0)
        return finalState.maxBy { it.value }.toString() + ", max value ever: $max"

    }

    private fun performInstructions(state: Map<String, Int>, instructions: List<String>, counter: Int): Map<String, Int> {
        val s = instructions.size
        if (counter >= s) {
            return state
        }
        val instruction = instructions[counter]
        val parts = instruction.split(Regex("\\s+"))
        check(parts.size == 7, { "instruction $instruction is not a valid one." })
        val registerName = parts[0]
        val operationName = parts[1]
        val operationValue = parts[2].toInt(10)
        check(parts[3] == "if", { "instruction $instruction has invalid if statement." })
        val conditionalRegister = parts[4]
        val conditionalOperation = parts[5]
        val conditionalValue = parts[6].toInt(10)
        val newState = state.toMutableMap()
        if (!newState.containsKey(registerName)) {
            newState.put(registerName, 0)
        }
        if (!newState.containsKey(conditionalRegister)) {
            newState.put(conditionalRegister, 0)
        }
        val registerOldValue = newState.get(registerName)!!
        val conditionalRegisterValue = newState.get(conditionalRegister)!!
        val cond = when (conditionalOperation) {
            ">" -> conditionalRegisterValue > conditionalValue
            "<" -> conditionalRegisterValue < conditionalValue
            "==" -> conditionalRegisterValue == conditionalValue
            "!=" -> conditionalRegisterValue != conditionalValue
            ">=" -> conditionalRegisterValue >= conditionalValue
            "<=" -> conditionalRegisterValue <= conditionalValue
            else -> throw RuntimeException("Unknown condition: $conditionalOperation")
        }
        if (cond) {
            val newValue = when (operationName) {
                "inc" -> registerOldValue + operationValue
                "dec" -> registerOldValue - operationValue
                else -> throw RuntimeException("Unknown operation: $operationName")
            }
            newState[registerName] = newValue

            if (newValue > max) {
                max = newValue
            }
        }
        return performInstructions(newState, instructions, counter + 1)
    }


}