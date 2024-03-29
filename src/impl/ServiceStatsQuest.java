package impl;

import Exceptions.NombreDeFoisJoueExceptions;
import Exceptions.NombreReponseExceptions;
import Exceptions.PasDeStatsExceptions;
import entities.bo.TopQuestionnaireBO;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Questionnaire_sme.entities.dto.QuestionDTO;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Questionnaire_sme.entities.dto.QuestionnaireDTO;
import modeles.ServiceQuizzQuest;

public class ServiceStatsQuest implements ServiceQuizzQuest {
    @Override
    public TopQuestionnaireBO recupererLesStats(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        TopQuestionnaireBO topQuestionnaire = new TopQuestionnaireBO();
        topQuestionnaire.setIdQuestionnaire(questionnaireDTO.getId_questionnaire());
        if (questionnaireDTO.getNbjouer() < 0)
            throw new NombreDeFoisJoueExceptions();
        topQuestionnaire.setNbDeFoisJoueQuestionnaire(questionnaireDTO.getNbjouer());

        QuestionDTO meilleurTaux;
        int i = 0;
        do {
            meilleurTaux = questionnaireDTO.getQuestions().get(i);
        } while (meilleurTaux.getStatsQuestionDTO().getNbjouer()<=0);

        for (QuestionDTO questionDTO : questionnaireDTO.getQuestions()) {
            if (questionDTO.getStatsQuestionDTO() == null)
                throw new PasDeStatsExceptions();
            if (questionDTO.getStatsQuestionDTO().getNbjouer() > topQuestionnaire.getNbDeFoisJoueQuestionnaire())
                throw new NombreDeFoisJoueExceptions();
            if (questionDTO.getStatsQuestionDTO().getNbOk() > questionDTO.getStatsQuestionDTO().getNbjouer())
                throw new NombreReponseExceptions();
            if (questionDTO.getStatsQuestionDTO().getNbjouer() > 0
                    && (float) questionDTO.getStatsQuestionDTO().getNbjouer()/questionDTO.getStatsQuestionDTO().getNbjouer() >
                    (float) meilleurTaux.getStatsQuestionDTO().getNbjouer()/meilleurTaux.getStatsQuestionDTO().getNbjouer())
                meilleurTaux = questionDTO;
        }
        QuestionDTO  pireTaux;
        pireTaux = questionnaireDTO.getQuestions().get(i);

        for (QuestionDTO questionDTO : questionnaireDTO.getQuestions()) {
            if (questionDTO.getStatsQuestionDTO().getNbjouer() > 0
                    && (float) questionDTO.getStatsQuestionDTO().getNbjouer()/questionDTO.getStatsQuestionDTO().getNbjouer() <
                    (float) pireTaux.getStatsQuestionDTO().getNbOk()/pireTaux.getStatsQuestionDTO().getNbjouer())
                pireTaux = questionDTO;
        }

        return topQuestionnaire;
    }
}

