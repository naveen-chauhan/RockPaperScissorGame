package svc;

import interfaces.IGameExecutor;
import models.GameResult;
import models.GameToken;
import models.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class to Test RockPaperScissorExecutor's executeGame method
 * @author naveen.chauhan on 06/08/22
 */
public class RockPaperScissorExecutorTest {
	private IGameExecutor gameExecutor;

	@Before
	public void setUp() throws Exception {
		gameExecutor = new RockPaperScissorExecutor();
	}

	//Testcase: when Player1 player ROCK, and second player token is interchanging
	@Test
	public void testExecuteGameWhenPlayerPlayedROCK() {
		Player playerOne = generatePlayerInfo("Player1", GameToken.ROCK);
		Player playerTwo = generatePlayerInfo("Player2", GameToken.SCISSOR);

		Assert.assertEquals(GameResult.WON, gameExecutor.executeGame(playerOne, playerTwo));

		playerTwo.setToken(GameToken.ROCK);
		Assert.assertEquals(GameResult.TIE, gameExecutor.executeGame(playerOne, playerTwo));

		playerTwo.setToken(GameToken.PAPER);
		Assert.assertEquals(GameResult.LOST, gameExecutor.executeGame(playerOne, playerTwo));
	}

	//Testcase: when Player1 player PAPER, check for all the playerTwo Options
	@Test
	public void testExecuteGameWhenPlayerPlayedPAPER() {
		Player playerOne = generatePlayerInfo("Player1", GameToken.PAPER);
		Player playerTwo = generatePlayerInfo("Player2", GameToken.ROCK);

		Assert.assertEquals(GameResult.WON, gameExecutor.executeGame(playerOne, playerTwo));

		playerTwo.setToken(GameToken.PAPER);
		Assert.assertEquals(GameResult.TIE, gameExecutor.executeGame(playerOne, playerTwo));

		playerTwo.setToken(GameToken.SCISSOR);
		Assert.assertEquals(GameResult.LOST, gameExecutor.executeGame(playerOne, playerTwo));
	}

	//Testcase: when Player1 played SCISSOR, check for all the playerTwo Options
	@Test
	public void testExecuteGameWhenPlayerPlayedSCISSOR() {
		Player playerOne = generatePlayerInfo("Player1", GameToken.SCISSOR);
		Player playerTwo = generatePlayerInfo("Player2", GameToken.PAPER);

		Assert.assertEquals(GameResult.WON, gameExecutor.executeGame(playerOne, playerTwo));

		playerTwo.setToken(GameToken.SCISSOR);
		Assert.assertEquals(GameResult.TIE, gameExecutor.executeGame(playerOne, playerTwo));

		playerTwo.setToken(GameToken.ROCK);
		Assert.assertEquals(GameResult.LOST, gameExecutor.executeGame(playerOne, playerTwo));
	}

	private Player generatePlayerInfo(String playerName, GameToken gameToken) {
		Player player = new Player(playerName);
		player.setToken(gameToken);
		return player;
	}
}