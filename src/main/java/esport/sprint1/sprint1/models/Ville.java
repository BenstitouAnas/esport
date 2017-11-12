package esport.sprint1.sprint1.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Ville implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private String nom;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "VILLE_ID", referencedColumnName = "ID")
    private List<Utilisateur> utilisateurs;

    public Ville() {
    }

    public Ville(String nom) {
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

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
