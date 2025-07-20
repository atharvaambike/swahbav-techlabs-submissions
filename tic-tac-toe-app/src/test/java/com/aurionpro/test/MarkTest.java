package com.aurionpro.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.aurionpro.model.Box;
import com.aurionpro.model.MarkType;

class MarkTest {

	@Test
	public void testMarkingX() {
		Box box = new Box();
		box.setMark(MarkType.X);
		assertEquals(MarkType.X, box.getMark());
	}

	@Test
	public void testMarkingO() {
		Box box = new Box();
		box.setMark(MarkType.O);
		assertEquals(MarkType.O, box.getMark());
	}

}
