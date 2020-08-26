import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class SalleTest {

    @Test
    void genSalleTest() {
        //je gen un rectangle
        Salle salle = new Salle();
        salle.genSalle();

        //on vérifie si Y est entre 1 et 6
        assertTrue(6 > salle.getHeight(), "Error, random is too high");
        assertTrue(1 < salle.getHeight(), "Error, random is too low");

        //on vérifie si X est entre 1 et 6
        assertTrue(6 > salle.getWidth(), "Error, random is too high");
        assertTrue(1 < salle.getWidth(), "Error, random is too low");
    }

}