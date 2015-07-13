package players;

public abstract class Player {
	private String sport;
	private String name;
	
	/**
	 * Initialize a player with specified sport and name
	 * @param sport- the sport this player plays
	 * @param name- this player's name
	 */
	public Player(String sport, String name){
		this.sport = sport;
		this.name = name;
	}
	
	/**
	 * @return the sport of this player 
	 */
	public String getSport(){
		return sport; 
	}
	
	/**
	 * @return the name of this player
	 */
	public String getName(){
		return name;
	}
}