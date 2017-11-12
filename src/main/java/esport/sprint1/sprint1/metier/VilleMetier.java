package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Ville;

import java.util.List;

public interface VilleMetier {
    Ville saveVille(Ville v);
    List<Ville> listVilles();
    boolean deleteVille(Long id);
    Ville getVille(Long id);
    Ville updateVille(Long id, Ville v);
}
