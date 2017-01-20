package saper.logics;

import saper.Cell;
import saper.GeneratorBoard;
import saper.gui.GuiCell;

public class GeneratorBoardImpl implements GeneratorBoard {

	public Cell[][] generate() {

		// return new Cell[][] { { new GuiCell(0, 0, "empty"), new GuiCell(0, 1,
		// "empty") },
		// { new GuiCell(1, 0, "bomb"), new GuiCell(1, 1, "empty") } };

		Cell data[][] = new Cell[2][2];

		data[0][0] = new GuiCell(0, 0, "one");
		data[0][1] = new GuiCell(0, 1, "one");
		data[1][0] = new GuiCell(1, 0, "one");
		data[1][1] = new GuiCell(1, 1, "bomb");
//		for (int x = 0; x <4; x++) {
//			for (int y = 0; y < 4; y++) {
//				data[x][y] = new GuiCell(x, y, "empty");
//			}
//		}
		return data;
	}
}
