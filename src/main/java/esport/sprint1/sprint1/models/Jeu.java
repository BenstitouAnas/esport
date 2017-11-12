package esport.sprint1.sprint1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Jeu implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private String nom;
    private String afficheUrl;
    private boolean type;

    @ManyToMany
    @JoinTable(
            name = "jeu_console",
            joinColumns = @JoinColumn(name = "JEU_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CONSOLE_ID", referencedColumnName = "ID")
    )
    private List<Console> consoles;

    @OneToMany(mappedBy = "jeu")
    private List<Tournois> tournois;

    public Jeu() {
    }

    public Jeu(String nom, String afficheUrl, boolean type) {
        this.nom = nom;
        this.afficheUrl = afficheUrl;
        this.type = type;
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

    public String getAfficheUrl() {
        return afficheUrl;
    }

    public void setAfficheUrl(String afficheUrl) {
        this.afficheUrl = afficheUrl;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public List<Console> getConsoles() {
        return consoles;
    }

    public void setConsoles(List<Console> consoles) {
        this.consoles = consoles;
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
