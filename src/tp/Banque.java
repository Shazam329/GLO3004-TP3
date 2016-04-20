package tp;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.HashMap;

import static tp.Constantes.*;

/**
 *  Nom de la classe: Banque
 *  Description: Représente une banque, les comptes qui lui sont associés, et les opérations qu'on peut y effectuer
 *  Invariants:
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
        comptes = new HashMap<>();
        entrees = 0;
        sorties = 0;
        soldeG = 0;
        soldeV = 0;
        gains = 0;

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
    public void ouvrirCompte(int soldeInit, NumCompte nc, Date o){
        // Préconditions
        if(soldeInit < MIN_SOLDE)
            throw new IllegalArgumentException("Le solde initial ne doit pas être inférieur au solde minimal.");
        if(comptes.size() >= MAX_NUM)
            throw new IllegalArgumentException("Le nombre de comptes ne doit pas être supérieur à la limite maximale.");
        if(comptes.containsKey(nc.getNum())){
            throw new IllegalArgumentException("Un compte avec ce numéro existe déjà.");
        }

        // Post-conditions
        entrees += soldeInit;
        soldeG += soldeInit;
        comptes.put(nc.getNum(), new Compte(soldeInit, 0, o, null, 0));

        // Vérifie les invariants
        verifieInvariants();
    }

    public void fermerCompte(NumCompte nc, Date f){
        // Préconditions
        if(!comptes.containsKey(nc.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if(comptes.get(nc.getNum()).getSolde() != MIN_SOLDE)
            throw new IllegalArgumentException("Pour une fermeture, le solde du compte doit être le solde minimum.");
        if(comptes.get(nc.getNum()).getDateFermeture() != null)
            throw new IllegalArgumentException("Le compte est déjà fermé.");
        if (f == null)
            throw new IllegalArgumentException("La date de fermeture ne doit pas être nulle.");

        // Post-conditions
        comptes.get(nc.getNum()).setDateFermeture(f);

        // Vérifie les invariants
        verifieInvariants();
    }

    public void supprimerCompte(NumCompte nc, Date d){
        // Préconditions
        if(!comptes.containsKey(nc.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if(comptes.get(nc.getNum()).getSolde() != MIN_SOLDE)
            throw new IllegalArgumentException("Pour une fermeture, le solde du compte doit être le solde minimum.");
        if(comptes.get(nc.getNum()).getDateFermeture() == null)
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

    public void retraitC(NumCompte nc, int montantRetrait){
        // Préconditions

        // Post-conditions

        // Vérifie les invariants
    }

    public void depotC(NumCompte nc, int montantDepot){
        // Préconditions

        // Post-conditions

        // Vérifie les invariants
    }

    public void depotLC(NumCompte nc, int montantDepot){
        // Préconditions

        // Post-conditions

        // Vérifie les invariants
    }

    public void virementC(NumCompte source, NumCompte destinataire, int montantTransfert){
        // Préconditions

        // Post-conditions

        // Vérifie les invariants
    }

    public void ch_NIP(NumCompte nc, int nNIP){
        // Préconditions

        // Post-conditions

        // Vérifie les invariants
    }

    public void bilanV(Date d){
        // Préconditions

        // Post-conditions

        // Vérifie les invariants
    }

    public void transactionSortante(NumCompte source, int MontantEnvoye){
        // Préconditions

        // Post-conditions

        // Vérifie les invariants
    }

    public void transactionEntrante(NumCompte destinataire, int montantRecu){
        // Préconditions

        // Post-conditions

        // Vérifie les invariants
    }
}