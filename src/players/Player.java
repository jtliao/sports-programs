package players;

/**
 * A generic player with sport and name, to be extended by a player of specific sport
 * @author Jason Liao
 */
public abstract class Player {
	private String sport;
	private String name;
	private double salary;
	
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
	
	/**
	 * Set the salary of this player
	 * Not in the constructor since salary isn't necessary for all players, and the salary 
	 * isn't needed for many calculations, so making it necessary in the constructor would be
	 * an inconvenience
	 * @param salary- salary to be set
	 */
	public void setSalary(double salary){
		this.salary = salary;
	}
	/**
	 * @return the salary of this player
	 */
	public double getSalary(){
		return salary;
	}
}