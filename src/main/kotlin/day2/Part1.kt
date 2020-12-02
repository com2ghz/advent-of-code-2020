package day2

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

fun main() {
    val lines = Files.readAllLines(Paths.get("src/main/resources/day2.txt")).stream()
        .toList()
}