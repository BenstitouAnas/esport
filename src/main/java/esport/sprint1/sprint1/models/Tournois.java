package esport.sprint1.sprint1.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tournois implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;

    private String titre;
    private String description;
    private boolean publie;
    private double prix;
    private String porte;
    private Date dateDebut;
    private Date dateFin;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LOCAL_ID")
    private Local local;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANISATEUR_ID")
    private Organisateur organisateur;

    @ManyToOne
    @JoinColumn(name = "CONSOLE_ID", referencedColumnName = "ID")
    private Console console;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JEU_ID")
    private Jeu jeu;

    public Tournois() {
    }

    public Tournois(String titre, String description, boolean publie, double prix, String porte, Date dateDebut, Date dateFin, Local local, Organisateur organisateur, Console console, Jeu jeu) {
        this.titre = titre;
        this.description = description;
        this.publie = publie;
        this.prix = prix;
        this.porte = porte;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.local = local;
        this.organisateur = organisateur;
        this.console = console;
        this.jeu = jeu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublie() {
        return publie;
    }

    public void setPublie(boolean publie) {
        this.publie = publie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public Organisateur getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(Organisateur organisateur) {
        this.organisateur = organisateur;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
