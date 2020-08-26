import java.util.*;

public class Salle {

    private Random r = new Random();
    private int coordonneeY;
    private int coordonneeX;
    private int height;
    private int width;
    int[][] matriceSalle;


    Salle(){
        this.coordonneeY = r.nextInt(Generation.tailleY - 5);
        this.coordonneeX = r.nextInt(Generation.tailleX - 5);
        int i = this.r.nextInt(Pattern.values().length);
        Pattern lol = Pattern.values()[i];
        this.matriceSalle = Pattern.map.get(lol); //Récupère la matrice du pattern
        this.width = Pattern.map.get(lol)[0].length;
        this.height = Pattern.map.get(lol).length;
    }

    Salle(int coordonneeY, int coordonneeX){
        this.coordonneeY = coordonneeY;
        this.coordonneeX = coordonneeX;
        this.genSalle(); //Cree une salle rectangulaire
    }
    Salle(int coordonneeY, int coordonneeX, Pattern pattern){ // Permet de choisir un pattern Pré-défini
        this.coordonneeY = coordonneeY;
        this.coordonneeX = coordonneeX;
        this.matriceSalle = Pattern.map.get(pattern);
        this.width = Pattern.map.get(pattern)[0].length;
        this.height = Pattern.map.get(pattern).length;
    }


    public void genSalle(){
        //Crée des patterns rectangulaires aleatoires. (min 2x2, max 7x5)
        int height = r.nextInt(4)+2;
        int width = r.nextInt(4)+2;
        int[][] rectPattern = new int[height][width];
        for(int h=0; h<height; h++){
            for(int w=0; w<width;w++){
                rectPattern[h][w] = 1;
            }
        }
        this.matriceSalle = rectPattern;
        this.height = height;
        this.width = width;
    }


    public void printSalle(){
        for (int[] values : matriceSalle) {
            for (int j = 0; j < values.length; j++) {
                if ((j + 1) == values.length) {
                    System.out.print(values[j]);
                } else {
                    System.out.print(values[j] + " ");
                }
            }
            System.out.print('\n');
        }
    }
    public int getCoordonneeY() { return coordonneeY; }
    public int getCoordonneeX() { return coordonneeX; }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }

}
