
package edu.ycp.cs496.ghosts.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import edu.ycp.cs496.ghosts.model.Gameplay;

public class GameplayController 
{
	Gameplay gameplayModel = new Gameplay();
	boolean spawnRed = false;
	boolean spawnYellow = false;
	boolean spawnWall = false;
	boolean spawnRare001 = false;
	int spawnValue = 0;
	
	int currentTime = 0;
	
	//timer to determine when to call for the next ghost
	@SuppressWarnings("deprecation")
	public void Timer()
	{
		int previousTime = currentTime;
		Calendar cal = Calendar.getInstance();
		currentTime = cal.getTime().getSeconds();
		if (currentTime - previousTime > 1)
		{
			setNextGhostBool(gameplayModel.getNextGhost());
		}
	}
	
	
	/**
	 * analyze the int value that is returned for the next ghost, set the correct boolean value in the array(may be unnecessary)
	 * and set the spawnValue to a number corresponding with the correct element
	 * 0 = empty
	 * 1 = red ghost
	 * 2 = yellow ghost
	 * 3 = wall
	 * 4 = rare ghost001
	 * @param nextGhost
	 * 
	 */

	public void setNextGhostBool(int nextGhost)
	{
	if (nextGhost >= 1 && nextGhost <= 45)
		{
			spawnValue = 1;
			spawnRed = true;
		}
		
		else if (nextGhost >= 46 && nextGhost <= 90)
		{
			spawnValue = 2;
			spawnYellow = true;
		}
		
		else if (nextGhost == 0)
		{
			spawnValue = 3;
			spawnWall = true;
		}
	
		else
		{
			if (gameplayModel.getRareGhost() == 1)
			{
				spawnValue = 4;
				spawnRare001 = true;
			}
		}
	}
	
	public int getSpawnValue()
	{
		return spawnValue;
	}
	 
}

