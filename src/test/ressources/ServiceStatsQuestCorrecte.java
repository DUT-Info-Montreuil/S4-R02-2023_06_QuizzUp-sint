package test.ressources;

import java.util.ArrayList;
import java.util.List;

import Exceptions.NombreDeFoisJoueExceptions;
import Exceptions.NombreReponseExceptions;
import Exceptions.PasDeStatsExceptions;
import entities.bo.TopQuestionnaireBO;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Questionnaire_sme.entities.dto.QuestionDTO;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Questionnaire_sme.entities.dto.StatsQuestDTO;
import modeles.ServiceQuizzQuest;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Questionnaire_sme.entities.dto.QuestionnaireDTO;

public class ServiceStatsQuestCorrecte implements ServiceQuizzQuest {


    @Override
    public TopQuestionnaireBO recupererLesStats(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        QuestionDTO questionOcean = new QuestionDTO(1,"Quel est le plus grand océan du monde ?","Océan Pacifique","fr",1);
        QuestionDTO questionDesert = new QuestionDTO(2,"Quel est le plus grand désert du monde ?","Désert de l'Antarctique.","fr",1);
        QuestionDTO questionParis = new QuestionDTO(3,"Quelle est la capitale de la France ?","Paris","fr",2);
        List<StatsQuestDTO> statsQuestions = new ArrayList();
        statsQuestions.add(new StatsQuestDTO(7, 5, 1));
        statsQuestions.add(new StatsQuestDTO(1, 7, 2));
        statsQuestions.add(new StatsQuestDTO(3, 7, 3));
        return new TopQuestionnaireBO(1,9,questionDesert,questionOcean);
    }


}