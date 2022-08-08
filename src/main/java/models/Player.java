package models;

/**
 * Model Class to Get the Basic Information of Players like - name of Player, what token it has chosen
 * @author naveen.chauhan on 06/08/22
 */
public class Player {
	private final String name;
	private GameToken token;

	public Player(String name) {
		this.name = name;
	}

	public GameToken getToken() {
		return token;
	}

	public void setToken(GameToken token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}
}
