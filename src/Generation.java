package src;

import java.util.ArrayList;

public class Generation {

    public static void main(String[] args) {
        /* Le fait qu'on génère le donjon dans le main peut être chiant pour la suite si on imagine par exemple
        créer différents étages qui pourraient avoir différentes façon de se générer, différentes tailles ou des types.
        On peut voir si on le met dans une classe à part ou pas.
         */
        Donjon matriceDonjon = new Donjon(20,20);
        matriceDonjon.printDonjon();
        Salle salle = new Salle(14,13);
        Salle salle1 = new Salle(0,0);
        Salle salle2 = new Salle(14,3);
        Salle salle3 = new Salle(8,8);
        Salle salle4 = new Salle(0,15);
        salle.printMatrice();
        matriceDonjon.ajoutSalle(salle);
        matriceDonjon.ajoutSalle(salle1);
        matriceDonjon.ajoutSalle(salle2);
        matriceDonjon.ajoutSalle(salle3);
        matriceDonjon.ajoutSalle(salle4);
        matriceDonjon.printDonjon();

    }

}