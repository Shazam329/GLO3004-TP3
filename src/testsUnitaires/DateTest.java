package testsUnitaires;

import org.junit.Test;
import tp.Date;
import tp.Jour;
import tp.Mois;
import tp.An;


import java.lang.reflect.Method;
import static org.junit.Assert.*;

/**
 *  Nom de la classe: DateTest
 *  Description: Tests unitaires de la classe Date
 */
public class DateTest
{
    /////////////////////////////
    //  Tests du constructeur  //
    /////////////////////////////

    //Test du constructeur valide
    @Test
    public void test_DateValide() throws Exception
    {
        Jour unJour = new Jour(5);
        Mois unMois = new Mois(6);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        assertEquals(uneDate.getJour(), unJour);
        assertEquals(uneDate.getMois(), unMois);
        assertEquals(uneDate.getAn(), unAn);
    }

    //Test du constructeur invalide (un mois ne contenant pas 31 jours)
    @Test
    public void test_DateInvalideMois31Jours() throws Exception
    {
        Jour unJour = new Jour(31);
        Mois unMois = new Mois(2);
        An unAn = new An(2007);

        try
        {
            Date uneDate = new Date(unJour, unMois, unAn);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Le mois de février ne contient pas 31 jours");
        }
    }

    //Test du constructeur invalide (le mois de février ne contient jamais 30 jours)
    @Test
    public void test_DateInvalide30JoursFevrier() throws Exception
    {
        Jour unJour = new Jour(30);
        Mois unMois = new Mois(2);
        An unAn = new An(2007);

        try
        {
            Date uneDate = new Date(unJour, unMois, unAn);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Le mois de février ne contient pas 30 jours");
        }
    }

    //Test du constructeur invalide (date de 29 février mais année non bissextile)
    @Test
    public void test_DateInvalideAnNonBissextile() throws Exception
    {
        Jour unJour = new Jour(29);
        Mois unMois = new Mois(2);
        An unAn = new An(2007);

        try
        {
            Date uneDate = new Date(unJour, unMois, unAn);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "La date du 29 février est impossible en 2007");
        }
    }


    ////////////////////////////////////////////
    //  Tests des fonctions getter et setter  //
    ////////////////////////////////////////////

    //Test de la fonction getter getJour
    @Test
    public void getJour() throws Exception
    {
        Jour unJour = new Jour(5);
        Mois unMois = new Mois(6);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        assertEquals(uneDate.getJour(), unJour);
    }

    //Test de la fonction getter getMois
    @Test
    public void getMois() throws Exception
    {
        Jour unJour = new Jour(5);
        Mois unMois = new Mois(6);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        assertEquals(uneDate.getMois(), unMois);
    }

    //Test de la fonction getter getAn
    @Test
    public void getAn() throws Exception
    {
        Jour unJour = new Jour(5);
        Mois unMois = new Mois(6);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        assertEquals(uneDate.getAn(), unAn);
    }

    //Test de la fonction setter setJour valide
    @Test
    public void setJourValide() throws Exception
    {
        Jour unJour = new Jour(5);
        Mois unMois = new Mois(6);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        Jour nouveauJour = new Jour(6);
        uneDate.setJour(nouveauJour);

        assertEquals(uneDate.getJour(), nouveauJour);
    }

    //Test de la fonction setter setJour invalide (un mois ne contenant pas 31 jours)
    @Test
    public void test_setJourInvalideMois31Jours() throws Exception
    {
        Jour unJour = new Jour(5);
        Mois unMois = new Mois(4);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        try
        {
            Jour nouveauJour = new Jour(31);
            uneDate.setJour(nouveauJour);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Le mois de cette date est avril, il ne contient pas 31 jours");
        }
    }

    //Test de la fonction setter setJour invalide (le mois de février ne contient jamais 30 jours)
    @Test
    public void test_setJourInvalide30JoursFevrier() throws Exception
    {
        Jour unJour = new Jour(5);
        Mois unMois = new Mois(2);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        try
        {
            Jour nouveauJour = new Jour(30);
            uneDate.setJour(nouveauJour);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Le mois de cette date est février, il ne contient pas 30 jours");
        }
    }

    //Test de la fonction setter setJour invalide (date de 29 février mais année non bissextile)
    @Test
    public void test_setJourInvalideAnNonBissextile() throws Exception
    {
        Jour unJour = new Jour(5);
        Mois unMois = new Mois(2);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        try
        {
            Jour nouveauJour = new Jour(29);
            uneDate.setJour(nouveauJour);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "L'année de cette date est 2007, elle ne contient donc pas 29 jours en février");
        }
    }

    //Test de la fonction setter setMois valide
    @Test
    public void setMoisValide() throws Exception
    {
        Jour unJour = new Jour(5);
        Mois unMois = new Mois(6);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        Mois nouveauMois = new Mois(7);
        uneDate.setMois(nouveauMois);

        assertEquals(uneDate.getMois(), nouveauMois);
    }

    //Test de la fonction setter setMois invalide (un mois ne contenant pas 31 jours)
    @Test
    public void test_setMoisInvalideMois31Jours() throws Exception
    {
        Jour unJour = new Jour(31);
        Mois unMois = new Mois(1);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        try
        {
            Mois nouveauMois = new Mois(4);
            uneDate.setMois(nouveauMois);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Le jour de cette date étant 31, on ne peut pas changer son mois pour le mois de avril");
        }
    }

    //Test de la fonction setter setMois invalide (le mois de février ne contient jamais 30 jours)
    @Test
    public void test_setMoisInvalide30JoursFevrier() throws Exception
    {
        Jour unJour = new Jour(30);
        Mois unMois = new Mois(3);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        try
        {
            Mois nouveauMois = new Mois(2);
            uneDate.setMois(nouveauMois);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Le jour de cette date étant 30, on ne peut pas changer son mois pour le mois de février");
        }
    }

    //Test de la fonction setter setMois invalide (date de 29 février mais année non bissextile)
    @Test
    public void test_setMoisInvalideAnNonBissextile() throws Exception
    {
        Jour unJour = new Jour(29);
        Mois unMois = new Mois(3);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        try
        {
            Mois nouveauMois = new Mois(2);
            uneDate.setMois(nouveauMois);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "L'Année de cette date étant 2007, il est impossible de lui donner les valeurs du 29 février car elle n'est pas bissextile");
        }
    }

    //Test de la fonction setter setAn valide
    @Test
    public void setAnValide() throws Exception
    {
        Jour unJour = new Jour(5);
        Mois unMois = new Mois(6);
        An unAn = new An(2007);
        Date uneDate = new Date(unJour, unMois, unAn);

        An nouvelAn = new An(2008);
        uneDate.setAn(nouvelAn);

        assertEquals(uneDate.getAn(), nouvelAn);
    }

    //Test de la fonction setter setAn invalide (date de 29 février mais année non bissextile)
    @Test
    public void test_setAnInvalideAnNonBissextile() throws Exception
    {
        Jour unJour = new Jour(29);
        Mois unMois = new Mois(2);
        An unAn = new An(2008);
        Date uneDate = new Date(unJour, unMois, unAn);

        try
        {
            An nouvelAn = new An(2007);
            uneDate.setAn(nouvelAn);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Le jour et mois de cette date étant le 29 février, il est impossible de lui donner l'an 2007 car il n'est pas bissextile");
        }
    }


    ///////////////////////////////////
    //  Tests des fonctions membres  //
    ///////////////////////////////////

    //Test de la fonction validation31Jours valide
    @Test
    public void test_validation31Jours() throws Exception
    {
        Jour unJour = new Jour(29);
        Mois unMois = new Mois(2);
        An unAn = new An(2008);
        Date uneDate = new Date(unJour, unMois, unAn);

        Class[] paramValidation = new Class[2];
        paramValidation[0] = Integer.TYPE;
        paramValidation[1] = Integer.TYPE;

        Method methodePrivee = Date.class.getDeclaredMethod("validation31Jours", paramValidation);
        methodePrivee.setAccessible(true);

        assertTrue((boolean)methodePrivee.invoke(uneDate, 5, 12));
    }

    //Test de la fonction validation31Jours invalide (le mois ne possède pas 31 jours)
    @Test
    public void test_validation31JoursInvalide() throws Exception
    {
        Jour unJour = new Jour(29);
        Mois unMois = new Mois(2);
        An unAn = new An(2008);
        Date uneDate = new Date(unJour, unMois, unAn);

        Class[] paramValidation = new Class[2];
        paramValidation[0] = Integer.TYPE;
        paramValidation[1] = Integer.TYPE;

        Method methodePrivee = Date.class.getDeclaredMethod("validation31Jours", paramValidation);
        methodePrivee.setAccessible(true);

        assertFalse((boolean)methodePrivee.invoke(uneDate, 31, 4));
    }

    //Test de la fonction validationAnBissextile valide
    @Test
    public void test_validationAnBissextile() throws Exception
    {
        Jour unJour = new Jour(29);
        Mois unMois = new Mois(2);
        An unAn = new An(2008);
        Date uneDate = new Date(unJour, unMois, unAn);

        Class[] paramValidation = new Class[1];
        paramValidation[0] = Integer.TYPE;

        Method methodePrivee = Date.class.getDeclaredMethod("validationAnBissextile", paramValidation);
        methodePrivee.setAccessible(true);

        assertTrue((boolean)methodePrivee.invoke(uneDate, 2008));
    }

    //Test de la fonction validationAnBissextile invalide (année non bissextile)
    @Test
    public void test_validationAnBissextileInvalide() throws Exception
    {
        Jour unJour = new Jour(29);
        Mois unMois = new Mois(2);
        An unAn = new An(2008);
        Date uneDate = new Date(unJour, unMois, unAn);

        Class[] paramValidation = new Class[1];
        paramValidation[0] = Integer.TYPE;

        Method methodePrivee = Date.class.getDeclaredMethod("validationAnBissextile", paramValidation);
        methodePrivee.setAccessible(true);

        assertFalse((boolean)methodePrivee.invoke(uneDate, 2007));
    }

    //Test de la fonction convertirNombreMois valide
    @Test
    public void test_convertirNombreMois() throws Exception
    {
        Jour unJour = new Jour(29);
        Mois unMois = new Mois(2);
        An unAn = new An(2008);
        Date uneDate = new Date(unJour, unMois, unAn);

        Class[] paramValidation = new Class[1];
        paramValidation[0] = Integer.TYPE;

        Method methodePrivee = Date.class.getDeclaredMethod("convertirNombreMois", paramValidation);
        methodePrivee.setAccessible(true);

        assertEquals(methodePrivee.invoke(uneDate, 4), "avril");
    }

    //Test de la fonction convertirNombreMois invalide (nombre supérieure à 12)
    @Test
    public void test_convertirNombreMoisInvalideValeurSup() throws Exception
    {
        Jour unJour = new Jour(29);
        Mois unMois = new Mois(2);
        An unAn = new An(2008);
        Date uneDate = new Date(unJour, unMois, unAn);

        Class[] paramValidation = new Class[1];
        paramValidation[0] = Integer.TYPE;

        Method methodePrivee = Date.class.getDeclaredMethod("convertirNombreMois", paramValidation);
        methodePrivee.setAccessible(true);

        assertEquals(methodePrivee.invoke(uneDate, 13), "NombreInvalide");
    }

    //Test de la fonction convertirNombreMois invalide (nombre inférieur à 1)
    @Test
    public void test_convertirNombreMoisInvalideValeurInf() throws Exception
    {
        Jour unJour = new Jour(29);
        Mois unMois = new Mois(2);
        An unAn = new An(2008);
        Date uneDate = new Date(unJour, unMois, unAn);

        Class[] paramValidation = new Class[1];
        paramValidation[0] = Integer.TYPE;

        Method methodePrivee = Date.class.getDeclaredMethod("convertirNombreMois", paramValidation);
        methodePrivee.setAccessible(true);

        assertEquals(methodePrivee.invoke(uneDate, 0), "NombreInvalide");
    }
}