package view2d.menu;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Animazione che effettua lo zoom-in e zoom-out del {@link MenuButton}
 *  quando il mouse vi si posiziona sopra.
 * @author Jancarlos
 */
public class SimpleButtonAnimation implements ButtonAnimator{

	private MenuButton button;
	private Timer timer;
	private int delta = 1;
	private int maxShift, shift;
	private int xStart, yStart;
	private int buttonImageWidth, buttonImageHeight;
	private boolean needSave;
	
	public SimpleButtonAnimation(MenuButton button, int maxShift) {
		super();
		this.button = button;
		this.maxShift = maxShift;
		needSave = true;
	}
	
	@Override
	public void runAnimation(boolean running) {
		if(running){
			if(needSave){
				xStart = button.getxDrawing();
				yStart = button.getyDrawing();
				buttonImageWidth = button.getButtonImageWidth();
				buttonImageHeight = button.getButtonImageHeight();
				needSave = false;
			}
			timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					if(shift<=0){
						delta = 1;
					}else if(shift >= maxShift-1){
						delta = -1;
					}
					shift += delta;
					button.setxDrawing(xStart-shift);
					button.setyDrawing(yStart-shift);
					button.setDrawingImageWidth(buttonImageWidth+shift+shift);
					button.setDrawingImageHeight(buttonImageHeight+shift+shift);
					button.repaint();
				}
			}, 100, 100);
		}else{
			button.setxDrawing(xStart);
			button.setyDrawing(yStart);
			button.setDrawingImageWidth(buttonImageWidth);
			button.setDrawingImageHeight(buttonImageHeight);
			needSave = true;
			timer.cancel();
		}
	}
}
