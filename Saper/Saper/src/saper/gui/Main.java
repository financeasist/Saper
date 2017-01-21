package saper.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import saper.logics.Easy;
import saper.logics.GeneratorBoardImpl;

/**
 * Enterpoint to app. Creates Main frame
 * 
 * @author Roman
 * @since 13.01.2017
 */
public class Main {
	private static final GeneratorBoardImpl GENERATOR = new GeneratorBoardImpl();
	private static final JPanel controlPanel = new JPanel();
	// private static final JPanel controlPanelForMenu = new JPanel();
	private static final GuiBoard BOARD = new GuiBoard();
	private static final Easy LOGIC = new Easy();
	static JTextField jt_mines, jt_time;

	public static void main(String[] arg) {

		final JFrame frame = new JFrame();
		frame.setTitle("Сапер");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setSize(205, 300);
		// frame.getContentPane().add(controlPanelForMenu,
		// BorderLayout.PAGE_START);
		frame.getContentPane().add(controlPanel, BorderLayout.PAGE_START);
		frame.getContentPane().add(BOARD, BorderLayout.CENTER);
		BOARD.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7),
				BorderFactory.createLoweredBevelBorder()));

		jt_mines = new JTextField("push on");
		jt_mines.setFont(new Font("DigtalFont.TTF", Font.BOLD, 17));
		jt_mines.setForeground(Color.RED);
		jt_mines.setBorder(BorderFactory.createLoweredBevelBorder());

		jt_time = new JTextField(" smile!");
		jt_time.setFont(new Font("DigtalFont.TTF", Font.BOLD, 20));
		jt_time.setBorder(BorderFactory.createLoweredBevelBorder());
		jt_time.setForeground(Color.RED);
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
		controlPanel.add(jt_mines);
		jt_mines.setBackground(Color.black);
		jt_time.setBackground(Color.black);
		final JButton generate = new JButton("");
		generate.setIcon(new ImageIcon("resources\\new game.gif"));
		generate.setBorder(BorderFactory.createLoweredSoftBevelBorder());

		generate.addActionListener(new GuiAction(LOGIC, BOARD, GENERATOR));
		controlPanel.add(generate);
		controlPanel.add(jt_time);

		centre(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}

	public static void centre(Window w) {
		Dimension us = w.getSize();
		Dimension them = Toolkit.getDefaultToolkit().getScreenSize();
		int newX = (them.width - us.width) / 2;
		int newY = (them.height - us.height) / 2;
		w.setLocation(newX, newY);

	}

	public static void setLabel(String textOnLabel) {
		jt_mines.setText(textOnLabel);
		jt_mines.repaint();
	}
}
