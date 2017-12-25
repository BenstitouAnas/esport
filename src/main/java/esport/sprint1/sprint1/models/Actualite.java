package esport.sprint1.sprint1.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Actualite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String titre;
    private String contenu;
    private Date Date_Ecriture;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ecrivain_ID")
    private Journaliste m_Writer;

    public Actualite() {
    }

    public Actualite(String titre, String contenu, Date date_Ecriture, Journaliste m_Writer) {
        this.titre = titre;
        this.contenu = contenu;
        Date_Ecriture = date_Ecriture;
        this.m_Writer = m_Writer;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate_Ecriture() {
        return Date_Ecriture;
    }

    public void setDate_Ecriture(Date date_Ecriture) {
        Date_Ecriture = date_Ecriture;
    }

    public Journaliste getM_Writer() {
        return m_Writer;
    }

    public void setM_Writer(Journaliste m_Writer) {
        this.m_Writer = m_Writer;
    }
}
