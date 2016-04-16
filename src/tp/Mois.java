package tp;

/**
 *  Nom de la classe: Mois
 *  Description: Cette classe sera utilisée afin de créer une date
 *  Préconditions:
 *      - La valeur d'un mois doit être comprise entre 1 et 12 inclusivement
 */
public class Mois
{
    ///////////////////////
    // Variables membres //
    ///////////////////////

    //Valeur du mois
    int m_nMois;


    ///////////////////
    // Constructeurs //
    ///////////////////

    //Constructeur avec toutes les variables membres en paramètre
    public Mois(int nMois)
    {
        //On affecte la valeur seulement si la précondition est respectée
        if(nMois < 1 || nMois > 12)
            throw new IllegalArgumentException("Mois non valide: " + nMois);
        else
            m_nMois = nMois;
    }


    ///////////////////////
    // Fonctions Getters //
    ///////////////////////

    //Getter pour la valeur de mois
    public int getMois()
    {
        return m_nMois;
    }


    ///////////////////////
    // Fonctions Setters //
    ///////////////////////

    //Setter pour la valeur de mois
    public void setMois(int nMois)
    {
        //On affecte la valeur seulement si la précondition est respectée
        if(nMois < 1 || nMois > 12)
            throw new IllegalArgumentException("Mois non valide: " + nMois);
        else
            m_nMois = nMois;
    }
}
