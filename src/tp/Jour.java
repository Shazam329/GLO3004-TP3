package tp;

/**
 *  Nom de la classe: Jour
 *  Description: Cette classe sera utilisée afin de créer une date
 *  Préconditions:
 *      - La valeur d'une journée doit être comprise entre 1 et 31 inclusivement
 */
public class Jour
{
    ///////////////////////
    // Variables membres //
    ///////////////////////

    //Valeur du jour
    private int m_nJour;


    ///////////////////
    // Constructeurs //
    ///////////////////

    //Constructeur avec toutes les variables membres en paramètre
    public Jour(int nJour)
    {
        //On affecte la valeur seulement si la précondition est respectée
        if(nJour < 1 || nJour > 31)
            throw new IllegalArgumentException("Jour non valide: " + nJour);
        else
            m_nJour = nJour;
    }


    ///////////////////////
    // Fonctions Getters //
    ///////////////////////

    //Getter pour la valeur de jour
    public int getJour()
    {
        return m_nJour;
    }


    ///////////////////////
    // Fonctions Setters //
    ///////////////////////

    //Setter pour la valeur de jour
    public void setJour(int nJour)
    {
        //On affecte la valeur seulement si la précondition est respectée
        if(nJour < 1 || nJour > 31)
            throw new IllegalArgumentException("Jour non valide: " + nJour);
        else
            m_nJour = nJour;
    }
}
