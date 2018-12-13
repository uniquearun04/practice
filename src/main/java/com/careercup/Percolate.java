package com.careercup;

import lombok.AllArgsConstructor;

import java.util.Stack;

/**
 * Created by achaudhary on 9/21/18.
 */
public class Percolate {

    // An entry 1 means porus, 0 means opaque
    public static void findIfWaterPercolates(int [][] wall) {
        int n = wall.length;
        int m = wall[0].length;

        boolean [][] visted = new boolean [n][m];

        Stack<Brick>  porusBricksStack = new Stack<>();

        for(int i = 0; i < m; i++) {
            if(wall[0][i] == 1) {
                Brick porusBrick = new Brick(0, i, true);
                porusBricksStack.push(porusBrick);
            }
        }

        while (!porusBricksStack.isEmpty()) {
            Brick brick = porusBricksStack.pop();

            int row = brick.row;
            int column = brick.column;
            if(row == n - 1) {
                System.out.println("Water reaches to ground");
                return;
            }
            visted[row][column] = true;
            addListOfNeibhouringPorusBricks(wall, brick, n, m, visted, porusBricksStack);
        }
        System.out.println("Water does not reaches to ground");
    }

    static void addListOfNeibhouringPorusBricks(int [][] wall, Brick brick, int height, int width, boolean [][] visited, Stack<Brick> porusBrickStack) {
        int row = brick.row;
        int column = brick.column;
        validateAndAddBrickToStack(wall, visited, porusBrickStack, row, column - 1, height, width);
        validateAndAddBrickToStack(wall, visited, porusBrickStack, row, column + 1, height, width);
        validateAndAddBrickToStack(wall, visited, porusBrickStack, row + 1, column - 1, height, width);
        validateAndAddBrickToStack(wall, visited, porusBrickStack, row + 1, column, height, width);
        validateAndAddBrickToStack(wall, visited, porusBrickStack, row + 1, column + 1, height, width);
    }

    private static void validateAndAddBrickToStack(int [][] wall, boolean[][] visited, Stack<Brick> porusBrickStack, int row, int column, int height, int width) {
        if(row < height && column < width && column >= 0 && wall[row][column] == 1 && !visited[row][column]) {
            porusBrickStack.add(new Brick(row, column, true));
        }
    }

    public static void main(String ...args) {
        int [][] wall_01 = {
                {0,1,0,1,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {0,0,1,0,0},
        };
        int [][] wall_02 = {
                {0,1,0,1,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {0,0,0,0,0},
        };
        findIfWaterPercolates(wall_01);
        findIfWaterPercolates(wall_02);

    }

}

@AllArgsConstructor
class Brick {
    int row;
    int column;
    boolean porus;
}
