package com.guru.concepts.matrix;

public class MatrixFlipValue {

	public static void main(String[] args) {
		MatrixFlipValue mfv = new MatrixFlipValue();
		int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
		System.out.println(mfv.isPossibleToCutPath(grid));
	}
	
	private boolean isPossibleToCutPath(int[][] grid) {
        if(grid[1][0] == 1 && grid[0][1] == 0) {
            return true;
        }
        else if(grid[1][0] == 0 && grid[0][1] == 1) {
            return true;
        }
        else {
            grid[1][0] = 0;
            boolean path1 = findPath(grid,0,0);
            if(!path1) {
                return true;
            }
            grid[1][0] = 1;
            grid[0][1] = 0;
            boolean path2 = findPath(grid,0,0);
            if(!path2) {
                return true;
            }
        }

        return false;
    }

    private boolean findPath(int[][] grid,int m, int n) {
    	if(m == grid.length-1 && n == grid[0].length-1) {
        	return true;
        }
    	else if(m < grid.length && n < grid[0].length) {
            if(grid[m][n] == 0) {
                return false;
            }
            boolean path1 = findPath(grid,m+1,n);
            boolean path2 = findPath(grid,m,n+1);

            return path1 || path2;
        }
    	
        return false;
    }
}
