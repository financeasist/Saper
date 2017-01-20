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
	private Boolean isVisible = false;

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

		if ("one".equals(type))
			src = "resources/1.gif";
		if ("two".equals(type))
			src = "resources/2.gif";
		if ("three".equals(type))
			src = "resources/3.gif";
		if ("four".equals(type))
			src = "resources/4.gif";
		if ("five".equals(type))
			src = "resources/5.gif";
		if ("six".equals(type))
			src = "resources/6.gif";
		if ("seven".equals(type))
			src = "resources/7.gif";
		if ("eight".equals(type))
			src = "resources/8.gif";
		if ("bomb".equals(type))
			src = "resources/bomb.gif";
		if ("flag".equals(type))
			src = "resources/flag.gif";
		if ("bang".equals(type))
			src = "resources/bang.gif";
		if (!isVisible)
			src = "resources/0.gif";
		try {
			img = ImageIO.read(new File(src));
		} catch (IOException e) {
			e.printStackTrace();
		}
		paint.drawImage(img, x * 18 + 7, y * 18 + 7, 17, 17, null);

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}

}
