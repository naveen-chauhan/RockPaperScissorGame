package svc;

import helper.GameTokenAdaptor;
import models.GameToken;

import java.util.Random;

/**
 * A Separate Class to implement all the various things computer can do.
 * @author naveen.chauhan on 06/08/22
 */
public class ComputerSvc {
	private static final Random random = new Random();

	private ComputerSvc() {}

	/**
	 * This method generate the Random GameToken for Computer Player.
	 * @return GameToken
	 * @see GameTokenAdaptor
	 * @see GameToken
	 */
	public static GameToken generateRandomGameToken() {
		return GameTokenAdaptor.adaptToGameTokenFromNumber(random.nextInt(3));
	}
}
