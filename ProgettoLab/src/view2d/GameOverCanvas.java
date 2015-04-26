package view2d;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class GameOverCanvas extends Canvas {
	
	private Color bgColor = new Color(43,62,84);
	private int width, height;
	
	public GameOverCanvas(int width, int height) {
		
		this.width = width;
		this.height = height;
		
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);		
	}
	
	/**
	 * Disegna il "menu" che visualizza il punteggio e le informazioni di fine partita.
	 * @param score
	 */
	public void drawScore(long score) {
		Graphics2D g = (Graphics2D) this.getGraphics();
		g.setColor(bgColor);
		g.drawString(String.valueOf(score), 200, 200);
		g.dispose();
	}
	
	

}
