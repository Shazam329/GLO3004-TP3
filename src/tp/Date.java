package tp;

/**
 * Created by Francis on 2016-04-15.
 */
public class Date
{
    ///////////////////////
    // Variables membres //
    ///////////////////////

    //Jour de la date
    int m_nJour;

    //Mois de la date
    int m_nMois;

    //Année de la date (format YYYY)
    int m_nAn;


    ///////////////////
    // Constructeurs //
    ///////////////////

    //Constructeur avec toutes les variables membres en paramètre
    public Date(int nJour, int nMois, int nAn)
    {
        m_nJour = nJour;
        m_nMois = nMois;
        m_nAn = nAn;
    }


    ///////////////////////
    // Fonctions Getters //
    ///////////////////////

    //Getter pour le jour
    public int getJour()
    {
        return m_nJour;
    }

    //Getter pour le mois
    public int getMois()
    {
        return m_nMois;
    }

    //Getter pour l'année
    public int getAn()
    {
        return m_nAn;
    }


    ///////////////////////
    // Fonctions Setters //
    ///////////////////////

    //Setter pour le jour
    public void setJour(int nJour)
    {
        m_nJour = nJour;
    }

    //Setter pour le mois
    public void setMois(int nMois)
    {
        m_nMois = nMois;
    }

    //Setter pour l'année
    public void setAn(int nAn)
    {
        m_nAn = nAn;
    }
}
