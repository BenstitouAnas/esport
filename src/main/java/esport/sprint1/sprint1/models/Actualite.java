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
    private String Titre;
    private String Contenu;
    private Date Date_Ecriture;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ecrivain_ID")
    private Journaliste m_Writer;

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getContenu() {
        return Contenu;
    }

    public Actualite(String titre, String contenu, Date date_Ecriture, Journaliste m_Writer) {
        Titre = titre;
        Contenu = contenu;
        Date_Ecriture = date_Ecriture;
        this.m_Writer = m_Writer;
    }

    public Date getDate_Ecriture() {
        return Date_Ecriture;
    }

    public void setDate_Ecriture(Date date_Ecriture) {
        Date_Ecriture = date_Ecriture;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }

    public Journaliste getM_Writer() {
        return m_Writer;
    }

    public void setM_Writer(Journaliste m_Writer) {
        this.m_Writer = m_Writer;
    }

}
