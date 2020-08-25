import java.util.Random;

public class Couloir {
    /*Contient des coordonnées pour représenter nos formes de couloirs
    chaque couloir est représenté par un tableau de n entiers avec [x0, ... ,x(n//2),y0, ..., y(n//2)]
    exemple concret pour upline : (x0 = 0, x1 = 0; y1 = 10, y2 = 10)
    quand on appellera upline on fera :
    gui.drawline(current + x0,current + y0) PUIS
    gui.drawline(current + x1,current + y1)*/
    int x;
    int y;

    public Couloir(){
        Random r = new Random();
        int aleatoire = r.nextInt(4);
        switch(aleatoire){
            case 0:
                this.y = 10;
                break;
            case 1:
                this.y = -10;
                break;
            case 2:
                this.x = 10;
                break;
            default:
                this.x = -10;
                break;
        }
    }


    public Couloir(int x, int y){
        this.x = x;
        this.y = y;
    }


    public Couloir(int n){
        switch(n){
            case 0:
                this.y = 10;
                break;
            case 1:
                this.y = -10;
                break;
            case 2:
                this.x = 10;
                break;
            default:
                this.x = -10;
                break;
        }
    }
}
