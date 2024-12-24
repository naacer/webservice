package com.nacer.controller;

import com.nacer.model.Commande;
import com.nacer.service.CommandeProducer;
import com.nacer.service.CommandeService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CommandeController {
    private final CommandeService commandeService;
    private final CommandeProducer commandeProducer;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @QueryMapping
    public List<Commande> commandes() {
        return commandeService.listerCommandes();
    }

    @PostMapping
    public ResponseEntity<String> creerCommande(@RequestBody String commandeDetails) {
        commandeProducer.envoyerMessage("Nouvelle commande : " + commandeDetails);
        return ResponseEntity.ok("Commande créée et message envoyé à Kafka !");
    }
}
