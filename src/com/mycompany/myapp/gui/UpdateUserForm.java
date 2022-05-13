/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.services.ServiceTask;

/**
 *
 * @author Hazem
 */
public class UpdateUserForm extends Form {

    public UpdateUserForm(User u, Resources res) {
        setTitle("update Personne");
        setLayout(BoxLayout.y());
//        Event t = new Event();
 //       ComboBox cb = new ComboBox();
    TextField Id = new TextField(String.valueOf(u.getId()), "UserID");
    TextField nom = new TextField(u.getNom(), "nom", 20, TextField.ANY);
    TextField prenom = new TextField(u.getPrenom(), "prenom", 20, TextField.ANY);
    TextField Email = new TextField(u.getEmail(), "E-Mail", 20, TextField.EMAILADDR);
    TextField num_tel = new TextField(""+u.getNum_tel(), "Phone", 20, TextField.PHONENUMBER);
    TextField password = new TextField(u.getPassword(), "password", 20, TextField.PHONENUMBER);

    
    nom.getAllStyles().setMargin(LEFT, 0);
    prenom.getAllStyles().setMargin(LEFT, 0);
    Email.getAllStyles().setMargin(LEFT, 0);
    num_tel.getAllStyles().setMargin(LEFT, 0);

    
        Button btnSubmit = new Button("Update");
        Button btnret = new Button("return");
        
            btnret.addActionListener(e -> new ProfileForm(res).show());
        
        
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((nom.getText().length() == 0)||(prenom.getText().length() == 0)) {
                    Dialog.show("Alert", "Are you sure !!", new Command("OK"));
               } else {
                        User u = new User(Integer.parseInt(Id.getText()),Integer.parseInt(num_tel.getText()),nom.getText(),prenom.getText(),Email.getText(), password.getText().toString());
                   // System.out.println(tfID.getText());
//                    Event t = new Event(tfID.getText());
                    System.out.println(u);
                    System.out.println(u.getEmail());                 
                    System.out.println("updated account");
                    
                    if (ServiceTask.getInstance().UpdateUser(u)) {
                        Dialog.show("Success", "Connection Accepted", new Command("OK"));
                    } else {
                        Dialog.show("ERROR", "Connection Failed", new Command("OK"));
                    }
                        
                }
               
            
            }
        });
        addAll( Id,nom,prenom,Email,num_tel ,password,btnSubmit,btnret);
//        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    
}
}
