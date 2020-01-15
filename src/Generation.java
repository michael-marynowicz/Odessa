package src;

import java.util.ArrayList;

public class Generation {
    static void ajoutSalle(int[][] matriceDonjon, Salle salle){
        //Y'a peut être moyen de réduire le nombre de paramètre en ayant un donjon global/ une classe donjon et
        //en faisant que "ajoutsalle()" devienne une méthode de classe
        int n=0, m=0;
        for(int i=0; i < 5; i++){
            for(int j=0; j < 5; j++){
                matriceDonjon[salle.getCoordonneeX()+i][salle.getCoordonneeY() + j] = salle.matriceSalle[n][m];
                m+=1;
            }
            m=0;
            n+=1;
        }
    }

    public static void main(String[] args) {
        /* Le fait qu'on génère le donjon dans le main peut être chiant pour la suite si on imagine par exemple
        créer différents étages qui pourraient avoir différentes façon de se générer, différentes tailles ou des types.
        On peut voir si on le met dans une classe à part ou pas.
         */
        int[][] matriceDonjon = genDonjon( 20,20);
        printDonjon(matriceDonjon);
        Salle test = new Salle(14,13);
        test.printMatrice();
        ajoutSalle(matriceDonjon, test);
        printDonjon(matriceDonjon);

    }

    public static int[][] genDonjon(int dimensionX, int dimensionY){
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


    public static void printDonjon(int[][] donjon){
        //Permet d'afficher le donjon ça évite la duplication de code
        //Pour l'instant c'est une méthode static mais normalement elle sera déplacer
        //dans la classe Donjon pour faciliter la lisibilité
        for (int[] ints : donjon) {
            for (int j = 0; j < donjon.length; j++) {
                if ((j + 1) == donjon.length) {
                    System.out.print(ints[j]);
                } else {
                    System.out.print(ints[j] + "   ");
                }
            }
            System.out.print('\n');
        }
    }

}