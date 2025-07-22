package com.aurionpro.helper;

import java.util.Scanner;
import java.util.function.Function;

public class InputValidator {
	private static final Scanner scanner = new Scanner(System.in);

	// Generic prompt with validation
	public static <T> T prompt(String message, Function<String, T> parser, String errorMessage) {
		while (true) {
			System.out.print(message);
			String input = scanner.nextLine();
			try {
				return parser.apply(input);
			} catch (Exception e) {
				System.out.println("❌ " + errorMessage);
			}
		}
	}

	public static int safeIntInput(String message) {
		return prompt(message, input -> {
			int val = Integer.parseInt(input);
			if (val < 0)
				throw new NumberFormatException("Negative numbers not allowed.");
			return val;
		}, "Please enter a valid positive integer.");
	}

	public static double safeDoubleInput(String message) {
		return prompt(message, Double::parseDouble, "Please enter a valid number.");
	}

	public static String safeStringInput(String message) {
		return prompt(message, s -> s.trim(), "Please enter valid text.");
	}
}
