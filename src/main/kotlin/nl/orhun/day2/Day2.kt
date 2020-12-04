package nl.orhun.day2

import nl.orhun.Puzzle

fun main() {
    Day2.partOne()
    Day2.partTwo()
}

object Day2 : Puzzle() {
    private val PWD_PATTERN = """(\d+)-(\d+)\s([a-z|A-Z]):\s([a-z|A-Z]+)""".toRegex();
    private val lines = readLines(2020, 2);

    override fun partOne() {
        val validCount = lines.filter {
            val matchResult = PWD_PATTERN.find(it)
            val from = matchResult!!.groupValues[1].toInt();
            val to = matchResult.groupValues[2].toInt();
            val pwChar = matchResult.groupValues[3];
            val password = matchResult.groupValues[4];

            val count = password.count { pwChar == it.toString() }
            count in from..to
        }.map { println(it) }.count()
        println(validCount)
    }

    override fun partTwo() {
        val validCount = lines.filter {
            val matchResult = PWD_PATTERN.find(it)
            val from = matchResult!!.groupValues[1].toInt();
            val to = matchResult.groupValues[2].toInt();
            val pwChar = matchResult.groupValues[3];
            val password = matchResult.groupValues[4];

            val startEquals = password[from - 1].toString() == pwChar
            val endEquals = password[to - 1].toString() == pwChar

            startEquals xor endEquals;
        }.map { println(it) }.count()
        println(validCount)
    }

}