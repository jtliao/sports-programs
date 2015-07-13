package players;

public abstract class Player {
	private String sport = null; 
	private String name = null;
	
	public Player(String sport, String name){
		this.sport = sport;
		this.name = name;
	}
	
	public String getSport(){
		return sport; 
	}
	
	public String getName(){
		return name;
	}

}
