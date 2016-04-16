package tp;

public class Main {

    public static void main(String[] args) {

        String newLine = System.getProperty("line.separator");

        //Tests pour la classe Jour
        //Cas valide
        System.out.println("Tests de la classe Jour" + newLine + newLine + "Cas valide");

        System.out.println("Construction d'un Jour avec la valeur 12");
        Jour unJour = new Jour(12);
        System.out.println("Jour: " + unJour.getJour());

        System.out.println("Changeons la valeur pour 18");
        unJour.setJour(18);
        System.out.println("Jour: " + unJour.getJour());

        //Cas invalide
        System.out.println(newLine + "Cas invalide");

        System.out.println("Construction d'un Jour avec la valeur 35");
        try
        {
            Jour unJourInvalide = new Jour(35);
        } catch (IllegalArgumentException e)
        {
            System.err.println("Exception argument illegal: " + e.getMessage());
        }

        /*System.out.println("Jour: " + unJourInvalide.getJour());

        System.out.println("Changeons la valeur pour 34");
        unJourInvalide.setJour(34);
        System.out.println("Jour: " + unJourInvalide.getJour());*/


        //Tests pour la classe Date
        Date testDate = new Date(12, 12, 1212);

        System.out.println("Jour: " + testDate.getJour() + " Mois: " + testDate.getMois() + " Année: " + testDate.getAn());

        testDate.setJour(11);
        testDate.setMois(11);
        testDate.setAn(1111);

        System.out.println("Jour: " + testDate.getJour() + " Mois: " + testDate.getMois() + " Année: " + testDate.getAn());
    }
}
