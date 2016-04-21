package tp;
import static tp.Constantes.*;

/**
 *  Nom de la classe: NumCompte
 *  Description: Valide un numéro de compte compris dans la plage permise.
 *  Invariants:
 *      - numCompte est entre 1 et MAX_NUM, inclusivement
 */
public class NumCompte {
    // Variables membres
    private final int nc;
    // Constructeur
    public NumCompte(int nc){
        if (nc < 1 || nc > MAX_NUM)
            throw new IllegalArgumentException("Le numéro de compte doit être compris dans la plage permise.");
        this.nc = nc;
    }
    // Méthodes publiques
    public int getNum(){
        return nc;
    }
}
