package src;

import java.util.ArrayList;

public class Generation {
    static int[][] ajoutSalle(int[][] matriceDonjon, Salle salle, int coordonneeX, int coordonneeY){
        //Y'a peut être moyen de réduire le nombre de paramètre en ayant un donjon global/ une classe donjon et
        //en faisant que "ajoutsalle()" devienne une méthode de classe
        int n=0, m=0;
        for(int i=0; i < 5; i++){
            for(int j=0; j < 5; j++){
                matriceDonjon[coordonneeX+i][coordonneeY + j] = salle.matriceSalle[n][m];
                m+=1;
            }
            m=0;
            n+=1;
        }
        return matriceDonjon;
    }

    public static void main(String[] args) {
        /* Le fait qu'on génère le donjon dans le main peut être chiant pour la suite si on imagine par exemple
        créer différents étages qui pourraient avoir différentes façon de se générer, différentes tailles ou des types.
        On peut voir si on le met dans une classe à part ou pas.
         */
        int[][] matriceDonjon = new int[20][20];
        for(int i = 0; i< matriceDonjon.length; i++){
            for(int j = 0; j< matriceDonjon.length; j++){
                matriceDonjon[i][j] = 0;
                if((j+1) == matriceDonjon.length){
                    System.out.print(matriceDonjon[i][j]);
                }
                else {
                    System.out.print(matriceDonjon[i][j] + "   ");
                }
            }
            System.out.print('\n');
        }
        Salle test = new Salle(0,0);
        test.printMatrice();
        matriceDonjon = ajoutSalle(matriceDonjon, test,14,3);
        for(int i=0; i< matriceDonjon.length;i++){
            for(int j = 0; j< matriceDonjon.length; j++){
                if((j+1) == matriceDonjon.length){
                    System.out.print(matriceDonjon[i][j]);
                }
                else {
                    System.out.print(matriceDonjon[i][j] + "   ");
                }
            }
            System.out.print('\n');
        }

    }

}