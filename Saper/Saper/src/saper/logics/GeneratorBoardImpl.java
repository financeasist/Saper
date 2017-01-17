package saper.logics;

import saper.Cell;
import saper.GeneratorBoard;
import saper.gui.GuiCell;

public class GeneratorBoardImpl implements GeneratorBoard {

	public Cell[][] generate() {

		// return new Cell[][] { { new GuiCell(0, 0, "empty"), new GuiCell(0, 1,
		// "empty") },
		// { new GuiCell(1, 0, "bomb"), new GuiCell(1, 1, "empty") } };

		Cell data[][] = new Cell[10][10];

		for (int x = 0; x <10; x++) {
			for (int y = 0; y < 10; y++) {
				data[x][y] = new GuiCell(x, y, "empty");
			}
		}
		return data;
	}
}
