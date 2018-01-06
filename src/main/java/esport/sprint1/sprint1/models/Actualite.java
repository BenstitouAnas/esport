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

    @Lob
    private String contenu;

    private Date dateEcriture;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ecrivain_ID")
    private Journaliste m_Writer;

    private String backGround;

    public Actualite() {
    }

    public Actualite(String titre, String contenu, Date dateEcriture, Journaliste m_Writer, String backGround) {
        this.titre = titre;
        this.contenu = contenu;
        this.dateEcriture = dateEcriture;
        this.m_Writer = m_Writer;
        this.backGround = backGround;
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

    public Date getDateEcriture() {
        return dateEcriture;
    }

    public void setDateEcriture(Date dateEcriture) {
        this.dateEcriture = dateEcriture;
    }

    public Journaliste getM_Writer() {
        return m_Writer;
    }

    public void setM_Writer(Journaliste m_Writer) {
        this.m_Writer = m_Writer;
    }

    public String getBackGround() {
        return backGround;
    }

    public void setBackGround(String backGround) {
        this.backGround = backGround;
    }
}
