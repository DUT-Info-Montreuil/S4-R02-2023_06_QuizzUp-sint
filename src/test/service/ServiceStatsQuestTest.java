package test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.NombreDeFoisJoueExceptions;
import Exceptions.NombreReponseExceptions;
import Exceptions.PasDeStatsExceptions;
import entities.bo.TopQuestionnaireBO;
import modeles.ServiceQuizzQuest;
import test.ressources.ServiceStatsQuestCorrecte;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Questionnaire_sme.entities.dto.QuestionDTO;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Questionnaire_sme.entities.dto.StatsQuestDTO;
import impl.ServiceStatsQuest;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Questionnaire_sme.entities.dto.QuestionnaireDTO;

public class ServiceStatsQuestTest {
    private ServiceQuizzQuest serviceSuperQuizzQuestionnaire;

    public ServiceStatsQuestTest() {
    }

    @BeforeEach
    public void init() {
        this.serviceSuperQuizzQuestionnaire= new ServiceStatsQuest();
    }

    @Test
    public void statsQuestCorrect() throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        ServiceStatsQuestCorrecte serviceCorrect = new ServiceStatsQuestCorrecte();
        QuestionDTO questionOcean = new QuestionDTO(1,"Quel est le plus grand océan du monde ?","Océan Pacifique","fr",1);
        QuestionDTO questionDesert = new QuestionDTO(2,"Quel est le plus grand désert du monde ?","Désert de l'Antarctique.","fr",1);
        QuestionDTO questionParis = new QuestionDTO(3,"Quelle est la capitale de la France ?","Paris","fr",2);
        List<StatsQuestDTO> statsQuestions = new ArrayList();
        statsQuestions.add(new StatsQuestDTO(7, 5, 1));
        statsQuestions.add(new StatsQuestDTO(1, 7, 2));
        statsQuestions.add(new StatsQuestDTO(3, 7, 3));
        TopQuestionnaireBO StatsCorrect = new TopQuestionnaireBO(1,9,questionDesert,questionOcean);
        List<QuestionDTO> listeQuestions = new ArrayList();
        listeQuestions.add(questionOcean);
        listeQuestions.add(questionDesert);
        listeQuestions.add(questionParis);
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO(1,listeQuestions);
        Assertions.assertEquals(StatsCorrect.toString(), serviceCorrect.bestOfQuestionnaire(questionnaireDTO).toString());

    }
}
