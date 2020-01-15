package src;

import java.util.ArrayList;

public class Generation {

    public static void main(String[] args) {
        int[][] matriceDonjon = new int[20][20];
        for(int i = 0; i< matriceDonjon.length; i++){
            for(int j = 0; j< matriceDonjon.length; j++){
                matriceDonjon[i][j] = 0;
                if((j+1) == matriceDonjon.length){
                    System.out.print(matriceDonjon[i][j]);
                }
                else {
                    System.out.print(matriceDonjon[i][j] + "   ");
                }
            }
            System.out.print('\n');
        }
        Salle test = new Salle(0,0);
        test.printMatrice();
    }
}