package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query("select p from Produit p where p.nom like :mot and p.quantite > 0")
    Page<Produit> chercherProduit(@Param("mot") String mot, Pageable pageable);
}
