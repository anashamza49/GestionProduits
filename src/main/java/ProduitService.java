import java.util.ArrayList;
import java.util.List;

public class ProduitService {
       private List<Produit> produits;
        public ProduitService() {
            this.produits = new ArrayList<>();
        }
        public void ajouterProduit(Produit produit) throws Exception {

            if (produitExiste(produit.getId())  produitExiste(produit.getNom())) {
                throw new Exception("Un produit avec le même ID ou nom existe déjà.");
            }
            if (produit.getPrix() < 0  produit.getQuantite() < 0) {
                throw new Exception("Le prix et la quantité doivent être positifs.");
            }
            produits.add(produit);
        }
	          public Produit lireProduit(Long id) throws Exception {
            for (Produit produit : produits) {
                if (produit.getId().equals(id)) {
                    return produit;
                }
            }
            throw new Exception("Produit non trouvé.");
        }

        public void mettreAJourProduit(Produit produit) throws Exception {
            if (!produitExiste(produit.getId())) {
                throw new Exception("Produit non trouvé pour la mise à jour.");
            }
            if (produit.getPrix() < 0 || produit.getQuantite() < 0) {
                throw new Exception("Le prix et la quantité doivent être positifs.");
            }
        }
}
