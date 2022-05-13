/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author MSI GAMMING
 */
public class Menu { 
    
    private int id ; 
    private String nom ; 
    private String descp ; 
    private String image ; 
    private int prix ;
   // private Categorie cat ; 

    public Menu() {
    }

    public Menu(int id, String nom, String descp, String image, int prix) {
        this.id = id;
        this.nom = nom;
        this.descp = descp;
        this.image = image;
        this.prix = prix;
      
    }

    public Menu(String nom, String descp, String image, int prix) {
        this.nom = nom;
        this.descp = descp;
        this.image = image;
        this.prix = prix;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrix() {
        return (float)prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

  

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", nom=" + nom + ", descp=" + descp + ", image=" + image + ", prix=" + prix + '}';
    }

  
  
}
