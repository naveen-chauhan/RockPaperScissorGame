package svc;

import interfaces.IGameExecutor;
import lombok.extern.slf4j.Slf4j;
import models.GameResult;
import models.Player;

/**
 * The class execute the core logic of Game. Please refer the method documentation section for details.
 * @author naveen.chauhan on 06/08/22
 */
@Slf4j
public class RockPaperScissorExecutor implements IGameExecutor {

	/**
	 * The method will execute the core Logic of Game - Given the two players picks which player will win the game.
	 * @param playerOne The first value
	 * @param playerTwo The second value
	 * @return GameResult - WON - playerOne Won, LOST - PlayerTwo Won, TIE - if Game is Tie.
	 * @see Player
	 */
	@Override
	public GameResult executeGame(Player playerOne, Player playerTwo) {
		log.debug("Getting the Result for the Player: {} and Token: {}", playerOne.getName(), playerOne.getToken().name());
		return playerOne.getToken().getResult(playerTwo.getToken());
	}

}
