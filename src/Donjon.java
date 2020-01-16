package src;

public class Donjon {

    int tailleX, tailleY;
    int[][] matriceDonjon;

    //Permet de bloquer le constructeur par défaut
    private Donjon(){}

    public Donjon(int tailleX, int tailleY){
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        matriceDonjon = genDonjon(tailleX, tailleY);
    }

    private int[][] genDonjon(int dimensionX, int dimensionY){
        //Permet de générer le donjon, évite la duplication de code
        //Pour l'instant c'est une méthode static mais normalement elle sera déplacer dans le constructeur
        //de la classe Donjon.
        int[][] donjon = new int[dimensionX][dimensionY];
        for(int i = 0; i< donjon.length; i++){
            for(int j = 0; j< donjon.length; j++){
                donjon[i][j] = 0;
            }
        }
        return donjon;
    }


    public void printDonjon(){
        //Permet d'afficher le donjon ça évite la duplication de code
        //Pour l'instant c'est une méthode static mais normalement elle sera déplacer
        //dans la classe Donjon pour faciliter la lisibilité
        for (int[] ints : this.matriceDonjon) {
            for (int j = 0; j < this.matriceDonjon.length; j++) {
                if ((j + 1) == this.matriceDonjon.length) {
                    System.out.print(ints[j]);
                } else {
                    System.out.print(ints[j] + "   ");
                }
            }
            System.out.print('\n');
        }
    }

    void ajoutSalle(Salle salle){
        //Y'a peut être moyen de réduire le nombre de paramètre en ayant un donjon global/ une classe donjon et
        //en faisant que "ajoutsalle()" devienne une méthode de classe
        int n=0, m=0;
        for(int i=0; i < 5; i++){
            for(int j=0; j < 5; j++){
                this.matriceDonjon[salle.getCoordonneeX()+i][salle.getCoordonneeY() + j] = salle.matriceSalle[n][m];
                m+=1;
            }
            m=0;
            n+=1;
        }
    }
}
