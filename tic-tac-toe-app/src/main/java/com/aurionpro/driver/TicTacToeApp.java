package com.aurionpro.driver;

import java.util.Scanner;

import com.aurionpro.exception.MatchExitException;
import com.aurionpro.model.GameManager;
import com.aurionpro.model.MarkType;
import com.aurionpro.model.User;
import com.aurionpro.util.InputHelper;

public class TicTacToeApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n🎮 Welcome to Tic Tac Toe\n");

		System.out.print("Enter name for Player 1: ");
		User user1 = new User(scanner.next(), MarkType.X);

		System.out.print("Enter name for Player 2: ");
		User user2 = new User(scanner.next(), MarkType.O);

		GameManager manager = new GameManager(user1, user2);

		boolean running = true;

		while (running) {
			int choice = InputHelper.showMenuAndGetChoice(scanner);

			switch (choice) {
			case 1:
				playSingleMatch(scanner, manager);
				System.out.println("Match Ended\n");
				break;

			case 2:
				printScoreboard(manager);
				break;
				
			case 3:
				System.out.println("New match started!");
				playSingleMatch(scanner, manager);

			case 4:
				System.out.println("Thanks for playing. Goodbye!");
				running = false;
				break;
			}
		}
	}

	private static void playSingleMatch(Scanner scanner, GameManager manager) {
		boolean matchOver = false;

		while (!matchOver) {
			manager.printBoard();
			System.out.println("Current Player: " + manager.getCurrentUser().getName());

			boolean moveSuccessful = false;
			while (!moveSuccessful) {
				try {
					int[] position = InputHelper.getRowColFromCell(scanner);
					int row = position[0];
					int col = position[1];
					moveSuccessful = manager.playMove(row, col);
				} catch (MatchExitException e) {
					System.out.println("👋 Returning to main menu...");
					return;
				}
			}

			if (manager.isGameOver()) {
				matchOver = true;
			}
			break;
		}

		printScoreboard(manager);
		return;
	}

	private static void printScoreboard(GameManager manager) {
		System.out.println("\n📊 Scoreboard:");
		System.out.println(manager.getUser1().getName() + ": " + manager.getUser1().getWinCount() + " wins");
		System.out.println(manager.getUser2().getName() + ": " + manager.getUser2().getWinCount() + " wins\n");
	}

}
