package fr.iut.montreuil.S4_R02_2023_06_QuizzUp_sint.impl;

import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_Joueur_sme.impl.ServiceJoueur;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_sint.entities.dto.StatJoueurDTO;
import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_sint.modeles.IServiceJoueurQuizz;

import java.util.ArrayList;

public class ServiceJoueurQuizzImpl implements IServiceJoueurQuizz {

    private ServiceJoueur service ;

    public ServiceJoueurQuizzImpl(ServiceJoueur service) {
        super();
        this.service = service;
    }

    public ArrayList<StatJoueurDTO> getStats() {
        ArrayList<StatJoueurDTO> stats = new ArrayList<StatJoueurDTO>();

        for(JoueurDTO joueur : service.listerJoueur()) {
            stats.add(new StatJoueurDTO(joueur));
        }
        return stats;
    }

}