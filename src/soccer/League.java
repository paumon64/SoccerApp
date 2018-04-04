package soccer;

import utility.GameUtils;

public class League {

	public static void main(String[] args) {

		/* 04.04.2018 @rumos
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

		Team[] theTeams = createTeams();

		Game[] theGames = createGames(theTeams);

		Game currGame = theGames[0];
		
		currGame.playGame();
		
		System.out.println(currGame.getDescription());
//		
//		int numberOfGoals = (int) (Math.random()*7);
//		System.out.println("socore "+numberOfGoals+" goals");
//		
//		Goal[] theGoals = new Goal [numberOfGoals];
//		
//		currGame.goals = theGoals;
		
		
//		GameUtils.addGameGoals(currGame);
//
//		for (Goal currGoal: currGame.goals) {
//			System.out.println("Goal scored after " +
//			currGoal.theTime + " mins by " +
//			currGoal.thePlayer.playerName +
//			" of " + currGoal.theTeam.teamName);
//		}
//		
		

		System.out.println("Game 1");
		System.out.println("Hometeam " + currGame.homeTeam.teamName + " Awayteam " + currGame.awayTeam.teamName);

		System.out.println("");
		System.out.println(currGame.homeTeam.teamName);
		for (Player thePlayerName : currGame.homeTeam.playerArray) {
			System.out.println(thePlayerName.playerName);
		}
		System.out.println("");
		System.out.println(currGame.awayTeam.teamName);
		for (Player thePlayerName : currGame.awayTeam.playerArray) {
			System.out.println(thePlayerName.playerName);
		}

		// create a goal

//		Goal goal1 = new Goal();
//		goal1.thePlayer = currGame.homeTeam.playerArray[2];
//		goal1.theTeam = currGame.homeTeam;
//		goal1.theTime = 55;
//
//		Goal[] theGoals = { goal1 };
//		currGame.goals = theGoals;
//
//		System.out.println("Goal scored after " + currGame.goals[0].theTime + " mins by "
//				+ currGame.goals[0].thePlayer.playerName + " of " + currGame.goals[0].theTeam.teamName);

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
		 * ")[0]); 
		 * System.out.println("Last name of player is " +
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
	}

	public static Team[] createTeams() {

		Team team1 = new Team();
		team1.teamName = "The Greens";

		Player player1 = new Player();
		player1.playerName = "George Eliot";
		Player player2 = new Player();
		player2.playerName = "Graham Greene";
		Player player3 = new Player();
		player3.playerName = "Geoffrey Chaucer";

		Player[] thePlayers = { player1, player2, player3 };

		team1.playerArray = thePlayers;

		// player1.playerName = "Robert Service";

		Team team2 = new Team();
		team2.teamName = "The Reds";

		team2.playerArray = new Player[3];

		team2.playerArray[0] = new Player();
		team2.playerArray[0].playerName = "Robert Service";
		team2.playerArray[1] = new Player();
		team2.playerArray[1].playerName = "Robbie Burns";
		team2.playerArray[2] = new Player();
		team2.playerArray[2].playerName = "Rafael Sabatini";

		Team team3 = new Team();
		team3.teamName = "The Blues";

		Player player4 = new Player();
		player4.playerName = "George Lucas";
		Player player5 = new Player();
		player5.playerName = "Francis Coppola";
		Player player6 = new Player();
		player6.playerName = "Rob Reiner";

		Player[] thePlayers3 = { player4, player5, player6 };

		team3.playerArray = thePlayers3;

		Team[] theTeams = { team1, team2, team3 };

		return theTeams;

	}

	public static Game[] createGames(Team[] theTeams) {

		Game theGame = new Game();

		theGame.homeTeam = theTeams[0];
		theGame.awayTeam = theTeams[2];

		Game[] theGames = { theGame };
		return theGames;

	}

}