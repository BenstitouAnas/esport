package esport.sprint1.sprint1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Console implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "consoles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Jeu> jeux;

    @OneToMany(mappedBy = "console")
    @JsonIgnore
    private List<Tournois> tournois;

    public Console() {
    }

    public Console(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @JsonIgnore
    public List<Jeu> getJeux() {
        return jeux;
    }

    @JsonSetter
    public void setJeux(List<Jeu> jeux) {
        this.jeux = jeux;
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
