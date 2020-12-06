package nl.orhun

import java.nio.file.Files
import java.nio.file.Paths

abstract class Puzzle {
    fun readLines(year: Int, day: Int): MutableList<String> {
        return Files.readAllLines(getPath(year, day))
    }

    fun readString(year: Int, day: Int): String {
        return Files.readString(getPath(year, day))
    }

    private fun getPath(year: Int, day: Int) = Paths.get("src/main/resources/$year/day$day.txt")

    abstract fun partOne()
    abstract fun partTwo()
}