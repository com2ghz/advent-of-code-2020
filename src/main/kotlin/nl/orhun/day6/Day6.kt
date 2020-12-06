package nl.orhun.day6

import nl.orhun.Puzzle

fun main() {
    Day6.partOne()
    Day6.partTwo()
}
object Day6 : Puzzle() {
    private val data = readString(2020, 6)

    override fun partOne() {
        val sum = data.split("\n\n")
            .map { it.split("\n") }
            .map { group ->
                group.map { it.toList() }
                    .flatten()
                    .distinct()
                    .size
            }.sum()
        println(sum)
    }

    override fun partTwo() {
    }
}