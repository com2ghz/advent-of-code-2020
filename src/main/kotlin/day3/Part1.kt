package day3

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val lines = Files.readAllLines(Paths.get("src/main/resources/day3.txt"))
    var stepRight = 0;

    val count = lines.filter { line ->
        val posX = stepRight % line.length;
        stepRight += 3;
        line[posX] == '#'
    }.count()

    println(count)
}