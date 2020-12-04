package nl.orhun.day3;

import nl.orhun.Puzzle;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Day3Java extends Puzzle {

    private List<String> STRINGS = readLines(2020, 3);;

    public static void main(String[] args) throws IOException {
        new Day3Java().partOne();
        new Day3Java().partTwo();
    }

    @Override
    public void partOne() {
        int trees = 0;

        for (int i = 0, stepsRight = 0; i < STRINGS.size(); i++, stepsRight += 3) {
            int x = stepsRight % STRINGS.get(i).length();
            if (STRINGS.get(i).charAt(x) == '#') {
                trees++;
            }
        }
        System.out.println(trees);
    }

    @Override
    public void partTwo() {
        Long count = Stream.of(
                slope(STRINGS, 1, 1),
                slope(STRINGS, 3, 1),
                slope(STRINGS, 5, 1),
                slope(STRINGS, 7, 1),
                slope(STRINGS, 1, 2)
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
