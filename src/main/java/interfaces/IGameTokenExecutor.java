package interfaces;

import models.GameResult;
import models.GameToken;

/**
 * An interface to implement the logic what will be the gameResult for each GameToken. Each GameToken will write logic for themselves.
 * @author naveen.chauhan on 06/08/22
 */
public interface IGameTokenExecutor {

   /**
    * interface method to check given two GameToken, which token will win. For Example - ROCK - SCISSOR - ROCK will win.
    * Each Enum Literal Implement its own Logic for win or loss
    * @param playerTwoToken
    * @return GameResult
    * @see GameToken
    */
   GameResult getResult(GameToken playerTwoToken);
}
