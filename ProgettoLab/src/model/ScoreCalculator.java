package model;

import java.util.Timer;
import java.util.TimerTask;


public class ScoreCalculator {
	
	private long score = 0;
	private static final int COEFF = 50;
	
	
	public void start(){
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {

				score = score+COEFF;
				System.out.println(score);
			}
		};
		timer.scheduleAtFixedRate(task, 0, 500);
	}

	public long getScore() {
		return score;
	}

}
