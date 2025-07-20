package com.aurionpro.model;

public class Board {
	private final int size = 3;
	private Box[][] grid;
	
	

	public Board() {
		grid = new Box[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				grid[i][j] = new Box();
	}
	

	public boolean setMove(int row, int col, MarkType mark) {
		if (grid[row][col].isEmpty()) {
			grid[row][col].setMark(mark);
			return true;
		}
		return false;
	}

	public MarkType getMarkAt(int row, int col) {
		return grid[row][col].getMark();
	}
	
	public Box getBox(int row, int col) {
		return grid[row][col];
	}

	public boolean checkWin(MarkType mark) {
		
		// rows chk
		for (int i = 0; i < size; i++) {
			boolean win = true;
			for (int j = 0; j < size; j++) {
				if (grid[i][j].getMark() != mark) {
					win = false;
					break;
				}
			}
			if (win)
				return true;
		}

		// columns chk
		for (int j = 0; j < size; j++) {
			boolean win = true;
			for (int i = 0; i < size; i++) {
				if (grid[i][j].getMark() != mark) {
					win = false;
					break;
				}
			}
			if (win)
				return true;
		}

		// main diagonal chk
		boolean win = true;
		for (int i = 0; i < size; i++) {
			if (grid[i][i].getMark() != mark) {
				win = false;
				break;
			}
		}
		if (win)
			return true;

		// toher diagonal chk
		win = true;
		for (int i = 0; i < size; i++) {
			if (grid[i][size - i - 1].getMark() != mark) {
				win = false;
				break;
			}
		}
		return win;
	}

	public boolean isFull() {
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (grid[i][j].isEmpty())
					return false;
		return true;
	}

}
