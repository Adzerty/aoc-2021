import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Jour4
{
	public static void main(String... args){

		/*--------------*/
		/*	PUZZLE ONE	*/
		/*--------------*/

		Scanner scFic;
		ArrayList<Integer> alNumbersDrawn = new ArrayList<>();
		ArrayList<Grille> alGrilles = new ArrayList<>();

		try
		{
			scFic = new Scanner ( new FileReader ( "./input.txt" ) );

			String numbersDrawn = scFic.nextLine();
			Scanner scNumbersDrawn = new Scanner( numbersDrawn );
			scNumbersDrawn.useDelimiter(",");

			while(scNumbersDrawn.hasNext()){
				alNumbersDrawn.add(Integer.parseInt(scNumbersDrawn.next()));
			}

			while(scFic.hasNextLine()){
				scFic.nextLine();
				String[] tabTmpGrille = new String[5];
				for(int i = 0; i<5; i++)
				{
					tabTmpGrille[i] = scFic.nextLine();
				}

				// for(int i = 0; i<5; i++)
				// {
				// 	System.out.println(tabTmpGrille[i]);
				// }
				
				alGrilles.add(new Grille(tabTmpGrille));
				//System.out.println(alGrilles.size());
				
			}
		}catch (Exception e){e.printStackTrace();}


		//Tirage des nombres

		Grille winningGrille = null;
		int indiceLastDrawn = 0;
		int indiceWinningDrawn = 0;
		int number = 0;
		int grilleRestantes = alGrilles.size();
		for(int i = 0; i<alNumbersDrawn.size() && grilleRestantes > 0; i++)
		{
			number = alNumbersDrawn.get(i);
			for(Grille g : alGrilles)
			{
				if(!(g.hasWin) && g.drawNumber(number)){
					grilleRestantes--;
					System.out.println(grilleRestantes);
					winningGrille = g;
					indiceWinningDrawn = indiceLastDrawn;
				}
			}
		}

		System.out.println();
		System.out.println("Réponse au puzzle 1 : " + number * winningGrille.getSum());
	}
}
