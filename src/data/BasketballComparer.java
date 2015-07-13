package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import jxl.read.biff.BiffException;

import players.BasketballPlayer;

public class BasketballComparer {
	/**
	 * Runs the basketball comparer
	 */
	public static void main(String[] args) throws BiffException, IOException {
		System.out.println("Loading data...");
		ArrayList<BasketballPlayer> list = new ArrayList<BasketballPlayer>();
		BasketballImport.importSheet("C:\\Users\\Jason\\Documents\\shortdata.xls", list);
		System.out.println("Enter player to be compared:");
		Scanner scan = new Scanner(System.in);
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