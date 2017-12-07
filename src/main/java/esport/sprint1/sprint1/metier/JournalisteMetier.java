package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Journaliste;

import java.util.List;

public interface JournalisteMetier {
    Journaliste saveJournaliste(Journaliste J);
    List<Journaliste> listJournalistes();
    boolean deleteJournaliste(Long id);
    Journaliste getJournaliste(Long id);
    Journaliste updateJournaliste(Long id, Journaliste J);
}
