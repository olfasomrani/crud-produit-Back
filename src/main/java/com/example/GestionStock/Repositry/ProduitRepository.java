package com.example.GestionStock.Repositry;

import com.example.GestionStock.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository
    extends JpaRepository<Produit,Integer> {

}
