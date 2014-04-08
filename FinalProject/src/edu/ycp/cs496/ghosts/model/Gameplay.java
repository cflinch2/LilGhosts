package edu.ycp.cs496.ghosts.model;
import java.util.Random;

public class Gameplay 
{
	float spawnRate;
	float rareSpawnRate;
	
	int currentScore;
	int playerHighScore;
	
	
	int aStart = 0;
	int aEnd = 4; //increment any time a new ghost is designed and implemented
	Random aRandom = new Random();
	int Min = 0;
	int Max = 4;
	int numRareGhosts = 1;	//increment any time a new RARE ghost is designed and implemented
	int nextGhost = 0;
	boolean spawnRed = false;
	boolean spawnYellow = false;
	boolean spawnWall = false;
	boolean spawnRare001 = false;
		
	boolean gameActive = false;
	int value;

	public void incrementSpawnRate(int incrementValue)
	{
		spawnRate = spawnRate + incrementValue;
	}
	
	public void decrementSpawnRate (int decrementValue)
	{
		spawnRate = spawnRate - decrementValue;
	}
	
	/**@author cflinch2
	 * Use this method with caution, it is probably better to use the incrementSpawnRate/decrementSpawnRate methods 
	 * @param newSpawnRate
	 */
	public void setSpawnRate (int newSpawnRate)
	{
		spawnRate = newSpawnRate;
	}
	
	public void incrementRareSpawnRate(int incrementValue)
	{
		rareSpawnRate += incrementValue;
	}
	
	public void decrementRareSpawnRate (int decrementValue)
	{
		rareSpawnRate -= decrementValue;
	}
	
	/**@author cflinch2
	 * Use this method with caution, it is probably better to use the incrementSpawnRate/decrementSpawnRate methods 
	 * @param newSpawnRate
	 */
	public void setRareSpawnRate (int newRareSpawnRate)
	{
		rareSpawnRate = newRareSpawnRate;
	}
	
	public int getCurrentScore()
	{
		return currentScore;
	}
	
	public void incrementCurrentScore(int incrementScoreValue)
	{
		currentScore += incrementScoreValue;
	}
	
	public void decrementCurrentScore(int decrementScoreValue)
	{
		currentScore -= decrementScoreValue;
	}
	
	public void incrementPlayerHighScore(int incrementScoreValue)
	{
		playerHighScore += incrementScoreValue;
	}
	
	/**
	 * Optional use, may not implement
	 */
	public void resetPlayerHighScore()
	{
		playerHighScore = 0;
	}
	

	
	/**@author cflinch2
	 * Generates a random number between predefined Min and Max (inclusive)
	 * which is used in another method to determine what the next ghost to be generated will be
	 * and sets that ghost value to true
	 * 
	 * If additional ghosts are added, the Min value must be updated in the Gameplay class.
	 * NOTE: Currently does NOT implement Rareity in any capacity
	 */
	public void updateNextGhost()
	{
		nextGhost = Min + (int)(Math.random() * ((Max - Min) + 1));
	}
	
	/**
	 *  This will be updated as more rare ghosts are added, which will be further divided by their rarity
	 */
	public int getRareGhost()
	{
		return nextGhost = 1 + (int)(Math.random() * ((numRareGhosts - 1) + 1));
	}
	
	
	
	public int getNextGhost()
	{
		updateNextGhost();
		return nextGhost;
	}
	
	public boolean getGameActive()
	{
		return gameActive;
	}
	
	public void setGameActive(boolean x)
	{
		if (x == true)
		{
			gameActive = true;
		}
		
		else
		{
			gameActive = false;
		}
	}
	
 
	
}
