package src;

import java.util.ArrayList;

public class Generation {

    public static void main(String[] args) {
        int[][] tableau = new int[20][20];
        for(int i = 0; i< tableau.length; i++){
            for(int j = 0; j< tableau.length; j++){
                tableau[i][j] = 0;
                if((j+1) == tableau.length){
                    System.out.print(tableau[i][j]);
                }
                else {
                    System.out.print(tableau[i][j] + "   ");
                }
            }
            System.out.print('\n');
        }

        Salle test = new Salle();
        test.getTableau();
    }

}