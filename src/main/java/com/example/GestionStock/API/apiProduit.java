package com.example.GestionStock.API;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.GestionStock.Exception.ResourceNotFoundException;
import com.example.GestionStock.Model.Produit;
import com.example.GestionStock.Repositry.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/takwa")
public class apiProduit {

    @Autowired
    private ProduitRepository pr;

    // get all employees
    @GetMapping
    public List<Produit> getAllProduit(){
        return pr.findAll();
    }

    // create employee rest api
    @PostMapping
    public Produit createProduit(@RequestBody Produit p) {
        return pr.save(p);
    }

    // find employee rest api
    @GetMapping("/{ref}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Integer ref) {
        Produit produit= pr.findById(ref)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with ref :" + ref));
        return ResponseEntity.ok(produit);
    }


    // update employee rest api

    @PutMapping("/{ref}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Integer ref, @RequestBody Produit prodD){
        Produit produit =pr.findById(ref)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with ref :" + ref));

        produit.setNom(prodD.getNom());
        produit.setDescription(prodD.getDescription());
        produit.setPrix(prodD.getPrix());
        produit.setImage(prodD.getImage());
        produit.setQte_stock(prodD.getQte_stock());
        produit.setEtat(prodD.getEtat());


        Produit updateProduit = pr.save(produit);
        return ResponseEntity.ok(updateProduit);
    }

    // delete employee rest api
    @DeleteMapping("/{ref}")
    public ResponseEntity<Map<String, Boolean>> deleteProduit(@PathVariable Integer ref){
        Produit produit = pr.findById(ref)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + ref));

        pr.delete(produit);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
