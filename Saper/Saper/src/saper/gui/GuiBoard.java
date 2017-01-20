package saper.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import saper.Board;
import saper.Cell;

public class GuiBoard extends JPanel implements Board {

	
	private Cell<Graphics>[][] cells;

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		if (this.cells != null) {
			for (int x = 0; x != cells.length; x++) {
				for (int y = 0; y != cells[0].length; y++) {
					graphics.setColor(Color.black);
					cells[x][y].drawCell(graphics, false);
					
				}
			}
		}
	}

	@Override
	public void drawBoard(Cell[][] cells) {
		this.cells = cells;
		this.repaint();
	}

	@Override
	public void drawCell(int x, int y) {
		this.repaint();

	}

	@Override
	public void drawBang() {
		this.repaint();

	}

	@Override
	public void drawCongratulate() {

	}
	public Cell<Graphics>[][] getCells() {
		return cells;
	}

	public void setCells(Cell<Graphics>[][] cells) {
		this.cells = cells;
	}
}
