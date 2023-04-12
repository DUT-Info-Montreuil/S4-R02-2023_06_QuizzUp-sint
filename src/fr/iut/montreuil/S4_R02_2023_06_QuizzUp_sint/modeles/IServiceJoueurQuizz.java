package fr.iut.montreuil.S4_R02_2023_06_QuizzUp_sint.modeles;

import fr.iut.montreuil.S4_R02_2023_06_QuizzUp_sint.entities.dto.StatJoueurDTO;

import java.util.ArrayList;

public interface IServiceJoueurQuizz {

    public ArrayList<StatJoueurDTO> getStats();

}