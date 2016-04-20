package tp;
import static tp.Constantes.*;

/**
 *  Nom de la classe: NumBanque
 *  Description: Représente un numéro de banque compris dans la plage permise.
 *  Invariants:
 *      - numCompte est entre 1 et MAX_BANQUE, inclusivement
 */
public final class NumBanque {
    // Méthodes publiques
    public static int GetNumBanque(int nb){
        if (nb < 1 || nb > MAX_BANQUE){
            throw new IllegalArgumentException("Le numéro de compte doit être compris dans la plage permise.");
        }else{
            return nb;
        }
    }
}
