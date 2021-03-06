package view2d.menu.button;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import view2d.menu.ButtonImageSet;
import view2d.menu.MenuButton;

public class WebLauncherMenuButton extends MenuButton{

	private static final long serialVersionUID = 1L;
	private String url;
	
	/**
	 * @param url
	 * @param buttonName
	 * @param imageSet
	 * @param fontID
	 * @param fontSize
	 */
	public WebLauncherMenuButton(String url, String buttonName,
			ButtonImageSet imageSet, int fontID, float fontSize) {
		super(buttonName, imageSet, fontID, fontSize);
		this.url = url;
	}

	/**
	 * @param url
	 * @param buttonName
	 * @param imageSet
	 */
	public WebLauncherMenuButton(String url, String buttonName, ButtonImageSet imageSet) {
		super(buttonName, imageSet);
		this.url = url;
	}

	/**
	 * @see MenuButton
	 */
	@Override
	public void action() {
		if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
	}
}
