package day1

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

fun main() {
    val numbers = Files.readAllLines(Paths.get("src/main/resources/day1.txt")).stream()
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