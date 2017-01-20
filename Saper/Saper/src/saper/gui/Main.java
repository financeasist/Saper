package saper.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import saper.Cell;
import saper.GeneratorBoard;
import saper.logics.Easy;
import saper.logics.GeneratorBoardImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * TODO: comment
 * 
 * @author Roman
 * @since 13.01.2017
 */
public class Main {
	private static final JPanel controlPanel = new JPanel();
//	private static final JPanel controlPanelForMenu = new JPanel();
	private static final GuiBoard board = new GuiBoard();
	static JTextField jt_mines, jt_time;

	public static void main(String[] arg) {

		final JFrame frame = new JFrame();
		frame.setTitle("Сапер");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setSize(205, 300);
		//frame.getContentPane().add(controlPanelForMenu, BorderLayout.PAGE_START);
		frame.getContentPane().add(controlPanel, BorderLayout.PAGE_START);
		frame.getContentPane().add(board, BorderLayout.CENTER);
		board.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7),	BorderFactory.createLoweredBevelBorder()));
		
		jt_mines = new JTextField(3);
		jt_mines.setFont(new Font("DigtalFont.TTF", Font.BOLD, 25));
		jt_mines.setForeground(Color.RED);
		jt_mines.setBorder(BorderFactory.createLoweredBevelBorder());
		jt_time = new JTextField(3);
		jt_time.setFont(new Font("DigtalFont.TTF", Font.BOLD, 25));
		jt_time.setBorder(BorderFactory.createLoweredBevelBorder());
		jt_time.setForeground(Color.RED);
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
		controlPanel.add(jt_mines);
		jt_mines.setBackground(Color.black);
		jt_time.setBackground(Color.black);
		final JButton generate = new JButton("");
		generate.setIcon(new ImageIcon("resources\\new game.gif"));
		generate.setBorder(BorderFactory.createLoweredSoftBevelBorder());
	
		generate.addActionListener(new GuiAction(new Easy(), board, new GeneratorBoardImpl()));
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
}
