package tp;


import com.sun.javaws.exceptions.InvalidArgumentException;
import static tp.Constantes.*;

/**
 *  Nom de la classe: Compte
 *  Description: Représente un compte et les opérations qu'on peut y effectuer
 *  Invariants:
 *      - Le montant total déposé en argent liquide ne doit pas dépasser le montant maximal permis.
 *      - Le solde d'un compte actif ne doit pas être inférieur au solde minimal.
 */
public class Compte {

    ///////////////////////
    // Variables membres //
    ///////////////////////
    private int solde;
    private int nip;
    private Date ouverture;
    private Date fermeture;
    private int montantDeposeLiquide;

    ///////////////////
    // Constructeur  //
    ///////////////////
    public Compte(int solde, int nip, Date ouverture, Date fermeture, int montantDeposeLiquide){
        // Préconditions
        if (montantDeposeLiquide > MAX_DEPOT_LIQUIDE)
            throw new IllegalArgumentException("Le montant total déposé en argent liquide ne doit pas dépasser le montant maximal permis.");
        if(solde < MIN_SOLDE)
            throw new IllegalArgumentException("Le solde d'un compte actif ne doit pas être inférieur au solde minimal.");
        if(ouverture == null)
            throw new IllegalArgumentException("La date d'ouverture ne doit pas être nulle.");
        if(fermeture != null)
            throw new IllegalArgumentException("La date de fermeture doit être nulle.");

        // Post-conditions
        this.solde = solde;
        this.nip = nip;
        this.ouverture = ouverture;
        this.fermeture = null;
        this.montantDeposeLiquide = montantDeposeLiquide;

        // Vérifie les invariants
        verifieInvariants();
    }

    ///////////////////////
    // Invariants        //
    ///////////////////////
    private void verifieInvariants(){
        if (montantDeposeLiquide > MAX_DEPOT_LIQUIDE)
            throw new IllegalStateException("Le montant total déposé en argent liquide ne doit pas dépasser le montant maximal permis.");
        if (fermeture != null && solde < MIN_SOLDE)
            throw new IllegalStateException("Le solde d'un compte actif ne doit pas être inférieur au solde minimal.");
    }

    ///////////////////////
    // Fonctions Getters //
    ///////////////////////
    public int getSolde(){
        return solde;
    }
    public int getNip(){
        return nip;
    }
    public Date getDateOuverture(){
        return ouverture;
    }
    public Date getDateFermeture(){
        return fermeture;
    }
    public int getMontantDeposeLiquide(){
        return montantDeposeLiquide;
    }

    ///////////////////////
    // Fonctions Setters //
    ///////////////////////
    public void setDateFermeture(Date fermeture){
        this.fermeture = fermeture;

        // Vérifie les invariants
        verifieInvariants();
    }

    ////////////////////////
    // Méthodes publiques //
    ////////////////////////

    // Utilisé pour retirer un montant d'argent (non liquide) du compte
    public void retrait(int montantRetrait){
        // Préconditions
        if (fermeture != null)
            throw new IllegalArgumentException("Un compte doit être actif pour effectuer un retrait.");
        if(montantRetrait <= 0)
            throw new IllegalArgumentException("Le montant du retrait doit être supérieur à zéro.");
        if (solde - montantRetrait < MIN_SOLDE)
            throw new IllegalArgumentException("Le solde ne doit pas être inférieur au solde minimum après le retrait.");

        // Post-conditions
        solde -= montantRetrait;

        // Vérifie les invariants
        verifieInvariants();
    }

    //Utilisé pour déposer un montant d'argent (non liquide) dans le compte
    public void depot(int montantDepot){
        // Préconditions
        if (fermeture != null)
            throw new IllegalArgumentException("Un compte doit être actif pour effectuer un dépot.");
        if(montantDepot <= 0)
            throw new IllegalArgumentException("Le montant du dépot doit être supérieur à zéro.");

        // Post-conditions
        solde += montantDepot;

        // Vérifie les invariants
        verifieInvariants();
    }

    //Utilisé pour déposer un montant d'argent liquide dans le compte
    public void depotLiquide(int montantDepot){
        // Préconditions
        if (fermeture != null)
            throw new IllegalArgumentException("Un compte doit être actif pour effectuer un dépot.");
        if(montantDepot <= 0)
            throw new IllegalArgumentException("Le montant du dépot doit être supérieur à zéro.");
        if(solde + montantDepot > MAX_DEPOT_LIQUIDE)
            throw new IllegalArgumentException("Le montant total déposé en argent liquide ne doit pas dépasser le montant maximal permis.");

        // Post-conditions
        solde += montantDepot;
        montantDeposeLiquide += montantDepot;

        // Vérifie les invariants
        verifieInvariants();
    }

    //Utilisé pour remettre à 0 la valeur de montantDeposeLiquide au début de chaque
    //exercice financier par la Banque
    public void remiseZeroMontantDeposeLiquide(){
        // Post-conditions
        montantDeposeLiquide = 0;

        // Vérifie les invariants
        verifieInvariants();
    }

    //Pour permettre de modifier le NIP du compte
    public void modifierNIP(int nNIP){
        // Préconditions
        if(nip == nNIP)
            throw new IllegalArgumentException("Le NIP doit être différent du NIP actuel.");

        // Post-conditions
        nip = nNIP;

        // Vérifie les invariants
        verifieInvariants();
    }
}
