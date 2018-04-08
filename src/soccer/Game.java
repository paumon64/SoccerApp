package soccer;

import utility.GameUtils;

public class Game {
	
	private Team homeTeam;
	private Team awayTeam;
	private Goal[] goals;
	
	public Game(Team homeTeam, Team awayTeam) {
		
		this.setHomeTeam(homeTeam);
		this.setAwayTeam(awayTeam);
	}
	
	

	public void playGame(int maxGoals) {

		int numberOfGoals = (int) (Math.random()*(maxGoals+1));
		System.out.println("score "+numberOfGoals+" goals");
		
		Goal[] theGoals = new Goal [numberOfGoals];	
		this.setGoals(theGoals);		
		GameUtils.addGameGoals(this);
	
	}
	
	// overloading method playGame 8.3 exercise
	
	public void playGame() {
		
		playGame(6);
	}
	
	public String getDescription() {
		
		StringBuilder returnString = new StringBuilder();
		
		for (Goal currGoal: this.getGoals()) {
			returnString.append("Goal scored after " +
			currGoal.getTheTime() + " mins by " +
			currGoal.getThePlayer().getPlayerName() +
			" of " + currGoal.getTheTeam().getTeamName()+"\n");
			
		}
		
		return returnString.toString();
	}



	public Goal[] getGoals() {
		return goals;
	}



	public void setGoals(Goal[] goals) {
		this.goals = goals;
	}



	public Team getAwayTeam() {
		return awayTeam;
	}



	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}



	public Team getHomeTeam() {
		return homeTeam;
	}



	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	
}