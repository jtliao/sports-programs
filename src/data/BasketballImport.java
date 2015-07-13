package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import players.BasketballPlayer;
import stats.Statline;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class BasketballImport {
	static Statline mean;

	public BasketballImport() {}
	
	public static void importSheet(String sheetName, ArrayList<BasketballPlayer> list) throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File(sheetName));
		Sheet sheet = workbook.getSheet(0);
		int counter =0;
		try{
			while (sheet.getCell(0, counter)!=null){
				list.add(importRowToPlayer(counter, sheet));
				counter++;
			}
		}
		catch (ArrayIndexOutOfBoundsException e){
			return;
		}
	}
	
	private static BasketballPlayer importRowToPlayer(int row, Sheet sheet){
		String name = sheet.getCell(0, row).getContents();
		double points = Double.parseDouble(sheet.getCell(1, row).getContents());
		double  fgp = Double.parseDouble(sheet.getCell(2, row).getContents());
		double threes = Double.parseDouble(sheet.getCell(3, row).getContents());
		double threepp = Double.parseDouble(sheet.getCell(4, row).getContents());
		double ftm = Double.parseDouble(sheet.getCell(5, row).getContents());
		double ftp = Double.parseDouble(sheet.getCell(6, row).getContents());
		double reb = Double.parseDouble(sheet.getCell(7, row).getContents());
		double ast = Double.parseDouble(sheet.getCell(8, row).getContents());
		double stl = Double.parseDouble(sheet.getCell(9, row).getContents());
		double block = Double.parseDouble(sheet.getCell(10, row).getContents());
		double to = Double.parseDouble(sheet.getCell(11, row).getContents());
		mean = calculateMean(sheet);
		return new BasketballPlayer(name, new Statline(points, fgp, threes, threepp, ftm, ftp, reb, ast, stl, block, to), mean, calculateStdev(sheet));
	}
	
	private static Statline calculateMean(Sheet sheet){
		Cell[] cellArr = sheet.getColumn(1);
		double total = 0;
		for(Cell c: cellArr){
			total += Double.parseDouble(c.getContents());
		}
		double pts = total/sheet.getColumns();
		
		cellArr = sheet.getColumn(2);
		total = 0;
		for(Cell c: cellArr){
			total += Double.parseDouble(c.getContents());
		}
		double fgp = total/sheet.getColumns();
		
		cellArr = sheet.getColumn(3);
		total = 0;
		for(Cell c: cellArr){
			total += Double.parseDouble(c.getContents());
		}
		double thr = total/sheet.getColumns();
		
		cellArr = sheet.getColumn(4);
		total = 0;
		for(Cell c: cellArr){
			total += Double.parseDouble(c.getContents());
		}
		double thrp = total/sheet.getColumns();
		
		cellArr = sheet.getColumn(5);
		total = 0;
		for(Cell c: cellArr){
			total += Double.parseDouble(c.getContents());
		}
		double ftm = total/sheet.getColumns();
		
		cellArr = sheet.getColumn(6);
		total = 0;
		for(Cell c: cellArr){
			total += Double.parseDouble(c.getContents());
		}
		double ftp = total/sheet.getColumns();
		
		cellArr = sheet.getColumn(7);
		total = 0;
		for(Cell c: cellArr){
			total += Double.parseDouble(c.getContents());
		}
		double reb = total/sheet.getColumns();
		
		cellArr = sheet.getColumn(8);
		total = 0;
		for(Cell c: cellArr){
			total += Double.parseDouble(c.getContents());
		}
		double ast = total/sheet.getColumns();
		
		cellArr = sheet.getColumn(9);
		total = 0;
		for(Cell c: cellArr){
			total += Double.parseDouble(c.getContents());
		}
		double stl = total/sheet.getColumns();
		
		cellArr = sheet.getColumn(10);
		total = 0;
		for(Cell c: cellArr){
			total += Double.parseDouble(c.getContents());
		}
		double blk = total/sheet.getColumns();
		
		cellArr = sheet.getColumn(11);
		total = 0;
		for(Cell c: cellArr){
			total += Double.parseDouble(c.getContents());
		}
		double to = total/sheet.getColumns();
		
		return new Statline(pts, fgp, thr, thrp, ftm, ftp, reb, ast, stl, blk, to);
	}
	
	private static Statline calculateStdev(Sheet sheet){
		Cell[] cellArr = sheet.getColumn(1);
		double total = 0;
		for(Cell c: cellArr){
			total += Math.pow(Double.parseDouble(c.getContents())-mean.getPoints(), 2);
		}
		double pts = Math.sqrt(total/sheet.getColumns());
		
		cellArr = sheet.getColumn(2);
		total = 0;
		for(Cell c: cellArr){
			total += Math.pow(Double.parseDouble(c.getContents())-mean.getFgp(), 2);
		}
		double fgp = Math.sqrt(total/sheet.getColumns());
		
		cellArr = sheet.getColumn(3);
		total = 0;
		for(Cell c: cellArr){
			total += Math.pow(Double.parseDouble(c.getContents())-mean.getThrees(), 2);
		}
		double thr = Math.sqrt(total/sheet.getColumns());
		
		cellArr = sheet.getColumn(4);
		total = 0;
		for(Cell c: cellArr){
			total += Math.pow(Double.parseDouble(c.getContents())-mean.getThreepp(), 2);
		}
		double thrp = Math.sqrt(total/sheet.getColumns());
		
		cellArr = sheet.getColumn(5);
		total = 0;
		for(Cell c: cellArr){
			total += Math.pow(Double.parseDouble(c.getContents())-mean.getFtm(), 2);
		}
		double ftm = Math.sqrt(total/sheet.getColumns());
		
		cellArr = sheet.getColumn(6);
		total = 0;
		for(Cell c: cellArr){
			total += Math.pow(Double.parseDouble(c.getContents())-mean.getFtp(), 2);
		}
		double ftp = Math.sqrt(total/sheet.getColumns());
		
		cellArr = sheet.getColumn(7);
		total = 0;
		for(Cell c: cellArr){
			total += Math.pow(Double.parseDouble(c.getContents())-mean.getRebounds(), 2);
		}
		double reb = Math.sqrt(total/sheet.getColumns());
		
		cellArr = sheet.getColumn(8);
		total = 0;
		for(Cell c: cellArr){
			total += Math.pow(Double.parseDouble(c.getContents())-mean.getAssists(), 2);
		}
		double ast = Math.sqrt(total/sheet.getColumns());
		
		cellArr = sheet.getColumn(9);
		total = 0;
		for(Cell c: cellArr){
			total += Math.pow(Double.parseDouble(c.getContents())-mean.getSteals(), 2);
		}
		double stl = Math.sqrt(total/sheet.getColumns());
		
		cellArr = sheet.getColumn(10);
		total = 0;
		for(Cell c: cellArr){
			total += Math.pow(Double.parseDouble(c.getContents())-mean.getBlocks(), 2);
		}
		double blk = Math.sqrt(total/sheet.getColumns());
		
		cellArr = sheet.getColumn(11);
		total = 0;
		for(Cell c: cellArr){
			total += Math.pow(Double.parseDouble(c.getContents())-mean.getTurnovers(), 2);
		}
		double to = total/sheet.getColumns();
		
		return new Statline(pts, fgp, thr, thrp, ftm, ftp, reb, ast, stl, blk, to);
	}

}
