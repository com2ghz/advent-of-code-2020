package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Part1 {

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("src/main/resources/day3.txt"));

        int trees = 0;

        for (int i = 0, stepsRight = 0; i < strings.size(); i++, stepsRight += 3) {
            int x = stepsRight % strings.get(i).length();
            if (strings.get(i).charAt(x) == '#') {
                trees++;
            }
        }
        System.out.println(trees);
    }
}
