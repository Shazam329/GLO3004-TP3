package testsUnitaires;

import org.junit.Test;
import tp.*;

import static org.junit.Assert.*;
import static tp.Constantes.*;

/**
 *  Nom de la classe: BanqueTest
 *  Description: Tests unitaires de la classe Banque
 */
public class BanqueTest {

    private Date dateExFin = new Date(new Jour(31), new Mois(12), new An(2016));
    private Banque banque = new Banque(dateExFin);

    /////////////////////////////
    //  Tests du constructeur  //
    /////////////////////////////

    // Constructeur valide : les valeurs concordent avec les paramètres
    // Pas de préconditions à valider
    @Test
    public void test_BanqueConstructeur_Valide() {

        Banque b = new Banque(dateExFin);

        assertTrue(b.getComptes().isEmpty());
        assertEquals(b.getEntrees(), 0);
        assertEquals(b.getSorties(), 0);
        assertEquals(b.getSoldeG(), 0);
        assertEquals(b.getSoldeV(), 0);
        assertEquals(b.getGains(), 0);
        assertEquals(b.getDateExFin(), dateExFin);
    }

    ////////////////////////////////////
    //  Tests des méthodes publiques  //
    ////////////////////////////////////

    // Ouvrir compte valide : les arguments respectent les préconditions
    @Test
    public void test_ouvrirCompte_valide() {
        
    }

    // Ouvrir compte invalide :
    // Le solde initial ne doit pas être inférieur au solde minimal
    @Test(expected = IllegalArgumentException.class)
    public void test_ouvrirCompte_soldeInit_invalide() {

    }

    // Ouvrir compte invalide :
    // Le nombre de comptes ne doit pas être supérieur à la limite maximale
    @Test(expected = IllegalArgumentException.class)
    public void test_ouvrirCompte_maxComptes_invalide() {

    }

    // Ouvrir compte invalide :
    // Un compte avec ce numéro existe déjà
    @Test(expected = IllegalArgumentException.class)
    public void test_ouvrirCompte_numCompte_invalide() {

    }

    // ----------------------------------------------------------------------------


    // Fermer compte valide : les arguments respectent les préconditions
    @Test
    public void test_fermerCompte_valide() {

    }

    // Fermer compte invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_fermerCompte_numCompte_invalide() {

    }

    // Fermer compte invalide :
    // Pour une fermeture, le solde du compte doit être le solde minimum
    @Test(expected = IllegalArgumentException.class)
    public void test_fermerCompte_soldeMin_invalide() {

    }

    // Fermer compte invalide :
    // Le compte est déjà fermé
    @Test(expected = IllegalArgumentException.class)
    public void test_fermerCompte_fermeture_invalide() {

    }

    // Fermer compte invalide :
    // La date de fermeture ne doit pas être nulle
    @Test(expected = IllegalArgumentException.class)
    public void test_fermerCompte_date_invalide() {

    }

    // ----------------------------------------------------------------------------


    // Supprimer compte valide : les arguments respectent les préconditions
    @Test
    public void test_supprimerCompte_valide() {

    }

    // Supprimer compte invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_supprimerCompte_numCompte_invalide() {

    }

    // Supprimer compte invalide :
    // Pour une fermeture, le solde du compte doit être le solde minimum
    @Test(expected = IllegalArgumentException.class)
    public void test_supprimerCompte_soldeMin_invalide() {

    }

    // Supprimer compte invalide :
    // Le compte doit avoir une date de fermerture
    @Test(expected = IllegalArgumentException.class)
    public void test_supprimerCompte_dateFermeture_invalide() {

    }

    // Supprimer compte invalide :
    // La date en paramètre doit être supérieure d'au moins deux ans que la date de fermeture
    @Test(expected = IllegalArgumentException.class)
    public void test_supprimerCompte_date_invalide() {

    }

    // ----------------------------------------------------------------------------


    // Retrait valide : les arguments respectent les préconditions
    @Test
    public void test_retraitC_valide() {

    }

    // Retrait invalide :
    // Le montant du retrait doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_retraitC_montant_invalide() {

    }

    // Retrait invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_retraitC_numCompte_invalide() {

    }

    // Retrait invalide :
    // Le compte ne doit pas avoir une date de fermerture
    @Test(expected = IllegalArgumentException.class)
    public void test_retraitC_dateFermeture_invalide() {

    }

    // Retrait invalide :
    // Le solde du compte moins le retrait doit être plus grand ou égal au solde minimum
    @Test(expected = IllegalArgumentException.class)
    public void test_retraitC_solde_invalide() {

    }

    // Retrait invalide :
    // La vérification des montants doit balancer après un retrait
    @Test(expected = IllegalArgumentException.class)
    public void test_retraitC_balance_invalide() {

    }

    // ----------------------------------------------------------------------------


    // Dépôt valide : les arguments respectent les préconditions
    @Test
    public void test_depotC_valide() {

    }

    // Dépôt invalide :
    // Le montant du dépôt doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_depotC_montant_invalide() {

    }

    // Dépôt invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_depotC_numCompte_invalide() {

    }

    // Dépôt invalide :
    // La vérification des montants doit balancer après un dépôt
    @Test(expected = IllegalArgumentException.class)
    public void test_depotC_balance_invalide() {

    }

    // ----------------------------------------------------------------------------


    // Dépôt liquide valide : les arguments respectent les préconditions
    @Test
    public void test_depotLC_valide() {

    }

    // Dépôt liquide invalide :
    // Le montant du dépôt doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_depotLC_montant_invalide() {

    }

    // Dépôt liquide invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_depotLC_numCompte_invalide() {

    }

    // Dépôt liquide invalide :
    // L'ajout du dépôt fait dépasser la limite maximal de dépôt liquide
    @Test(expected = IllegalArgumentException.class)
    public void test_depotLC_limite_invalide() {

    }

    // Dépôt liquide invalide :
    // La vérification des montants doit balancer après un dépôt
    @Test(expected = IllegalArgumentException.class)
    public void test_depotLC_balance_invalide() {

    }

    // ----------------------------------------------------------------------------


    // Virement valide : les arguments respectent les préconditions
    @Test
    public void test_virementC_valide() {

    }

    // Virement invalide :
    // Le montant du transfert doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_montant_invalide() {

    }

    // Virement invalide :
    // Un compte source avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_numCompteSource_invalide() {

    }

    // Virement invalide :
    // Un compte destinataire avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_numCompteDestinataire_invalide() {

    }

    // Virement invalide :
    // Les numéros des comptes source et destinataire doivent être différents
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_numComptes_invalide() {

    }

    // Virement invalide :
    // Le compte est déjà fermé
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_ferme_invalide() {

    }

    // Virement invalide :
    // Le solde du compte moins le transfert doit être plus grand ou égal au solde minimum
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_solde_invalide() {

    }

    // Virement invalide :
    // La vérification des montants doit balancer après un transfert
    @Test(expected = IllegalArgumentException.class)
    public void test_virementC_balance_invalide() {

    }

    // ----------------------------------------------------------------------------


    // Changer NIP valide : les arguments respectent les préconditions
    @Test
    public void test_ch_NIP_valide() {

    }

    // Changer NIP invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_ch_NIP_numCompte_invalide() {

    }

    // Changer NIP invalide :
    // Le nouveau NIP doit être différent de l'ancien
    @Test(expected = IllegalArgumentException.class)
    public void test_ch_NIP_nouveauNIP_invalide() {

    }

    // ----------------------------------------------------------------------------


    // Bilan de vérification valide : les arguments respectent les préconditions
    @Test
    public void test_bilanV_valide() {

    }

    // Bilan de vérification invalide :
    // Le jour en paramètre doit correspondre au jour de la date du bilan
    @Test(expected = IllegalArgumentException.class)
    public void test_bilanV_jour_invalide() {

    }

    // Bilan de vérification invalide :
    // Le mois en paramètre doit correspondre au mois de la date du bilan
    @Test(expected = IllegalArgumentException.class)
    public void test_bilanV_mois_invalide() {

    }

    // Bilan de vérification invalide :
    // La vérification des montants doit balancer avant de faire le bilan
    @Test(expected = IllegalArgumentException.class)
    public void test_bilanV_balance_invalide() {

    }

    // ----------------------------------------------------------------------------

    // Transaction sortante valide : les arguments respectent les préconditions
    @Test
    public void test_transactionSortante_valide() {

    }

    // Transaction sortante invalide :
    // Le montant envoyé doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionSortante_montant_invalide() {

    }

    // Transaction sortante invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionSortante_numCompte_invalide() {

    }

    // Transaction sortante invalide :
    // Le compte est déjà fermé
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionSortante_ferme_invalide() {

    }

    // Transaction sortante invalide :
    // Le solde du compte après transaction doit être plus grand ou égal au solde minimum
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionSortante_soldeMin_invalide() {

    }

    // Transaction sortante invalide :
    // La vérification des montants doit balancer avant de faire le bilan
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionSortante_balance_invalide() {

    }

    // ----------------------------------------------------------------------------

    // Transaction entrante valide : les arguments respectent les préconditions
    @Test
    public void test_transactionEntrante_valide() {

    }

    // Transaction entrante invalide :
    // Le montant reçu moins les frais de transaction doit être plus grand que zéro
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionEntrante_montant_invalide() {

    }

    // Transaction entrante invalide :
    // Un compte avec ce numéro n'existe pas
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionEntrante_numCompte_invalide() {

    }

    // Transaction entrante invalide :
    // Le compte est déjà fermé
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionEntrante_ferme_invalide() {

    }

    // Transaction entrante invalide :
    // La vérification des montants doit balancer avant de faire le bilan
    @Test(expected = IllegalArgumentException.class)
    public void test_transactionEntrante_balance_invalide() {

    }
}