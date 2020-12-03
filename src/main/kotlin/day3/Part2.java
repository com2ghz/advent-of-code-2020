package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Part2 {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("src/main/resources/day3.txt"));

        Long count = Stream.of(
                slope(strings, 1, 1),
                slope(strings, 3, 1),
                slope(strings, 5, 1),
                slope(strings, 7, 1),
                slope(strings, 1, 2)
        ).reduce((aLong, aLong2) -> aLong * aLong2)
                .orElse(0L);
        System.out.println(count);
    }

    private static long slope(List<String> strings, int right, int down) {
        int trees = 0;
        for (int i = 0, stepsRight = 0; i < strings.size(); i = i + down, stepsRight += right) {
            int x = stepsRight % strings.get(i).length();
            if (strings.get(i).charAt(x) == '#') {
                trees++;
            }
        }
        return trees;
    }
}
