/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu.gui;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.BaseForm;
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.entities.Menu;
import com.mycompany.myapp.entities.services.ServiceMenu;
import com.mycompany.myapp.services.ServiceCate;

/**
 *
 * @author Hazem
 */
public class AddCat extends BaseForm {

    String Imagecode;
    String filePath = "";

    public AddCat(Resources res, Form previous) {
        super("Ajouter cate", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajouter cate");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);

        tb.addSearchCommand(e -> {
        });
        Categorie fa = new Categorie();

        TextComponent nom = new TextComponent().labelAndHint("nom");
        add(nom);

        Button Ajouter = new Button("Ajouter");

        Ajouter.addActionListener((evt) -> {
            if (nom.getText().equals("")) {
                Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
            } else {

                ServiceCate sf = new ServiceCate();
                fa.setNom(nom.getText());

                sf.addcat(fa);
                Dialog.show("Success", "Menu ajoute avec success", new Command("OK"));
                new AllCat(res).show();

            }
        });

        addStringValue("", FlowLayout.encloseRightMiddle(Ajouter));

        /////////////////////////////////////   Notification     /////////////////////
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage("Ajouter Nouvelle cate ");
        status.setExpires(4000);  // only show the status for 3 seconds, then have it automatically clear
        status.show();
        System.out.println("Hallo");
///////////////////////////////////////////

    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));

    }

}
