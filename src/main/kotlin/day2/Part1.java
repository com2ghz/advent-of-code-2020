package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Part1 {

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("src/main/resources/day3.txt"));

        String[][] matrix = new String[strings.size()][];

        int treeCount = 0;
        int right = 0;
        for (int i =0; i< strings.size(); i++) {
            for (int j =0; j<strings.get(i).length(); j++) {
                if (matrix[i] == null) {
                    matrix[i] = new String[strings.get(i).length()];
                }
                char lineChar = strings.get(i).toCharArray()[j];
                String charFound = Character.toString(lineChar);
                if (j == right) {
                    if (lineChar =='#') {
                        charFound = "X";
                        treeCount++;
                    } else {
                        charFound = "0";
                    }
                }
                    matrix[i][j] = charFound;
            }
            right += 3;
            if (right > strings.get(i).length()) {
                right = 0;
            }
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j< matrix[i].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println(treeCount);

    }
}
