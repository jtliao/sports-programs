package stats;

public class Statline {
	private double points; 
	private double fgp;
	private double threes; 
	private double threepp; 
	private double ftm;
	private double ftp;
	private double rebounds;
	private double assists; 
	private double steals;
	private double blocks;
	private double turnovers;

	/**
	 * Initialize a statline with specified stats
	 * @param points- points per game
	 * @param fgp- field goal percentage
	 * @param threes- threes per game
	 * @param threepp- three point percentage
	 * @param ftm- free throws made per game
	 * @param ftp- free throw percentage
	 * @param rebounds- rebounds per game
	 * @param assists- assists per game
	 * @param steals- steals per game
	 * @param blocks- blocks per game
	 * @param turnovers- turnovers per game
	 */
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
	
	/**
	 * @return this statline's points per game
	 */
	public double getPoints(){
		return points; 
	}
	
	/**
	 * @return this statline's field goal percentage
	 */
	public double getFgp(){
		return fgp; 
	}
	
	/**
	 * @return this statline's threes made per game
	 */
	public double getThrees(){
		return threes; 
	}
	
	/**
	 * @return this statline's three point percentage
	 */
	public double getThreepp(){
		return threepp; 
	}
	
	/**
	 * @return this statline's free throws made per game
	 */
	public double getFtm(){
		return ftm; 
	}
	
	/**
	 * @return this statline's free throw percentage
	 */
	public double getFtp(){
		return ftp; 
	}
	
	/**
	 * @return this statline's rebounds per game
	 */
	public double getRebounds(){
		return rebounds; 
	}
	
	/**
	 * @return this statline's assists per game
	 */
	public double getAssists(){
		return assists; 
	}
	
	/**
	 * @return this statline's steals per game
	 */
	public double getSteals(){
		return steals; 
	}
	
	/**
	 * @return this statline's blocks per game
	 */
	public double getBlocks(){
		return blocks; 
	}
	
	/**
	 * @return this statline's turnovers per game
	 */
	public double getTurnovers(){
		return turnovers; 
	}
}