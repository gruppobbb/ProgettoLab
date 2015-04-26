package test.server;

import model.scores.ScoreCalculator;

public class TestScore {
	
	public static void main(String[] args) {
		
		ScoreCalculator calc = new ScoreCalculator();
		calc.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calc.stop();
		
	}

}