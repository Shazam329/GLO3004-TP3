package tp;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import tp.Constantes.*;

import static tp.Constantes.MAX_DEPOT_LIQUIDE;
import static tp.Constantes.MIN_SOLDE;


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
    // Constructeurs //
    ///////////////////
    public Compte(@NotNull int solde, @NotNull int nip, @NotNull Date ouverture, @Nullable Date fermeture, @NotNull int montantDeposeLiquide){
        // Préconditions
        if (montantDeposeLiquide > MAX_DEPOT_LIQUIDE)
            throw new IllegalArgumentException("Le montant total déposé en argent liquide ne doit pas dépasser le montant maximal permis.");
        if(solde < MIN_SOLDE)
            throw new IllegalArgumentException("Le solde d'un compte actif ne doit pas être inférieur au solde minimal.");
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

    private void verifieInvariants(){
        if (montantDeposeLiquide > MAX_DEPOT_LIQUIDE)
            throw new IllegalStateException("Le montant total déposé en argent liquide ne doit pas dépasser le montant maximal permis.");
        if (fermeture != null && solde < MIN_SOLDE)
            throw new IllegalStateException("Le solde d'un compte actif ne doit pas être inférieur au solde minimal.");
    }

}
