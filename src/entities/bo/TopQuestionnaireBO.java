package entities.bo;

import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Questionnaire_sme.entities.dto.QuestionDTO;

public class TopQuestionnaireBO {
    private int idQuestionnaire;
    private int nbDeFoisJoueQuestionnaire;
    private QuestionDTO questionPireReussite;
    private QuestionDTO questionMeilleurReussite;

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public int getNbDeFoisJoueQuestionnaire() {
        return nbDeFoisJoueQuestionnaire;
    }

    public void setNbDeFoisJoueQuestionnaire(int nbDeFoisJoueQuestionnaire) {
        this.nbDeFoisJoueQuestionnaire = nbDeFoisJoueQuestionnaire;
    }

    public QuestionDTO getQuestionPireReussite() {
        return questionPireReussite;
    }

    public void setQuestionPireReussite(QuestionDTO questionPireReussite) {
        this.questionPireReussite = questionPireReussite;
    }

    public QuestionDTO getQuestionMeilleurReussite() {
        return questionMeilleurReussite;
    }

    public void setQuestionMeilleurReussite(QuestionDTO questionMeilleurReussite) {
        this.questionMeilleurReussite = questionMeilleurReussite;
    }
}
