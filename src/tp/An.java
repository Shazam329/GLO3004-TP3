package tp;

/**
 *  Nom de la classe: An
 *  Description: Cette classe sera utilisée afin de créer une date
 *  Préconditions:
 *      - La valeur d'un an doit être comprise entre 1900 et 20000 inclusivement
 */
public class An
{
    ///////////////////////
    // Variables membres //
    ///////////////////////

    //Valeur du an
    private int m_nAn;


    ///////////////////
    // Constructeurs //
    ///////////////////

    //Constructeur avec toutes les variables membres en paramètre
    public An(int nAn)
    {
        //On affecte la valeur seulement si la précondition est respectée
        if(nAn < 1900 || nAn > 20000)
            throw new IllegalArgumentException("An non valide: " + nAn);
        else
            m_nAn = nAn;
    }


    ///////////////////////
    // Fonctions Getters //
    ///////////////////////

    //Getter pour la valeur de an
    public int getAn()
    {
        return m_nAn;
    }


    ///////////////////////
    // Fonctions Setters //
    ///////////////////////

    //Setter pour la valeur de an
    public void setAn(int nAn)
    {
        //On affecte la valeur seulement si la précondition est respectée
        if(nAn < 1900 || nAn > 20000)
            throw new IllegalArgumentException("An non valide: " + nAn);
        else
            m_nAn = nAn;
    }
}
