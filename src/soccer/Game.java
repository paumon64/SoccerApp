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

		int numberOfGoals = (int) (Math.random() * (maxGoals + 1));
		System.out.println("score " + numberOfGoals + " goals");

		Goal[] theGoals = new Goal[numberOfGoals];
		this.setGoals(theGoals);
		GameUtils.addGameGoals(this);
	}

	// overloading method playGame 8.3 exercise

	public void playGame() {

		playGame(6);
	}

	public String getDescription() {
		
		int homeTeamGoals = 0;
		int awayTeamGoals = 0;
		
		
		StringBuilder returnString = new StringBuilder();
		
		returnString.append(homeTeam.getTeamName() + " vs. " + awayTeam.getTeamName() + "\n");
		
		for (Goal currGoal: this.getGoals()) {
			returnString.append("Goal scored after " +
			currGoal.getTheTime() + " mins by " +
			currGoal.getThePlayer().getPlayerName() +
			" of " + currGoal.getTheTeam().getTeamName()+"\n");
			
			if (currGoal.getTheTeam()== homeTeam) {
				homeTeamGoals++;
			}
			else
				awayTeamGoals++;
			
		}
		
		if (homeTeamGoals == awayTeamGoals) {
			
			returnString.append("It's a draw!");
			homeTeam.incPointsTotal(1);
			awayTeam.incPointsTotal(1);
			
			}
				else if (homeTeamGoals > awayTeamGoals) {
				
				returnString.append(returnString.append(homeTeam.getTeamName()+ " win"));
				homeTeam.incPointsTotal(2);
		}
		
		else {
			returnString.append(returnString.append(awayTeam.getTeamName()+ " win"));
			awayTeam.incPointsTotal(2);
			}
		returnString.append(" ("+ homeTeamGoals + " - " +awayTeamGoals + ") \n");
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