package com.guru.concepts.matrix;

import java.util.ArrayList;
import java.util.List;

public class CheckCutPath {
	public static void main(String[] args) {
		CheckCutPath ccp = new CheckCutPath();
		int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
		System.out.println(ccp.isPossibleToCutPath(grid));
		
	}
	
	public boolean isPossibleToCutPath(int[][] grid) {
        Cell cell = new Cell(0,0,grid[0][0]);//row, col, val
        List<Cell> q = new ArrayList<>();
        q.add(cell);
        while(true) {
        	q = repopulate(q, grid);
        	if(q.isEmpty()) {
        		break;
        	}
        	else if(checkCutPath(q)) {
                return true;
            }            
        }

        return false;
    }

    private boolean checkCutPath(List<Cell> ls) {
        return ls.stream().mapToInt(c -> c.val).sum() < 2;
    }

    private List<Cell> repopulate(List<Cell> ls, int[][] grid) {
        List<Cell> l = new ArrayList<>();
        for(Cell pos : ls) {
            int r1 = pos.row + 1;
            int c1 = pos.col;
            //down
            if(r1 < grid.length && c1 < grid[0].length) {
                int v1 = grid[r1][c1];
                Cell ce1 = new Cell(r1,c1,v1);
                if(!l.contains(ce1)) {
                    l.add(ce1);
                }
            }
            // right
            r1 = pos.row;
            c1 = pos.col + 1;
            if(r1 < grid.length && c1 < grid[0].length) {
                int v1 = grid[r1][c1];
                Cell ce1 = new Cell(r1,c1,v1);
                if(!l.contains(ce1)) {
                    l.add(ce1);
                }
            }
        }

        return l;
    }
    class Cell {
        public int row;
        public int col;
        public int val;
        public Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public boolean equals(Object o) {
            return ((Cell)(o)).row == this.row && ((Cell)(o)).col == this.col;
        }

        public int hashcode() {
            return this.row + this.col;
        }
    }

}
