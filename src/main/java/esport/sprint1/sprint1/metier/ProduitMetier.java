package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProduitMetier {

    Produit saveProduit(Produit c);
    List<Produit> listProduits();
    boolean deleteProduit(Long id);
    Produit getProduit(Long id);
    Produit updateProduit(Long id, Produit c);

    Page<Produit> chercherProduit(String mot, Pageable pageable);
}
