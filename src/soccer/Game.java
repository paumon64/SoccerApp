package soccer;

import utility.GameUtils;

public class Game {
	
	public Team homeTeam;
	public Team awayTeam;
	public Goal[] goals;

	public void playGame(int maxGoals) {

		int numberOfGoals = (int) (Math.random()*(maxGoals+1));
		System.out.println("score "+numberOfGoals+" goals");
		
		Goal[] theGoals = new Goal [numberOfGoals];	
		this.goals = theGoals;		
		GameUtils.addGameGoals(this);
	
	}
	
	// overloading method playGame 8.3 exercise
	
	public void playGame() {
		
		playGame(6);
	}
	
	public String getDescription() {
		
		StringBuilder returnString = new StringBuilder();
		
		for (Goal currGoal: this.goals) {
			returnString.append("Goal scored after " +
			currGoal.getTheTime() + " mins by " +
			currGoal.getThePlayer().getPlayerName() +
			" of " + currGoal.getTheTeam().getTeamName()+"\n");
			
		}
		
		return returnString.toString();
	}
	
}