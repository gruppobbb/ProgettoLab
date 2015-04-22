package view2d.menu;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;

import model.Game;
import view2d.assets.Assets;
import view2d.assets.BFont;

public class MenuButton extends JComponent implements MouseListener{

	private Game game;

	private float fontSize;
	private BFont bFont;
	private String buttonName;
	private BufferedImage buttonImage;
	private Dimension buttondDimension;
	private int width, height;
	private int maxShift;
	
	private int xDrawing, yDrawing;
	private int xButtonName, yButtonName;
	private boolean needCentring;
	
	public MenuButton(Game game, String buttonName) {
		this(game, buttonName, Assets.FONT_BUTTON_NAME, 32f);
	}
	
	public MenuButton( Game game, String buttonName, int fontID, float fontSize) {
		super();
		this.game = game;
		bFont = Assets.getLoader().getFont(fontID);
		this.fontSize = fontSize;
		setFont(bFont.getSizedFont(fontSize));
		
		setButtonName(buttonName);
		enableInputMethods(true);
		addMouseListener(this);
		setFocusable(true);
		
		maxShift = 5;
		buttonImage = Assets.getLoader().getImage(Assets.IMAGE_BUTTON_OUT_FOCUS);
		width = buttonImage.getWidth() + 2*maxShift;
		height = buttonImage.getHeight() + 2*maxShift;
		buttondDimension = new Dimension(width,height);
		
		xDrawing = maxShift;
		yDrawing = maxShift;
	}
	
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
		needCentring = true;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buttonImage, xDrawing - shift, yDrawing-shift, buttonImage.getWidth() + shift*2, buttonImage.getHeight()+shift*2, null);
		if(needCentring){
			centreButtonName(g);
		}
		g.drawString(buttonName, xButtonName, yButtonName);
	}
	
	
	public void centreButtonName(Graphics g) {
	    FontMetrics fm = g.getFontMetrics();
	    xButtonName = (width - fm.stringWidth(buttonName)) / 2;
	    yButtonName = (fm.getAscent() + (height - (fm.getAscent() + fm.getDescent())) / 2);
	    needCentring = false;
	  }


	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	int shift = 0;
	Timer timer;
	@Override
	public void mouseEntered(MouseEvent e) {
		changeImage(Assets.IMAGE_BUTTON_ONFOCUS_UNPRESSED);
		runAnimation(true);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		resetLocation();
		runAnimation(false);
		changeImage(Assets.IMAGE_BUTTON_OUT_FOCUS);
	}
	
	private int delta = 1;
	private void runAnimation(boolean run){
		if(run){
			timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					if(shift==0){
						delta = 1;
					}else if(shift == maxShift-1){
						delta = -1;
					}
					shift += delta;
					needCentring = true;
					repaint();
				}
			}, 0, 100);
		}else{
			timer.cancel();
		}
	}
	
	public void setButtondDimension(int width, int height) {
		this.buttondDimension = new Dimension(width, height);
	}

	private void resetLocation() {
		shift = 0 ;
		shift = 0;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		changeImage(Assets.IMAGE_BUTTON_ONFOCUS_PRESSED);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		changeImage(Assets.IMAGE_BUTTON_ONFOCUS_UNPRESSED);
	}
	
	private void changeImage(int imageID){
		buttonImage = Assets.getLoader().getImage(imageID);
		repaint();
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