package fr.iut.montreuil.S4_R02_2023_06_QuizzUp_sint.entities.dto;

import java.util.ArrayList;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Joueur_sme.entities.dto.PartieDTO;

public class StatJoueurDTO {
     JoueurDTO joueur;

    public StatJoueurDTO(JoueurDTO joueur) {
        super();
        this.joueur = joueur;
    }


    public String fournirStratString() {
        int nbBonnesReponses = 0;
        int nbQuestionsRepondues = 0;
        ArrayList<PartieDTO> parties = joueur.getParties();
        int nbPartiesJouees = parties.size();

        for(PartieDTO partie : parties) {
            nbBonnesReponses += partie.getNbBonneReponse();
            nbQuestionsRepondues += partie.getNbQuestion();
        }

        int moyenne = (int) (nbBonnesReponses / nbQuestionsRepondues)*10;

        ArrayList<PartieDTO> dernieresParties = new ArrayList<PartieDTO>();
        if (nbPartiesJouees > 5) {
            for (int i = nbPartiesJouees - 5; i < nbPartiesJouees; i++) {
                dernieresParties.add(parties.get(i));
            }
        } else {
            dernieresParties = parties;
        }

        String stats = "Statistiques de "+joueur.getPrenom()+" :\n\n\t"
                +nbPartiesJouees+" parties jouées\n"
                +"\t"+nbBonnesReponses+" bonnes réponses sur "+nbQuestionsRepondues+"\n"
                +"\tMoyenne générale : "+moyenne+"/10 \n"
                +"\tDurée moyenne : inconnue"
                +"\n\n\t5 dernieres parties jouées : ";

        for (PartieDTO partie : dernieresParties) {
            stats += "\n\t\t" + partie.getNbBonneReponse() + "/" + partie.getNbQuestion() + " en TEMPS INCONNU";
        }

        return stats;

    }

}