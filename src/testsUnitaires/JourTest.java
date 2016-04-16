package testsUnitaires;

import org.junit.Test;
import tp.Jour;

import static org.junit.Assert.*;

/**
 *  Nom de la classe: JourTest
 *  Description: Tests unitaires de la classe Jour
 */
public class JourTest
{
    @Test
    public void test_Jour() throws Exception
    {
        Jour unJour = new Jour(5);
        int nJour = unJour.getJour();

        assertEquals(nJour, 5);
    }

    /*@Test
    public void test_getJour() throws Exception
    {

    }

    @Test
    public void test_setJour() throws Exception
    {

    }*/

}