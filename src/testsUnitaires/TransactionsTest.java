package testsUnitaires;

import org.junit.Before;
import org.junit.Test;
import tp.*;
import static tp.Constantes.*;
import java.util.HashMap;



/**
 *  Nom de la classe: TransactionTest
 *  Description: Tests unitaires de la classe TransactionTest
 */
public class TransactionsTest {

    /////////////////////////////
    //  Tests du constructeur  //
    /////////////////////////////
    private Date dateOuv = new Date(new Jour(1), new Mois(4), new An(2016));
    private Date dateExFin = new Date(new Jour(31), new Mois(12), new An(2016));
    private Banque b1 = new Banque(dateExFin);
    private Banque b2 = new Banque(dateExFin);
    private HashMap<NumBanque, Banque> banques = new HashMap<>();
    private Transactions t;


    @Before
    public void setUp() {
        b1.ouvrirCompte(MIN_SOLDE, new NumCompte(1), dateOuv);
        b1.ouvrirCompte(MIN_SOLDE + 10, new NumCompte(2), dateOuv);
        b1.ouvrirCompte(MIN_SOLDE + 100, new NumCompte(3), dateOuv);
        b1.ouvrirCompte(MIN_SOLDE + 1000, new NumCompte(4), dateOuv);
        b1.ouvrirCompte(MIN_SOLDE + 1000, new NumCompte(5), dateOuv);

        b2.ouvrirCompte(MIN_SOLDE, new NumCompte(10), dateOuv);
        b2.ouvrirCompte(MIN_SOLDE + 10, new NumCompte(20), dateOuv);
        b2.ouvrirCompte(MIN_SOLDE + 100, new NumCompte(30), dateOuv);
        b2.ouvrirCompte(MIN_SOLDE + 1000, new NumCompte(40), dateOuv);
        b2.ouvrirCompte(MIN_SOLDE + 1000, new NumCompte(50), dateOuv);

        banques.put(new NumBanque(1), b1);
        banques.put(new NumBanque(2), b2);
    }

    // Constructeur valide : les arguments respectent les préconditions
    @Test
    public void test_TransactionsConstructeur_valide() {
        this.t = new Transactions(banques);

    }

    // Constructeur invalide : Le nombre de banques doit être compris entre 2 et MAX_BANQUE
    @Test(expected = IllegalArgumentException.class)
    public void test_TransactionsConstructeur_Banques_Taille() {

    }

    // Constructeur invalide : Une banque ne peut être associée à deux numéros différents
    @Test(expected = IllegalArgumentException.class)
    public void test_TransactionsConstructeur_Banques_Valeurs_Multiples() {

    }


    ////////////////////////////////////
    //  Tests des méthodes publiques  //
    ////////////////////////////////////

    // Transaction interbancaire valide : les arguments respectent les préconditions
    @Test
    public void test_transactionInter_valide() {

    }

    // Transaction interbancaire invalide :
    // Le montant de la transaction doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionInter_montant_invalide() {

    }

    // Transaction interbancaire invalide :
    // Le montant moins les frais de transaction doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionInter_frais_invalide() {

    }

    // Transaction interbancaire invalide :
    // Les numéros des deux banques doivent être différents
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionInter_numBanque_invalide() {

    }

    // Transaction interbancaire invalide :
    // La banque 1 n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionInter_banque1_invalide() {

    }

    // Transaction interbancaire invalide :
    // La banque 2 n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionInter_banque2_invalide() {

    }

    // Transaction interbancaire invalide :
    // Le compte 1 n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionInter_numCompte1_invalide() {

    }

    // Transaction interbancaire invalide :
    // Le compte 2 n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionInter_numCompte2_invalide() {

    }

    // Transaction interbancaire invalide :
    // Le compte 1 est déjà fermé
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionInter_compte1_ferme_invalide() {

    }

    // Transaction interbancaire invalide :
    // Le compte 2 est déjà fermé
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionInter_compte2_ferme_invalide() {

    }

    // Transaction interbancaire invalide :
    // Le solde du compte après transaction doit être plus grand ou égal au solde minimum
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionInter_solde_invalide() {

    }
}