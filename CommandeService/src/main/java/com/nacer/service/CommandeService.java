package com.nacer.service;

import com.nacer.model.Commande;
import com.nacer.model.ProductDto;
import com.nacer.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    private final ProductClient produitsClient;

    public CommandesService(ProductClient produitsClient) {
        this.produitsClient = produitsClient;
    }

    public ProductDto getDetailsProduit(Long produitId) {
        return produitsClient.getProduct(produitId);
    }

    public Commande creerCommande(Commande commande) {
        // Vous pouvez ajouter une logique pour calculer le prix total à partir du produit
        return commandeRepository.save(commande);
    }

    public List<Commande> listerCommandes() {
        return commandeRepository.findAll();
    }
}
