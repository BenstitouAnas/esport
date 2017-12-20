package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Actualite;
import esport.sprint1.sprint1.models.Journaliste;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JournalisteMetier {
    Journaliste saveJournaliste(Journaliste J);
    List<Journaliste> listJournalistes();
    boolean deleteJournaliste(Long id);
    Journaliste getJournaliste(Long id);
    Journaliste updateJournaliste(Long id, Journaliste J);

    List<Actualite> getActualites(Long id);

    Page<Journaliste> chercherJounaliste(String mot, Pageable pageable);
}
