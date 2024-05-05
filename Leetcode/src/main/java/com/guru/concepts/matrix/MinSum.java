package com.guru.concepts.matrix;

public class MinSum {
	public static void main(String[] args) {
		MinSum ms = new MinSum();
		//int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		int[][] grid = {{1,2,3},{4,5,6}};
		System.out.println(ms.minPathSum(grid));
	}
	
	private int minPathSum(int[][] grid) {
        int i=0,j=0;
        int[][] ans = new int[grid.length][grid[0].length];
        ans[0][0] = grid[0][0];
        for(j=1 ; j<grid[0].length ; j++) {
        	ans[0][j] = ans[0][j-1] + grid[0][j];
        }
        for(i=1 ; i<grid.length ; i++) {
        	ans[i][0] = ans[i-1][0] + grid[i][0];
        }
        for(i=1 ; i<grid.length ; i++) {
            for(j=1 ; j<grid[0].length ; j++) {
                ans[i][j] = Math.min((grid[i][j] + ans[i-1][j]) , (grid[i][j] + ans[i][j-1]));
            }
        }

        return ans[i-1][j-1];
    }

}
