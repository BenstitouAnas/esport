package esport.sprint1.sprint1.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TournoisIndividuel")
public class TournoisIndividuel extends Tournois implements Serializable {

    private int nbJoueurs;
    private String test = "Tournois Individuel";

    public TournoisIndividuel() {
    }

    public TournoisIndividuel(int nbJoueurs, String test) {
        this.nbJoueurs = nbJoueurs;
        this.test = test;
    }

    public TournoisIndividuel(String titre, String description, boolean publie, double prix, String porte, Date dateDebut, Date dateFin, Local local, Organisateur organisateur, Console console, Jeu jeu, int nbJoueurs, String test) {
        super(titre, description, publie, prix, porte, dateDebut, dateFin, local, organisateur, console, jeu);
        this.nbJoueurs = nbJoueurs;
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }
}
