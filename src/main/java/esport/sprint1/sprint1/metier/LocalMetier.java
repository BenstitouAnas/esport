package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Local;

import java.util.List;

public interface LocalMetier {
    Local saveLocal(Local l);
    List<Local> listLocales();
    boolean deleteLocal(Long id);
    Local getLocal(Long id);
    Local updateLocal(Long id, Local l);
}
