package esport.sprint1.sprint1.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "organisateur", value = Organisateur.class),
        @JsonSubTypes.Type(name = "journaliste", value = Journaliste.class),
        @JsonSubTypes.Type(name = "joueur", value = Joueur.class)
})
public abstract class Utilisateur implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;

    private String nom;
    private String prenom;

    @Column(name = "VILLE_ID")
    private Long villeId;

    private String nomUtilisateur;
    private String email;
    private String adresse;
    private String pays;
    private int codePostale;
    private String apropos;
    private String citation;

    private int levele;
    private int points;

    private boolean newUser = true;
    private boolean active = false;
    private boolean confirm = false;

    private String photo;
    private String coverImg;

    private Date created_at = new Date();
    private Date updated_at;

    private String password;

    public Utilisateur() {
    }


    public Utilisateur(String nom, String prenom, Long villeId, String nomUtilisateur, String email, String adresse, String pays, int codePostale, String apropos, String citation, int levele, int points, boolean newUser, boolean active, boolean confirm, String photo, String coverImg, Date created_at, Date updated_at, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.villeId = villeId;
        this.nomUtilisateur = nomUtilisateur;
        this.email = email;
        this.adresse = adresse;
        this.pays = pays;
        this.codePostale = codePostale;
        this.apropos = apropos;
        this.citation = citation;
        this.levele = levele;
        this.points = points;
        this.newUser = newUser;
        this.active = active;
        this.confirm = confirm;
        this.photo = photo;
        this.coverImg = coverImg;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.password = password;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getVilleId() {
        return villeId;
    }

    public void setVilleId(Long villeId) {
        this.villeId = villeId;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getApropos() {
        return apropos;
    }

    public void setApropos(String apropos) {
        this.apropos = apropos;
    }

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }

    public int getLevele() {
        return levele;
    }

    public void setLevele(int levele) {
        this.levele = levele;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isNewUser() {
        return newUser;
    }

    public void setNewUser(boolean newUser) {
        this.newUser = newUser;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
