package tp;
import static tp.Constantes.*;

/**
 *  Nom de la classe: NumCompte
 *  Description: Représente un numéro de compte compris dans la plage permise.
 *  Invariants:
 *      - numCompte est entre 1 et MAX_NUM, inclusivement
 */
public final class NumCompte {
    // Méthodes publiques
    public static int GetNumCompte(int nc){
        if (nc < 1 || nc > MAX_NUM){
            throw new IllegalArgumentException("Le numéro de compte doit être compris dans la plage permise.");
        }else{
            return nc;
        }
    }
}
