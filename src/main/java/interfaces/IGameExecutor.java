package interfaces;

import models.GameResult;
import models.Player;

/**
 * An interface for Game, to implement the logic how game will decide the result.
 * @author naveen.chauhan on 06/08/22
 */
public interface IGameExecutor {

    /**
     * interface method to execute the core Logic of Game - Given the two players picks which player will win the game.
     * @param playerOne
     * @param playerTwo
     * @return GameResult
     * @see Player
     */
    GameResult executeGame(Player playerOne, Player playerTwo);
}
