/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author Hazem
 */
public class User {
    private  int id,num_tel ;
    private String nom,prenom,email,password,Image;
    private String[] Role;
    private boolean isExpired,isVerified;

    public User() {
    }
      public User(int num_tel, String nom,String prenom, String email, String password) {
        this.num_tel = num_tel;
        this.nom= nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
       
    }

    public User(String nom,String prenom, String email, int num_tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.num_tel = num_tel;
    }
      

    public User(int id) {
        this.id = id;
    }
    

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    

    public User(int id, int num_tel, String nom,String prenom, String email, String password) {
        this.id = id;
        this.num_tel = num_tel;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public User(int id, String nom,String prenom, String email, int num_tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.num_tel = num_tel;
    }

    public User(int id, int num_tel, String nom, String prenom ,String email, String password, String Image, String[] Role, boolean isExpired, boolean isVerified) {
        this.id = id;
        this.num_tel = num_tel;
        this.nom = nom ;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.Image = Image;
        this.Role = Role;
        this.isExpired = isExpired;
        this.isVerified = isVerified;
    }

  
  

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String[] getRole() {
        return Role;
    }

    public void setRole(String[] Role) {
        this.Role = Role;
    }

    public boolean isIsExpired() {
        return isExpired;
    }

    public void setIsExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", num_tel=" + num_tel + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + ", Image=" + Image + ", Role=" + Role + ", isExpired=" + isExpired + ", isVerified=" + isVerified + '}';
    }

   

   
    
    
    
}
