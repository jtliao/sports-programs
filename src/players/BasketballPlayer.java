package players;

import stats.Statline;

public class BasketballPlayer extends Player{
	private Statline stats;
	private Statline zstats;

	
	/**
	 * Initialize a player
	 * @param name- player name
	 * @param points-points per game
	 * @param fgp- field goal percentage
	 * @param threes- threes per game
	 * @param threepp- three point percentage
	 * @param ftm- free throws made
	 * @param ftp- free throw percentage
	 * @param rebounds- rebounds per game
	 * @param assists- assists per game
	 * @param steals- steals per game
	 * @param blocks- blocks per game
	 * @param turnovers- turnovers per game
	 */
	public BasketballPlayer(String name, Statline stats, Statline avg, Statline std) {
		super("Basketball", name);
		this.stats = stats;
		calculateZScoreStatline(avg, std);
	}
	
	public Statline getZScoreStatline(){
		return zstats;
	}
	
	private void calculateZScoreStatline(Statline average, Statline stdev){
		double pts=Math.abs((stats.getPoints()-average.getPoints())/stdev.getPoints());
		double fgp=Math.abs((stats.getFgp()-average.getFgp())/stdev.getFgp());
		double three=Math.abs((stats.getThrees()-average.getThrees())/stdev.getThrees());
		double threep=Math.abs((stats.getThreepp()-average.getThreepp())/stdev.getThreepp());
		double ftm=Math.abs((stats.getFtm()-average.getFtm())/stdev.getFtm());
		double ftp =Math.abs((stats.getFtp()-average.getFtp())/stdev.getFtp());
		double reb=Math.abs((stats.getRebounds()-average.getRebounds())/stdev.getRebounds());
		double ast =Math.abs((stats.getAssists()-average.getAssists())/stdev.getAssists());
		double stl=Math.abs((stats.getSteals()-average.getSteals()/stdev.getSteals()));
		double blk=Math.abs((stats.getBlocks()-average.getBlocks())/stdev.getBlocks());
		double to=Math.abs((stats.getTurnovers()-average.getTurnovers())/stdev.getTurnovers());
		zstats = new Statline(pts, fgp, three, threep, ftm, ftp, reb, ast, stl, blk, to);
	}
	
	public double calculateSimilarity (Statline otherStats){
		double total=0;
		total+=Math.abs((zstats.getPoints()-otherStats.getPoints())/zstats.getPoints());
		total+=Math.abs((zstats.getFgp()-otherStats.getFgp())/zstats.getFgp());
		total+=Math.abs((zstats.getThrees()-otherStats.getThrees())/zstats.getThrees());
		total+=Math.abs((zstats.getThreepp()-otherStats.getThreepp())/zstats.getThreepp());
		total+=Math.abs((zstats.getFtm()-otherStats.getFtm())/zstats.getFtm());
		total+=Math.abs((zstats.getFtp()-otherStats.getFtp())/zstats.getFtp());
		total+=Math.abs((zstats.getRebounds()-otherStats.getRebounds())/zstats.getRebounds());
		total+=Math.abs((zstats.getAssists()-otherStats.getAssists())/zstats.getAssists());
		total+=Math.abs((zstats.getSteals()-otherStats.getSteals()/zstats.getSteals()));
		total+=Math.abs((stats.getBlocks()-otherStats.getBlocks())/zstats.getBlocks());
		total+=Math.abs((zstats.getTurnovers()-otherStats.getTurnovers())/zstats.getTurnovers());
		return total;
	}
}
