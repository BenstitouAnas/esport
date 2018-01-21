package esport.sprint1.sprint1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Joueur")
public class Joueur extends Utilisateur implements Serializable {
    @ManyToMany(mappedBy = "joueurInscrit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TournoisIndividuel> tournois;
    public Joueur() {
    }

    public Joueur(String nom, String prenom, Long villeId, String nomUtilisateur, String email, String adresse, String pays, int codePostale, String apropos, String citation, int levele, int points, boolean newUser, boolean active, boolean confirm, String photo, String coverImg, Date created_at, Date updated_at, String password, List<TournoisIndividuel> tournois) {
        super(nom, prenom, villeId, nomUtilisateur, email, adresse, pays, codePostale, apropos, citation, levele, points, newUser, active, confirm, photo, coverImg, created_at, updated_at, password);
        this.tournois = tournois;
    }

    @JsonIgnore
    public List<TournoisIndividuel> getTournois() {
        return tournois;
    }

    @JsonSetter
    public void setTournois(List<TournoisIndividuel> tournois) {
        this.tournois = tournois;
    }
}
