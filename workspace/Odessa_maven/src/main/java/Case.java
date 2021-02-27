

public class Case {

    private boolean isDoor;
    public int printConsole = 1;


    private int coordonneeY;
    private int coordonneeX;
    private Case parent = null;
    private Case(){}

    Case(int x, int y){
        this.coordonneeX = x;
        this.coordonneeY = y;
    }

    Case(boolean isDoor){
        this.isDoor = isDoor;
    }

    Case(int vide){
        this.printConsole = vide;
    }

    Case(boolean isDoor, int porte){ //Sert à mettre un 2 dans la console (c'est plus lisible lol)
        this.printConsole = 2;
        this.isDoor = true;
    }

    public boolean isDoor() { return isDoor; }
    public int getPrintConsole(){ return this.printConsole; }

    public int getCoordonneeY() {
        return coordonneeY;
    }

    public int getCoordonneeX() {
        return coordonneeX;
    }

    public Case getParent() {
        return parent;
    }

    public void setParent(Case parent) {
        this.parent = parent;
    }
}


