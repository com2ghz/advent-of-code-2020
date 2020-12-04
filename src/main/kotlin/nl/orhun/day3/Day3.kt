package nl.orhun.day3

import nl.orhun.Puzzle

fun main() {
    Day3.partOne()
    Day3.partTwo()
}

object Day3 : Puzzle() {
    private val lines = readLines(2020, 3)

    override fun partOne() {
        var stepRight = 0;

        val count = lines.filter { line ->
            val posX = stepRight % line.length;
            stepRight += 3;
            line[posX] == '#'
        }.count()

        println(count)
    }

    override fun partTwo() {

        val count = longArrayOf(
            slope(lines, 1, 1),
            slope(lines, 3, 1),
            slope(lines, 5, 1),
            slope(lines, 7, 1),
            slope(lines, 1, 2),
        ).reduce { acc, i -> acc * i }

        println(count)
    }

    private fun slope(lines: MutableList<String>, right: Int, down: Int): Long {
        var stepRight = 0;
        return lines
            .filterIndexed { index, s -> index % down == 0 }
            .filter { line ->
                val posX = stepRight % line.length;
                stepRight += right;
                line[posX] == '#'
            }.count().toLong()
    }

}