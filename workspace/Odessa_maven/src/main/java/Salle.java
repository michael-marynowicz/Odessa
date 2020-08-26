import java.util.*;

public class Salle {

    private Random r = new Random();
    private int coordonneeY;
    private int coordonneeX;
    private int height;
    private int width;
    Case[][] matriceSalle;


    Salle(){
        this.coordonneeY = r.nextInt(Generation.tailleY - 5);
        this.coordonneeX = r.nextInt(Generation.tailleX - 5);
        int i = this.r.nextInt(Pattern.values().length);
        Pattern pat = Pattern.values()[i];
        this.matriceSalle = Pattern.map.get(pat); //Récupère la matrice du pattern
        this.width = Pattern.map.get(pat)[0].length;
        this.height = Pattern.map.get(pat).length;
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


    public void genSalle(){ //TODO Faire que le if passe (il permet de faire des portes)
        //Crée des patterns rectangulaires aleatoires. (min 2x2, max 7x5)
        int height = r.nextInt(4)+2;
        int width = r.nextInt(4)+2;
        Case[][] rectPattern = new Case[height][width];
        for(int h=0; h<height; h++){
            for(int w=0; w<width;w++){
                if((h == 0 && w == 0) || (h == (int) height/2 && w == 0) || (h == (int) height/2 && w == width) || (h == height && w == (int) width/2)){ //La condition passe jamais
                    rectPattern[h][w] = Pattern.Porte;
                }
                rectPattern[h][w] = Pattern.Simple;
            }
        }
        this.matriceSalle = rectPattern;
        this.height = height;
        this.width = width;
    }


    public void printSalle(){
        for (Case[] values : matriceSalle) {
            for (int j = 0; j < values.length; j++) {
                if ((j + 1) == values.length) {
                    System.out.print(values[j].getPrintConsole());
                } else {
                    System.out.print(values[j].getPrintConsole() + " ");
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
