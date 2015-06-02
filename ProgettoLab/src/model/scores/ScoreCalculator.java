package model.scores;

import java.util.Observable;

/**
 * Componente che si occupa del calcolo del punteggio. E' un observable, che informa gli osservatori quando il punteggio è cambiato.
 * @author Bianca
 */
public class ScoreCalculator extends Observable {
	
	private static final int DEFAULT_COEFF = 50;
	private ScoreKeeper scores = ScoreKeeper.getInstance();
	private long score;
	private int coeff;
	
	public ScoreCalculator() {
		coeff = DEFAULT_COEFF;
	}
	
	/** 
	 * @param coeff Coefficiente di incremento del punteggio
	 */
	public ScoreCalculator(int coeff) {
		this.coeff = coeff;
	}
	
	/**
	 * Aggiorna il punteggio, incrementandolo di coeff.
	 */
	public void updateScore() {
		score += coeff;		
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Restituisce il punteggio attuale.
	 * @return punteggio attuale
	 */
	public long getScore() {
		return score;
	}

	/**
	 * Restituisce il coefficiente di aggiornamento.
	 * @return Coefficiente di aggiornamento
	 */
	public int getCoeff() {
		return coeff;
	}

	/**
	 * Imposta il coefficiente di aggiornamento.
	 * @param Coefficiente di aggiornamento
	 */
	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}
	
	/**
	 * Convalida il punteggio, passandolo allo {@link ScoreKeeper}.
	 */
	public void convalidateScore() {
		scores.addScore(score);
	}
	
	
}
