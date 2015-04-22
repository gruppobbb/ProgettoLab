package view2d.render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import model.Game;

public class MenuButton extends JComponent implements MouseListener{
	
	private String buttonName;
	private int width = 100;
	private int height = 100;
	private Dimension buttondDimension = new Dimension(width,height);
	private Game game;
	
	private boolean mouseEntered;
	private boolean mousePressed;
	
	private int x = 0;
	private int y = 0;
	
	public MenuButton(String buttonName, Game game) {
		super();
		this.buttonName = buttonName;
		this.game = game;
		setLocation(x, y);
		enableInputMethods(true);
		addMouseListener(this);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(0, 0, width,height);
		System.out.println("disegnato");
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("disegnato");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		mouseEntered = true;
	}
	@Override
	public void mouseExited(MouseEvent e) {
		mouseEntered = false;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		mousePressed = true;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
	}
	
	
	@Override
	public Dimension getPreferredSize() {
		return buttondDimension;
	}
	
	@Override
	public Dimension getMinimumSize() {
		return buttondDimension;
	}
	
	@Override
	public Dimension getMaximumSize() {
		return buttondDimension;
	}
}