package src;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Generation {

    public static void main(String[] args) {
        Fenetre fen = new Fenetre();
        Points[][] tableau = new Points[11][11];
        Points Origine = new Points(5, 5, 1);
        tableau[5][5] = Origine;
        ArrayList<Points> PointsEnCours = new ArrayList<>();
    }

    void execution(ArrayList<Points> PointsEnCours, Points[][] tableau) {
        ArrayList<Points> PointsAjouter = new ArrayList<Points>();
        int incrementeurPointMort = 0;
        for (int i = 0; i < PointsEnCours.size(); i++) {

            Points points_up = new Points(PointsEnCours.get(i).getX(), PointsEnCours.get(i).getY() - 1, 1);
            Points points_down = new Points(PointsEnCours.get(i).getX(), PointsEnCours.get(i).getY() + 1, 1);
            Points points_right = new Points(PointsEnCours.get(i).getX() + 1, PointsEnCours.get(i).getY(), 1);
            Points points_left = new Points(PointsEnCours.get(i).getX() - 1, PointsEnCours.get(i).getY(), 1);
            if (tableau[points_up.getX()][points_up.getY()] != null) {
                tableau[points_up.getX()][points_up.getY()] = points_up;
                PointsAjouter.add(points_up);
            }
            if (tableau[points_down.getX()][points_down.getY()] != null) {
                tableau[points_down.getX()][points_down.getY()] = points_down;
                PointsAjouter.add(points_down);
            }
            if (tableau[points_right.getX()][points_right.getY()] != null) {
                tableau[points_right.getX()][points_right.getY()] = points_right;
                PointsAjouter.add(points_right);
            }
            if (tableau[points_left.getX()][points_left.getY()] != null) {
                tableau[points_left.getX()][points_left.getY()] = points_left;
                PointsAjouter.add(points_left);
            }

            incrementeurPointMort += 2;
        }

        PointsEnCours = (ArrayList<Points>) PointsAjouter.clone();
    }
}



/*
    public class Generation {
        Random r = new Random();
        Points Origine = new Points(100, 100, true);
        ArrayList<Points> PointsEnCours = new ArrayList<>();


    } */
