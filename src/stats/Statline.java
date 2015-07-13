package stats;

public class Statline {
	private double points; //points per game
	private double fgp;
	private double threes; //threes per game
	private double threepp; //three point percentage
	private double ftm;
	private double ftp;
	private double rebounds;
	private double assists; 
	private double steals;
	private double blocks;
	private double turnovers;

	public Statline(double points, double fgp, double threes, double threepp, double ftm, double ftp, double rebounds, double assists, double steals, double blocks, double turnovers) {
		this.points = points;
		this.fgp = fgp;
		this.threes = threes;
		this.threepp = threepp;
		this.ftm = ftm;
		this.ftp = ftp;
		this.rebounds = rebounds; 
		this.assists = assists; 
		this.steals = steals;
		this.blocks = blocks;
		this.turnovers = turnovers; 
	}
	
	public double getPoints(){
		return points; 
	}
	
	public double getFgp(){
		return fgp; 
	}
	
	public double getThrees(){
		return threes; 
	}
	
	public double getThreepp(){
		return threepp; 
	}
	
	public double getFtm(){
		return ftm; 
	}
	
	public double getFtp(){
		return ftp; 
	}
	
	public double getRebounds(){
		return rebounds; 
	}
	
	public double getAssists(){
		return assists; 
	}
	
	public double getSteals(){
		return steals; 
	}
	
	public double getBlocks(){
		return blocks; 
	}
	
	public double getTurnovers(){
		return turnovers; 
	}

}
