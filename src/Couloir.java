package src;

import java.util.Random;

public class Couloir {
    /*Contient des coordonnées pour représenter nos formes de couloirs
    chaque couloir est représenté par un tableau de n entiers avec [x0, ... ,x(n//2),y0, ..., y(n//2)]
    exemple concret pour upline : (x0 = 0, x1 = 0; y1 = 10, y2 = 10)
    quand on appellera upline on fera :
    gui.drawline(current + x0,current + y0) PUIS
    gui.drawline(current + x1,current + y1)*/
    int x0;
    int x1;
    int y0;
    int y1;

    int[] couloir =
    int[] pickCouloir(){
        /*permet de choisir aléatoirement un couloir parmis les différents couloirs possibles. */
        Random r = new Random();
        return Couloirs[r.nextInt(4)];
    }
}
