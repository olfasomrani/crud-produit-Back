package com.example.GestionStock.API;

import com.example.GestionStock.Exception.ResourceNotFoundException;
import com.example.GestionStock.Model.Produit;
import com.example.GestionStock.Repositry.ProduitRepository;
import com.example.GestionStock.Services.ServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Produit")*/
public class ControllerProduit {
    @Autowired
    ServiceProduit sp;
    ProduitRepository pr;
    @PostMapping
    public Produit AddProduit(@RequestBody Produit p){
        Produit newProd=sp.AjouterProduit(p);
        if(newProd !=null){
            return newProd;

        }else{
            return null;
        }
    }
    @GetMapping
    public List<Produit> getProduit(){
        return sp.AfficherProduit();
    }
    @DeleteMapping(path = "/{ref}")
    public ResponseEntity <Map<String, Boolean>> deleteEmployee(@PathVariable Integer ref)
        throws ResourceNotFoundException {
        Produit produit = pr.findById(ref)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " +ref));

        pr.delete(produit);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
  /*  @DeleteMapping(path = "/{ref}", consumes = "application/json", produces =
        "application/json")
    public boolean deleteProduit(@PathVariable("ref") Integer ref) {
        HashMap<String, Object> response = new HashMap<>();
        if(sp.SupprimerProduit(ref))
            return true;
        else
            return false;
    }
*/




}
