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
    /////////////////////////////
    //  Tests du constructeur  //
    /////////////////////////////

    //Test de constructeur valide
    @Test
    public void test_MoisValide() throws Exception
    {
        Mois unMois = new Mois(5);
        assertEquals(unMois.getMois(), 5);
    }

    //Test de constructeur invalide (valeur supérieure à 12)
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

    //Test de constructeur invalide (valeur inférieure à 1)
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


    ////////////////////////////////////////////
    //  Tests des fonctions getter et setter  //
    ////////////////////////////////////////////

    //Test de la fonction getter getMois
    @Test
    public void test_getMois() throws Exception
    {
        Mois unMois = new Mois(5);
        assertEquals(unMois.getMois(), 5);
    }

    //Test de la fonction setter setMois valide
    @Test
    public void test_setMoisValide() throws Exception
    {
        Mois unMois = new Mois(5);
        unMois.setMois(6);
        assertEquals(unMois.getMois(), 6);
    }

    //Test de la fonction setter setMois invalide (valeur supérieure à 12)
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

    //Test de la fonction setter setMois invalide (valeur inférieure à 1)
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
