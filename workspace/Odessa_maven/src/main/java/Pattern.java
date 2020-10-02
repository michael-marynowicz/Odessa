import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public enum Pattern {
    ISOLOIR, CARRE, FUMOIR, T, ARC;

    static HashMap<Pattern, Case[][]> map = new HashMap<Pattern, Case[][]>();
    static Case Porte = new Case(true, 2);
    static Case Simple = new Case(false);
    static Case Mur = new Case(0);

    public static void genPattern() {
        Case[][] isoloir = {{Simple, Porte, Simple}, {Porte, Simple, Porte}, {Simple, Porte, Simple}};
        map.put(ISOLOIR, isoloir);
        Case[][] carre = {{Simple, Simple, Porte, Simple, Simple}, {Simple, Simple, Simple, Simple, Simple}, {Porte, Simple, Simple, Simple, Porte}, {Simple, Simple, Simple, Simple, Simple}, {Simple, Simple, Porte, Simple, Simple}};
        map.put(CARRE, carre);
        Case[][] fumoir = {{Simple, Simple, Porte, Simple, Mur}, {Porte, Simple, Simple, Simple, Mur}, {Simple, Simple, Simple, Simple, Mur}, {Mur, Mur, Mur, Simple, Mur}};
        map.put(FUMOIR, fumoir);
        Case[][] t = {{Porte, Simple, Simple, Simple, Porte}, {Mur, Simple, Simple, Simple, Mur}, {Mur, Simple, Simple, Simple, Mur}, {Mur, Mur, Simple, Mur, Mur}, {Mur, Mur, Porte, Mur, Mur}};
        map.put(T, t);
        Case[][] arc = {{Simple, Simple, Porte, Simple, Simple}, {Simple, Simple, Simple, Simple, Simple}, {Simple, Simple, Mur, Simple, Simple}, {Porte, Simple, Mur, Simple, Porte}};
        map.put(ARC, arc);
    }

    public static Pattern getRandomPattern() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    public static ArrayList<ArrayList<Integer>> reperePorte(Pattern salle) {
        Case[][] oui = map.get(salle);
        ArrayList<ArrayList<Integer>> liste = new ArrayList<>();
        for(int i=0; i < oui.length; i++){
            for(int j=0; j < oui[i].length; j++){
                if(oui[i][j] == Porte){
                    ArrayList<Integer> sous = new ArrayList<Integer>();
                    sous.add(i);
                    sous.add(j);
                    liste.add(sous);
                }
            }
        }
        //System.out.println(liste);
        return liste;
    }

    public static Case[][] suppr_Porte(Pattern salle,  ArrayList<ArrayList<Integer>> pos){
        Case[][] oui = map.get(salle);
        int porte_enlever = 0;
        for(int i = 0; i < pos.size(); i++){
            Random random = new Random();
            int luck = random.nextInt(2);
            System.out.println("LA LUCK " + luck);
            if(luck == 1 & porte_enlever < (pos.size()-1)){
                porte_enlever ++ ;
                ArrayList<Integer> nui = pos.get(i);
                oui[nui.get(0)][nui.get(1)] = Simple;
            }
        }
        return oui;


    }
}

