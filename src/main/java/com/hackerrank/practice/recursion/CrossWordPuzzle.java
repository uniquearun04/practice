package com.hackerrank.practice.recursion;

/**
 * Created by achaudhary on 10/6/18.
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CrossWordPuzzle {

    final static String HYPHEN = "-";

    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {

        String[] entries = words.split(";");
        String[][] puzzle = new String [crossword.length][crossword[0].length()];

        for (int i = 0; i < crossword.length; i++) {
            puzzle[i] = crossword[i].split("|");
        }

//        Map<>

        int r = 0;
        for (int i = 0; i < entries.length; i++) {
            String entry = entries[i];
            String[] word = entry.split("|");

            boolean found = false;

            for (; r < puzzle.length; ) {

            String[] row = puzzle[r];

                for (int j = 0; j < row.length; j++) {
                    if (HYPHEN.equals(row[j])) {
                        if (j + 1 < row.length && HYPHEN.equals(row[j + 1])) {
                            for (int k = 0; k < word.length; k++) {
                                row[j + k] = word[k];
                            }
                        } else {
                            int downLength = 0;
                            for (int k = r; k < puzzle.length && k >= 0; k++) {
                                if (HYPHEN.equals(puzzle[k][j])) {
                                    downLength++;
                                } else {
                                    break;
                                }
                            }
                            for (int k = r - (word.length - downLength), l = 0; k < puzzle.length && k >= 0 && l < word.length; k++, l++) {
                                puzzle[k][j] = word[l];
                            }
                        }
                        found = true;
                        r++;
                        break;
                    }
                }
                if(found) {
                    break;
                }
                r++;
            }
        }
        for (int i = 0; i < crossword.length; i++) {
            crossword[i] = arrayToString(puzzle[i]);
        }

        return crossword;
    }

    private static String arrayToString(String [] A) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            sb.append(A[i]);
        }
        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();

        String[] result = crosswordPuzzle(crossword, words);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
