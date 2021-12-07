import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


//Each LF creates 1 LF every 7 days except for 1st cycle : 9 days
public class Jour6{
    public static void main(String[] args) {
        Scanner scFic;
        ArrayList<LanternFish> alFish = new ArrayList<>();
        final int NB_JOURS = 256;
		try
		{
			scFic = new Scanner ( new FileReader ( "./input.txt" ) );
            scFic.useDelimiter(",");
			while(scFic.hasNext()){
				int timer = Integer.parseInt(scFic.next());
                alFish.add(new LanternFish(timer));
            }
		}catch (Exception e){e.printStackTrace();}

        for(int i = 0; i<NB_JOURS; i++){
            int actualSize = alFish.size();
            //System.out.println("==========================================");
            //System.out.println("    JOUR " + i);
            //System.out.println("==========================================");
            for(int j = 0; j<actualSize; j++){
                
                LanternFish fish = alFish.get(j);
                //System.out.print("TIMER : " + fish.internalTimer);
                if(fish.internalTimer == 0){
                   
                    alFish.add(new LanternFish());
                    fish.internalTimer = 7;
                }
                fish.internalTimer--;
                //System.out.println(" \t TIMER : " + fish.internalTimer);
                
            }
        }
        
        /*
        for(LanternFish f : alFish){
            System.out.print(f.internalTimer + ',');
        }*/
        System.out.println(alFish.size());


        
    }
}