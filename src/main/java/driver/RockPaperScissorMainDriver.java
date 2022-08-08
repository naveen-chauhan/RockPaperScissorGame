package driver;

import lombok.extern.slf4j.Slf4j;
import svc.GameSvc;

import java.util.Scanner;

/**
 * Main Driver Class to start the Game. Take input from the command prompt and calls GameSvc Class to execute the game.
 * @see GameSvc
 * @author naveen.chauhan on 06/08/22
 */
@Slf4j
public class RockPaperScissorMainDriver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Hello Player!!, Please enter your name to start the Game: ");
		String input = scanner.nextLine();
		log.info("Hello {} !!", input);

		GameSvc gameSvc = GameSvc.startGame(input);

		while (!input.equalsIgnoreCase("EXIT")) {
			System.out.println("Please Enter the number, Here 0 - \"Rock\", 1 - \"Paper\", 2 - \"Scissor\", Or Enter \"Exit\" to end the game");
			input = scanner.nextLine();
			gameSvc.play(input);
		}
	}
}
