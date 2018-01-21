package esport.sprint1.sprint1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "organisateur")
public class Organisateur extends Utilisateur implements Serializable{

    private String organisateur;

    @OneToMany(mappedBy = "organisateur")
    private List<Tournois> tournois;

    public Organisateur() {
    }

    public Organisateur(String nom, String prenom, Long villeId, String nomUtilisateur, String email, String adresse, String pays, int codePostale, String apropos, String citation, int levele, int points, boolean newUser, boolean active, boolean confirm, String photo, String coverImg, Date created_at, Date updated_at, String password, String organisateur, List<Tournois> tournois) {
        super(nom, prenom, villeId, nomUtilisateur, email, adresse, pays, codePostale, apropos, citation, levele, points, newUser, active, confirm, photo, coverImg, created_at, updated_at, password);
        this.organisateur = organisateur;
        this.tournois = tournois;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    @JsonIgnore
    public List<Tournois> getTournois() {
        return tournois;
    }

    @JsonSetter
    public void setTournois(List<Tournois> tournois) {
        this.tournois = tournois;
    }
}
