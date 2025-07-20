package com.aurionpro.model;

public class Box {
	
	private MarkType mark;

	public Box() {
		this.mark = MarkType.EMPTY;
	}

	public boolean isEmpty() {
		return mark == MarkType.EMPTY;
	}

	public void setMark(MarkType mark) {
		if (isEmpty())
			this.mark = mark;
	}

	public MarkType getMark() {
		return mark;
	}
}
