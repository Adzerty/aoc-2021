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
	}
}
