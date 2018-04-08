package soccer;

import java.time.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import utility.GameUtils;
import utility.PlayerDatabase;

public class League {

	public static void main(String[] args) {

		/*
		 * 05.04.2018 @home
		 * 
		 * replace by at the method createTeams
		 * 
		 * Player player1 = new Player(); player1.playerName = "George Eliot"; Player
		 * player2 = new Player(); player2.playerName = "Graham Greene"; Player player3
		 * = new Player(); player3.playerName = "Geoffrey Chaucer";
		 * 
		 * Player[] thePlayers = { player1, player2, player3 };
		 * 
		 * Team team1 = new Team(); team1.teamName = "The Greens"; team1.playerArray =
		 * thePlayers;
		 * 
		 * // player1.playerName = "Robert Service";
		 * 
		 * Team team2 = new Team(); team2.teamName = "The Reds";
		 * 
		 * team2.playerArray = new Player[3];
		 * 
		 * team2.playerArray[0] = new Player(); team2.playerArray[0].playerName =
		 * "Robert Service"; team2.playerArray[1] = new Player();
		 * team2.playerArray[1].playerName = "Robbie Burns"; team2.playerArray[2] = new
		 * Player(); team2.playerArray[2].playerName = "Rafael Sabatini"; /* 2 print the
		 * player names
		 * 
		 * for (Player thePlayer : team1.playerArray) {
		 * 
		 * System.out.println(thePlayer.playerName); }
		 * 
		 * System.out.println(""); for (Player thePlayer : team2.playerArray) {
		 * 
		 * System.out.println(thePlayer.playerName); }
		 */

		// make leagues a instance

		League theLeague = new League();

		Team[] theTeams = theLeague.createTeams("The Robins,The Crows,The Swallows", 3);
		Game[] theGames = theLeague.createGames(theTeams);

		// exercise 8.2

		// Game currGame = theGames[0];

		// currGame.playGame(3);
		
		System.out.println(theLeague.getLeagueAnnouncement(theGames));

		for (Game currGame : theGames) {
			currGame.playGame();
		
			System.out.println(currGame.getDescription());
		
		
		}

		//
		// int numberOfGoals = (int) (Math.random()*7);
		// System.out.println("score "+numberOfGoals+" goals");
		//
		// Goal[] theGoals = new Goal [numberOfGoals];
		//
		// currGame.goals = theGoals;

		// GameUtils.addGameGoals(currGame);
		//
		// for (Goal currGoal: currGame.goals) {
		// System.out.println("Goal scored after " +
		// currGoal.theTime + " mins by " +
		// currGoal.thePlayer.playerName +
		// " of " + currGoal.theTeam.teamName);
		// }
		//

		// System.out.println("Game 1");
		// System.out.println("Hometeam " + currGame.homeTeam.teamName + " Awayteam " +
		// currGame.awayTeam.teamName);
		//
		// System.out.println("");
		// System.out.println(currGame.homeTeam.teamName);
		// for (Player thePlayerName : currGame.homeTeam.playerArray) {
		// System.out.println(thePlayerName.playerName);
		// }
		// System.out.println("");
		// System.out.println(currGame.awayTeam.teamName);
		// for (Player thePlayerName : currGame.awayTeam.playerArray) {
		// System.out.println(thePlayerName.playerName);
		// }

		// create a goal

		// Goal goal1 = new Goal();
		// goal1.thePlayer = currGame.homeTeam.playerArray[2];
		// goal1.theTeam = currGame.homeTeam;
		// goal1.theTime = 55;
		//
		// Goal[] theGoals = { goal1 };
		// currGame.goals = theGoals;
		//
		// System.out.println("Goal scored after " + currGame.goals[0].theTime + " mins
		// by "
		// + currGame.goals[0].thePlayer.playerName + " of " +
		// currGame.goals[0].theTeam.teamName);

		/*
		 * 
		 * exercise 7.1 find out whether the Blues/team2 have a player called Sabatini.
		 * match and split string methods
		 * 
		 */

		/**
		 * for (Player thePlayer : team2.playerArray) {
		 * 
		 * if (thePlayer.playerName.matches(".*Sabat.*")) {
		 * 
		 * thePlayer.playerName.split(" ");
		 * 
		 * System.out.println("First name of player is " + thePlayer.playerName.split("
		 * ")[0]); System.out.println("Last name of player is " +
		 * thePlayer.playerName.split(" ")[1]); System.out.println("Full name is " + " "
		 * + thePlayer.playerName); }
		 * 
		 * }
		 * 
		 * for (Player thePlayer : team1.playerArray) {
		 * 
		 * System.out.println("Full name is " + " " + thePlayer.playerName);
		 * 
		 * // thePlayer.playerName.split(" ");
		 * 
		 * System.out.println("First name of player is " + thePlayer.playerName.split("
		 * ")[0]); System.out.println("Last name of player is " +
		 * thePlayer.playerName.split(" ")[1]);
		 * 
		 * }
		 * 
		 * // StringBuilder to build up the name in the new format.
		 * 
		 * StringBuilder familyNameFirst = new StringBuilder();
		 * 
		 * for (Player thePlayer : team2.playerArray) {
		 * 
		 * thePlayer.playerName.split(" ");
		 * 
		 * familyNameFirst.append(thePlayer.playerName.split(" ")[1]);
		 * familyNameFirst.append(", ");
		 * familyNameFirst.append(thePlayer.playerName.split(" ")[0]);
		 * familyNameFirst.append("; ");
		 * 
		 * System.out.println("Player's family name first - " + familyNameFirst);
		 * familyNameFirst.delete(0, familyNameFirst.length());
		 * 
		 * }
		 * 
		 **/

	//	theLeague.showBestTeam(theTeams);
	}

	public void showBestTeam(Team[] theTeams) {

		Team currBestTeam = theTeams[0];

		System.out.println("\nTeams Points");

		for (Team currTeam : theTeams) {

			System.out.println(currTeam.getTeamName() + ":" + currTeam.getPointsTotal());

			currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal() ? currTeam : currBestTeam;
		}

		System.out.println("Winner of the league is " + currBestTeam.getTeamName());
	}

	public Team[] createTeams(String teamNames, int teamSize) {

		PlayerDatabase playerDB = new PlayerDatabase();
		StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ",");

		Team[] theTeams = new Team[teamNameTokens.countTokens()];

		for (int i = 0; i < theTeams.length; i++) {
			theTeams[i] = new Team(teamNameTokens.nextToken(), playerDB.getTeam(teamSize));
		}

		// Team team1 = new Team();
		// team1.teamName = "The Greens";

		// Player player1 = new Player("George Eliot");
		// // player1.playerName = "George Eliot";
		// Player player2 = new Player("Graham Greene");
		// // player2.playerName = ;
		// Player player3 = new Player("Geoffrey Chaucer");
		// // player3.playerName = "Geoffrey Chaucer";
		//
		// Player[] thePlayers = { player1, player2, player3 };

		// Team team1 = new Team("The Greens", playerDB.getTeam(3));

		// team1.playerArray = thePlayers;

		// player1.playerName = "Robert Service";

		// Team team2 = new Team();
		// // team2.teamName = "The Reds";
		// // team2.playerArray = new Player[3];
		//
		// team2.setTeamName("The Reds");
		// team2.setPlayerArray(new Player[3]);
		// team2.getPlayerArray()[0] = new Player("Robert Service");
		// // team2.playerArray[0].playerName = "Robert Service";
		// team2.getPlayerArray()[1] = new Player("Robbie Burns");
		// // team2.playerArray[1].playerName = "Robbie Burns";
		// team2.getPlayerArray()[2] = new Player("Rafael Sabatini");
		// // team2.playerArray[2].playerName = "Rafael Sabatini";

		// Team team3 = new Team();
		// team3.teamName = "The Blues";
		//
		//
		// Team team2 = new Team();
		// team2.teamName = "The Reds";
		// team2.playerArray = new Player[3];

		// Player player4 = new Player();
		// player4.playerName = "George Lucas";
		// Player player5 = new Player();
		// player5.playerName = "Francis Coppola";
		// Player player6 = new Player();
		// player6.playerName = "Rob Reiner";
		//
		// Player[] thePlayers3 = { player4, player5, player6 };
		//
		// team3.playerArray = thePlayers3;

		// Team team2 = new Team("The Reds", playerDB.getTeam(3));
		//
		// Team[] teams = { team1, team2 };

		return theTeams;

	}

	public Game[] createGames(Team[] theTeams) {

		// Game theGame = new Game(teams[0], teams[1]);
		//
		// // theGame.homeTeam = theTeams[0];
		// // theGame.awayTeam = theTeams[1];
		//
		// Game[] theGames = { theGame };

		// complete championship

		ArrayList<Game> theGames = new ArrayList<Game>();

		int daysBetweenGames = 0;

		for (Team homeTeam : theTeams) {
			for (Team awayTeam : theTeams) {
				if (homeTeam != awayTeam) {
					daysBetweenGames += 7;
					theGames.add(new Game(homeTeam, awayTeam, LocalDateTime.now().plusDays(daysBetweenGames)));
				}
			}
		}
		return (Game[]) theGames.toArray(new Game[1]);
	}

	public String getLeagueAnnouncement(Game[] theGames) {

		Period thePeriod = Period.between(theGames[0].getTheDateTime().toLocalDate(),
				theGames[theGames.length - 1].getTheDateTime().toLocalDate());
		
		return "The League is scheduled to run for " +
		thePeriod.getMonths() + " month(s), and " +
		thePeriod.getDays() + " day(s)\n";

	}

}