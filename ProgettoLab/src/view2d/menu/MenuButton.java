package view2d.menu;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;

import model.Game;
import view2d.assets.Assets;
import view2d.assets.BFont;
import view2d.menu.ButtonImageSet.ButtonStatus;

/**
 * Pulsante castomizzato per un menu B\.
 * Reso astratto e non cocreto piu' interfaccia 
 * per farlo rimanere un JComponent e poterlo aggiungere ad un JPanel.
 * @author Jan
 */
public abstract class MenuButton extends JComponent{
	
	private static final long serialVersionUID = -2037901012226328052L;
	
	private BFont bFont;
	private String buttonName;
	private BufferedImage buttonImage;
	private ButtonImageSet imageSet;
	private int drawingImageWidth, drawingImageHeight;
	private Dimension buttondDim;
	private int maxShift;
	
	private ButtonAnimator buttonAnimator;
	private int xDrawing, yDrawing;
	private int xButtonName, yButtonName;
	private boolean needCentring;
	
	/**
	 * Costruisce un pulsante per l'avvio di una modalita' {@link Geme}.
	 * @param parentMenu {@link BMenu} a cui appartiene il pulsante
	 * @param game modalit' da avviare
	 * @param buttonName nome del pulsante
	 * @param imageSet set di immagini
	 */
	public MenuButton(String buttonName, ButtonImageSet imageSet) {
		super();
		this.imageSet = imageSet;
		setButtonName(buttonName);
		enableInputMethods(true);
		setFocusable(true);
		init();
	}

	/**
	 * Costruisce un pulsante per l'avvio di una modalita' {@link Geme}.
	 * @param parentMenu {@link BMenu} a cui appartiene il pulsante
	 * @param game modalit' da avviare
	 * @param buttonName nome del pulsante
	 * @param imageSet set di immagini
	 * @param fontID nuovo font @see BFont
	 * @param fontSize dimensione nuovo font
	 */
	public MenuButton(String buttonName, ButtonImageSet imageSet, int fontID, float fontSize) {
		this(buttonName, imageSet);
		setBFont(fontID, fontSize);
	}
	
	private void init() {
		maxShift = 5;
		buttonImage = imageSet.getImageFromStatus(ButtonStatus.STATUS_OUT_FOCUS);
		drawingImageWidth = buttonImage.getWidth();
		drawingImageHeight = buttonImage.getHeight();
		int width =  drawingImageWidth + 2*maxShift;
		int height =  drawingImageHeight + 2*maxShift;
		buttondDim = new Dimension(width,height);
		xDrawing = maxShift;
		yDrawing = maxShift;
		addMouseListener(new ButtonMouseEventHandler(this));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buttonImage, xDrawing, yDrawing,drawingImageWidth, drawingImageHeight, null);
		if(needCentring){
			centreButtonName(g);
		}
		g.drawString(buttonName, xButtonName, yButtonName);
	}
	
	public abstract void action();
	
	/**
	 * Permette di centrare il nome del bottone, usando la metrics del font impostato e la dimensione del bottone.
	 * @param g
	 */
	public void centreButtonName(Graphics g) {
	    FontMetrics fm = g.getFontMetrics();
	    xButtonName = ( (int)buttondDim.getWidth() - fm.stringWidth(buttonName)) / 2;
	    yButtonName = (fm.getAscent() + ((int)buttondDim.getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
	    needCentring = false;
	}
	
	public void setButtondDimension(int width, int height) {
		this.buttondDim = new Dimension(width, height);
	}
	
	/**
	 * Permette di settare l'animazione del bottone.
	 * @see ButtonAnimator
	 * @param buttonAnimator
	 */
	public void setButtonAnimator(ButtonAnimator buttonAnimator) {
		this.buttonAnimator = buttonAnimator;
	}
	
	public ButtonAnimator getButtonAnimator() {
		return buttonAnimator;
	}
	
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
		needCentring = true;
	}
	
	/**
	 * Permette di inpostare un nuovo {@link BFont} e una nuova dimensione del font.
	 * @param fontID
	 * @param fontSize
	 */
	public void setBFont(int fontID, float fontSize) {
		this.bFont = Assets.getLoader().getFont(fontID);
		setBFontSize(fontSize);
	}
	
	public void setBFontSize(float fontSize) {
		setFont(bFont.getSizedFont(fontSize));
		needCentring = true;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return buttondDim;
	}
	
	@Override
	public Dimension getMinimumSize() {
		return buttondDim;
	}
	
	@Override
	public Dimension getMaximumSize() {
		return buttondDim;
	}
	
	public int getxDrawing() {
		return xDrawing;
	}

	public void setxDrawing(int xDrawing) {
		this.xDrawing = xDrawing;
	}

	public int getyDrawing() {
		return yDrawing;
	}

	public void setyDrawing(int yDrawing) {
		this.yDrawing = yDrawing;
	}

	public void setButtonStatus(int buttonStatus) {
		this.buttonImage = imageSet.getImageFromStatus(buttonStatus);
	}
	
	public int getButtonImageWidth() {
		return buttonImage.getWidth();
	}
	
	public int getButtonImageHeight() {
		return buttonImage.getHeight();
	}

	public void setDrawingImageWidth(int buttonImageWidth) {
		this.drawingImageWidth = buttonImageWidth;
	}

	public void setDrawingImageHeight(int buttonImageHeight) {
		this.drawingImageHeight = buttonImageHeight;
	}
}