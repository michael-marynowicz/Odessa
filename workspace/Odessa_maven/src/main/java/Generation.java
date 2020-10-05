package main.java;

import java.util.ArrayList;

public class Generation {
    static int tailleX = 50;
    static int tailleY = 25;
    static int nbPiece = 100;

    public static void main(String[] args) throws InterruptedException {
        /* Le fait qu'on génère le donjon dans le main peut être chiant pour la suite si on imagine par exemple
        créer différents étages qui pourraient avoir différentes façon de se générer, différentes tailles ou des types.
        On peut voir si on le met dans une classe à part ou pas.
         */
        Pattern.genPattern();
        Donjon matriceDonjon = new Donjon(tailleX,tailleY);
        for(int i = 0; i < nbPiece; i++){
            Salle salle = new Salle();
            salle.suppr_Porte();
            matriceDonjon.ajoutSalle(salle);
        }

        matriceDonjon.printDonjon();



    }

}