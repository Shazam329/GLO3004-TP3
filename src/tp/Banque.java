package tp;

import java.util.HashMap;
import static tp.Constantes.*;

/**
 *  Nom de la classe: Banque
 *  Description: Représente une banque, les comptes qui lui sont associés, et les opérations qu'on peut y effectuer
 *  Invariants:
 *      La somme globale des soldes des comptes doit être égale à la somme des soldes en début d'exercice + les entrées - les sorties
 */
public class Banque {

    ///////////////////////
    // Variables membres //
    ///////////////////////
    private HashMap<Integer, Compte> comptes;
    private int entrees;
    private int sorties;
    private int soldeG;
    private int soldeV;
    private int gains;
    private Date dateExFin;

    ///////////////////
    // Constructeur  //
    ///////////////////
    public Banque(Date dateExFin){

        // Post-conditions
        this.comptes = new HashMap<>();
        this.entrees = 0;
        this.sorties = 0;
        this.soldeG = 0;
        this.soldeV = 0;
        this.gains = 0;
        this.dateExFin = dateExFin;

        // Vérifie les invariants
        verifieInvariants();
    }

    ////////////////
    // Invariants //
    ////////////////
    private void verifieInvariants(){
        if (soldeG != soldeV + entrees - sorties)
            throw new IllegalStateException("Erreur dans la vérification des montants.");
    }


    ///////////////////////
    // Fonctions Getters //
    ///////////////////////
    public HashMap<Integer, Compte> getComptes(){
        return comptes;
    }


    ////////////////////////
    // Méthodes publiques //
    ////////////////////////

    // Méthode permettant d'ouvrir un compte
    public void ouvrirCompte(int soldeInit, NumCompte nc, Date o){

        // Préconditions
        if (soldeInit < MIN_SOLDE)
            throw new IllegalArgumentException("Le solde initial ne doit pas être inférieur au solde minimal.");
        if (comptes.size() >= MAX_NUM)
            throw new IllegalArgumentException("Le nombre de comptes ne doit pas être supérieur à la limite maximale.");
        if (comptes.containsKey(nc.getNum())){
            throw new IllegalArgumentException("Un compte avec ce numéro existe déjà.");
        }

        // Post-conditions
        entrees += soldeInit;
        soldeG += soldeInit;
        comptes.put(nc.getNum(), new Compte(soldeInit, 0, o, null, 0));

        // Vérifie les invariants
        verifieInvariants();
    }

    // Méthode permettant de fermer un compte
    public void fermerCompte(NumCompte nc, Date f){

        // Préconditions
        if (!comptes.containsKey(nc.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if (comptes.get(nc.getNum()).getSolde() != MIN_SOLDE)
            throw new IllegalArgumentException("Pour une fermeture, le solde du compte doit être le solde minimum.");
        if (comptes.get(nc.getNum()).getDateFermeture() != null)
            throw new IllegalArgumentException("Le compte est déjà fermé.");
        if (f == null)
            throw new IllegalArgumentException("La date de fermeture ne doit pas être nulle.");

        // Post-conditions
        comptes.get(nc.getNum()).setDateFermeture(f);

        // Vérifie les invariants
        verifieInvariants();
    }

    // Méthode permettant de supprimer un compte
    public void supprimerCompte(NumCompte nc, Date d){

        // Préconditions
        if (!comptes.containsKey(nc.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if (comptes.get(nc.getNum()).getSolde() != MIN_SOLDE)
            throw new IllegalArgumentException("Pour une fermeture, le solde du compte doit être le solde minimum.");
        if (comptes.get(nc.getNum()).getDateFermeture() == null)
            throw new IllegalArgumentException("Le compte doit avoir une date de fermerture.");
        // Précondition sur la date d'ouverture
        Date f = comptes.get(nc.getNum()).getDateOuverture();
        if (!(d.getAn().getAn() > f.getAn().getAn() + 2)
                || !(d.getAn().getAn() == f.getAn().getAn() + 2 && d.getMois().getMois() > f.getMois().getMois())
                || !(d.getAn().getAn() == f.getAn().getAn() + 2 && d.getMois().getMois() == f.getMois().getMois() && d.getJour().getJour() > f.getJour().getJour())){
            throw new IllegalArgumentException("La date de fermeture ne doit pas être nulle.");
        }

        // Post-conditions
        comptes.remove(nc.getNum());

        // Vérifie les invariants
        verifieInvariants();
    }

    // Méthode permettant de faire un retrait dans un compte de la Banque
    public void retraitC(NumCompte nc, int montantRetrait){

        // Préconditions
        if (montantRetrait <= 0)
            throw new IllegalArgumentException("Le montant du retrait doit être plus grand que zéro.");
        if (!comptes.containsKey(nc.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if (comptes.get(nc.getNum()).getDateFermeture() != null)
            throw new IllegalArgumentException("Le compte ne doit pas avoir une date de fermerture.");
        if (comptes.get(nc.getNum()).getSolde() - montantRetrait < MIN_SOLDE)
            throw new IllegalArgumentException("Le solde du compte moins le retrait doit être plus grand ou égal au solde minimum.");
        if (soldeG - montantRetrait != soldeV + entrees - sorties + montantRetrait)
            throw new IllegalArgumentException("La vérification des montants doit balancer après un retrait.");

        // Post-conditions
        comptes.get(nc.getNum()).retrait(montantRetrait);
        sorties += montantRetrait;
        soldeG -= montantRetrait;

        // Vérifie les invariants
        verifieInvariants();
    }

    // Méthode permettant de faire un dépôt (non liquide) dans un compte de la Banque
    public void depotC(NumCompte nc, int montantDepot){

        // Préconditions
        if (montantDepot <= 0)
            throw new IllegalArgumentException("Le montant du dépôt doit être plus grand que zéro.");
        if (!comptes.containsKey(nc.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if (soldeG + montantDepot != soldeV + entrees + montantDepot - sorties)
            throw new IllegalArgumentException("La vérification des montants doit balancer après un dépôt.");

        // Post-conditions
        comptes.get(nc.getNum()).depot(montantDepot);
        entrees += montantDepot;
        soldeG += montantDepot;

        // Vérifie les invariants
        verifieInvariants();
    }

    // Méthode permettant de faire un dépôt (liquide) dans un compte de la Banque
    public void depotLC(NumCompte nc, int montantDepot){

        // Préconditions
        if (montantDepot <= 0)
            throw new IllegalArgumentException("Le montant du dépôt doit être plus grand que zéro.");
        if (!comptes.containsKey(nc.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if (soldeG + montantDepot != soldeV + entrees + montantDepot - sorties)
            throw new IllegalArgumentException("La vérification des montants doit balancer après un dépôt.");
        if (comptes.get(nc.getNum()).getMontantDeposeLiquide() + montantDepot > MAX_DEPOT_LIQUIDE)
            throw new IllegalArgumentException("L'ajout du dépôt fait dépasser la limite maximal de dépôt liquide.");

        // Post-conditions
        comptes.get(nc.getNum()).depotLiquide(montantDepot);
        entrees += montantDepot;
        soldeG += montantDepot;

        // Vérifie les invariants
        verifieInvariants();
    }

    // permettant de faire un virement d'argent entre deux comptes de la même Banque
    public void virementC(NumCompte source, NumCompte destinataire, int montantTransfert){

        // Préconditions
        if (montantTransfert <= 0)
            throw new IllegalArgumentException("Le montant du transfert doit être plus grand que zéro.");
        if (!comptes.containsKey(source.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if (!comptes.containsKey(destinataire.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if (source.getNum() == destinataire.getNum())
            throw new IllegalArgumentException("Les numéros des comptes source et destinataire doivent être différents.");
        if (comptes.get(source.getNum()).getDateFermeture() != null)
            throw new IllegalArgumentException("Le compte est déjà fermé.");
        if (comptes.get(source.getNum()).getSolde() - montantTransfert < MIN_SOLDE)
            throw new IllegalArgumentException("Le solde du compte moins le transfert doit être plus grand ou égal au solde minimum.");
        if (soldeG + montantTransfert - montantTransfert != soldeV + (entrees + montantTransfert) - (sorties + montantTransfert))
            throw new IllegalArgumentException("La vérification des montants doit balancer après un transfert.");

        // Post-conditions
        entrees += montantTransfert;
        sorties += montantTransfert;
        comptes.get(source.getNum()).retrait(montantTransfert);
        comptes.get(destinataire.getNum()).depot(montantTransfert);

        // Vérifie les invariants
        verifieInvariants();
    }

    // Méthode permettant de modifier le NIP associé à un compte
    public void ch_NIP(NumCompte nc, int nNIP){

        // Préconditions
        if (!comptes.containsKey(nc.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if (nNIP == comptes.get(nc.getNum()).getNip())
            throw new IllegalArgumentException("Le nouveau NIP doit être différent de l'ancien.");

        // Post-conditions
        comptes.get(nc.getNum()).modifierNIP(nNIP);

        // Vérifie les invariants
        verifieInvariants();
    }

    // Méthode permettant de faire le bilan de vérification à la fin de l'exercice financier
    public void bilanV(Date d){

        // Préconditions
        if (d.getJour().getJour() != dateExFin.getJour().getJour())
            throw new IllegalArgumentException("Le jour doit correspondre au jour de la date du bilan.");
        if (d.getMois().getMois() != dateExFin.getMois().getMois())
            throw new IllegalArgumentException("Le mois doit correspondre au mois de la date du bilan.");
        if (soldeG != soldeV + entrees - sorties)
            throw new IllegalArgumentException("La vérification des montants doit balancer avant de faire le bilan.");

        // Post-conditions
        soldeV = 0;
        for (Compte c : comptes.values()) {
            soldeV += c.getSolde();
            c.remiseZeroMontantDeposeLiquide();
        }
        soldeG = soldeV;
        entrees = 0;
        sorties = 0;

        // Vérifie les invariants
        verifieInvariants();
    }

    // Méthode permettant d'effectuer le résultat d'une transaction bancaire vers un compte à l'extérieur de la banque
    public void transactionSortante(NumCompte source, int montantEnvoye){

        // Préconditions
        if (montantEnvoye <= 0)
            throw new IllegalArgumentException("Le montant envoyé doit être plus grand que zéro.");
        if (!comptes.containsKey(source.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if (comptes.get(source.getNum()).getDateFermeture() != null)
            throw new IllegalArgumentException("Le compte est déjà fermé.");
        if (comptes.get(source.getNum()).getSolde() - montantEnvoye - FRAIS_TRANSACTION_SORTANTE < MIN_SOLDE)
            throw new IllegalArgumentException("Le solde du compte après transaction doit être plus grand ou égal au solde minimum.");
        if (soldeG - montantEnvoye - FRAIS_TRANSACTION_SORTANTE != soldeV + entrees - (sorties + montantEnvoye + FRAIS_TRANSACTION_SORTANTE))
            throw new IllegalArgumentException("La vérification des montants doit balancer avant de faire le bilan.");

        // Post-conditions
        comptes.get(source.getNum()).retrait(montantEnvoye + FRAIS_TRANSACTION_SORTANTE);
        soldeG -= montantEnvoye;
        sorties += montantEnvoye;
        gains += FRAIS_TRANSACTION_SORTANTE;

        // Vérifie les invariants
        verifieInvariants();
    }

    // Méthode permettant d'effectuer le résultat d'une transaction bancaire en provenance d'un compte à l'extérieur de la banque
    public void transactionEntrante(NumCompte destinataire, int montantRecu){

        // Préconditions
        if (montantRecu - FRAIS_TRANSACTION_ENTRANTE <= 0)
            throw new IllegalArgumentException("Le montant reçu moins les frais de transaction doit être plus grand que zéro.");
        if (!comptes.containsKey(destinataire.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if (comptes.get(destinataire.getNum()).getDateFermeture() != null)
            throw new IllegalArgumentException("Le compte est déjà fermé.");
        if (soldeG + montantRecu - FRAIS_TRANSACTION_ENTRANTE != soldeV + (entrees + montantRecu) - (sorties + FRAIS_TRANSACTION_ENTRANTE))
            throw new IllegalArgumentException("La vérification des montants doit balancer avant de faire le bilan.");

        // Post-conditions
        comptes.get(destinataire.getNum()).depot(montantRecu - FRAIS_TRANSACTION_ENTRANTE);
        soldeG += montantRecu;
        entrees += montantRecu;
        gains += FRAIS_TRANSACTION_ENTRANTE;

        // Vérifie les invariants
        verifieInvariants();
    }
}