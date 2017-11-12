package esport.sprint1.sprint1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "organisateur")
public class Organisateur extends Utilisateur implements Serializable{

    private String organisateur;

    @OneToMany(mappedBy = "organisateur")
    private List<Tournois> tournois;

    public Organisateur() {
    }

    public Organisateur(String nom, String prenom, Long aVille, String organisateur) {
        super(nom, prenom, aVille);
        this.organisateur = organisateur;
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
