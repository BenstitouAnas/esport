package esport.sprint1.sprint1.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
/*
    @ManyToOne
    private Utilisateur emmeteur;

    @ManyToOne
    private Utilisateur recepteur;

    private Date dateMessage;
    private boolean vu;

    public Message() {
    }

    public Message(String message, Utilisateur emmeteur, Utilisateur recepteur, Date dateMessage, boolean vu) {
        this.message = message;
        this.emmeteur = emmeteur;
        this.recepteur = recepteur;
        this.dateMessage = dateMessage;
        this.vu = vu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Utilisateur getEmmeteur() {
        return emmeteur;
    }

    public void setEmmeteur(Utilisateur emmeteur) {
        this.emmeteur = emmeteur;
    }

    public Utilisateur getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Utilisateur recepteur) {
        this.recepteur = recepteur;
    }

    public Date getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }

    public boolean isVu() {
        return vu;
    }

    public void setVu(boolean vu) {
        this.vu = vu;
    }*/
}
