import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Jour5
{
	public static void main(String... args){

		/*--------------*/
		/*	PUZZLE ONE	*/
		/*--------------*/

		Scanner scFic;
		

		try
		{
			ArrayList<Coord> alCoord = new ArrayList<>();
			scFic = new Scanner ( new FileReader ( "./input.txt" ) );
			while(scFic.hasNextLine()){
				String line = scFic.nextLine();

				Scanner scLine = new Scanner(line);
				scLine.useDelimiter(" -> ");

				String[] coord1 = scLine.next().split(",");
				String[] coord2 = scLine.next().split(",");

				alCoord.add(new Coord(	Integer.parseInt(coord1[0]), 
										Integer.parseInt(coord1[1]), 
										Integer.parseInt(coord2[0]), 
										Integer.parseInt(coord2[1]))
																		);
			}
			int maxX = alCoord.get(0).x1;
			int maxY = alCoord.get(0).y1;

			for(Coord c : alCoord){

				if(c.x1 > maxX) maxX = c.x1;
				if(c.x2 > maxX) maxX = c.x2;
				if(c.y1 > maxY) maxY = c.y1;
				if(c.y2 > maxY) maxY = c.y2;
			}

			//System.out.println( alCoord.size());

			int[][] grille = new int[maxY+1][maxX+1];

			for(Coord c : alCoord){
				if(c.x1 == c.x2){
					//System.out.println("X " + c);
					for(int y = Math.min(c.y1, c.y2); y <= Math.max(c.y1, c.y2); y++){
					
						grille[y][c.x1]++;
					}
				}
				if(c.y1 == c.y2){
					//System.out.println("Y " + c);
					for(int x = Math.min(c.x1, c.x2); x <= Math.max(c.x1, c.x2); x++){
		
						grille[c.y1][x]++;
					}
				}
			}

			int sum = 0;
			for(int i = 0; i<grille.length; i++){
				for(int j = 0; j<grille[i].length; j++){
					//System.out.print(grille[i][j]);
					if(grille[i][j] >= 2) sum++;
				}
				//System.out.println();
			}

			System.out.println(sum);


		}catch (Exception e){e.printStackTrace();}

		/*--------------*/
		/*	PUZZLE TWO	*/
		/*--------------*/


		try
		{
			ArrayList<Coord> alCoord = new ArrayList<>();
			scFic = new Scanner ( new FileReader ( "./input.txt" ) );
			while(scFic.hasNextLine()){
				String line = scFic.nextLine();

				Scanner scLine = new Scanner(line);
				scLine.useDelimiter(" -> ");

				String[] coord1 = scLine.next().split(",");
				String[] coord2 = scLine.next().split(",");

				alCoord.add(new Coord(	Integer.parseInt(coord1[0]), 
										Integer.parseInt(coord1[1]), 
										Integer.parseInt(coord2[0]), 
										Integer.parseInt(coord2[1]))
																		);
			}
			int maxX = alCoord.get(0).x1;
			int maxY = alCoord.get(0).y1;

			for(Coord c : alCoord){

				if(c.x1 > maxX) maxX = c.x1;
				if(c.x2 > maxX) maxX = c.x2;
				if(c.y1 > maxY) maxY = c.y1;
				if(c.y2 > maxY) maxY = c.y2;
			}

			//System.out.println( alCoord.size());

			int[][] grille = new int[maxY+1][maxX+1];

			for(Coord c : alCoord){
				if(c.x1 == c.x2){
					//System.out.println("X " + c);
					for(int y = Math.min(c.y1, c.y2); y <= Math.max(c.y1, c.y2); y++){
						//System.out.println(" -> " + c.x1 + " : " + y);
						grille[y][c.x1]++;
					}
				}
				else{
					if(c.y1 == c.y2){
						//System.out.println("Y " + c);
						for(int x = Math.min(c.x1, c.x2); x <= Math.max(c.x1, c.x2); x++){
							//System.out.println(" -> " + x + " : " + c.y1);
							grille[c.y1][x]++;
						}
					}else{
						//System.out.println("Z " + c);
						int x = c.x1, y = c.y1;
						int deltaX = c.x1 <= c.x2 ? 1 : -1;
						int deltaY = c.y1 <= c.y2 ? 1 : -1;
						System.out.println(Math.abs(c.x1 - c.x2) == Math.abs(c.y1 - c.y2) ? "" : "FAUX");
						for(int i = 0; i<Math.abs(c.x1 - c.x2)+1; i++){
							
							//System.out.println(" -> " + x + " : " + y);
							grille[y][x]++;
							x+=deltaX;
							y+=deltaY;
						}
						
					}
				}
			}

			int sum = 0;
			for(int i = 0; i<grille.length; i++){
				for(int j = 0; j<grille[i].length; j++){
					//System.out.print(grille[i][j]);
					if(grille[i][j] >= 2) sum++;
				}
				//System.out.println();
			}

			System.out.println(sum);


		}catch (Exception e){e.printStackTrace();}
	}
}
