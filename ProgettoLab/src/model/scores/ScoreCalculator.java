package model.scores;


/**
 * Componente che si occupa del calcolo del punteggio.
 * @author Bianca
 */
public class ScoreCalculator {
	
	private ScoreKeeper scores = ScoreKeeper.getScoreKeeper();
	private long score = 0;
	private int coeff = 50;
	
	public void updateScore() {
		score += coeff;		
	}
	
	/**
	 * Restituisce il punteggio attuale.
	 * @return
	 */
	public long getScore() {
		return score;
	}

	public int getCoeff() {
		return coeff;
	}

	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}
	
	public void convalidateScore() {
		scores.addScore(score);
	}
	
	
}
