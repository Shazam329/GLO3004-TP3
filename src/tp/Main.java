
//*******************************************************************************
//* Authors:
//*	#1
//*	Nom			Barrigas-Bernard, Keven
//*	Matricule	111 080 771
//*	Programme	Informatique
//*	#2
//*	Nom			Collins, Francis
//*	Matricule	909 236 993
//*	Programme	Informatique
//*	#3
//*	Nom			L'Écuyer, Mathieu
//*	Matricule   111 078 093
//*	Programme	Informatique
//*******************************************************************************


package tp;

import com.sun.istack.internal.NotNull;

public class Main {

    public static void main(String[] args) {

        /*
            Voici le texte explicatif demandé. Il est également en pdf dans le document de remise

            Pour ce TP3, nous avons optés pour l’utilisation de tests unitaires avec JUnit afin de valider chacune des
            conditions, des cas valides et invalides. Deux packages sont présent dans le projet, un nommé « tp » qui
            contient toutes les implantations de classes et l’autre nommé « testsUnitaires » qui contient des fichiers
            de tests unitaires pour chacune des classe.

            Nous avons donc fais tous les tests de préconditions, invariants et post-conditions dans les classes et
            nous avons par la suite validé le tout. Nous avons donc un cas valide pour chacune des fonctions et des cas
            invalides pour tester, comme le qualificatif l’indique, les fois où l’on tente de faire une opération
            non-valide.

            Le résultat escompté est donc que tous les tests unitaires soient effectués avec succès. Pour les lancer,
            avec le logiciel IntelliJ IDEA, il suffit de sélectionner dans le coin supérieur droit « Tests in
            <testsUnitaires> » et ensuite de lancer le tout (Run). Si jamais vous n’avez pas accès au workspace comme
            nous l’avons créé, pas de problème, je vous explique comment faire. Suivez ces étapes :

                1-	Barre de menus -> Run -> Edit Configurations.
                2-	On clique sur l’icône du + vert.
                3-	On sélectionne JUnit
                4-	On peut facultativement nommé cette configuration avec le nom de son choix
                5-	Pour le champ Test Kind, il faut sélectionner « All in package »
                6-	Pour le champ Package, on vient choisir « testsUnitaires »
                7-	On fait OK
                8-	On est prêt à lancer les tests comme expliqué précédemment en sélectionnant le nom de configuration
                qu’on vient de lui donner dans l’encadré en haut à droite de l’interface.

            Rien n’est spécifié dans le main outre ce texte qui est en commentaire et en affichage à l’écran s’il a
            été lancé avant de lire ce texte.
         */

        System.out.println(""
            + "Si vous voyez ce texte c'est que vous avez lancé le main avant de lire notre texte\n"
            + "explicatif, c'est pourquoi nous avons jugé bon en mettre une copie ici. \n"
            + "Il est également en pdf dans le document de remise\n"

            + "Pour ce TP3, nous avons optés pour l’utilisation de tests unitaires avec JUnit afin de valider chacune des\n"
            + "conditions, des cas valides et invalides. Deux packages sont présent dans le projet, un nommé « tp » qui\n"
            + "contient toutes les implantations de classes et l’autre nommé « testsUnitaires » qui contient des fichiers\n"
            + "de tests unitaires pour chacune des classe.\n"

            + "Nous avons donc fais tous les tests de préconditions, invariants et post-conditions dans les classes et\n"
            + "nous avons par la suite validé le tout. Nous avons donc un cas valide pour chacune des fonctions et des cas\n"
            + "invalides pour tester, comme le qualificatif l’indique, les fois où l’on tente de faire une opération\n"
            + "non-valide.\n"

            + "Le résultat escompté est donc que tous les tests unitaires soient effectués avec succès. Pour les lancer,\n"
            + "avec le logiciel IntelliJ IDEA, il suffit de sélectionner dans le coin supérieur droit « Tests in\n"
            + "<testsUnitaires> » et ensuite de lancer le tout (Run). Si jamais vous n’avez pas accès au workspace comme\n"
            + "nous l’avons créé, pas de problème, je vous explique comment faire. Suivez ces étapes :\n"

            + "1- Barre de menus -> Run -> Edit Configurations.\n"
            + "2- On clique sur l’icône du + vert.\n"
            + "3- On sélectionne JUnit\n"
            + "4- On peut facultativement nommé cette configuration avec le nom de son choix\n"
            + "5- Pour le champ Test Kind, il faut sélectionner « All in package »\n"
            + "6- Pour le champ Package, on vient choisir « testsUnitaires »\n"
            + "7- On fait OK\n"
            + "8- On est prêt à lancer les tests comme expliqué précédemment en sélectionnant le nom de configuration\n"
            + "qu’on vient de lui donner dans l’encadré en haut à droite de l’interface.\n"

            + "Rien n’est spécifié dans le main outre ce texte qui est en commentaire et en affichage à l’écran s’il a\n"
            + "été lancé avant de lire ce texte.\n");
    }
}
