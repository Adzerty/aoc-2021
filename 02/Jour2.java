import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

public class Jour2
{
	public static void main(String... args){
		Scanner scFic;
		Scanner scLine;
		int horizontalPos = 0;
		int depth = 0;

    	try
		{
			scFic = new Scanner ( new FileReader ( "./input.txt" ) );

			while ( scFic.hasNextLine() )
			{
				scLine = new Scanner ( scFic.nextLine() );
				scLine.useDelimiter(" ");

				String command = scLine.next(); 
				int units = Integer.parseInt(scLine.next()); 
				
				switch(command.charAt(0)){
					case 'f': horizontalPos+=units; break;
					case 'u': depth -= units; break;
					case 'd': depth += units; break;
					default : break;
				}
			}
		}catch (Exception e){e.printStackTrace();}
		System.out.println("Réponse au puzzle 1 : " + horizontalPos * depth);

		horizontalPos = 0;
		depth = 0;
		int aim = 0;

		try
		{
			scFic = new Scanner ( new FileReader ( "./input.txt" ) );

			while ( scFic.hasNextLine() )
			{
				scLine = new Scanner ( scFic.nextLine() );
				scLine.useDelimiter(" ");

				String command = scLine.next(); 
				int units = Integer.parseInt(scLine.next()); 
				
				switch(command.charAt(0)){
					case 'f': 
						horizontalPos+=units;
						depth += aim * units; 
						break;
					case 'u': aim -= units; break;
					case 'd': aim += units; break;
					default : break;
				}
			}
		}catch (Exception e){e.printStackTrace();}
		
		System.out.println("Réponse au puzzle 2 : " + horizontalPos * depth);
	}
}
