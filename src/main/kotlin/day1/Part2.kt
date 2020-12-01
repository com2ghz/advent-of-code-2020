package day1

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

fun main() {
    val numbers = Files.readAllLines(Paths.get("src/main/resources/day1.txt")).stream()
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
    println(result);
}