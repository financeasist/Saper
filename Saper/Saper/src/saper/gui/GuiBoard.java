package saper.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import saper.Board;
import saper.Cell;

/**
 * This class describes GuiBoad 
 * @author Roman Grupskyi
 *	@version 1.2 21.01.2017
 */

public class GuiBoard extends JPanel implements Board {

	private Cell<Graphics>[][] cells;
	private boolean real = false;

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		if (this.cells != null) {
			for (int x = 0; x != cells.length; x++) {
				for (int y = 0; y != cells[0].length; y++) {
					cells[x][y].draw(graphics, real);

				}
			}
		}
	}

	@Override
	public void drawBoard(Cell[][] cells) {
		this.cells =  cells;
		real = false;
		this.repaint();
	}

	@Override
	public void drawCell(int x, int y) {
		this.repaint();

	}

	@Override
	public void drawBang(int x, int y) {
		GuiCell cell = (GuiCell) cells[x][y];
		cell.setType("bang");
		this.real = true;
		this.repaint();

	}

	@Override
	public void drawCongratulate() {
		this.real = true;
		this.repaint();

	}

	public Cell<Graphics>[][] getCells() {
		return cells;
	}
}
