package helper;

import exceptions.InvalidArgumentException;
import lombok.extern.slf4j.Slf4j;
import models.GameToken;

/**
 * An Adapter Class which converts the [0, 1, 2] into their respective GameToken
 * @author naveen.chauhan on 06/08/22
 */
@Slf4j
public class GameTokenAdaptor {
	private GameTokenAdaptor() {}

	/**
	 * This is a helper which convert the commandLine input - [0, 1, 2] into GameToken Enum.
	 * @param playerInput Integer input of Player.
	 * @return GameToken.
	 * @exception InvalidArgumentException On invalid playerInput.
	 * @see GameToken
	 */
    public static GameToken adaptToGameTokenFromNumber(Integer playerInput) {
		switch (playerInput) {
			case 0:
				return GameToken.ROCK;
			case 1:
				return GameToken.PAPER;
			case 2:
				return GameToken.SCISSOR;
			default:
				log.error("Invalid playerInput it should be either [0, 1, 2]");
				throw new InvalidArgumentException("Invalid playerInput it should be either [0, 1, 2]");

		}
    }
}
