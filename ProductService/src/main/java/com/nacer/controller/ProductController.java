package com.nacer.controller;

import com.nacer.model.Product;
import com.nacer.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProduits() {
        return productService.listerProduits();
    }

    @PostMapping
    public Product ajouterProduit(@RequestBody Product produit) {
        return productService.ajouterProduit(produit);
    }

    @PutMapping("/{id}")
    public Product modifierProduit(@PathVariable Long id, @RequestBody Product produit) {
        return productService.modifierProduit(id, produit);
    }

    @DeleteMapping("/{id}")
    public void supprimerProduit(@PathVariable Long id) {
        productService.supprimerProduit(id);
    }
}
