package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Points {


    int x;
    int y;
    int couloirs = 4;
    List<String> sorties = new ArrayList<>();
    boolean constructable = true;
    Points(int x, int y, boolean constructable){
        this.x = x;
        this.y = y;
        this.constructable = constructable;

    }
    boolean constructable(int incrementeurPointMort) {
        /*
        Définit si un point est mort ou non.
        Un point considéré mort ne permet pas de construire de couloirs
        (c'est une sorte de cas d'arrêt)
        Plus la génération avance, plus les chances d'avoir des points morts augmentent.*/
        Random r = new Random();
        return (r.nextInt() < incrementeurPointMort);
    }



    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
