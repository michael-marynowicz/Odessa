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

        Salle salle1 = new Salle(0,0);
        Salle salle2 = new Salle(6,0);
        Salle salle3 = new Salle(8,0);
        Salle salle4 = new Salle(5,6);
        Salle salle5 = new Salle(3,6);
        Salle salle6 = new Salle(7,15);
        matriceDonjon.ajoutSalle(salle1);
        matriceDonjon.ajoutSalle(salle2);
        matriceDonjon.ajoutSalle(salle3);
        matriceDonjon.ajoutSalle(salle4);
        matriceDonjon.ajoutSalle(salle5);
        matriceDonjon.ajoutSalle(salle6);
        matriceDonjon.printDonjon();
        System.out.println(salle1.getCoordonneeX() +" : " + salle1.getCoordonneeY());
        System.out.println(salle2.getCoordonneeX() +" : " + salle2.getCoordonneeY());
        System.out.println(salle3.getCoordonneeX() +" : " + salle3.getCoordonneeY());
        System.out.println(salle4.getCoordonneeX() +" : " + salle4.getCoordonneeY());
        System.out.println(salle5.getCoordonneeX() +" : " + salle5.getCoordonneeY());
        System.out.println(salle6.getCoordonneeX() +" : " + salle6.getCoordonneeY());


    }

}