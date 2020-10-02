import java.util.ArrayList;
import java.util.Arrays;
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
        Case[][] fumoir = {{Simple, Simple, Porte, Simple, Mur}, {Porte, Simple, Simple, Porte, Mur}, {Simple, Simple, Simple, Simple, Mur}, {Mur, Mur, Mur, Simple, Mur}};
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
}

