package src;

import java.util.ArrayList;

public class Generation {
    public static void main(String[] args) throws InterruptedException {
        /* Le fait qu'on génère le donjon dans le main peut être chiant pour la suite si on imagine par exemple
        créer différents étages qui pourraient avoir différentes façon de se générer, différentes tailles ou des types.
        On peut voir si on le met dans une classe à part ou pas.
         */
        Pattern.genPattern();
        Donjon matriceDonjon = new Donjon(20,20);

        Salle salle1 = new Salle();
        Salle salle2 = new Salle();
        Salle salle3 = new Salle();
        Salle salle4 = new Salle();
        Salle salle5 = new Salle();
        Salle salle6 = new Salle();

        matriceDonjon.ajoutSalle(salle1);
        matriceDonjon.ajoutSalle(salle2);
        matriceDonjon.ajoutSalle(salle3);
        matriceDonjon.ajoutSalle(salle4);
        matriceDonjon.ajoutSalle(salle5);
        matriceDonjon.ajoutSalle(salle6);
        matriceDonjon.printDonjon();



    }

}