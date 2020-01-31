package src;

import java.util.*;

public class Salle {
    private Random r = new Random();

    private int coordonneeY;
    private int coordonneeX;
    int[][] matriceSalle;

    //Pour la matrice de la salle faudra voir comment on gère nos patternes, pour que ce soit automatisé quoi

    Salle(){
        this.coordonneeY = r.nextInt(15);
        this.coordonneeX = r.nextInt(15);
        this.matriceSalle = Pattern.map.get(Pattern.getRandomPattern());
    }
    Salle(int coordonneeY, int coordonneeX){ //Le pattern est random
        this.coordonneeY = coordonneeY;
        this.coordonneeX = coordonneeX;
        this.matriceSalle = Pattern.map.get(Pattern.getRandomPattern());
    }

    Salle(int coordonneeY, int coordonneeX, Pattern pattern){
        this.coordonneeY = coordonneeY;
        this.coordonneeX = coordonneeX;
        this.matriceSalle = Pattern.map.get(pattern); //On défini le pattern de cette salle
    }

    public int getCoordonneeY() {
        return coordonneeY;
    }
    public int getCoordonneeX() {
        return coordonneeX;
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
