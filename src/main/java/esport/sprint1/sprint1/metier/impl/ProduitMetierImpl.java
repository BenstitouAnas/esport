package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.ProduitRepository;
import esport.sprint1.sprint1.metier.ProduitMetier;
import esport.sprint1.sprint1.models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitMetierImpl implements ProduitMetier {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit c) {
        return produitRepository.save(c);
    }

    @Override
    public List<Produit> listProduits() {
        return produitRepository.findAll();
    }

    @Override
    public boolean deleteProduit(Long id) {
        produitRepository.delete(id);
        return true;
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findOne(id);
    }

    @Override
    public Produit updateProduit(Long id, Produit c) {
        c.setId(id);
        return produitRepository.save(c);
    }

    @Override
    public Page<Produit> chercherProduit(String mot, Pageable pageable) {
        return produitRepository.chercherProduit(mot, pageable);
    }
}
