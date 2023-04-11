package modeles;

import Exceptions.NombreDeFoisJoueExceptions;
import Exceptions.NombreReponseExceptions;
import Exceptions.PasDeStatsExceptions;
import entities.bo.TopQuestionnaireBO;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Questionnaire_sme.entities.dto.QuestionnaireDTO;

public interface ServiceQuizzQuest {

    public TopQuestionnaireBO recupererLesStats(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions;
}
