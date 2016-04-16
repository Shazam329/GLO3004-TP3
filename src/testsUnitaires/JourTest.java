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
    //Tests du constructeur
    @Test
    public void test_JourValide() throws Exception
    {
        Jour unJour = new Jour(5);
        assertEquals(unJour.getJour(), 5);
    }

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

    //Tests de la fonction getter
    @Test
    public void test_getJour() throws Exception
    {
        Jour unJour = new Jour(5);
        assertEquals(unJour.getJour(), 5);
    }

    //Tests de la fonction setter
    @Test
    public void test_setJourValide() throws Exception
    {
        Jour unJour = new Jour(5);
        unJour.setJour(6);
        assertEquals(unJour.getJour(), 6);
    }

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