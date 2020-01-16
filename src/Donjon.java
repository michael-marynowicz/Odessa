package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Donjon {

    int tailleX, tailleY;
    int[][] matriceDonjon;
    private List<Integer[]> coordonneeSalles = new ArrayList<Integer[]>(); //Contient les coordonnées des salles sous la forme : [[x1,y1],[x2,y2],[x3,y3]]


    //Permet de bloquer le constructeur par défaut
    private Donjon(){}

    public Donjon(int tailleX, int tailleY){
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        matriceDonjon = genDonjon(tailleX, tailleY);
    }

    private int[][] genDonjon(int dimensionX, int dimensionY){
        //Permet de générer le donjon, évite la duplication de code
        //Pour l'instant c'est une méthode static mais normalement elle sera déplacer dans le constructeur
        //de la classe Donjon.
        int[][] donjon = new int[dimensionX][dimensionY];
        for(int i = 0; i< donjon.length; i++){
            for(int j = 0; j< donjon.length; j++){
                donjon[i][j] = 0;
            }
        }
        return donjon;
    }


    public void printDonjon(){
        //Permet d'afficher le donjon ça évite la duplication de code
        //Pour l'instant c'est une méthode static mais normalement elle sera déplacer
        //dans la classe Donjon pour faciliter la lisibilité
        for (int[] ints : this.matriceDonjon) {
            for (int j = 0; j < this.matriceDonjon.length; j++) {
                if ((j + 1) == this.matriceDonjon.length) {
                    System.out.print(ints[j]);
                } else {
                    System.out.print(ints[j] + "   ");
                }
            }
            System.out.print('\n');
        }
    }
    boolean verifierPlacementSalle(Salle salle){
        if(salle.getCoordonneeX()+4>=this.tailleX || salle.getCoordonneeY()+4>=this.tailleY){
            System.out.println("Impossible de créer la salle : Out Of Bounds");
            return false;
        }
        for(int i=0; i < coordonneeSalles.size(); i++){ //On regarde toutes les coordonnées des salles dans le donjon pour éviter la superposition.
            if((salle.getCoordonneeX()>= coordonneeSalles.get(i)[0] && salle.getCoordonneeX()<= (coordonneeSalles.get(i)[0]+4))
                    && (salle.getCoordonneeY()>= coordonneeSalles.get(i)[1] && salle.getCoordonneeY()<= (coordonneeSalles.get(i)[1]+4))){
                System.out.println("Impossible de créer la salle : Superposition");
                return false;
                //Si ( coordoX < salleX < coordoX+5 ET coordoY < salleY < coordoY+5 ) alors la salle se superpose avec un autre.
            }
        }
        return true; //Arrivé ici on ne peut pas se superposer à une autre salle
    }

    void ajoutSalle(Salle salle) {
        int n = 0, m = 0;
        if(verifierPlacementSalle(salle)) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    this.matriceDonjon[salle.getCoordonneeX() + i][salle.getCoordonneeY() + j] = salle.matriceSalle[n][m];
                    m += 1;
                }
                m = 0;
                n += 1;
            }
            Integer[] coordonnee = {salle.getCoordonneeX(), salle.getCoordonneeX()};
            coordonneeSalles.add(coordonnee);
        }
    }
}
