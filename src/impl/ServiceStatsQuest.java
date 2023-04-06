package impl;

import modeles.ServiceQuizzQuest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class ServiceStatsQuest implements ServiceQuizzQuest {

    @Override
    public StatsDTO recupererLesStats() {
        return null;
    }
    public StatsQuestDTO trouverQuestionLaPlusFacile(ArrayList<StatsQuestDTO> questions) {
        questions.sort(Comparator.comparing(StatsQuestDTO::getNbOk).reversed()
                .thenComparing(StatsQuestDTO::getDifficulte).reversed()
                .thenComparingInt(StatsQuestDTO::getNbjouer)
                .thenComparing(StatsQuestDTO::getNumero));
        return questions.get(0);
    }


    public StatsQuestDTO trouverQuestionLaPlusDure(ArrayList<StatsQuestDTO> questions) {
        questions.sort(Comparator.comparing(StatsQuestDTO::getNbOk)
                .thenComparing(StatsQuestDTO::getDifficulte)
                .thenComparingInt(StatsQuestDTO::getNbjouer)
                .thenComparing(StatsQuestDTO::getNumero));
        return questions.get(0);
    }

}
