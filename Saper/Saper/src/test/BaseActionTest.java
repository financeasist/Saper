package test;

import org.junit.Test;

import saper.BaseAction;
import saper.Cell;
import saper.GeneratorBoard;
import saper.console.ConsoleBoard;
import saper.console.ConsoleCell;
import saper.logics.Easy;

public class BaseActionTest {

	final BaseAction action = new BaseAction(new Easy(), new ConsoleBoard(), new GeneratorBoard() {
		@Override
		public Cell[][] generate() {
			return new Cell[][] { { new ConsoleCell(true), new ConsoleCell(false) },
					{ new ConsoleCell(true), new ConsoleCell(false) } };
		}
	});

	@Test
	public void successGame() {
		action.initGame();
		action.select(0, 0, true);
		action.select(1, 0, true);
		action.select(0, 1, false);
		action.select(1, 1, false);
	}

	@Test
	public void failureGame() {
		action.initGame();
		action.select(0, 0, true);
		action.select(1, 0, false);
	}
}