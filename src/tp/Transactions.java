package tp;

import java.util.*;
import static tp.Constantes.*;

/**
 *  Nom de la classe: Transactions
 *  Description: Sert à gérer les transactions interbancaires en veillant à sauvegarder les montants
 *               d'argent qui circulent lors d'un virement d'un compte d'une banque à un autre compte
 *               d'une autre banque.
 *  Invariants:
 *      -
 */
public class Transactions {

    ///////////////////////
    // Variables membres //
    ///////////////////////
    private HashMap<NumBanque, Banque> banques;
    private int sortiesC;
    private int depotsC;
    private int frais;


    ///////////////////
    // Constructeur  //
    ///////////////////
    public Transactions(HashMap<NumBanque, Banque> b){

        // Préconditions
        if (b.size() < 2 || b.size() > MAX_BANQUE)
            throw new IllegalArgumentException("Le nombre de banques doit être compris entre 2 et MAX_BANQUE.");

        // Post-conditions
        this.banques = b;
        this.sortiesC = 0;
        this.depotsC = 0;
        this.frais = 0;

        // Vérifie les invariants
        verifieInvariants();
    }


    ////////////////
    // Invariants //
    ////////////////
    private void verifieInvariants(){
        if (banques.size() < 2 || banques.size() > MAX_BANQUE)
            throw new IllegalArgumentException("Le nombre de banques doit être compris entre 2 et MAX_BANQUE.");
        if (sortiesC != depotsC + frais)
            throw new IllegalStateException("Erreur dans la vérification des montants.");

        Set banquesSet = new HashSet<Banque>(banques.values());
        if (banques.values().size() != banquesSet.size())
            throw new IllegalStateException("Une banque ne peut être associée à deux numéros différents.");
    }


    ///////////////////////
    // Fonctions Getters //
    ///////////////////////
    public HashMap<NumBanque, Banque> getBanques(){
        return banques;
    }


    ////////////////////////
    // Méthodes publiques //
    ////////////////////////

    public void transactionInter(NumBanque b1, NumBanque b2, NumCompte nc1, NumCompte nc2, int montant){



    }

}
