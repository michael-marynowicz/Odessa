

import java.util.*;

public class Salle {

    private Random r = new Random();
    private final int coordonneeY;
    private final int coordonneeX;
    private int height;
    private int width;
    Case[][] matriceSalle;
    ArrayList<ArrayList<Integer>> positionDesPortes;

    public Salle(){
        this.coordonneeY = r.nextInt(Generation.tailleY - 5);
        this.coordonneeX = r.nextInt(Generation.tailleX - 4);
        int i = this.r.nextInt(Pattern.values().length);
        Pattern pat = Pattern.values()[i];
        this.matriceSalle = new Case[Pattern.map.get(pat).length][];
        for (int w= 0; w < Pattern.map.get(pat).length; w++) {
            matriceSalle[w] = Arrays.copyOf(Pattern.map.get(pat)[w], Pattern.map.get(pat)[w].length);
        } //Récupère la matrice du pattern
        this.width = Pattern.map.get(pat)[0].length;
        this.height = Pattern.map.get(pat).length;
        this.positionDesPortes =  this.reperePorte();
        this.corrigerPortes();
    }
    Salle(int coordonneeY, int coordonneeX){
        this.coordonneeY = coordonneeY;
        this.coordonneeX = coordonneeX;
        this.genSalle(); //Cree une salle rectangulaire
    }
    public Salle(int coordonneeY, int coordonneeX, Pattern pattern){ // Permet de choisir un pattern Pré-défini
        this.coordonneeY = coordonneeY;
        this.coordonneeX = coordonneeX;
        this.matriceSalle = new Case[Pattern.map.get(pattern).length][];
        for (int w= 0; w < Pattern.map.get(pattern).length; w++) {
            matriceSalle[w] = Arrays.copyOf(Pattern.map.get(pattern)[w], Pattern.map.get(pattern)[w].length);
        }
        this.width = Pattern.map.get(pattern)[0].length;
        this.height = Pattern.map.get(pattern).length;
        this.positionDesPortes =  this.reperePorte();
        this.corrigerPortes();
    }


    public void genSalle(){
        //Crée des patterns rectangulaires aleatoires. (min 2x2, max 7x5)
        int height = r.nextInt(4)+2;
        int width = r.nextInt(4)+2;
        Case[][] rectPattern = new Case[height][width];
        for(int h=0; h<height; h++){
            for(int w=0; w<width;w++){
                if((h == 0 && w == 0) || (h == height/2 && w == 0) || (h == height/2 && w == width-1) || (h == height-1 && w ==  width/2)){
                    rectPattern[h][w] = Pattern.Porte;
                }
                rectPattern[h][w] = Pattern.Simple;
            }
        }
        this.matriceSalle = rectPattern;
        this.height = height;
        this.width = width;
    }


    private ArrayList<ArrayList<Integer>> reperePorte() {
        ArrayList<ArrayList<Integer>> liste = new ArrayList<>();
        for(int i=0; i < this.matriceSalle.length; i++){
            for(int j=0; j < this.matriceSalle[i].length; j++){
                if(this.matriceSalle[i][j].isDoor()){
                    ArrayList<Integer> porte = new ArrayList<>();
                    porte.add(i);
                    porte.add(j);
                    liste.add(porte);
                }
            }
        }
        return liste;
    }

    public boolean porteMalPlacee(ArrayList<Integer> CoordonneePorte){
        if(CoordonneePorte.get(1) == 0 && this.coordonneeX == 0) { return true; }
        if(CoordonneePorte.get(1) + this.coordonneeX +1 >= Generation.tailleX) { return true; }
        if(CoordonneePorte.get(0) == 0  && this.coordonneeY <= 0) { return true; }
        return CoordonneePorte.get(0) + this.coordonneeY + 1 >= Generation.tailleY;
    }

    public void effacerPorte(ArrayList<Integer> CoordonneePorte){
        //Remplace la porte part une case Simple dans la matrice de la salle
        int y = CoordonneePorte.get(0);
        int x = CoordonneePorte.get(1);
        this.matriceSalle[y][x] = Pattern.Simple;
    }

    public void corrigerPortes(){
        //Vérifie pour chaque porte de la salle si elle est trop proche d'un bord et l'efface si c'est le cas
        for(int porte=0; porte < this.positionDesPortes.size(); porte++){
            if(porteMalPlacee(this.positionDesPortes.get(porte))){
                effacerPorte(this.positionDesPortes.get(porte));
                this.positionDesPortes.remove(porte);
                porte--;
            }
        }
    }

    public void suppr_Porte(){
        int porte_restante = this.positionDesPortes.size();
        ArrayList<ArrayList<Integer>> tampon = new ArrayList<ArrayList<Integer>>(positionDesPortes);
        int inTampon = 0;
        for(int porte=0; porte < this.positionDesPortes.size(); porte++){
            if((r.nextInt(3)==1) & porte_restante > 2){ //une chance sur 2 de supprimer une porte si on a plus de 2 portes
                effacerPorte(tampon.get(inTampon));
                tampon.remove(inTampon);
                if(inTampon >0){ //Ouais je sais c'est moche mais jdois aller manger j'ai pas eu le temps de faire mieux
                    inTampon --;
                }
                porte_restante -- ;
            }
            else{
                inTampon++;
            }

        }
        this.positionDesPortes = tampon;
    }

   public void printSalle(){
        //On peut surement supprimer ça
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
        System.out.print('\n');
    }
    public int getCoordonneeY() { return coordonneeY; }
    public int getCoordonneeX() { return coordonneeX; }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }

}
