/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import soccer.*;

/**
 *
 * @author ksomervi
 */
public class GameUtils {

    public static void addGameGoals(Game currGame) {

        if (currGame.getGameEvent() == null) {
            currGame.setGameEvent(new Goal[(int) (Math.random() * 10)]);   // If goals not initialized max will be 9
        }

        //System.out.println(currGame.goals.length);
        int i = 0;
        for (GameEvent currGameEvent : currGame.getGameEvent()) {
            currGameEvent = new Goal();
            currGameEvent.setTheTeam(Math.random() > 0.5 ? getHomeTeam(currGame, "home") : getHomeTeam(currGame, "away"));
            currGameEvent.setThePlayer(currGameEvent.getTheTeam().getPlayerArray()[(int) (Math.random() * currGameEvent.getTheTeam().getPlayerArray().length)]);
            currGameEvent.setTheTime((int) (Math.random() * 90));
            currGame.getGameEvent()[i] = currGameEvent;
            i++;
        }
        Arrays.sort(currGame.getGameEvent(), (g1, g2) -> Double.valueOf(g1.getTheTime()).compareTo(Double.valueOf(g2.getTheTime())));

    }

    // Uses reflection so works with getter method or public field
    private static Team getHomeTeam(Game currGame, String homeOrAway) {
        Team theTeam = null;
        Method m;
        Field f;
        try {
            m = Game.class.getMethod("get" + Character.toUpperCase(homeOrAway.charAt(0)) + homeOrAway.substring(1) + "Team");
            theTeam = (Team)m.invoke(currGame);
        } catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException em) {
            try {
                f = Game.class.getField(homeOrAway + "Team");
                theTeam = (Team)f.get(currGame);
            } catch (NoSuchFieldException|IllegalAccessException ef) { 
                System.out.println("The addGoals() utility requires the Goal class to contain either:\n" +
                        "public String fields called homeTeam and awayTeam, OR,\n" +
                        "public accessor methods called getHomeTeam() and getAwayTeam().");
            }
        }
        return theTeam;
    }
}
