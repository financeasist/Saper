package saper.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import saper.BaseAction;
import saper.GeneratorBoard;
import saper.SaperLogic;
import saper.logics.Easy;

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
		int buttonId = e.getButton();
		int xc = e.getX();
		int yc = e.getY();
		int x = 0, y = 0;
		if (xc <= 22 && yc <= 20) { // це координати cells[0][0]
			x = 0;
			y = 0;
		}
		if (xc >= 22 && yc <= 20) { // це координати cells[1][0]
			x = 1;
			y = 0;
		}
		if (xc <= 20 && yc >= 30) { // це координати cells[0][1]
			x = 0;
			y = 1;
		}
		if (xc >= 30 && yc >= 30) { // це координати cells[1][1]
			x = 1;
			y = 1;
		}
		this.select(x, y, buttonId !=1);
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
