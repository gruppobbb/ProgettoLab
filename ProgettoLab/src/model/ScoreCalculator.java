package model;

import java.util.Timer;
import java.util.TimerTask;


public class ScoreCalculator {
	
	private int score = 0;
	private static final int COEFF = 50;
	
	
	public void start(){
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {

				setScore(score+COEFF);
				System.out.println(score);
			}
		};
		timer.scheduleAtFixedRate(task, 0, 500);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
