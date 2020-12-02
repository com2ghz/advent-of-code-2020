package day2

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val validCount = Files.readAllLines(Paths.get("src/main/resources/day2.txt")).filter {
        val matchResult = PWD_PATTERN.find(it)
        val from = matchResult!!.groupValues.get(1).toInt();
        val to = matchResult.groupValues.get(2).toInt();
        val pwChar = matchResult.groupValues.get(3);
        val password = matchResult.groupValues.get(4);

        val startEquals = password.get(from - 1).toString() == pwChar
        val endEquals = password.get(to - 1).toString() == pwChar

        startEquals xor endEquals;
    }.map { println(it) }.count()
    println(validCount)
}