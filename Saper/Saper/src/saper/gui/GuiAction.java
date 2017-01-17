package saper.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import saper.BaseAction;
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
