package com.example.GestionStock.Services;

import com.example.GestionStock.Model.Produit;
import com.example.GestionStock.Repositry.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduit  {
    @Autowired
    ProduitRepository pr;
    /*  Fonction Ajout */
    public Produit AjouterProduit(Produit p){
        try{
             return pr.save(p);
        }
        catch(Exception e)
        {e.printStackTrace();
        return null;
        }
    }
    /*  Fonction Affiche */
    public List<Produit> AfficherProduit(){
        try{
            return pr.findAll();
        }
        catch(Exception e)
        {e.printStackTrace();
        return null;}
    }
    /*  Fonction Supprimer */
    public boolean SupprimerProduit( int ref){
        try{
            pr.deleteById(ref);
            return true;
        }
        catch(Exception e)
        {e.printStackTrace();
        return false;
        }

    }
    /*  Fonction Modifier */
    public boolean ModifierProduit(Produit p){
        try{
            pr.save(p);
            return true;

        }
        catch(Exception e)
        {e.printStackTrace();
        return false;
        }

    }
    /*  Fonction Chercher */
    public boolean ChercherProduit( int ref){
        try{
            pr.findById(ref);
            return true;

        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }


}
