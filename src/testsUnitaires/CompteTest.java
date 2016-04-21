package testsUnitaires;

import org.junit.Test;
import tp.*;

import static org.junit.Assert.*;
import static tp.Constantes.*;

/**
 *  Nom de la classe: CompteTest
 *  Description: Tests unitaires de la classe Compte
 */
public class CompteTest {

    /////////////////////////////
    //  Tests du constructeur  //
    /////////////////////////////

    private Date dateOuv = new Date(new Jour(1), new Mois(4), new An(2016));
    private Compte compteTest = new Compte(100, 12345, dateOuv, null, 0);

    // Constructeur valide: les valeurs concordent avec les paramètres
    @Test
    public void test_CompteConstructeur_Valide()
    {
        Compte compte = new Compte(100, 12345, dateOuv, null, 0);
        assertEquals(compte.getSolde(), 100);
        assertEquals(compte.getNip(), 12345);
        assertEquals(compte.getDateOuverture(), dateOuv);
        assertEquals(compte.getDateFermeture(), null);
        assertEquals(compte.getMontantDeposeLiquide(), 0);
    }

    // Constructeur invalide: solde sous le minimum
    @Test(expected = IllegalArgumentException.class)
    public void test_CompteConstructeur_SoldeMin() {
        Compte compte = new Compte(MIN_SOLDE - 1, 12345, dateOuv, null,0);
    }

    // Constructeur invalide: date ouverture nulle
    @Test(expected = IllegalArgumentException.class)
    public void test_CompteConstructeur_DateOuvertureNulle() {
        Compte compte = new Compte(100, 12345, null, null,0);
    }

    // Constructeur invalide: date fermeture non nulle
    @Test(expected = IllegalArgumentException.class)
    public void test_CompteConstructeur_DateFermetureNonNulle() {
        Compte compte = new Compte(100, 12345, null, dateOuv,0);
    }

    // Constructeur invalide: montant déposé liquide supérieur au maximum
    @Test(expected = IllegalArgumentException.class)
    public void test_CompteConstructeur_DepotLiquideMax() {
        Compte compte = new Compte(100, 12345, dateOuv, null, MAX_DEPOT_LIQUIDE + 1);
    }

    // Retrait valide: retrait au solde minimum permis
    @Test
    public void test_CompteRetrait_Valide() {
        compteTest.retrait(compteTest.getSolde() - MIN_SOLDE);
        assertEquals(compteTest.getSolde(), MIN_SOLDE);
    }

    // Retrait invalide: retrait jusqu'au solde minimum moins 1
    @Test(expected = IllegalArgumentException.class)
    public void test_CompteRetrait_Invalide() {
        compteTest.retrait(compteTest.getSolde() - MIN_SOLDE + 1);
    }

    // Depot valide: solde ajusté correctement
    @Test
    public void test_CompteDepot_Valide() {
        int solde = compteTest.getSolde();
        compteTest.depot(10);
        assertEquals(compteTest.getSolde(), solde + 10);
    }

    // Depot invalide: inférieur à 1
    @Test(expected = IllegalArgumentException.class)
    public void test_CompteDepot_Invalide() {
        compteTest.depot(0);
    }

    // DepotLiquide valide: solde ajusté au maximum permis
    @Test
    public void test_CompteDepotLiquide_Valide() {
        compteTest.depotLiquide(MAX_DEPOT_LIQUIDE - compteTest.getSolde());
        assertEquals(compteTest.getSolde(), MAX_DEPOT_LIQUIDE);
    }

    // DepotLiquide invalide: inférieur à 1
    @Test(expected = IllegalArgumentException.class)
    public void test_CompteDepotLiquide_NonPositif() {
        compteTest.depot(0);
    }

    // DepotLiquide invalide: supérieur aux montant maximal des dépots liquides
    @Test(expected = IllegalArgumentException.class)
    public void test_CompteDepotLiquide_MaxDepotLiquide() {
        compteTest.depotLiquide(MAX_DEPOT_LIQUIDE - compteTest.getSolde() + 1);
    }

    // RemiseZeroMontantDeposeLiquide valide: Montant remis à zéro.
    // Aucun cas invalide à tester
    @Test
    public void test_CompteRemiseZeroMontantDeposeLiquide_Valide() {
        compteTest.remiseZeroMontantDeposeLiquide();
        assertEquals(compteTest.getMontantDeposeLiquide(), 0);
    }

    // modifierNIP valide: nip modifié correctement
    @Test
    public void test_CompteModifierNIP_Valide() {
        int nip = compteTest.getNip();
        compteTest.modifierNIP(nip + 1);
        assertEquals(compteTest.getNip(), nip + 1);
    }

    // modifierNIP invalide: nip identique
    @Test(expected = IllegalArgumentException.class)
    public void test_CompteModifierNIP_Identique() {
        compteTest.modifierNIP(compteTest.getNip());
    }

    // setDateFermeture valide: compte fermé
    @Test
    public void test_CompteSetDateFermeture_Valide() {
        Date dateFerm = new Date(new Jour(1), new Mois(5), new An(2016));
        compteTest.setDateFermeture(dateFerm);
        assertEquals(compteTest.getDateFermeture(), dateFerm);

        try{
            compteTest.retrait(5);
        }catch(IllegalArgumentException e){
            // OK si retrait refusé
        }
        try{
            compteTest.depot(5);
        }catch(IllegalArgumentException e){
            // OK si retrait refusé
        }
        try{
            compteTest.depotLiquide(5);
        }catch(IllegalArgumentException e){
            // OK si retrait refusé
        }
    }
}