package main.java;


import javax.lang.model.type.ArrayType;
import java.util.*;

public class Generation {
    static int tailleX = 50;
    static int tailleY = 25;
    static int nbPiece = 20;
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

        Case depart = new Case(matriceDonjon.coordonneeSalles.get(0)[1]+ matriceDonjon.coordoPortes.get(0).get(0).get(1),matriceDonjon.coordonneeSalles.get(0)[0]+ matriceDonjon.coordoPortes.get(0).get(0).get(0));
        Case fin = new Case(matriceDonjon.coordonneeSalles.get(1)[1]+ matriceDonjon.coordoPortes.get(1).get(0).get(1),matriceDonjon.coordonneeSalles.get(1)[0]+ matriceDonjon.coordoPortes.get(1).get(0).get(0));

        BFS(matriceDonjon, depart, fin);

        matriceDonjon.printDonjon();
    }



    public static void BFS(Donjon matrice, Case depart, Case fin){
        Queue<Case> queue = new LinkedList<Case>();
        ArrayList<Case> visited = new ArrayList<Case>();
        queue.add(depart);

        visited.add(depart);
        while(!queue.isEmpty()) {
            Case s = queue.remove();
            int x = s.getCoordonneeX();
            int y = s.getCoordonneeY();
            boolean ajout = true;

            //PARCOURS AUTOUR DE LUI
            if ((x - 1 >= 0 && x - 1 < tailleX)){
                if (matrice.matriceDonjon[y][x - 1].printConsole == 0 || (matrice.matriceDonjon[y][x - 1].printConsole == 2 && x - 1 == fin.getCoordonneeX() && y == fin.getCoordonneeY()) ) {
                    Case tempo = new Case(x-1, y);

                    if (tempo.getCoordonneeY() == fin.getCoordonneeY() && tempo.getCoordonneeX() == fin.getCoordonneeX()) {
                        fin.setParent(s);
                        break;
                    }
                    ajout = true;
                    for(Case i : visited){
                        if (i.getCoordonneeX() == tempo.getCoordonneeX() && i.getCoordonneeY() == tempo.getCoordonneeY()) {
                            ajout = false;
                            break;
                        }
                    }
                    if(ajout){
                        tempo.setParent(s);
                        queue.add(tempo);
                        visited.add(tempo);

                    }
                }
            }
            if ((y - 1 >= 0 && y - 1 < tailleY)) {
                if (matrice.matriceDonjon[y - 1][x].printConsole == 0 || (matrice.matriceDonjon[y - 1][x].printConsole == 2 && x == fin.getCoordonneeX() && y - 1 == fin.getCoordonneeY())) {
                    Case tempo = new Case(x, y-1);
                    if (tempo.getCoordonneeY() == fin.getCoordonneeY() && tempo.getCoordonneeX() == fin.getCoordonneeX()) {
                        fin.setParent(s);
                        break;
                    }
                    ajout = true;
                    for(Case i : visited){
                        if (i.getCoordonneeX() == tempo.getCoordonneeX() && i.getCoordonneeY() == tempo.getCoordonneeY()) {
                            ajout = false;
                            break;
                        }
                    }
                    if(ajout){
                        tempo.setParent(s);
                        queue.add(tempo);
                        visited.add(tempo);
                    }
                }
            }
            if ((x + 1 > 0 && x + 1 < tailleX)){
                if( matrice.matriceDonjon[y][x + 1].printConsole == 0 || (matrice.matriceDonjon[y][x + 1].printConsole == 2 && x + 1 == fin.getCoordonneeX() && y == fin.getCoordonneeY())) {
                    Case tempo = new Case(x+1, y);
                    if (tempo.getCoordonneeY() == fin.getCoordonneeY() && tempo.getCoordonneeX() == fin.getCoordonneeX()) {
                        fin.setParent(s);
                        break;
                    }
                    ajout = true;
                    for(Case i : visited){
                        if (i.getCoordonneeX() == tempo.getCoordonneeX() && i.getCoordonneeY() == tempo.getCoordonneeY()) {
                            ajout = false;
                            break;
                        }
                    }
                    if(ajout){
                        tempo.setParent(s);
                        queue.add(tempo);
                        visited.add(tempo);
                    }
                }
            }
            if( (y+1 > 0 && y+1 < tailleY)) {
                if (matrice.matriceDonjon[y + 1][x].printConsole == 0 || (matrice.matriceDonjon[y + 1][x].printConsole == 2 && x == fin.getCoordonneeX() && y + 1 == fin.getCoordonneeY())) {
                    Case tempo = new Case(x, y+1);
                    if (tempo.getCoordonneeY() == fin.getCoordonneeY() && tempo.getCoordonneeX() == fin.getCoordonneeX()) {
                        fin.setParent(s);
                        break;
                    }
                    ajout = true;
                    for(Case i : visited){
                        if (i.getCoordonneeX() == tempo.getCoordonneeX() && i.getCoordonneeY() == tempo.getCoordonneeY()) {
                            ajout = false;
                            break;
                        }
                    }
                    if(ajout){
                        tempo.setParent(s);
                        queue.add(tempo);
                        visited.add(tempo);
                    }
                }
            }
        }

        // LinkedList to store path

        LinkedList<Case> path = new LinkedList<Case>();
        Case crawl = fin;
        path.add(crawl);
        boolean verif = false;
        while (!verif) {
            if(crawl.getParent() == null){
                verif = true;
                break;
            }
            path.add(crawl.getParent());
            crawl = crawl.getParent();
        }
        for(Case s : path) {
            matrice.matriceDonjon[s.getCoordonneeY()][s.getCoordonneeX()] = Pattern.Couloir;
        }
        fin.setParent(null);




    }

}