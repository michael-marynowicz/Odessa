package src;

import java.util.Random;

public class Salle {
    private Random r = new Random();

    private int x;
    private int y;

    int[][] tableau = {{0,1,1,1,0,0},{0,1,1,1,0,0},{0,1,1,1,0,0},{0,1,1,1,0,0},{0,0,0,1,0,0},{0,0,0,0,0,0}};


    Salle(){
        x = r.nextInt(20);
        y = r.nextInt(20);
    }

    Salle(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void getTableau(){
        for (int[] ints : tableau) {
            for (int j = 0; j < tableau.length; j++) {
                if ((j + 1) == tableau.length) {
                    System.out.print(ints[j]);
                } else {
                    System.out.print(ints[j] + "   ");
                }
            }
            System.out.print('\n');
        }
    }
}
