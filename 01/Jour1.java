import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

public class Jour1
{
	public static void main(String... args){
		Scanner scFic;
		int nbIncrease = 0;
		int lastValue = -1;

    	try
		{
			scFic = new Scanner ( new FileReader ( "./input.txt" ) );

			while ( scFic.hasNextLine() )
			{
				int tmpValue = Integer.parseInt(scFic.nextLine());
				if(lastValue == -1)
				{
					lastValue = tmpValue;
				}else{
					if(tmpValue > lastValue)
					{
						nbIncrease++;
					}
					lastValue = tmpValue;
				}

			}
		}catch (Exception e){e.printStackTrace();}
		System.out.println("Réponse au puzzle 1 : " + nbIncrease);

		lastValue = -1;
		nbIncrease = 0;
		int[] tab = new int[2000];
		int ind = 0;

		try
		{
			scFic = new Scanner ( new FileReader ( "./input.txt" ) );

			while ( scFic.hasNextLine() )
			{
				tab[ind++] = Integer.parseInt(scFic.nextLine());

			}
		}catch (Exception e){e.printStackTrace();}

		for(int i = 1; i<tab.length-1; i++){
			int tmpValue = tab[i-1] + tab[i] + tab[i+1];
			if(lastValue == -1)
			{
				lastValue = tmpValue;
			}else{
				if(tmpValue > lastValue)
				{
					nbIncrease++;
				}
				lastValue = tmpValue;
			}
		}
		
		System.out.println("Réponse au puzzle 2 : " + nbIncrease);
	}
}
