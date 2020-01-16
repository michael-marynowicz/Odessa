package src;

import java.util.*;

public class Salle {
    private Random r = new Random();

    private int coordonneeX;
    private int coordonneeY;
    int[][] matriceSalle;

    //Pour la matrice de la salle faudra voir comment on gère nos patternes, pour que ce soit automatisé quoi

    Salle(){
        this.coordonneeX = r.nextInt(15);
        this.coordonneeY = r.nextInt(15);
        this.matriceSalle = Pattern.map.get(Pattern.getRandomPattern());
    }
    Salle(int coordonneeX, int coordonneeY){ //Le pattern est random
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.matriceSalle = Pattern.map.get(Pattern.getRandomPattern());
    }

    Salle(int coordonneeX, int coordonneeY, Pattern pattern){
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.matriceSalle = Pattern.map.get(pattern); //On défini le pattern de cette salle
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
