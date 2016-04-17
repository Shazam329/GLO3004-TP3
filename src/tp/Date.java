package tp;

/**
 *  Nom de la classe: Date
 *  Description: Représentation d'une date (jour, mois, année)
 *  Invariants:
 *      - Le jour ne peut pas être 31 lorsque le mois est février, avril, juin, septembre et novembre
 *      - Le 29 février n'est pas possible lorsque l'année n'est pas bissextile
 */
public class Date
{
    ///////////////////////
    // Variables membres //
    ///////////////////////

    //Jour de la date
    private Jour m_Jour;

    //Mois de la date
    private Mois m_Mois;

    //Année de la date (format YYYY)
    private An m_An;


    ///////////////////
    // Constructeurs //
    ///////////////////

    //Constructeur avec toutes les variables membres en paramètre
    public Date(Jour jour, Mois mois, An an)
    {
        //Validation qu'on peut mettre 31 comme valeur de jour en fonction du mois et validation qu'un 29 fév arrive durant une année bissextile
        int nJour = jour.getJour();
        int nMois = mois.getMois();
        int nAn = an.getAn();

        if((nJour == 31 && !validation31Jours(nJour, nMois)) || (nJour == 30 && nMois == 2))
            throw new IllegalArgumentException("Le mois de " + convertirNombreMois(nMois) + " ne contient pas " + nJour + " jours");
        else if(nJour == 29 && nMois == 2 && !validationAnBissextile(nAn))
            throw new IllegalArgumentException("La date du 29 février est impossible en " + nAn);
        else
        {
            m_Jour = jour;
            m_Mois = mois;
            m_An = an;
        }
    }


    ///////////////////////
    // Fonctions Getters //
    ///////////////////////

    //Getter pour le jour
    public Jour getJour()
    {
        return m_Jour;
    }

    //Getter pour le mois
    public Mois getMois()
    {
        return m_Mois;
    }

    //Getter pour l'année
    public An getAn()
    {
        return m_An;
    }


    ///////////////////////
    // Fonctions Setters //
    ///////////////////////

    //Setter pour le jour
    public void setJour(Jour jour)
    {
        int nJour = jour.getJour();
        int nMois = (this.getMois()).getMois();
        int nAn = (this.getAn()).getAn();

        if((nJour == 31 && !validation31Jours(nJour, nMois)) || (nJour == 30 && nMois == 2))
            throw new IllegalArgumentException("Le mois de cette date est " + convertirNombreMois(nMois) + ", il ne contient pas " + nJour  + " jours");
        else if(nJour == 29 && nMois == 2 && !validationAnBissextile(nAn))
            throw new IllegalArgumentException("L'année de cette date est " + nAn + ", elle ne contient donc pas 29 jours en février");
        else
        {
            m_Jour = jour;
        }
    }

    //Setter pour le mois
    public void setMois(Mois mois)
    {
        int nJour = (this.getJour()).getJour();
        int nMois = mois.getMois();
        int nAn = (this.getAn()).getAn();

        if((nJour == 31 && !validation31Jours(nJour, nMois)) || (nJour == 30 && nMois == 2))
            throw new IllegalArgumentException("Le jour de cette date étant " + nJour + ", on ne peut pas changer son mois pour le mois de " + convertirNombreMois(nMois));
        else if(nJour == 29 && nMois == 2 && !validationAnBissextile(nAn))
            throw new IllegalArgumentException("L'Année de cette date étant " + nAn + ", il est impossible de lui donner les valeurs du 29 février car elle n'est pas bissextile");
        else
        {
            m_Mois = mois;
        }
    }

    //Setter pour l'année
    public void setAn(An an)
    {
        int nJour = (this.getJour()).getJour();
        int nMois = (this.getMois()).getMois();
        int nAn = an.getAn();

        if(nJour == 29 && nMois == 2 && !validationAnBissextile(nAn))
            throw new IllegalArgumentException("Le jour et mois de cette date étant le 29 février, il est impossible de lui donner l'an " + nAn + " car il n'est pas bissextile");
        else
        {
            m_An = an;
        }
    }


    ///////////////////////
    // Fonctions membres //
    ///////////////////////

    //Permet de valider qu'on peut donner la valeur 31 au jour d'une date
    private boolean validation31Jours(int nJour, int nMois)
    {
        boolean bJourValide = true;

        if(nJour == 31 && (nMois == 2 || nMois == 4 || nMois == 6 || nMois == 9 || nMois == 11))
            bJourValide = false;

        return bJourValide;
    }

    //Permet de valider que l'année est bien bissextile et qu'on peut lui donner la date du 29 février
    private boolean validationAnBissextile(int nAn)
    {
        boolean bAnBissextile = false;

        if(nAn % 4 == 0 || nAn % 400 == 0)
            bAnBissextile = true;

        return bAnBissextile;
    }

    //Permet de convertir le nombre représentant un nombre pour son nom
    private String convertirNombreMois(int nMois)
    {
        String strNomMois = "";

        switch(nMois)
        {
            case 1:
                strNomMois = "janvier";
                break;
            case 2:
                strNomMois = "février";
                break;
            case 3:
                strNomMois = "mars";
                break;
            case 4:
                strNomMois = "avril";
                break;
            case 5:
                strNomMois = "mai";
                break;
            case 6:
                strNomMois = "juin";
                break;
            case 7:
                strNomMois = "juillet";
                break;
            case 8:
                strNomMois = "août";
                break;
            case 9:
                strNomMois = "septembre";
                break;
            case 10:
                strNomMois = "octobre";
                break;
            case 11:
                strNomMois = "novembre";
                break;
            case 12:
                strNomMois = "décembre";
                break;
            default:
                strNomMois = "NombreInvalide";
                break;
        }

        return strNomMois;
    }
}
