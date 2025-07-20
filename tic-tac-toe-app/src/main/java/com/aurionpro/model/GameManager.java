package com.aurionpro.model;

import java.util.Scanner;

import com.aurionpro.util.BoardPrinter;
import com.aurionpro.util.InputHelper;

public class GameManager {
	private Board board;
	private User user1;
	private User user2;
	private User currentUser;
	private IGameRule rule;

	public GameManager() {

	}

	public GameManager(User user1, User user2) {
		this.user1 = user1;
		this.user2 = user2;
		this.board = new Board();
		this.currentUser = user1;
		this.rule = new StandardTicTacToeRule(); // ✅ plug in the rule
	}

	public void playMatch(Scanner sc) {
		boolean matchOver = false;

		while (!matchOver) {
			printBoard();
			System.out.println("Current Player: " + currentUser.getName());

			int[] pos = InputHelper.getRowColFromCell(sc);
			int row = pos[0];
			int col = pos[1];

			boolean moveSuccessful = playMove(row, col); // this will handle win/draw logic
			if (moveSuccessful && (board.checkWin(currentUser.getMark()) || board.isFull())) {
				matchOver = true;
			}
		}
	}

	public boolean playMove(int row, int col) {
		if (!board.setMove(row, col, currentUser.getMark())) {
			System.out.println("Invalid move. Try again.");
			return false;
		}

//		if (rule.checkWin(board, currentUser.getMark())) {
//		    currentUser.incrementWin();
//		    System.out.println(currentUser.getName() + " wins this round!");
//		    new BoardPrinter().print(board);
//		    resetGame();
//		    return true;
//		}

		if (rule.checkWin(board, currentUser.getMark())) {
			new BoardPrinter().print(board);

			System.out.println("🎉 " + currentUser.getName() + " (" + currentUser.getMark() + ") wins this round!");
			currentUser.incrementWin();

			resetGame();
			return true;
		}

		if (board.isFull()) {
			System.out.println("It's a DRAW!");
			new BoardPrinter().print(board);
			resetGame();
			return true;
		}

		switchTurn();
		return true;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	private void switchTurn() {
		currentUser = (currentUser == user1) ? user2 : user1;
	}

	public void resetGame() {
		board = new Board();
		currentUser = user1;
	}

	public boolean isGameOver() {
		return board.isFull() || board.checkWin(currentUser.getMark());
	}

	public void printBoard() {
		BoardPrinter printer = new BoardPrinter();
		printer.print(board);

	}

	public User getWinner() {
		return user1.getWinCount() > user2.getWinCount() ? user1 : user2;
	}

	public User getUser1() {
		return user1;
	}

	public User getUser2() {
		return user2;
	}

}
