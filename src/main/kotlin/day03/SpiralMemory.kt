package day03

import Answer
import java.lang.Math.abs

/**
 * Third day of advent of code.
 *
 * --- Day 3: Spiral Memory ---
 *
 * You come across an experimental new kind of memory stored on an infinite two-dimensional grid.
 *
 * Each square on the grid is allocated in a spiral pattern starting at a location marked 1 and then counting up while spiraling outward. For example, the first few squares are allocated like this:
 *
 * 17  16  15  14  13
 * 18   5   4   3  12
 * 19   6   1   2  11
 * 20   7   8   9  10
 * 21  22  23---> ...
 * While this is very space-efficient (no squares are skipped), requested data must be carried back to square 1 (the location of the only access port for this memory system) by programs that can only move up, down, left, or right. They always take the shortest path: the Manhattan Distance between the location of the data and square 1.
 *
 * For example:
 *
 * Data from square 1 is carried 0 steps, since it's at the access port.
 * Data from square 12 is carried 3 steps, such as: down, left, left.
 * Data from square 23 is carried only 2 steps: up twice.
 * Data from square 1024 must be carried 31 steps.
 */
class SpiralMemory : Answer {
    enum class Direction { Left, Right, Up, Down }

    val moveOrder = mapOf(Direction.Left to Direction.Down,
            Direction.Down to Direction.Right,
            Direction.Right to Direction.Up,
            Direction.Up to Direction.Left)

    override fun showAnswer(): String {
        val steps = 347991
        val (x, y) = move(Pair(0, 0), Direction.Right, 1, 0, steps - 1)
        val dist = abs(x) + abs(y)
        return "$steps -> ($x, $y) -> $dist"
    }

    fun coordinate(num: Int): Pair<Int, Int> {
        return move(Pair(0, 0), Direction.Right, 1, 0, num - 1)

    }

    /**
     * Return a Euclidean coordinate after given number of steps along the spiral.
     * The center of the spiral corresponds to the origin (0, 0).
     *
     * The position on the spiral is completely defined by the following data:
     * 1. current (x, y) coordinate
     * 2. direction of the current move
     * 3. the length of the branch (the branches becomes longer after finishing vertical branches)
     * 4. distance btw the current branch start point and the current position
     */
    tailrec private fun move(coord: Pair<Int, Int>,
                             d: Direction,
                             branchLength: Int,
                             posOnBranch: Int,
                             remainingSteps: Int): Pair<Int, Int> {
        if (remainingSteps == 0) {
            return coord
        }
        val newPos = posOnBranch + 1
        val shift = displacementVector(d)
        val newCoord = Pair(coord.first + shift.first, coord.second + shift.second)
        if (newPos < branchLength) {
            return move(newCoord, d, branchLength, newPos, remainingSteps - 1)
        }
        val newDirection = moveOrder[d]!!
        val extra = if (isHorizontal(newDirection)) 1 else 0
        return move(newCoord, newDirection, branchLength + extra, 0, remainingSteps - 1)
    }


    private fun isHorizontal(d: Direction): Boolean {
        return d == Direction.Right || d == Direction.Left
    }

    /**
     * Gives the displacement vector (direction of the next move for a location
     * on a given branch
     * @param d
     */
    private fun displacementVector(d: SpiralMemory.Direction): Pair<Int, Int> {
        return when (d) {
            Direction.Right -> Pair(1, 0)
            Direction.Left -> Pair(-1, 0)
            Direction.Down -> Pair(0, -1)
            Direction.Up -> Pair(0, 1)
        }
    }

}