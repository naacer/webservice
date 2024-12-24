package com.nacer.service;

import com.nacer.model.Product;
import com.nacer.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository produitRepository) {
        this.productRepository = produitRepository;
    }

    public Product ajouterProduit(Product product) {
        return productRepository.save(product);
    }

    public Product modifierProduit(Long id, Product produitDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

        product.setName(produitDetails.getName());
        product.setDescription(produitDetails.getDescription());
        product.setPrix(produitDetails.getPrix());
        product.setQuantite(produitDetails.getQuantite());

        return productRepository.save(product);
    }

    public void supprimerProduit(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> listerProduits() {
        return productRepository.findAll();
    }
}
