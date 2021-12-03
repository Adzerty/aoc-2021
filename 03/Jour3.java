import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Jour3
{
	public static void main(String... args){

		/*--------------*/
		/*	PUZZLE ONE	*/
		/*--------------*/

		Scanner scFic;
		int[][] tab = new int[12][2];
		int ind = 0;
		String gammaRate = "";
		String epsilRate = "";

    	try
		{
			scFic = new Scanner ( new FileReader ( "./input.txt" ) );

			while ( scFic.hasNextLine() )
			{
				String line = scFic.nextLine();
				for(int i = 0; i<line.length(); i++)
				{
					if(line.charAt(i) == '0'){
						tab[i][0]++;
					}else{
						tab[i][1]++;
					}
				}

			}
		}catch (Exception e){e.printStackTrace();}

		for(int i = 0; i<tab.length; i++){
			if(tab[i][0] > tab[i][1]){
				gammaRate = gammaRate+'0';
				epsilRate = epsilRate+'1';
			}else{
				gammaRate = gammaRate+'1';
				epsilRate = epsilRate+'0';
			}
		}

		int gammaRateDec = Integer.parseInt(gammaRate, 2);
		int epsilRateDec = Integer.parseInt(epsilRate, 2);
		System.out.println("Réponse au puzzle 1 : " + gammaRateDec * epsilRateDec);

		/*--------------*/
		/*	PUZZLE TWO	*/
		/*--------------*/

		String oxygen = "";
		String co2 = "";

		ArrayList<String> alOxygen = new ArrayList<String>();
		ArrayList<String> alCO2 = new ArrayList<String>();
		try
		{
			scFic = new Scanner ( new FileReader ( "./input.txt" ) );

			while ( scFic.hasNextLine() )
			{
				String line = scFic.nextLine();
				alOxygen.add(line);
				alCO2.add(line);
			}
		}catch (Exception e){e.printStackTrace();}

		ind = 0;
		while(alOxygen.size() != 1)
		{
			ArrayList<String> tmp = new ArrayList<>();
			int amountOf1 = 0;
			char bitSearched;

			for(String s : alOxygen)
			{
				if(s.charAt(ind) == '1'){
					amountOf1++;
				}
			}
			bitSearched = (alOxygen.size() - amountOf1) > amountOf1 ? '0' : '1';

			for(String s : alOxygen)
			{
				if(s.charAt(ind) != bitSearched){
					tmp.add(s);
				}
			}

			alOxygen.removeAll(tmp);
			tmp.clear();
			ind++;
		}

		ind = 0;
		while(alCO2.size() != 1)
		{
			ArrayList<String> tmp = new ArrayList<>();
			int amountOf1 = 0;
			char bitSearched;

			for(String s : alCO2)
			{
				if(s.charAt(ind) == '1'){
					amountOf1++;
				}
			}
			bitSearched = alCO2.size() - amountOf1 <= amountOf1 ? '0' : '1';

			for(String s : alCO2)
			{
				if(s.charAt(ind) != bitSearched){
					tmp.add(s);
				}
			}
			alCO2.removeAll(tmp);
			tmp.clear();
			ind++;
		}

		oxygen = alOxygen.get(0);
		co2 = alCO2.get(0);

		int oxygenDec = Integer.parseInt(oxygen, 2);
		int co2Dec = Integer.parseInt(co2, 2);
		
		
		System.out.println("Réponse au puzzle 2 : " + oxygenDec * co2Dec);
	}
}
