package src;

import java.util.ArrayList;
import java.util.Random;

public class Generation{

    public static void main(String[] args) {
        Fenetre fen = new Fenetre();
        Points Origine = new Points(100, 100, true);
        ArrayList<Points> PointsEnCours = new ArrayList<>();
    }

    void execution(ArrayList<Points>  PointsEnCours) {
        int incrementeurPointMort = 0;
        int[] current = {0, 0};
        while (!PointsEnCours.isEmpty()) {
            for (int i = 0; i < PointsEnCours.size(); i++) {
                for (int j = 0;  j < PointsEnCours.get(i).couloirs) {
                    Couloir couloir = new Couloir();
                    Points points = new Points(PointsEnCours.get(i).getX()-couloir.x1,PointsEnCours.get(i).getY()-couloir.y1,true);
                    incrementeurPointMort += 2;
                }
            }
        }
    }
}



/*
    public class Generation {
        Random r = new Random();
        Points Origine = new Points(100, 100, true);
        ArrayList<Points> PointsEnCours = new ArrayList<>();


    } */
