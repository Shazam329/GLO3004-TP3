package testsUnitaires;

import org.junit.Before;
import org.junit.Test;
import tp.*;

import static org.junit.Assert.*;
import static tp.Constantes.*;

/**
 *  Nom de la classe: BanqueTest
 *  Description: Tests unitaires de la classe Banque
 */
public class BanqueTest {

    private Date dateExFin;
    private Banque banque;
    private Banque banqueFermeture;
    private Banque banqueTransaction;

    @Before
    public void setUp() {
        dateExFin = new Date(new Jour(31), new Mois(12), new An(2016));
        banque = new Banque(dateExFin);
        banqueFermeture = new Banque(dateExFin);
        banqueTransaction = new Banque(dateExFin);

        Date o = new Date(new Jour(1), new Mois(4), new An(2016));
        NumCompte n1 = new NumCompte(10);
        NumCompte n2 = new NumCompte(20);

        banqueFermeture.ouvrirCompte(MIN_SOLDE,n1,o);
        banqueTransaction.ouvrirCompte(10000,n1,o);
        banqueTransaction.ouvrirCompte(10000,n2,o);
    }

    /////////////////////////////
    //  Tests du constructeur  //
    /////////////////////////////

    // Constructeur valide : les valeurs concordent avec les paramètres
    // Pas de préconditions à valider
    @Test
    public void test_BanqueConstructeur_Valide() {
        assertTrue(banque.getComptes().isEmpty());
        assertEquals(banque.getEntrees(), 0);
        assertEquals(banque.getSorties(), 0);
        assertEquals(banque.getSoldeG(), 0);
        assertEquals(banque.getSoldeV(), 0);
        assertEquals(banque.getGains(), 0);
        assertEquals(banque.getDateExFin(), dateExFin);
    }

    ////////////////////////////////////
    //  Tests des méthodes publiques  //
    ////////////////////////////////////

    // Ouvrir compte valide : les arguments respectent les préconditions
    @Test
    public void test_ouvrirCompte_valide() throws Exception {
        int soldeInit = 100000;
        NumCompte nc = new NumCompte(10);
        Date o = new Date(new Jour(20), new Mois(4), new An(2016));

        banque.ouvrirCompte(soldeInit, nc, o);
    }

    // Ouvrir compte invalide :
    // Le solde initial ne doit pas être inférieur au solde minimal
    @Test(expected = IllegalArgumentException.class)
    public void test_ouvrirCompte_soldeInit_invalide() {
        int soldeInit = MIN_SOLDE - 1;
        NumCompte nc = new NumCompte(10);
        Date o = new Date(new Jour(20), new Mois(4), new An(2016));

        banque.ouvrirCompte(soldeInit, nc, o);
    }

    // Ouvrir compte invalide :
    // Le numéro de compte ne doit pas être supérieur à la limite maximale
    @Test(expected = IllegalArgumentException.class)
    public void test_ouvrirCompte_maxComptes_invalide() {
        int soldeInit = 100000;
        NumCompte nc = new NumCompte(MAX_NUM + 1);
        Date o = new Date(new Jour(20), new Mois(4), new An(2016));

        banque.ouvrirCompte(soldeInit, nc, o);
    }

    // Ouvrir compte invalide :
    // Un compte avec ce numéro existe déjà
    @Test(expected = IllegalArgumentException.class)
    public void test_ouvrirCompte_numCompte_invalide() {
        int soldeInit = 100000;
        NumCompte nc = new NumCompte(10);
        Date o = new Date(new Jour(20), new Mois(4), new An(2016));

        banque.ouvrirCompte(soldeInit, nc, o);
        banque.ouvrirCompte(soldeInit, nc, o);
    }

    // ----------------------------------------------------------------------------


    // Fermer compte valide : les arguments respectent les préconditions
    @Test
    public void test_fermerCompte_valide() throws Exception {
        NumCompte nc = new NumCompte(10);
        Date f = new Date(new Jour(1), new Mois(5), new An(2016));

        banqueFermeture.fermerCompte(nc, f);
    }

    // Fermer compte invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_fermerCompte_numCompte_invalide() {
        NumCompte nc = new NumCompte(10000);
        Date f = new Date(new Jour(1), new Mois(5), new An(2016));

        banqueFermeture.fermerCompte(nc, f);
    }

    // Fermer compte invalide :
    // Pour une fermeture, le solde du compte doit être le solde minimum
    @Test(expected = IllegalArgumentException.class)
    public void test_fermerCompte_soldeMin_invalide() {
        NumCompte nc = new NumCompte(10);
        Date f = new Date(new Jour(1), new Mois(5), new An(2016));

        banqueFermeture.depotC(nc,1000);
        banqueFermeture.fermerCompte(nc, f);
    }

    // Fermer compte invalide :
    // Le compte est déjà fermé
    @Test(expected = IllegalArgumentException.class)
    public void test_fermerCompte_fermeture_invalide() {
        NumCompte nc = new NumCompte(10);
        Date f = new Date(new Jour(1), new Mois(5), new An(2016));

        banqueFermeture.fermerCompte(nc, f);
        banqueFermeture.fermerCompte(nc, f);
    }

    // Fermer compte invalide :
    // La date de fermeture ne doit pas être nulle
    @Test(expected = IllegalArgumentException.class)
    public void test_fermerCompte_date_invalide() {
        NumCompte nc = new NumCompte(10);

        banqueFermeture.fermerCompte(nc, null);
    }

    // ----------------------------------------------------------------------------


    // Supprimer compte valide : les arguments respectent les préconditions
    @Test
    public void test_supprimerCompte_valide() throws Exception {
        NumCompte nc = new NumCompte(10);
        Date f = new Date(new Jour(1), new Mois(5), new An(2016));
        Date d = new Date(new Jour(2), new Mois(5), new An(2018));

        banqueFermeture.fermerCompte(nc, f);
        banqueFermeture.supprimerCompte(nc, d);
    }

    // Supprimer compte invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_supprimerCompte_numCompte_invalide() {
        NumCompte nc = new NumCompte(1);
        Date f = new Date(new Jour(1), new Mois(5), new An(2016));
        Date d = new Date(new Jour(2), new Mois(5), new An(2018));

        banqueFermeture.fermerCompte(nc, f);
        banqueFermeture.supprimerCompte(nc, d);
    }

    // Supprimer compte invalide :
    // Pour une fermeture, le solde du compte doit être le solde minimum
    @Test(expected = IllegalArgumentException.class)
    public void test_supprimerCompte_soldeMin_invalide() {
        NumCompte nc = new NumCompte(10);
        Date f = new Date(new Jour(1), new Mois(5), new An(2016));
        Date d = new Date(new Jour(2), new Mois(5), new An(2018));

        banqueFermeture.depotC(nc, 100);
        banqueFermeture.fermerCompte(nc, f);
        banqueFermeture.supprimerCompte(nc, d);
    }

    // Supprimer compte invalide :
    // Le compte doit avoir une date de fermerture
    @Test(expected = IllegalArgumentException.class)
    public void test_supprimerCompte_dateFermeture_invalide() {
        NumCompte nc = new NumCompte(10);
        Date f = new Date(new Jour(1), new Mois(5), new An(2016));
        Date d = new Date(new Jour(2), new Mois(5), new An(2018));

        banqueFermeture.supprimerCompte(nc, d);
    }

    // Supprimer compte invalide :
    // La date en paramètre doit être supérieure d'au moins deux ans que la date de fermeture
    @Test(expected = IllegalArgumentException.class)
    public void test_supprimerCompte_date_invalide() {
        NumCompte nc = new NumCompte(10);
        Date f = new Date(new Jour(1), new Mois(5), new An(2016));
        Date d = new Date(new Jour(2), new Mois(5), new An(2017));

        banqueFermeture.fermerCompte(nc, f);
        banqueFermeture.supprimerCompte(nc, d);
    }

    // ----------------------------------------------------------------------------


    // Retrait valide : les arguments respectent les préconditions
    @Test
    public void test_retraitC_valide() throws Exception {
        NumCompte nc = new NumCompte(10);
        banqueTransaction.retraitC(nc, 100);
    }

    // Retrait invalide :
    // Le montant du retrait doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_retraitC_montant_invalide() {
        NumCompte nc = new NumCompte(10);
        banqueTransaction.retraitC(nc, 0);
    }

    // Retrait invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_retraitC_numCompte_invalide() {
        NumCompte nc = new NumCompte(1);
        banqueTransaction.retraitC(nc, 100);
    }

    // Retrait invalide :
    // Le compte ne doit pas avoir une date de fermerture
    @Test(expected = IllegalArgumentException.class)
    public void test_retraitC_dateFermeture_invalide() {
        NumCompte nc = new NumCompte(10);
        Date f = new Date(new Jour(1), new Mois(5), new An(2016));
        banqueTransaction.fermerCompte(nc, f);
        banqueTransaction.retraitC(nc, 100);
    }

    // Retrait invalide :
    // Le solde du compte moins le retrait doit être plus grand ou égal au solde minimum
    @Test(expected = IllegalArgumentException.class)
    public void test_retraitC_solde_invalide() {
        NumCompte nc = new NumCompte(10);
        banqueTransaction.retraitC(nc, 10000 + MIN_SOLDE);
    }

    // ----------------------------------------------------------------------------


    // Dépôt valide : les arguments respectent les préconditions
    @Test
    public void test_depotC_valide() throws Exception {
        NumCompte nc = new NumCompte(10);
        banqueTransaction.depotC(nc, 100);
    }

    // Dépôt invalide :
    // Le montant du dépôt doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_depotC_montant_invalide() {
        NumCompte nc = new NumCompte(10);
        banqueTransaction.depotC(nc, 0);
    }

    // Dépôt invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_depotC_numCompte_invalide() {
        NumCompte nc = new NumCompte(1);
        banqueTransaction.depotC(nc, 100);
    }

    // ----------------------------------------------------------------------------


    // Dépôt liquide valide : les arguments respectent les préconditions
    @Test
    public void test_depotLC_valide() throws Exception {
        NumCompte nc = new NumCompte(10);
        banqueTransaction.depotLC(nc, 100);
    }

    // Dépôt liquide invalide :
    // Le montant du dépôt doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_depotLC_montant_invalide() {
        NumCompte nc = new NumCompte(10);
        banqueTransaction.depotLC(nc, 0);
    }

    // Dépôt liquide invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_depotLC_numCompte_invalide() {
        NumCompte nc = new NumCompte(1);
        banqueTransaction.depotLC(nc, 100);
    }

    // Dépôt liquide invalide :
    // L'ajout du dépôt fait dépasser la limite maximal de dépôt liquide
    @Test(expected = IllegalArgumentException.class)
    public void test_depotLC_limite_invalide() {
        NumCompte nc = new NumCompte(10);
        banqueTransaction.depotLC(nc, 1 + MAX_DEPOT_LIQUIDE);
    }

    // ----------------------------------------------------------------------------


    // Virement valide : les arguments respectent les préconditions
    @Test
    public void test_virementC_valide() throws Exception {
        NumCompte source = new NumCompte(10);
        NumCompte destinataire = new NumCompte(20);
        banqueTransaction.virementC(source, destinataire, 20);
    }

    // Virement invalide :
    // Le montant du transfert doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_montant_invalide() {
        NumCompte source = new NumCompte(10);
        NumCompte destinataire = new NumCompte(20);
        banqueTransaction.virementC(source, destinataire, 0);
    }

    // Virement invalide :
    // Un compte source avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_numCompteSource_invalide() {
        NumCompte source = new NumCompte(1);
        NumCompte destinataire = new NumCompte(20);
        banqueTransaction.virementC(source, destinataire, 20);
    }

    // Virement invalide :
    // Un compte destinataire avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_numCompteDestinataire_invalide() {
        NumCompte source = new NumCompte(10);
        NumCompte destinataire = new NumCompte(2);
        banqueTransaction.virementC(source, destinataire, 20);
    }

    // Virement invalide :
    // Les numéros des comptes source et destinataire doivent être différents
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_numComptes_invalide() {
        NumCompte source = new NumCompte(10);
        NumCompte destinataire = new NumCompte(10);
        banqueTransaction.virementC(source, destinataire, 20);
    }

    // Virement invalide :
    // Le compte est déjà fermé
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_ferme_invalide() {
        NumCompte source = new NumCompte(10);
        NumCompte destinataire = new NumCompte(20);

        Date f = new Date(new Jour(1), new Mois(5), new An(2016));
        banqueTransaction.fermerCompte(source, f);

        banqueTransaction.virementC(source, destinataire, 20);
    }

    // Virement invalide :
    // Le solde du compte moins le transfert doit être plus grand ou égal au solde minimum
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_solde_invalide() {
        NumCompte source = new NumCompte(10);
        NumCompte destinataire = new NumCompte(20);

        int solde = banqueTransaction.getComptes().get(source.getNum()).getSolde();
        banqueTransaction.virementC(source, destinataire, solde + MIN_SOLDE);
    }

    // ----------------------------------------------------------------------------


    // Changer NIP valide : les arguments respectent les préconditions
    @Test
    public void test_ch_NIP_valide() throws Exception {
        NumCompte nc = new NumCompte(10);
        int nNIP = 12345;
        banqueTransaction.ch_NIP(nc, nNIP);
    }

    // Changer NIP invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_ch_NIP_numCompte_invalide() {
        NumCompte nc = new NumCompte(1);
        int nNIP = 12345;
        banqueTransaction.ch_NIP(nc, nNIP);
    }

    // Changer NIP invalide :
    // Le nouveau NIP doit être différent de l'ancien
    @Test(expected = IllegalArgumentException.class)
    public void test_ch_NIP_nouveauNIP_invalide() {
        NumCompte nc = new NumCompte(10);
        int nNIP = 12345;
        banqueTransaction.ch_NIP(nc, nNIP);
        banqueTransaction.ch_NIP(nc, nNIP);
    }

    // ----------------------------------------------------------------------------


    // Bilan de vérification valide : les arguments respectent les préconditions
    @Test
    public void test_bilanV_valide() throws Exception {
        Date d = new Date(new Jour(31), new Mois(12), new An(2016));
        banqueTransaction.bilanV(d);
    }

    // Bilan de vérification invalide :
    // Le jour en paramètre doit correspondre au jour de la date du bilan
    @Test(expected = IllegalArgumentException.class)
    public void test_bilanV_jour_invalide() {
        Date d = new Date(new Jour(1), new Mois(12), new An(2016));
        banqueTransaction.bilanV(d);
    }

    // Bilan de vérification invalide :
    // Le mois en paramètre doit correspondre au mois de la date du bilan
    @Test(expected = IllegalArgumentException.class)
    public void test_bilanV_mois_invalide() {
        Date d = new Date(new Jour(31), new Mois(5), new An(2016));
        banqueTransaction.bilanV(d);
    }

    // ----------------------------------------------------------------------------


    // Transaction sortante valide : les arguments respectent les préconditions
    @Test
    public void test_transactionSortante_valide() throws Exception {
        NumCompte source = new NumCompte(10);
        banqueTransaction.transactionSortante(source, 20);
    }

    // Transaction sortante invalide :
    // Le montant envoyé doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionSortante_montant_invalide() {
        NumCompte source = new NumCompte(10);
        banqueTransaction.transactionSortante(source, 0);
    }

    // Transaction sortante invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionSortante_numCompte_invalide() {
        NumCompte source = new NumCompte(1);
        banqueTransaction.transactionSortante(source, 20);
    }

    // Transaction sortante invalide :
    // Le compte est déjà fermé
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionSortante_ferme_invalide() {
        NumCompte source = new NumCompte(10);

        Date f = new Date(new Jour(1), new Mois(5), new An(2016));
        banqueTransaction.fermerCompte(source, f);

        banqueTransaction.transactionSortante(source, 20);
    }

    // Transaction sortante invalide :
    // Le solde du compte après transaction doit être plus grand ou égal au solde minimum
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionSortante_soldeMin_invalide() {
        NumCompte source = new NumCompte(10);

        int solde = banqueTransaction.getComptes().get(source.getNum()).getSolde();

        banqueTransaction.transactionSortante(source, solde);
    }

    // ----------------------------------------------------------------------------


    // Transaction entrante valide : les arguments respectent les préconditions
    @Test
    public void test_transactionEntrante_valide() throws Exception {
        NumCompte destinataire = new NumCompte(10);
        banqueTransaction.transactionEntrante(destinataire, 20);
    }

    // Transaction entrante invalide :
    // Le montant reçu moins les frais de transaction doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionEntrante_montant_invalide() {
        NumCompte destinataire = new NumCompte(10);
        banqueTransaction.transactionEntrante(destinataire, FRAIS_TRANSACTION_ENTRANTE);
    }

    // Transaction entrante invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionEntrante_numCompte_invalide() {
        NumCompte destinataire = new NumCompte(2);
        banqueTransaction.transactionEntrante(destinataire, 20);
    }

    // Transaction entrante invalide :
    // Le compte est déjà fermé
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionEntrante_ferme_invalide() {
        NumCompte destinataire = new NumCompte(10);

        Date f = new Date(new Jour(1), new Mois(5), new An(2016));
        banqueTransaction.fermerCompte(destinataire, f);

        banqueTransaction.transactionEntrante(destinataire, 20);
    }
}