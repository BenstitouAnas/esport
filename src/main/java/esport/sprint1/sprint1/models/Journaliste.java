package esport.sprint1.sprint1.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Journaliste extends Utilisateur implements Serializable {
    @OneToMany(mappedBy = "m_Writer")
    private List<Actualite> m_Acts;

    public List<Actualite> getM_Acts() {
        return m_Acts;
    }

    public Journaliste(List<Actualite> m_Acts) {
        this.m_Acts = m_Acts;
    }

    public Journaliste(String nom, String prenom, Long villeId, String nomUtilisateur, String email, String adresse, String pays, int codePostale, String apropos, String citation, int levele, int points, boolean newUser, boolean active, boolean confirm, String photo, String coverImg, Date created_at, Date updated_at, List<Actualite> m_Acts) {
        super(nom, prenom, villeId, nomUtilisateur, email, adresse, pays, codePostale, apropos, citation, levele, points, newUser, active, confirm, photo, coverImg, created_at, updated_at);
        this.m_Acts = m_Acts;
    }
    public Journaliste(){}
    public void setM_Acts(List<Actualite> m_Acts) {
        this.m_Acts = m_Acts;
    }
}
