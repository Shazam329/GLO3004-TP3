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
    public void ouvrirCompte(int soldeInit, int nc, Date o){
        // Préconditions
        if(soldeInit < MIN_SOLDE)
            throw new IllegalArgumentException("Le solde initial ne doit pas être inférieur au solde minimal.");
        if(comptes.size() >= MAX_NUM)
            throw new IllegalArgumentException("Le nombre de comptes ne doit pas être supérieur à la limite maximale.");
        if(comptes.containsKey(NumCompte.GetNumCompte(nc))){
            throw new IllegalArgumentException("Un compte avec ce numéro existe déjà!.");
        }

        // Post-conditions

        // Vérifie les invariants
        verifieInvariants();
    }

}