/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Menu;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MSI GAMMING
 */
public class ServiceMenu {

    public static ServiceMenu instance = null;
    private ConnectionRequest req;
    
    public static ServiceMenu getInstance() {
        if (instance == null) {
            instance = new ServiceMenu();
        }
        return instance;
    }
    
    public ServiceMenu() {
        req = new ConnectionRequest();
    }
    
    public void ajoutMenu(Menu p) {
        String url = Statics.BASE_URL + "menuu/addmenu?nom=" + p.getNom() + "&descp=" + p.getDescp()
                + "&image=" + p.getImage() + "&prix=" + p.getPrix();
        System.out.println(url);
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());
            //reponse json hedhi elli rynaha fil naviguateur 

            System.out.println("data == " + str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution mtaie request sinon yitada chay dima nalkawha 

    }
    
    public void EditMenu(Menu r) {
        String url = Statics.BASE_URL + "menuu/updateMenu?id=" + r.getId() + "&nom=" + r.getNom()
                + "&descp=" + r.getDescp() + "&image=" + r.getImage() + "&prix=" + r.getPrix();
        System.out.println(url);
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());
            //reponse json hedhi elli rynaha fil naviguateur 

            System.out.println("data == " + str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution mtaie request sinon yitada chay dima nalkawha 

    }
    
    public ArrayList<Menu> affichageMenus() {
        
        ArrayList<Menu> result = new ArrayList<>();
        String url = Statics.BASE_URL + "menuu/allmenus";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();
                
                try {
                    Map<String, Object> mapMenus = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapMenus.get("root");
                    
                    for (Map<String, Object> obj : listOfMaps) {
                        
                        Menu fe = new Menu();

                        //dima id fi codenameone float dima khir 
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        System.out.println(obj);
                        String nom = obj.get("nom").toString();
                        String descp = obj.get("descp").toString();
                        String image = obj.get("image").toString();
                        float prix = Float.parseFloat(obj.get("prix").toString());
                    
                        fe.setId((int) id);
                        fe.setDescp(descp);
                        fe.setImage(image);
                        fe.setPrix((int) prix);

                        //insert data into ArrayList result
                        result.add(fe);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        );
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
    }
    
    public Menu DetailMenu(int id, Menu p) {
        
        String url = Statics.BASE_URL + "menuu/detailmenu?id" + id;
        req.setUrl(url);
        
        String str = new String(req.getResponseData());
        req.addResponseListener((evt) -> {
            JSONParser jsonp = new JSONParser();
            
            try {
                Map<String, Object> obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));

                //    p.setUser_id((int)obj.get("user_id"));
                //  p.setReunionid((int)obj.get("reunionid"));
                p.setNom(obj.get("nom").toString());
                p.setDescp(obj.get("descp").toString());
                p.setImage(obj.get("image").toString());
                p.setPrix((int) obj.get("prix"));
                
            } catch (IOException ex) {
                System.out.println("error related to sql : ( " + ex.getMessage());
            }
            
            System.out.println("data ===" + str);
            
        });
        NetworkManager.getInstance().addToQueueAndWait(req);//execution mtaie request sinon yitada chay dima nalkawha 

        return p;
        
    }
    
    public boolean resultOK;

        public boolean deleteMenu(int id) {
        String url = Statics.BASE_URL + "menuu/delMenu?idF=" + id;
            System.out.println(url);
               req.setUrl(url);
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
}