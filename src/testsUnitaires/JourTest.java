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
    /////////////////////////////
    //  Tests du constructeur  //
    /////////////////////////////

    //Test de constructeur valide
    @Test
    public void test_JourValide() throws Exception
    {
        Jour unJour = new Jour(5);
        assertEquals(unJour.getJour(), 5);
    }

    //Test de constructeur invalide (valeur supérieure à 31)
    @Test
    public void test_JourInvalideValeurSup() throws Exception
    {
        try
        {
            Jour unJourInvalide = new Jour(32);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Jour non valide: 32");
        }
    }

    //Test de constructeur invalide (valeur inférieure à 1)
    @Test
    public void test_JourInvalideValeurInf() throws Exception
    {
        try
        {
            Jour unJourInvalide = new Jour(0);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Jour non valide: 0");
        }
    }


    ////////////////////////////////////////////
    //  Tests des fonctions getter et setter  //
    ////////////////////////////////////////////

    //Test de la fonction getter getJour
    @Test
    public void test_getJour() throws Exception
    {
        Jour unJour = new Jour(5);
        assertEquals(unJour.getJour(), 5);
    }

    //Test de la fonction setter setJour valide
    @Test
    public void test_setJourValide() throws Exception
    {
        Jour unJour = new Jour(5);
        unJour.setJour(6);
        assertEquals(unJour.getJour(), 6);
    }

    //Test de la fonction setter setJour invalide (valeur supérieure à 31)
    @Test
    public void test_setJourInvalideValeurSup() throws Exception
    {
        Jour unJour = new Jour(5);

        try
        {
            unJour.setJour(32);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Jour non valide: 32");
        }
    }

    //Test de la fonction setter setJour invalide (valeur inférieure à 1)
    @Test
    public void test_setJourInvalideValeurInf() throws Exception
    {
        Jour unJour = new Jour(5);

        try
        {
            unJour.setJour(0);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Jour non valide: 0");
        }
    }
}