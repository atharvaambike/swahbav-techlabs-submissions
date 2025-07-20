package com.aurionpro.model;

public class User {
	private String name;
	private MarkType mark;
	private int winCount;

	public User(String name, MarkType mark) {
		this.name = name;
		this.mark = mark;
		this.winCount = 0;
	}

	public void incrementWin() {
		winCount++;
	}

	public MarkType getMark() {
		return mark;
	}

	public String getName() {
		return name;
	}

	public int getWinCount() {
		return winCount;
	}
}
