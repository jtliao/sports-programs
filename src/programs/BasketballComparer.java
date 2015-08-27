package programs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import data.BasketballImport;
import jxl.read.biff.BiffException;
import players.BasketballPlayer;

/**
 * Class to be run to find the most statistically similar player to specified player
 * @author Jason Liao
 *
 */
public class BasketballComparer {
	/**
	 * Runs the basketball comparer
	 */
	public static void main(String[] args) throws BiffException, IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter file path to .xls file:");
		String pathName = scan.nextLine();
		System.out.println("Loading data...");
		ArrayList<BasketballPlayer> list = new ArrayList<BasketballPlayer>();
		BasketballImport.importFullStatPlayers(pathName, list);
		System.out.println("Enter player to be compared:");
		String name = scan.nextLine();
		System.out.println("Searching for player most similar to: "+name);
		BasketballPlayer player = null;
		for (BasketballPlayer b: list){
			if (name.equals(b.getName())){
				player = b;
				break;
			}
		}
		
		if(player==null){
			System.out.println("Player not found");
		}
		else{
			double total=Double.MAX_VALUE;
			BasketballPlayer comparablePlayer = null;;
			for (BasketballPlayer b: list){
				if (!b.equals(player)){
					if (player.calculateSimilarity(b.getZScoreStatline())<total){
						total = player.calculateSimilarity(b.getZScoreStatline());
						comparablePlayer = b;
					}
				}
			}
			System.out.println(comparablePlayer.getName());
		}
	}
}