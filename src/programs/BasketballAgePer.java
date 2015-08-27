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
public class BasketballAgePer {
	/**
	 * Runs the basketball comparer
	 */
	public static void main(String[] args) throws BiffException, IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter file path to .xls file:");
		String pathName = scan.nextLine();
		System.out.println("Loading data...");
		ArrayList<BasketballPlayer> list = new ArrayList<BasketballPlayer>();
		BasketballImport.importPerPlayers(pathName, list);
		
	}
}