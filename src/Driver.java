/**
 * Driver class for Project 1 in CSC330 Artificial Intelligence at DePauw University. 
 * Contains code to read in file for Eight Puzzle game and checks validity. 
 * 
 * Created 2-13-2017
 * @author Brad Burch and Katherine Martin  
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args)
	{
		String fileName = new String();
		Scanner reader = new Scanner(System.in);
		int[][] puzzle = new int[3][3];
		
		System.out.println("This program is used to solve the Eight-Puzzle using IDS and Best First Search.");

		System.out.print("Please enter a puzzle file you would like to solve: ");
		fileName = reader.nextLine();
		
		try
		{
			File file = new File (fileName);
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext())
			{
				for (int i = 0; i < 3; i ++)
				{
					for (int j = 0; j < 3; j++)
					{
						puzzle[i][j] = scanner.nextInt();
					}
					System.out.println();
				}
			}
			
			Node node = new Node(puzzle);
			IDS_Search idsSearch = new IDS_Search();
			BestFirstSearch bestfs = new BestFirstSearch();
			
//			System.out.println("IDS");
//			idsSearch.runIDS(node);
//			System.out.println("-------------------------------------------------------------");
			
			System.out.println("BEST FIRST SEARCH");
			bestfs.runBestFS(node);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open the file " + fileName + ".");
		}
		catch(IOException e)
		{
			System.out.println("Could not read from " + fileName + ".");
		}
	}
}
