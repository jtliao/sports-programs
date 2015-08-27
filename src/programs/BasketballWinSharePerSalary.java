package programs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import jxl.read.biff.BiffException;
import players.BasketballPlayer;
import data.BasketballImport;

public class BasketballWinSharePerSalary {
	public static void main(String[] args) throws BiffException, IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter file path to player .xls file:");
		String pathName = scan.nextLine();
		System.out.println("Loading data...");
		ArrayList<BasketballPlayer> list = new ArrayList<BasketballPlayer>();
		BasketballImport.importFullStatPlayers(pathName, list);
		System.out.println("Player data loaded, enter file path to salary .xls file");
		pathName = scan.nextLine();
		BasketballImport.importSalaries(pathName, list);
		System.out.println("Salary data loaded, enter file path to win shares .xls file");
		pathName = scan.nextLine();
		BasketballImport.importWinShare(pathName, list);
		System.out.println("Win share data loaded, calculating win share/salary...");
		TreeMap<BasketballPlayer, Double> map = new TreeMap<BasketballPlayer, Double>();
		System.out.println(list.get(0).getWinShare());
		System.out.println(list.get(0).getSalary());
		for (BasketballPlayer b: list){
			map.put(b, b.getWinShare()/b.getSalary());
		}
		System.out.println(map.toString());
	}
}
