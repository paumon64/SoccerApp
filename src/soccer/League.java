package soccer;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.StringTokenizer;

import utility.PlayerDatabase;

// @rumos 11.04.2018

public class League {

	public static void main(String[] args) {

		League theLeague = new League();
		Team[] theTeams = theLeague.createTeams("The Robins,The Crows,The Swallows", 3);
		Game[] theGames = theLeague.createGames(theTeams);
		
		System.out.println(theLeague.getLeagueAnnouncement(theGames));

		int contador = 1;
		for (Game currGame : theGames) {
			currGame.playGame();
			
			System.out.println(currGame.getDescription());
			contador++;
			theLeague.showBestTeam(theTeams);
					
		}
	}

	public Team[] createTeams(String teamNames, int teamSize) { // Criar equipas e jogadores

		PlayerDatabase playerDatabase = new PlayerDatabase();

		Team team1 = new Team("The Greens", playerDatabase.getTeam(3));
		Team team2 = new Team("The Reds", playerDatabase.getTeam(3));

		StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ",");
		Team[] theTeams = new Team[teamNameTokens.countTokens()];

		for (int i = 0; i < theTeams.length; i++) {
			theTeams[i] = new Team(teamNameTokens.nextToken(), playerDatabase.getTeam(teamSize));
		}

		return theTeams;

	}

	public Game[] createGames(Team[] theTeams) { // Criar o jogos

		ArrayList<Game> theGames = new ArrayList<Game>();
		int daysBetweenGames = 0;
		for (Team homeTeam : theTeams) {
			for (Team awayTeam : theTeams) {
				if (homeTeam != awayTeam) {
					daysBetweenGames+=7;
					theGames.add(new Game(homeTeam, awayTeam, LocalDateTime.now().plusDays(daysBetweenGames)));
				}
			}
		}
		return (Game[]) theGames.toArray( new Game[1] );
	}

	public void showBestTeam(Team[] theTeams) {
		Team currBestTeam = theTeams[0];
		System.out.println("\nTeam Points:");
		for (Team currTeam : theTeams) {
			System.out.println(currTeam.getTeamName() + ":" + currTeam.getPointsTotal() + " --" + "Total goals: "
					+ currTeam.getGoalsTotal());
			currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal() ? currTeam : currBestTeam;

			if (currTeam.getPointsTotal() == currBestTeam.getPointsTotal()) {
				currBestTeam = currTeam;
			} else if (currTeam.getPointsTotal() == currBestTeam.getPointsTotal()) {
				if (currTeam.getGoalsTotal() > currBestTeam.getGoalsTotal()) {

				}
			}
		}

		System.out.println("Winner of the League is : " + currBestTeam.getTeamName());
		System.out.println(currBestTeam.getTeamName() + ":" + "\tTotal points: " + currBestTeam.getPointsTotal()
				+ " \tTotal Goals: " + currBestTeam.getGoalsTotal());

	}
	public String getLeagueAnnouncement(Game[] theGames){
		
		Game firstGame = theGames[0];
		Game lastGame = theGames[theGames.length-1];
		
		Period thePeriod =Period.between(firstGame.getTheDateTime().toLocalDate(),lastGame.getTheDateTime().toLocalDate());
		
//		Period thePeriod =Period.between(theGames[0].getTheDateTime().toLocalDate(),
//				theGames[theGames.length - 1].getTheDateTime().toLocalDate());
		
		return "The League is scheduled to run for " +thePeriod.getMonths() + " month(s), and " +
		thePeriod.getDays() + " day(s)\n";
		
	}
}