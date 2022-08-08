package svc;

import helper.GameTokenAdaptor;
import interfaces.IGameExecutor;
import lombok.extern.slf4j.Slf4j;
import models.GameResult;
import models.GameToken;
import models.Player;

import java.util.function.Predicate;

/**
 * The class is the main Game Service which interacts with the Main Driver Class to execute the game.
 *
 * @author naveen.chauhan on 06/08/22
 */
@Slf4j
public class GameSvc {
	private static final String ROBOT = "Computer";

	private final Predicate<String> isValidNumber =
			(str -> (str.equals("0") || str.equals("1") || str.equals("2")));

	private IGameExecutor gameExecutor;
	private final Player player1;
	private final Player player2;

	private GameSvc(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		gameExecutor = new RockPaperScissorExecutor();

	}

	public Predicate<String> getIsValidNumber() {
		return isValidNumber;
	}

	public static GameSvc startGame(String playerOneName) {
		GameSvc gameSvc = new GameSvc(new Player(playerOneName), new Player(ROBOT));
		log.info("Started the Game Svc");
		return gameSvc;
	}

	public void setGameExecutor(IGameExecutor gameExecutor) {
		this.gameExecutor = gameExecutor;
	}

	/**
	 * The method execute the game once the player has chosen with ROCK, PAPER, SCISSOR.
	 * @param playerInput - Player's Input, It can be in form of 0 - ROCK or 1 - PAPER or 2 - SCISSOR
	 * @see GameToken
	 * @see GameTokenAdaptor
	 * @see RockPaperScissorExecutor
	 */
	public void play(String playerInput) {
		//Step 1: Check if player has given the valid Input i.e. anything from {0 to 1}
		if (!isValidNumber.test(playerInput)) {
			//Logging for production where we use Logging instead of printing on the console
			log.warn("Invalid Input, Please try again, valid input are [0, 1, 2]");

			//Here we can throw an exception for invalid Input, But it will stop the Game. Hence, just printing the invalid Input message
			return;
		}

		//Step 2: Get the GameToken for player and Update the Game Token in Player Class.
		GameToken playerOneToken = GameTokenAdaptor.adaptToGameTokenFromNumber(Integer.parseInt(playerInput));
		player1.setToken(playerOneToken);

		//Step 3: Call the Computer Svc to generate the Computer's GameToken and Update the Player Two Details
		GameToken playerComputerToken = ComputerSvc.generateRandomGameToken();
		player2.setToken(playerComputerToken);

		//Logging the Player and Computer's GameToken
		log.info("You played: {} , Computer player played: {}", playerOneToken, playerComputerToken);

		//Call the gameExecutor to check to get the result of the Game
		log.debug("Calling the GameExecutor..");
		GameResult gameResult = gameExecutor.executeGame(player1, player2);

		if (gameResult.equals(GameResult.WON)) {
			System.out.println("CONGRATULATIONS !!, " + player1.getName() + " , You won!!");
		} else if (gameResult.equals(GameResult.LOST)) {
			System.out.println("OOPS !! You Lost :-(, Better Luck Next Time !!");
		} else {
			System.out.println("It's TIE !!. You can try again");
		}
	}
}
