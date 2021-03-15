package com.roy.leetcode;

/**
 * @Author roy.luo@wiseplatform.cn
 * <p>
 * https://mp.weixin.qq.com/s/zJxRBWL4ok0tu2xXvNAjKA
 **/
public class lc695 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

/*        int[][] grid = new int[][]{
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };*/

        lc695 test = new lc695();
        int i = test.maxAreaOfIsland(grid);
        System.out.println(i);
    }

    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            //行遍历
            int[] line = grid[i];
            for (int j = 0; j < line.length; j++) {
                int anInt = grid[i][j];
                if (anInt == 1) {
                    int sum = sum(grid, i, j);
                    if (max < sum) {
                        max = sum;
                    }
                }
            }
        }

        return max;
    }

    private int sum(int[][] grid, int i, int j) {

        //数组越界判断
        if (0 <= i && i < grid.length) {
            int[] len = grid[i];
            if (!(0 <= j && j < len.length)) {
                return 0;
            }
        } else {
            return 0;
        }

        int temp = grid[i][j];

        if (temp == 2) {
//            除掉已经累加过的值,value = 2;
            return 0;
        } else if (temp == 0) {
            //-> 水
            return 0;
        }

        //遍历过的都标记一下
        grid[i][j] = 2;

        //计算四周的土地数量,排
        return 1 +
                sum(grid, i - 1, j) +
                sum(grid, i + 1, j) +
                sum(grid, i, j - 1) +
                sum(grid, i, j + 1);
    }

}
