package modeles;

import Exceptions.NombreDeFoisJoueExceptions;
import Exceptions.NombreReponseExceptions;
import Exceptions.PasDeStatsExceptions;
import entities.bo.TopQuestionnaireBO;

public interface ServiceQuizzQuest {

    public TopQuestionnaireBO recupererLesStats() throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions;
}
