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
    //Tests du constructeur
    @Test
    public void test_AnValide() throws Exception
    {
        An unAn = new An(2005);
        assertEquals(unAn.getAn(), 2005);
    }

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

    //Tests de la fonction getter
    @Test
    public void test_getAn() throws Exception
    {
        An unAn = new An(2005);
        assertEquals(unAn.getAn(), 2005);
    }

    //Tests de la fonction setter
    @Test
    public void test_setAnValide() throws Exception
    {
        An unAn = new An(2005);
        unAn.setAn(2006);
        assertEquals(unAn.getAn(), 2006);
    }

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
