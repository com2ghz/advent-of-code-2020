package day3

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val lines = Files.readAllLines(Paths.get("src/main/resources/day3.txt"))

    val count = arrayOf(
        slope(lines, 1, 1),
        slope(lines, 3, 1),
        slope(lines, 5, 1),
        slope(lines, 7, 1),
        slope(lines, 1, 2),
    ).map { println(it); it }.reduce { acc, i -> acc * i }

    println(count)
}

private fun slope(lines: MutableList<String>, right: Int, down: Int, ): Int {
    var stepRight = 0;
    return lines
        .filterIndexed { index, s -> index % down == 0 }
        .filter { line ->
            val posX = stepRight % line.length;
            stepRight += right;
            line[posX] == '#'
        }.count()
}