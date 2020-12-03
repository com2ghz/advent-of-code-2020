package day3

import java.nio.file.Files
import java.nio.file.Paths


fun main() {
    val lines = Files.readAllLines(Paths.get("src/main/resources/day3.txt"))

    val matrix = Array(lines.size) { Array(lines[0].length) { "" } }

    var right = 0;
    var treeCount = 0;
    for ((yIndex, line) in lines.withIndex()) {
        for ((xIndex, str) in line.withIndex()) {
            if (xIndex == right) {
                if (str == '.') {
                    matrix[yIndex][xIndex] = "0"
                } else {
                    matrix[yIndex][xIndex] = "X"
                    treeCount++;
                }
            } else {
                matrix[yIndex][xIndex] = str.toString()
            }
        }
        right += 3
    }


    for (line in matrix) {
        for (s in line) {
            print(s)
        }
        println()
    }

    println("Tree count: $treeCount")


}