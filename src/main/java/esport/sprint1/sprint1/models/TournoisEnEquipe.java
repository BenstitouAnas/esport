package esport.sprint1.sprint1.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class TournoisEnEquipe extends Tournois implements Serializable {

    private int nbEquipes;
    private String test = "Tournois En Equipe";

    public TournoisEnEquipe() {
    }

    public TournoisEnEquipe(int nbEquipes, String test) {
        this.nbEquipes = nbEquipes;
        this.test = test;
    }

    public TournoisEnEquipe(String titre, String description, boolean publie, double prix, boolean porte, Date dateDebut, Date dateFin, Local local, Organisateur organisateur, Console console, Jeu jeu, int nbEquipes, String test) {
        super(titre, description, publie, prix, porte, dateDebut, dateFin, local, organisateur, console, jeu);
        this.nbEquipes = nbEquipes;
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getNbEquipes() {
        return nbEquipes;
    }

    public void setNbEquipes(int nbEquipes) {
        this.nbEquipes = nbEquipes;
    }
}
