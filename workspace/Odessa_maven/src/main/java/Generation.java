package main.java;

import java.util.ArrayList;

public class Generation {
    static int tailleX = 50;
    static int tailleY = 25;
    static int nbPiece = 50;

    public static void main(String[] args) throws InterruptedException {
        /* Le fait qu'on génère le donjon dans le main peut être chiant pour la suite si on imagine par exemple
        créer différents étages qui pourraient avoir différentes façon de se générer, différentes tailles ou des types.
        On peut voir si on le met dans une classe à part ou pas.
         */
        Pattern.genPattern();
        Donjon matriceDonjon = new Donjon(tailleX,tailleY);
        int j = 0;
        for(int i = 0; i < nbPiece; i++){
            Salle salle = new Salle();
            salle.suppr_Porte();

            if(matriceDonjon.ajoutSalle(salle)){
                System.out.println(matriceDonjon.coordoPortes.get(j).get(0).get(0) + salle.getCoordonneeY());
                System.out.println(matriceDonjon.coordoPortes.get(j).get(0).get(1) + salle.getCoordonneeX());
                System.out.println("================\n");
                j +=1;
            }
        }

        matriceDonjon.printDonjon();



    }

}