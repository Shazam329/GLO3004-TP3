package tp;

import java.util.*;
import static tp.Constantes.*;

/**
 *  Nom de la classe: Transactions
 *  Description: Sert à gérer les transactions interbancaires en veillant à sauvegarder les montants
 *               d'argent qui circulent lors d'un virement d'un compte d'une banque à un autre compte
 *               d'une autre banque.
 *  Invariants:
 *      - Le nombre de banques doit être compris entre 2 et le nombre maximum de banques
 *      - Une banque ne peut-être associée à deux numéros différents
 *      - Le solde global des montants qui sortent des banques doit être le même que celui reçu par ces banques
 *        plus les frais.
 */
public class Transactions {

    ///////////////////////
    // Variables membres //
    ///////////////////////
    private HashMap<Integer, Banque> banques = new HashMap<>();
    private int sortiesC;
    private int depotsC;
    private int frais;


    ///////////////////
    // Constructeur  //
    ///////////////////
    public Transactions(HashMap<Integer, Banque> b){

        // Préconditions
        if (b.size() < 2 || b.size() > MAX_BANQUE)
            throw new IllegalArgumentException("Le nombre de banques doit être compris entre 2 et MAX_BANQUE.");

        Set banquesSet = new HashSet<Banque>(banques.values());
        if (banques.values().size() != banquesSet.size())
            throw new IllegalStateException("Une banque ne peut être associée à deux numéros différents.");

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

        Set banquesSet = new HashSet<>(banques.values());
        if (banques.values().size() != banquesSet.size())
            throw new IllegalStateException("Une banque ne peut être associée à deux numéros différents.");
    }


    ///////////////////////
    // Fonctions Getters //
    ///////////////////////
    public HashMap<Integer, Banque> getBanques(){
        return banques;
    }


    ////////////////////////
    // Méthodes publiques //
    ////////////////////////

    // Méthode permettant d'effectuer un virement entre deux comptes de deux banques
    public void transactionInter(NumBanque b1, NumBanque b2, NumCompte nc1, NumCompte nc2, int montant){

        // Préconditions
        if (montant <= 0)
            throw new IllegalArgumentException("Le montant de la transaction doit être plus grand que zéro.");
        if (montant - FRAIS_TRANSACTION_ENTRANTE <= 0)
            throw new IllegalArgumentException("Le montant moins les frais de transaction doit être plus grand que zéro.");
        if (b1.getNum() == b2.getNum())
            throw new IllegalArgumentException("Les numéros des deux banques doivent être différents.");
        if (!banques.containsKey(b1.getNum()))
            throw new IllegalArgumentException("Cette banque n'existe pas.");
        if (!banques.containsKey(b2.getNum()))
            throw new IllegalArgumentException("Cette banque n'existe pas.");
        if (!banques.get(b1.getNum()).getComptes().containsKey(nc1.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if (!banques.get(b2.getNum()).getComptes().containsKey(nc2.getNum()))
            throw new IllegalArgumentException("Un compte avec ce numéro n'existe pas.");
        if (banques.get(b1.getNum()).getComptes().get(nc1.getNum()).getDateFermeture() != null)
            throw new IllegalArgumentException("Le compte est déjà fermé.");
        if (banques.get(b2.getNum()).getComptes().get(nc2.getNum()).getDateFermeture() != null)
            throw new IllegalArgumentException("Le compte est déjà fermé.");
        if (banques.get(b1.getNum()).getComptes().get(nc1.getNum()).getSolde() - montant - FRAIS_TRANSACTION_SORTANTE < MIN_SOLDE)
            throw new IllegalArgumentException("Le solde du compte après transaction doit être plus grand ou égal au solde minimum.");


        // Post-conditions
        banques.get(b1.getNum()).transactionSortante(nc1, montant);
        banques.get(b2.getNum()).transactionEntrante(nc2, montant);

        sortiesC += (montant + FRAIS_TRANSACTION_SORTANTE);
        depotsC += (montant - FRAIS_TRANSACTION_ENTRANTE);
        frais += (FRAIS_TRANSACTION_SORTANTE + FRAIS_TRANSACTION_ENTRANTE);


        // Vérifie les invariants
        verifieInvariants();
    }

}