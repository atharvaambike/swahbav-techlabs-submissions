package com.aurionpro.util;

import java.util.Scanner;

import com.aurionpro.exception.MatchExitException;

public class InputHelper {

	public static int safeIntInput(Scanner scanner, String message, int min, int max) {
		int value;
		while (true) {
			try {
				System.out.print(message);
				value = Integer.parseInt(scanner.next());
				if (value >= min && value <= max)
					break;
				else
					System.out.println("❌ Enter a value between " + min + " and " + max);
			} catch (Exception e) {
				System.out.println("❌ Invalid input. Please enter an integer.");
			}
		}
		return value;
	}

	public static boolean askYesNo(Scanner scanner, String message) {
		while (true) {
			System.out.print(message);
			String input = scanner.next().trim().toLowerCase();
			if (input.equals("y"))
				return true;
			if (input.equals("n"))
				return false;
			System.out.println("❌ Please enter 'y' or 'n'");
		}
	}

	public static int[] getRowColFromCell(Scanner scanner) {
//	    String[][] mapping = {
//	        { "A", "B", "C" },
//	        { "D", "E", "F" },
//	        { "G", "H", "I" }
//	    };
		
		String[][] mapping = {
		        { "1", "2", "3" },
		        { "4", "5", "6" },
		        { "7", "8", "9" }
		    };

	    while (true) {
	        System.out.print("Enter cell (1-9) or type 'exit' to quit match): ");
	        String cell = scanner.next().trim().toUpperCase();

	        if (cell.equals("EXIT")) {
	            throw new MatchExitException("User chose to exit match.");
	        }

	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (mapping[i][j].equals(cell)) {
	                    return new int[] { i, j };
	                }
	            }
	        }

	        System.out.println("❌ Invalid cell. Try again (A to I only).");
	    }
	}


	public static int showMenuAndGetChoice(Scanner scanner) {
		System.out.println("1. Play Match");
		System.out.println("2. Show Scoreboard");
		System.out.println("3. Restart Game");
		System.out.println("4. Exit Game");

		return safeIntInput(scanner, "Enter your choice (1-4): ", 1, 4);
	}

}
