package esport.sprint1.sprint1.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TournoisEnEquipe")
public class TournoisEnEquipe extends Tournois implements Serializable {

    private String test = "Tournois En Equipe";

    public TournoisEnEquipe() {
    }

    public TournoisEnEquipe(String titre, String description, boolean publie, double prix, String porte, int nbJoueurs, int nbEquipes, Date dateDebut, Date dateFin, Local local, Utilisateur organisateur, Console console, Jeu jeu, String test) {
        super(titre, description, publie, prix, porte, nbJoueurs, nbEquipes, dateDebut, dateFin, local, organisateur, console, jeu);
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
