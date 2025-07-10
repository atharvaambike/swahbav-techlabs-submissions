package com.aurionpro.ctrlstrhw;

import java.util.Random;
import java.util.Scanner;

public class PIG {

	public static void main(String[] args) {

		System.out.println("Game start! Goal: Reach 20 points.");
		System.out.println("* If you roll a 1, you lose all points for the turn.");
		System.out.println("* Turn ends when you hold or roll a 1.\n");

		Scanner scanner = new Scanner(System.in);

		int totalSum = 0;
		int turns = 1;

		while (turns <= 5 && totalSum < 20) {
			System.out.println("Current turn: " + turns);
			int currentSum = 0;

			while (true) {
				System.out.print("Roll or Hold?(r/h): ");
				String input = scanner.next();

				if (input.equalsIgnoreCase("r")) {
					Random random = new Random();
					int currentDiceValue = random.nextInt(6) + 1;
					System.out.println("Dice: " + currentDiceValue);

					if (currentDiceValue == 1) {
						System.out.println("Turn over. No score.\n");
						currentSum = 0;
						break;
					}
					currentSum += currentDiceValue;

				} else if (input.equalsIgnoreCase("h")) {
					totalSum += currentSum;
					System.out.println("Score for turn: " + currentSum);
					System.out.println("Total score: " + totalSum + "\n");
					break;
				} else {
					System.out.println("Invalid input. Enter 'r' or 'h'.");
				}
			}
			turns++;
		}

		if (totalSum >= 20)
			System.out.println("You finished in " + (turns - 1) + " turns!");
		else
			System.out.println("You did not reach 20 points in 5 turns.\nFinal score: " + totalSum);

		System.out.println("Game over!");
		scanner.close();
	}

}
