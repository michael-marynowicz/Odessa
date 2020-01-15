package src;

import java.util.Random;

public class Salle {
    private Random r = new Random();

    private int coordonneeX;
    private int coordonneeY;
    int[][] matriceSalle = {{0,1,1,1,0,},{0,1,1,1,0,},{0,1,1,1,0,},{0,1,1,1,0,},{0,0,0,1,0,}};
    //Pour la matrice de la salle faudra voir comment on gère nos patternes, pour que ce soit automatisé quoi

    Salle(int coordonneeX, int coordonneeY){
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
    }

    public int getCoordonneeX() {
        return coordonneeX;
    }
    public int getCoordonneeY() {
        return coordonneeY;
    }

    public void printMatrice(){
        for (int[] ints : matriceSalle) {
            for (int j = 0; j < matriceSalle.length; j++) {
                if ((j + 1) == matriceSalle.length) {
                    System.out.print(ints[j]);
                } else {
                    System.out.print(ints[j] + "   ");
                }
            }
            System.out.print('\n');
        }
    }
}
