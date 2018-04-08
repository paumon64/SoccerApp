package soccer;

import java.awt.Event;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import utility.GameUtils;

public class Game {

	private Team homeTeam;
	private Team awayTeam;
	private Goal[] goals;
	private LocalDateTime theDateTime;

	public Game(Team homeTeam, Team awayTeam, LocalDateTime theDateTime) {

		this.setHomeTeam(homeTeam);
		this.setAwayTeam(awayTeam);
		this.theDateTime = theDateTime;
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

		// playGame(6);

		ArrayList<Goal> eventList = new ArrayList();

		Goal currEvent;

		for (int i = 1; i <= 90; i++) {
			if (Math.random() > 0.95) {

				currEvent = new Goal();
				currEvent.setTheTeam(Math.random() > 0.5 ? homeTeam : awayTeam);
				currEvent.setThePlayer(currEvent.getTheTeam()
						.getPlayerArray()[(int) (Math.random() * currEvent.getTheTeam().getPlayerArray().length)]);
				currEvent.setTheTime(i);
				eventList.add(currEvent);
			}
		}
		this.goals = new Goal[eventList.size()];
		eventList.toArray(goals);
	}

	public String getDescription() {

		int homeTeamGoals = 0;
		int awayTeamGoals = 0;

		StringBuilder returnString = new StringBuilder();
		System.out.println("");
		returnString.append(homeTeam.getTeamName() + " vs. " + awayTeam.getTeamName() + "Date "
				+ this.theDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n");

		for (Goal currGoal : this.getGoals()) {
			returnString.append("Goal scored after " + currGoal.getTheTime() + " mins by "
					+ currGoal.getThePlayer().getPlayerName() + " of " + currGoal.getTheTeam().getTeamName() + "\n");

			if (currGoal.getTheTeam() == homeTeam) {
				homeTeamGoals++;
			} else
				awayTeamGoals++;

		}

		if (homeTeamGoals == awayTeamGoals) {

			returnString.append("It's a draw!");
			homeTeam.incPointsTotal(1);
			awayTeam.incPointsTotal(1);

		} else if (homeTeamGoals > awayTeamGoals) {

			returnString.append(returnString.append(homeTeam.getTeamName() + " win"));
			homeTeam.incPointsTotal(2);
		}

		else {
			returnString.append(returnString.append(awayTeam.getTeamName() + " win"));
			awayTeam.incPointsTotal(2);
		}

		System.out.println("");
		returnString.append(" (" + homeTeamGoals + " - " + awayTeamGoals + ") \n");
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

	public LocalDateTime getTheDateTime() {

		return LocalDateTime.now();
	}

}