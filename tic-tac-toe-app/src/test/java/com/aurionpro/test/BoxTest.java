package com.aurionpro.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.aurionpro.model.Board;
import com.aurionpro.model.Box;
import com.aurionpro.model.MarkType;

public class BoxTest {

//	@Test
//	public void testBoxEmptyAtStart() {
//		Box box = new Box();
//		assertEquals(MarkType.EMPTY, box.getMark());
//	}

	@Test
	public void testAllBoxesEmptyAtStart() {
		Board board = new Board();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				assertEquals(MarkType.EMPTY, board.getBox(i, j).getMark());
			}
		}
	}

	@Test
	public void testCannotMarkAlreadyMarkedBox() {
		Box box = new Box();
		box.setMark(MarkType.X);
		box.setMark(MarkType.O); // to avoid over writing
		assertEquals(MarkType.X, box.getMark());
	}
}
