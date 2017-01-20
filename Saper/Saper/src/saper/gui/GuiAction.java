package saper.gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import saper.BaseAction;
import saper.Cell;
import saper.GeneratorBoard;
import saper.SaperLogic;

public class GuiAction extends BaseAction implements ActionListener, MouseListener {

	private GuiBoard board;

	public GuiAction(SaperLogic logic, GuiBoard board, GeneratorBoard generator) {
		super(logic, board, generator);
		this.board = board;
		this.board.addMouseListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		this.initGame();
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int button = e.getButton();
		Cell<Graphics>[][] cells = board.getCells();
		if (button == 1) {
			if (x <= 22 && y <= 20) { // це координати cells[0][0]
				cells[0][0] = new GuiCell(0, 0, "one");
				GuiCell cell = (GuiCell) cells[0][0];
				cell.setIsVisible(true);
			}
		}
		if (button == 3) {
			if (x <= 22 && y <= 20) {// це координати cells[0][0]
				cells[0][0] = new GuiCell(0, 0, "flag");
				GuiCell cell = (GuiCell) cells[0][0];
				cell.setIsVisible(true);
			}
		}
		board.repaint();
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
