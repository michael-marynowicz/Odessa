package src;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Donjon {

    private int tailleX, tailleY;
    private int[][] matriceDonjon;
    private List<Integer[]> coordonneeSalles = new ArrayList<Integer[]>(); //Contient les coordonnées des salles sous la forme : [[x1,y1],[x2,y2],[x3,y3]]

    //Permet de bloquer le constructeur par défaut
    private Donjon(){}


    Donjon(int tailleX, int tailleY){
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        matriceDonjon = genDonjon(tailleX, tailleY);
    }


    private int[][] genDonjon(int dimensionX, int dimensionY){
        //Creer une matrice remplie de "0" de taille X,Y
        int[][] donjon = new int[dimensionX][dimensionY];
        for(int i = 0; i< donjon.length; i++){
            for(int j = 0; j< donjon.length; j++){
                donjon[i][j] = 0;
            }
        }
        return donjon;
    }


    void printDonjon() throws InterruptedException {
        for (int[] values : this.matriceDonjon) {
            for (int j = 0; j < this.matriceDonjon.length; j++) {
                //Thread.sleep(5); 
                if ((j + 1) == this.matriceDonjon.length) {
                    System.out.print(values[j]);
                } else {
                    System.out.print(values[j] + " ");
                }
            }
            System.out.print('\n');
        }
    }


    private boolean verifierPlacementSalle(Salle salle){
        if(salle.getCoordonneeY()+salle.getHeight()>this.tailleY || salle.getCoordonneeX()+salle.getWidth()>this.tailleX){
            System.out.println("Impossible de créer la salle : Out Of Bounds");
            return false;
        }
        for(int i=0; i < coordonneeSalles.size(); i++){ //On regarde toutes les coordonnées des salles dans le donjon pour éviter la superposition.
            if(((salle.getCoordonneeY()>= coordonneeSalles.get(i)[0]-salle.getHeight() && salle.getCoordonneeY()<= (coordonneeSalles.get(i)[0]+salle.getHeight()))
                    && (salle.getCoordonneeX()>= coordonneeSalles.get(i)[1]-salle.getWidth() && salle.getCoordonneeX()<= (coordonneeSalles.get(i)[1]+salle.getWidth())))){
                System.out.println("Impossible de créer la salle : Superposition");
                return false;
                //Si ( coordoX < salleX < coordoX+5 ET coordoY < salleY < coordoY+5 ) alors la salle se superpose avec un autre
                //donc on la crée pas
            }
        }
        return true; //Arrivé ici on ne peut pas se superposer à une autre salle
    }


    void ajoutSalle(Salle salle) {
        int donjonY = 0, donjonX = 0;
        if(verifierPlacementSalle(salle)) {
            for (int salleY = 0; salleY < salle.getHeight(); salleY++) {
                for (int salleX = 0; salleX < salle.getWidth(); salleX++) {
                    this.matriceDonjon[salle.getCoordonneeY() + salleY][salle.getCoordonneeX() + salleX] = salle.matriceSalle[donjonY][donjonX];
                    donjonX += 1;
                }
                donjonX = 0;
                donjonY += 1;
            }
            Integer[] coordonnee = {salle.getCoordonneeY(), salle.getCoordonneeX()};
            coordonneeSalles.add(coordonnee);
        }
    }
}
