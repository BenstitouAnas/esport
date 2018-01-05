package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.ProduitMetier;
import esport.sprint1.sprint1.models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProduitRestService {

    @Autowired
    private ProduitMetier produitMetier;

    @RequestMapping(value = "/produits", method = RequestMethod.POST)
    public Produit saveProduit(@RequestBody Produit c) {
        return produitMetier.saveProduit(c);
    }

    @RequestMapping(value = "/produits", method = RequestMethod.GET)
    public List<Produit> listProduits() {
        return produitMetier.listProduits();
    }

    @RequestMapping(value = "/produits/{id}", method = RequestMethod.DELETE)
    public boolean deleteProduit(@PathVariable Long id) {
        return produitMetier.deleteProduit(id);
    }

    @RequestMapping(value = "/prosuits/{id}", method = RequestMethod.GET)
    public Produit getProduit(@PathVariable Long id) {
        return produitMetier.getProduit(id);
    }

    @RequestMapping(value = "/produits", method = RequestMethod.PUT)
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit c) {
        return produitMetier.updateProduit(id, c);
    }

    @RequestMapping(value = "/produits/chercher", method = RequestMethod.GET)
    public Page<Produit> chercherProduit(
            @RequestParam(name = "mot", defaultValue = "") String mot,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        return produitMetier.chercherProduit("%" + mot + "%", new PageRequest(page, size));
    }
}
