import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class Fenetre extends JPanel {
    public Fenetre() {
        JFrame Fenetre = new JFrame();

        //Définit un titre pour notre fenêtre
        Fenetre.setTitle("Ma première fenêtre Java");
        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        Fenetre.setSize(400, 100);
        //Nous demandons maintenant à notre objet de se positionner au centre
        Fenetre.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        Fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Et enfin, la rendre visible
        Fenetre.setVisible(true);

        //Instanciation d'un objet JPanel
        JPanel pan = new JPanel();
        //Définition de sa couleur de fond
        pan.setBackground(Color.ORANGE);
        //On prévient notre JFrame que notre JPanel sera son content pane
        this.setVisible(true);
    }

}
