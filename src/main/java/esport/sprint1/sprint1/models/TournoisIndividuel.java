package esport.sprint1.sprint1.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class TournoisIndividuel extends Tournois implements Serializable {

    private int nbJoueurs;
    @ManyToMany
    @JoinTable(
            name = "joueur_tournoi",
            joinColumns = @JoinColumn(name = "Tournoi_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "Joueur_ID", referencedColumnName = "ID")
    )
    private List<Joueur> joueurInscrit = new ArrayList<Joueur>();
    private String test = "Tournois Individuel";

    public TournoisIndividuel() {
    }

    public TournoisIndividuel(int nbJoueurs, String test) {
        this.nbJoueurs = nbJoueurs;
        this.test = test;
    }

    public TournoisIndividuel(String titre, String description, boolean publie, double prix, boolean porte, Date dateDebut, Date dateFin, Local local, Organisateur organisateur, Console console, Jeu jeu, boolean enHorsLigne, int nbJoueurs, String test) {
        super(titre, description, publie, prix, porte, dateDebut, dateFin, local, organisateur, console, jeu, enHorsLigne);
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

    public List<Joueur> getJoueurInscrit() {
        return joueurInscrit;
    }

    public void setJoueurInscrit(List<Joueur> joueurInscrit) {
        this.joueurInscrit = joueurInscrit;
    }
}
