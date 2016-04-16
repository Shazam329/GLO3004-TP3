package testsUnitaires;

import org.junit.Test;
import tp.Mois;

import static org.junit.Assert.*;

/**
 *  Nom de la classe: MoisTest
 *  Description: Tests unitaires de la classe Mois
 */
public class MoisTest
{
    //Tests du constructeur
    @Test
    public void test_MoisValide() throws Exception
    {
        Mois unMois = new Mois(5);
        assertEquals(unMois.getMois(), 5);
    }

    @Test
    public void test_MoisInvalideValeurSup() throws Exception
    {
        try
        {
            Mois unMoisInvalide = new Mois(13);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Mois non valide: 13");
        }
    }

    @Test
    public void test_MoisInvalideValeurInf() throws Exception
    {
        try
        {
            Mois unMoisInvalide = new Mois(0);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Mois non valide: 0");
        }
    }

    //Tests de la fonction getter
    @Test
    public void test_getMois() throws Exception
    {
        Mois unMois = new Mois(5);
        assertEquals(unMois.getMois(), 5);
    }

    //Tests de la fonction setter
    @Test
    public void test_setMoisValide() throws Exception
    {
        Mois unMois = new Mois(5);
        unMois.setMois(6);
        assertEquals(unMois.getMois(), 6);
    }

    @Test
    public void test_setMoisInvalideValeurSup() throws Exception
    {
        Mois unMois = new Mois(5);

        try
        {
            unMois.setMois(13);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Mois non valide: 13");
        }
    }

    @Test
    public void test_setMoisInvalideValeurInf() throws Exception
    {
        Mois unMois = new Mois(5);

        try
        {
            unMois.setMois(0);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Mois non valide: 0");
        }
    }
}
