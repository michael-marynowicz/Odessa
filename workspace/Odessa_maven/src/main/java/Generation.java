package main.java;


import javax.lang.model.type.ArrayType;
import java.util.*;

public class Generation {
    static int tailleX = 50;
    static int tailleY = 25;
    static int nbPiece = 4;
    static boolean arrive = false;
    public static void main(String[] args) throws InterruptedException {
        /* Le fait qu'on génère le donjon dans le main peut être chiant pour la suite si on imagine par exemple
        créer différents étages qui pourraient avoir différentes façon de se générer, différentes tailles ou des types.
        On peut voir si on le met dans une classe à part ou pas.
         */
        Pattern.genPattern();
        Donjon matriceDonjon = new Donjon(tailleX,tailleY);
        int j = 0;
        for(int i = 0; i < nbPiece; i++) {
            Salle salle = new Salle();
            salle.suppr_Porte();

            matriceDonjon.ajoutSalle(salle);
        }
        int[] depart = new int[]{matriceDonjon.coordonneeSalles.get(0)[1]+ matriceDonjon.coordoPortes.get(0).get(0).get(1), matriceDonjon.coordonneeSalles.get(0)[0]+ matriceDonjon.coordoPortes.get(0).get(0).get(0)};
        int[] fin = new int[]{matriceDonjon.coordonneeSalles.get(1)[1]+ matriceDonjon.coordoPortes.get(1).get(0).get(1), matriceDonjon.coordonneeSalles.get(1)[0]+ matriceDonjon.coordoPortes.get(1).get(0).get(0)};
        int[] t = {5,5};
        int[] d = {5,5};
        System.out.println(depart[0] + " " + depart[1]);
        System.out.println(fin[0] + " " + fin[1]);
        System.out.println("==========");


        BFS(matriceDonjon, depart, fin);
        matriceDonjon.printDonjon();
    }

    public static void BFS(Donjon matrice, int[] depart, int[] fin){
        Queue<int[]> queue = new LinkedList<int[]>();
        ArrayList<int[]> visited = new ArrayList<int[]>();
        queue.add(depart);

        visited.add(depart);
        while(!queue.isEmpty()) {
            int[] s = queue.remove();
            System.out.println(s[0] + " " + s[1]);
            if (Arrays.equals(s, fin)) {
                queue.add(s);
                System.out.println("LA FIN : " + s[0] + " " + s[1]);
                break;
            }
            int x = s[0];
            int y = s[1];
            boolean ajout = true;
            if ((x - 1 >= 0 && x - 1 < tailleX)){
                if (matrice.matriceDonjon[y][x - 1].printConsole == 0 || (matrice.matriceDonjon[y][x - 1].printConsole == 2 && x - 1 == fin[0] && y == fin[1])) {
                    int[] tempo = {x - 1, y};
                    ajout = true;
                    for(int[] i : visited){
                        if (i[0] == tempo[0] && i[1] == tempo[1]) {
                            ajout = false;

                            break;
                        }
                    }
                    if(ajout){
                        queue.add(tempo);
                        visited.add(tempo);
                    }
                }
            }
            if ((y - 1 >= 0 && y - 1 < tailleY)) {
                if (matrice.matriceDonjon[y - 1][x].printConsole == 0 || (matrice.matriceDonjon[y - 1][x].printConsole == 2 && x == fin[0] && y - 1 == fin[1])) {
                    int[] tempo = {x, y - 1};
                    ajout = true;
                    for(int[] i : visited){
                        if (i[0] == tempo[0] && i[1] == tempo[1]) {
                            ajout = false;

                            break;
                        }
                    }
                    if(ajout){
                        queue.add(tempo);
                        visited.add(tempo);
                    }
                }
            }

            if ((x + 1 > 0 && x + 1 < tailleX)){
                if( matrice.matriceDonjon[y][x + 1].printConsole == 0 || (matrice.matriceDonjon[y][x + 1].printConsole == 2 && x + 1 == fin[0] && y == fin[1])) {
                    int[] tempo = {x + 1, y};
                    ajout = true;
                    for(int[] i : visited){
                        if (i[0] == tempo[0] && i[1] == tempo[1]) {
                            ajout = false;

                            break;
                        }
                    }
                    if(ajout){
                        queue.add(tempo);
                        visited.add(tempo);
                    }
                }
            }
            if( (y+1 > 0 && y+1 < tailleY)) {
                if (matrice.matriceDonjon[y + 1][x].printConsole == 0 || (matrice.matriceDonjon[y + 1][x].printConsole == 2 && x == fin[0] && y + 1 == fin[1])) {
                    int[] tempo = {x, y + 1};
                    ajout = true;
                    for(int[] i : visited){
                        if (i[0] == tempo[0] && i[1] == tempo[1]) {
                            ajout = false;

                            break;
                        }
                    }
                    if(ajout){
                        queue.add(tempo);
                        visited.add(tempo);
                    }
                }
            }
        }
        System.out.println("LA QUEUE :");

        for(int[] s : visited) {
            matrice.matriceDonjon[s[1]][s[0]] = new Case(7);
        }
        for(int[] s : queue) {
            System.out.println(s[0] + " " + s[1]);
            matrice.matriceDonjon[s[1]][s[0]] = new Case(5);
        }

    }

}