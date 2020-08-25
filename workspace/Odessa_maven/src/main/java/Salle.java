import java.util.*;

public class Salle {

    private Random r = new Random();
    private int coordonneeY;
    private int coordonneeX;
    private int height;
    private int width;
    int[][] matriceSalle;


    Salle(){
        this.coordonneeY = r.nextInt(15);
        this.coordonneeX = r.nextInt(15);
        int i = this.r.nextInt(Pattern.values().length);
        Pattern lol = Pattern.values()[i];
        this.matriceSalle = Pattern.map.get(lol); //Cree une salle rectangulaire
        this.width = 5;
        this.height = 5;
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
        this.height = 5; //Nécessaire pour pouvoir ajouter la salle et tester les cas de collisions
        this.width = 5; 
    }


    public void genSalle(){
        //Crée des patterns rectangulaires aleatoires. (min 2x2, max 7x5)
        int height = r.nextInt(3)+2;
        int width = r.nextInt(3)+2;
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
