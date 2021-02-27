package main.java;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Donjon {

    private int tailleX, tailleY;
     Case[][] matriceDonjon;
     List<Integer[]> coordonneeSalles = new ArrayList<Integer[]>(); //Contient les coordonnées des salles sous la forme : [[y1,x1,y2,x2],....]
     ArrayList<ArrayList<ArrayList<Integer>>> coordoPortes = new ArrayList<ArrayList<ArrayList<Integer>>>(); //Contient les coordonnées des portes par rapport à l'index de coordonneSalles : [[[y1,x1], [y2,x2]],....]

    //Permet de bloquer le constructeur par défaut
    private Donjon(){}


    Donjon(int tailleX, int tailleY){
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        matriceDonjon = genDonjon(tailleX, tailleY);
    }


    private Case[][] genDonjon(int dimensionX, int dimensionY){
        //Creer une matrice remplie de "0" de taille X,Y
        Case[][] donjon = new Case[dimensionY][dimensionX];
        for(int i = 0; i< dimensionY; i++){
            for(int j = 0; j< dimensionX; j++){
                donjon[i][j] = Pattern.Mur;
            }
        }
        return donjon;
    }


    void printDonjon() {
        for (Case[] values : this.matriceDonjon) {
            for (int j = 0; j < values.length; j++) {
                //Thread.sleep(5); 
                if ((j + 1) == values.length) {
                    if ( values[j] == Pattern.Simple){
                        System.out.print(ConsoleColors.BLUE + values[j].getPrintConsole() + ConsoleColors.RESET);
                    }
                    else if(values[j] == Pattern.Porte ){
                        System.out.print(ConsoleColors.RED + values[j].getPrintConsole() + ConsoleColors.RESET);
                    }
                    else if(values[j] == Pattern.Couloir ){
                        System.out.print(ConsoleColors.GREEN + values[j].getPrintConsole() + ConsoleColors.RESET);
                    }
                    else{
                        System.out.print(ConsoleColors.RESET + values[j].getPrintConsole());
                    }

                } else {
                    if (values[j] == Pattern.Simple){
                        System.out.print(ConsoleColors.BLUE + values[j].getPrintConsole() + " ");
                    }
                    else if(values[j] == Pattern.Porte  ){
                        System.out.print(ConsoleColors.RED + values[j].getPrintConsole() + " ");
                    }
                    else if(values[j] == Pattern.Couloir ){
                        System.out.print(ConsoleColors.GREEN + values[j].getPrintConsole() + " ");
                    }
                    else{
                        System.out.print(ConsoleColors.RESET + values[j].getPrintConsole() + " ");
                    }

                }
            }
            System.out.print('\n');
        }
        System.out.println("Nombre de pièces dans le donjon : " + coordonneeSalles.size() + "/" + Generation.nbPiece);
    }



    private boolean verifierPlacementSalle(Salle salle){
        if(salle.getCoordonneeY()+salle.getHeight()>this.tailleY || salle.getCoordonneeX()+salle.getWidth()>this.tailleX){
            System.out.println("Impossible de créer la salle : Out Of Bounds");
            return false;
        }
        for(int i=0; i < coordonneeSalles.size(); i++){ //On regarde toutes les coordonnées des salles dans le donjon pour éviter la superposition.
            if(((salle.getCoordonneeY() >= coordonneeSalles.get(i)[0] - salle.getHeight() && salle.getCoordonneeY() <= (coordonneeSalles.get(i)[0] + coordonneeSalles.get(i)[2]))
                    && (salle.getCoordonneeX() >= coordonneeSalles.get(i)[1] - salle.getWidth() && salle.getCoordonneeX()<= (coordonneeSalles.get(i)[1]+coordonneeSalles.get(i)[3])))){

                return false;
                //Si ( coordoX < salleX < coordoX+5 ET coordoY < salleY < coordoY+5 ) alors la salle se superpose avec un autre
                //donc on la crée pas
            }
        }
        return true; //Arrivé ici on ne peut pas se superposer à une autre salle
    }


    boolean ajoutSalle(Salle salle) {
        if(verifierPlacementSalle(salle)) {
            for (int salleY = 0; salleY < salle.getHeight(); salleY++) {
                if (salle.getWidth() >= 0)
                    System.arraycopy(salle.matriceSalle[salleY], 0, this.matriceDonjon[salle.getCoordonneeY() + salleY], salle.getCoordonneeX(), salle.getWidth());
            }
            Integer[] coordonnee = {salle.getCoordonneeY(), salle.getCoordonneeX(), salle.getHeight(), salle.getWidth()};
            coordonneeSalles.add(coordonnee);
            coordoPortes.add(salle.positionDesPortes);
            return true;
        }
        return false;

    }

}
