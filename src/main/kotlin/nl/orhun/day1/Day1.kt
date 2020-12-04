package nl.orhun.day1

import nl.orhun.Puzzle
import kotlin.streams.toList

fun main() {
    Day1.partOne()
    Day1.partTwo()
}
object Day1 : Puzzle() {
    private val lines = readLines(2020, 1);

    override fun partOne() {
        val numbers = lines.stream()
            .mapToInt(Integer::parseInt)
            .toList()

        var result = 0;
        for (outer in numbers) {
            for (inner in numbers) {
                if (outer + inner == 2020) {
                    result = outer * inner
                    break
                }
            }
        }
        println(result);
    }

    override fun partTwo() {
        val numbers = lines.stream()
            .mapToInt(Integer::parseInt)
            .toList()

        var result = 0;
        for (firstValue in numbers) {
            for (secondValue in numbers) {
                for (thirdValue in numbers) {
                    if (firstValue + secondValue + thirdValue == 2020) {
                        result = firstValue * secondValue * thirdValue
                        break
                    }
                }
            }
        }
        println(result)
    }
}
