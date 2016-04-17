package testsUnitaires;

import org.junit.Test;
import tp.An;

import static org.junit.Assert.*;

/**
 *  Nom de la classe: AnTest
 *  Description: Tests unitaires de la classe An
 */
public class AnTest
{
    /////////////////////////////
    //  Tests du constructeur  //
    /////////////////////////////

    //Test de constructeur valide
    @Test
    public void test_AnValide() throws Exception
    {
        An unAn = new An(2005);
        assertEquals(unAn.getAn(), 2005);
    }

    //Test de constructeur invalide (valeur supérieure à 20000)
    @Test
    public void test_AnInvalideValeurSup() throws Exception
    {
        try
        {
            An unAnInvalide = new An(20001);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "An non valide: 20001");
        }
    }

    //Test de constructeur invalide (valeur inférieure à 1900)
    @Test
    public void test_AnInvalideValeurInf() throws Exception
    {
        try
        {
            An unAnInvalide = new An(1899);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "An non valide: 1899");
        }
    }


    ////////////////////////////////////////////
    //  Tests des fonctions getter et setter  //
    ////////////////////////////////////////////

    //Test de la fonction getter getAn
    @Test
    public void test_getAn() throws Exception
    {
        An unAn = new An(2005);
        assertEquals(unAn.getAn(), 2005);
    }

    //Test de la fonction setter setAn valide
    @Test
    public void test_setAnValide() throws Exception
    {
        An unAn = new An(2005);
        unAn.setAn(2006);
        assertEquals(unAn.getAn(), 2006);
    }

    //Test de la fonction setter setAn invalide (valeur supérieure à 20000)
    @Test
    public void test_setAnInvalideValeurSup() throws Exception
    {
        An unAn = new An(2005);

        try
        {
            unAn.setAn(20001);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "An non valide: 20001");
        }
    }

    //Test de la fonction setter setAn invalide (valeur inférieure à 1900)
    @Test
    public void test_setAnInvalideValeurInf() throws Exception
    {
        An unAn = new An(2005);

        try
        {
            unAn.setAn(1899);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "An non valide: 1899");
        }
    }
}
