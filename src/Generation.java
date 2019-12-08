package src;

import java.util.ArrayList;
import java.util.Random;

public class Generation{

    public static void main(String[] args) {
        Fenetre fen = new Fenetre();

    }
}



/*
    public class Generation {
        Random r = new Random();
        Points Origine = new Points(100, 100, true);
        ArrayList<Points> PointsEnCours = new ArrayList<>();

        void execution() {
            int incrementeurPointMort = 0;
            int[] current = {0, 0};
            while (PointsEnCours.isEmpty() == false) {
                for (i in PointsEnCours) {
                    for (j in i.couloirs) {
                        choisiretconstruirecouloir();
                        construire(i, x, y, constructable(incrementeurPointMort)); //if constructable = false, Points.listeCouloir sera vide
                        remove j de i;
                        incrementeurPointMort += 2;
                    }
                }
            }
        }
    } */
