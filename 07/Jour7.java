import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


//Each LF creates 1 LF every 7 days except for 1st cycle : 9 days
public class Jour7{
    public static void main(String[] args) {
        Scanner scFic;
        ArrayList<Integer> alCrab = new ArrayList<>();
		try
		{
			scFic = new Scanner ( new FileReader ( "./input.txt" ) );
            scFic.useDelimiter(",");
			while(scFic.hasNext()){
				int number = Integer.parseInt(scFic.next());
                alCrab.add(number);
            }
		}catch (Exception e){e.printStackTrace();}

		Collections.sort(alCrab);

        int sumFuel = Integer.MAX_VALUE;

        for(int i = alCrab.get(0); i<alCrab.get(alCrab.size()-1); i++){
            int sumTmp = 0; 
            for(Integer fuel : alCrab){
                sumTmp += ((Math.abs(fuel - i)) * (Math.abs(fuel - i) + 1)) / 2;
            }
            if(sumFuel> sumTmp){
                sumFuel = sumTmp;
            }
        }

        System.out.println(sumFuel);
    
    }
}