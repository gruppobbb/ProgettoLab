package view2d.menu.button;

import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.scores.ScoreKeeper;
import view2d.menu.ButtonImageSet;
import view2d.menu.MenuButton;

public class HighscoresButton extends MenuButton{

	private static final long serialVersionUID = 1L;
	private ScoreKeeper scores = ScoreKeeper.getInstance();
	
	/**
	 * @param buttonName
	 * @param imageSet
	 */
	public HighscoresButton(String buttonName,
			ButtonImageSet imageSet) {
		super(buttonName, imageSet);
	}
	
	/**
	 * @see MenuButton
	 */
	@Override
	public void action() {
		// Fa partire il client per aggiornare i punteggi
//		IClient client = new LocalClient();
//		client.start(8080, "127.0.0.1");
		JFrame frame = new JFrame("Highscores");
		JPanel panel = new JPanel(new GridLayout(2, 1));
		frame.getContentPane().add(panel);
		
		TextArea scoreArea = new TextArea(getScoreText());
		scoreArea.setEditable(false);
		
		TextArea personalArea = new TextArea(
				"Hello, " +
				scores.getPlayerName() + "!\n" +
				"Your Personal Best is " + 
				scores.getPersonalBest()
		);
		personalArea.setEditable(false);
		
		panel.add(personalArea);
		panel.add(scoreArea);
		frame.setSize(400, 600);
		frame.setVisible(true);
	}
	
	private String getScoreText(){
		String scoreText = "Highscores\n";
		
		for (int i = 0; i < scores.getHighScores().size()-1; i++) {
			scoreText = scoreText+((i+1) + ") " +  scores.getHighScores().get(i).getPlayerName() +
					" - " + scores.getHighScores().get(i).getScore() + "\n");
		}
		return scoreText;
	}


}
