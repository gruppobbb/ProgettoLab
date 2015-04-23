package view2d.menu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view2d.menu.ButtonImageSet.ButtonStatus;

/**
 * Classe per la gestione degli eventi del mouse per un {@link MenuButton}.
 * @author Jan
 */
public class ButtonMouseEventHandler implements MouseListener {

	private MenuButton button;
	
	/**
	 * Costruisce un listener dedicato ai {@link MenuButton}.
	 * @param button
	 */
	public ButtonMouseEventHandler(MenuButton button) {
		this.button = button;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if(button.getButtonAnimator()!= null){
			button.getButtonAnimator().runAnimation(true);
		}
		button.setButtonStatus(ButtonStatus.STATUS_ON_FOCUS_UNPRESSED);
		button.repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(button.getButtonAnimator()!= null){
			button.getButtonAnimator().runAnimation(false);
		}
		button.setButtonStatus(ButtonStatus.STATUS_OUT_FOCUS);
		button.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		button.setButtonStatus(ButtonStatus.STATUS_ON_FOCUS_PRESSED);
		button.repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		button.setButtonStatus(ButtonStatus.STATUS_ON_FOCUS_UNPRESSED);
		button.repaint();
		button.openPanel();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
}
