/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceCate {

    public ArrayList<Categorie> User;

    public static ServiceCate instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceCate() {
        req = new ConnectionRequest();
    }

    public static ServiceCate getInstance() {
        if (instance == null) {
            instance = new ServiceCate();
        }
        return instance;
    }

    public boolean addcat(Categorie u) {
        System.out.println(u);
        System.out.println("********");
        String url = Statics.BASE_URL + "categoriee/addCategorie?nom=" + u.getNom();
        // String url = Statics.BASE_URL + "create";
        System.out.println("********");

        req.setUrl(url);

//       req.addArgument("username", u.getUsername());
//       req.addArgument("email", u.getEmail()+"");
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Categorie> parseTasks(String jsonText) {
        try {
            User = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Categorie u = new Categorie();
                float id = Float.parseFloat(obj.get("id").toString());
                u.setId((int) id);
                String nom = obj.get("nom").toString();
                u.setNom(nom);

//                    String email= obj.get("email").toString() ;
//                    float id = Float.parseFloat(obj.get("id").toString());
//                    String username= obj.get("username").toString() ;
//                    String password= obj.get("password").toString() ;
//                    String tel= obj.get("tel").toString() ;
                User.add(u);
            }

        } catch (IOException ex) {

        }
        return User;
    }

    public ArrayList<Categorie> getAllcat() {
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL + "categoriee/allCategories";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                User = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return User;
    }

    public boolean deletecat(Categorie u) {
        String url = Statics.BASE_URL + "categoriee/deleteCategorie/" + u.getId();
//création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(resultOK);
        return resultOK;
    }

    public boolean Updatecat(Categorie u) {
        String url = Statics.BASE_URL + "categoriee/updateCategorie/" + u.getId() + "?nom=" + u.getNom();
//création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(resultOK);
        return resultOK;
    }
}
