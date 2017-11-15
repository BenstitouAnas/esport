package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Ville;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VilleMetier {
    Ville saveVille(Ville v);
    List<Ville> listVilles();
    boolean deleteVille(Long id);
    Ville getVille(Long id);
    Ville updateVille(Long id, Ville v);

    Page<Ville> chercherVille(String mot, Pageable pageable);
}
