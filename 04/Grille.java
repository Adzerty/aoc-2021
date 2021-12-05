import java.util.Scanner;
import java.util.regex.Pattern;

public class Grille {
    int[][] grille = new int[5][5];
    boolean[][] marked = new boolean[5][5];
    public boolean hasWin = false;

    public Grille(String[] rows){
        for(int i = 0; i<5; i++){
            Scanner sc = new Scanner(rows[i]);
            sc.useDelimiter(Pattern.compile(" +"));
            for(int j = 0; j<5; j++){
                String number = sc.next();
                grille[i][j] = Integer.parseInt(number);
            }
        }
    }

    public boolean drawNumber(int number)
    {
        int row; 
        int col;
        for(int i = 0; i<5; i++)
        {
            for(int j = 0; j<5; j++)
            {
                if(number == grille[i][j]){
                    row = i;
                    col = j;
                    marked[i][j] = true;
                }
            }
        }

        return checkForWin();
    }

    private boolean checkForWin(){
        //Check for rows
        for(int i = 0; i<5; i++){
            if( marked[i][0] && 
                marked[i][1] && 
                marked[i][2] && 
                marked[i][3] && 
                marked[i][4])
                hasWin = true;
        }

         //Check for cols
         for(int i = 0; i<5; i++){
            if( marked[0][i] && 
                marked[1][i] && 
                marked[2][i] && 
                marked[3][i] && 
                marked[4][i])
                hasWin = true;
        }

        return hasWin;
    }

    public int getSum()
    {
        int sum = 0;
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(!marked[i][j]){
                    sum+=grille[i][j];
                }
            } 
        }
        return sum;
    }

    @Override
    public String toString() {
        String sRet = "";
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
              sRet += "" + grille[i][j];  
            }
            sRet+='\n';
        }

        return sRet;
    }
}
