package com.example.GestionStock.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity

public class Produit  implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ref;
    private String nom;
    private String description;
    private double prix;
    private String image;
    private int qte_stock;
    private boolean etat;

    public Produit(){}
    public Produit(int ref,String nom,String description,double prix,String image ,int qte_stock,boolean etat){
        this.ref=ref;
        this.nom=nom;
        this.description=description;
        this.prix=prix;
        this.image=image;
        this.qte_stock=qte_stock;
        this.etat=etat;

    } public Produit(String libelle,String description,double prix,String image ,int qte_stock,boolean etat){
        super();
        this.nom=nom;
        this.description=description;
        this.prix=prix;
        this.image=image;
        this.qte_stock=qte_stock;
        this.etat=etat;

    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom=nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQte_stock() {
        return qte_stock;
    }

    public void setQte_stock(int qte_stock) {
        this.qte_stock = qte_stock;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Produit{" +
            "ref=" + ref +
            ", libellé='" + nom + '\'' +
            ", description='" + description + '\'' +
            ", prix=" + prix +
            ", image='" + image + '\'' +
            ", qte_stock=" + qte_stock +
            ", etat=" + etat +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return ref == produit.ref;
    }

    @Override
    public int hashCode() {
        return 3;
    }
}
