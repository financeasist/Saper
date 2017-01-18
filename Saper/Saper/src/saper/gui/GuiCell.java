package saper.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import saper.Cell;

public class GuiCell implements Cell<Graphics> {

	private int x;
	private int y;
	private String type;

	public GuiCell(int x, int y, String type) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
	}

	@Override
	public boolean isBomb() {
		return false;
	}

	@Override
	public boolean isGuessedBomb() {
		return false;
	}

	@Override
	public boolean isGuessedEmpty() {
		return false;
	}

	@Override
	public void suggestEmpty() {
	}

	@Override
	public void suggestBomb() {
	}

	@Override
	public void drawCell(Graphics paint, boolean real) {

		BufferedImage img = null;
		String src = "resources/empty.gif";
		

		if("bomb".equals(type))
			src = "resources/mine.gif";
		try {
			img = ImageIO.read(new File(src));
		} catch (IOException e) {
			e.printStackTrace();
		}
		paint.drawImage(img, x * 18, y * 18, 17, 17, null);
		
	}

}
