package com.aurionpro.helper;

public class FoodIdGenerator {

	private static int currentId = 1000;

	private FoodIdGenerator() {
	}

	public static int getNextId() {
		return ++currentId;
	}

	public static void setStartingId(int id) {
		if (id > currentId) {
			currentId = id;
		}
	}
}
