package svc;

import interfaces.IGameExecutor;
import models.GameResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author naveen.chauhan on 06/08/22
 */
public class GameSvcTest {

	private GameSvc gameSvc;
	IGameExecutor gameExecutor  = Mockito.mock(RockPaperScissorExecutor.class);

	@Before
	public void setUp() throws Exception {
		gameSvc = GameSvc.startGame("Player1");
	}

	//For the valid Input, GameExecutor will be invoked once.
	@Test
	public void testPlayWhenPlayerPlayedValidInput() {
		gameSvc.setGameExecutor(gameExecutor);
		Mockito.when(gameExecutor.executeGame(Mockito.any(), Mockito.anyObject())).thenReturn(GameResult.WON);

		gameSvc.play("0");
		Mockito.verify(gameExecutor, Mockito.times(1)).executeGame(Mockito.any(), Mockito.anyObject());
	}

	//When Player add input which is not [0, 1, 2], then GameExecutor will not be invoked as GameSvc Precondition will fail
	@Test
	public void testPlayWhenPlayerPlayedInvalidInput() {
		gameSvc.setGameExecutor(gameExecutor);

		gameSvc.play("3");
		Mockito.verify(gameExecutor, Mockito.times(0)).executeGame(Mockito.any(), Mockito.anyObject());
	}

	//Test isValidNumber() Predicate's behaviour
	@Test
	public void testIsValidPredicateMethod() {
		Assert.assertTrue(gameSvc.getIsValidNumber().test("0"));
		Assert.assertTrue(gameSvc.getIsValidNumber().test("1"));
		Assert.assertTrue(gameSvc.getIsValidNumber().test("2"));

		Assert.assertFalse(gameSvc.getIsValidNumber().test("3"));
		Assert.assertFalse(gameSvc.getIsValidNumber().test("randomString"));
	}
}